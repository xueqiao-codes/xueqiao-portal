<template>
  <div class="page">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/quotationAccount' }">行情订阅管理 行情账号</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/accountRegisterAbility/' + accountId }">订阅能力管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="header">
      <div class="header-text">订阅能力管理 <span> —— 账号：{{accountNickName}}（{{accountName}}） {{$config.QUOTATION_PLATFORM_ENV.ITEMS[platformEnv].label}}</span></div>
    </div>
    <div class="body">
      <div class="body-header">
        <div class="body-header-left">
          <!-- <span>账号：</span>
          <span class="body-header-input body-header-component">{{accountName}}</span> -->
          <span>交易所名：</span>
          <el-input
            class="body-header-input body-header-component"
            placeholder="交易所名"
            v-model="searchKeyExchange"
            clearable
          >
          </el-input>
          <span>商品名：</span>
          <el-input
            class="body-header-input body-header-component"
            placeholder="商品名"
            v-model="searchKeyCommodity"
            clearable
          >
          </el-input>
          <el-button
            class="body-header-component"
            type="primary"
            size="small"
            @click="query"
          >查询</el-button>
        </div>
        <div class="body-header-right">
          <el-button
            class="body-header-component"
            type="primary"
            size="small"
            @click="showAddAccountRegisterAbilityDialog"
          >添加</el-button>
        </div>
      </div>
      <div class="body-content">
        <table>
          <tr bgColor=#F8FCFF>
            <th width="300">交易所</th>
            <th width="1400">商品</th>
            <th width="300">操作</th>
          </tr>
          <tr
            v-for="(exchangeRegisterAbility, index) in exchangeRegisterAbilityList"
            v-bind:key="index"
          >
            <td>{{exchangeRegisterAbility.exchangeName}}</td>
            <td v-if="exchangeRegisterAbility.supportType == SupportTypeALL">*</td>
            <td v-else>
              <div class="td-commodity-container">
                <el-tag
                  class="commodity-item"
                  :key="index"
                  v-for="(commodityAbility, index) in exchangeRegisterAbility.commodityAbilities"
                  closable
                  size="small"
                  @close="showRemoveCommodityAbilityDialog(commodityAbility)"
                >
                  {{commodityAbility.commodityName}}
                </el-tag>
              </div>
            </td>
            <td>
              <a
                href="#"
                class="body-table-operation"
                @click="showRemoveExchangeRegisterAbilityDialog(exchangeRegisterAbility)"
              >删除</a>
            </td>
          </tr>
        </table>
        <div
          class="body-content-nodata"
          v-if="nodata"
        >无数据</div>
      </div>
      <div class="pagination">
        <!-- <el-pagination
          background
          layout="sizes, prev, pager, next"
          :total="totalNum"
          :page-size="pageSize"
          :current-page="currentPage"
          @size-change="handleSizeChange"
          @current-change="onPageChange"
        >
        </el-pagination> -->
      </div>
    </div>
    <dialog-addition
      v-bind:isShow="isShowAdditionDialog"
      :accountId="accountId"
      :sledExchangeId="sledExchangeId"
      :platformEnv="platformEnv"
      @confirm="confirmAddition"
      @close="cancelAddition"
    ></dialog-addition>
    <!-- <dialog-edition
      v-bind:isShow="isShowEditionDialog"
      :accountRegisterAbility="selectedAccountRegisterAbility"
      @confirm="confirmEdition"
      @close="cancelEdition"
    ></dialog-edition> -->
  </div>
</template>

<script>
import AddAccountRegisterAbilityDialog from "../components/specdialog/AddAccountRegisterAbilityDialog.vue";
// import EditAccountRegisterAbilityDialog from "../components/specdialog/EditAccountRegisterAbilityDialog.vue";
export default {
  components: {
    "dialog-addition": AddAccountRegisterAbilityDialog
    // "dialog-edition": EditAccountRegisterAbilityDialog
  },
  data() {
    return {
      // page
      totalNum: 0,
      currentPage: 1,
      pageSize: 10,

      // dialog
      isShowAdditionDialog: false,
      isShowEditionDialog: false,

      // search key
      searchKeyExchange: null,
      searchKeyCommodity: null,

      // data
      nodata: true,
      // accountRegisterAbilityList: null,
      exchangeRegisterAbilityList: null,

      // selected data
      selectedAccountRegisterAbility: null,

      // const
      accountId: 0,
      accountName: null,
      accountNickName: null,
      platformEnv: null,
      SupportTypeALL: SupportType.ALL,
      SupportTypeSET: SupportType.SET,

      // dialog param
      sledExchangeId: 0
    };
  },
  mounted() {
    // alert("accountId : " + this.$route.params.accountId)
    // this.reqAccountRegisterAbility();
    this.reqExchangeRegisterAbility();
    // this.accountId = this.$route.query.accountId
    // this.accountName = this.$route.query.acountName
    // alert("accountId : " + this.accountId)
  },
  methods: {
    onPageChange(currentPage) {
      this.currentPage = currentPage;
      this.reqAccountRegisterAbility();
    },
    handleSizeChange(size) {
      this.pageSize = size;
      this.reqAccountRegisterAbility();
    },
    reqExchangeRegisterAbility() {
      this.accountId = this.$route.query.accountId;
      this.accountName = this.$route.query.acountName;
      this.accountNickName = this.$route.query.nickName;
      this.platformEnv = this.$route.query.platformEnv;

      var that = this;

      var reqAccountRegisterAbilityOption = new ReqAccountRegisterAbilityOption();

      reqAccountRegisterAbilityOption.accountId = this.accountId;
      if (this.searchKeyExchange) {
        reqAccountRegisterAbilityOption.exchangeNamePartical = this.searchKeyExchange;
      }
      if (this.searchKeyCommodity) {
        reqAccountRegisterAbilityOption.commodityNamePartical = this.searchKeyCommodity;
      }

      // alert(
      //   "reqAccountRegisterAbilityOption : " +
      //     JSON.stringify(reqAccountRegisterAbilityOption)
      // );
      this.$api.reqExchangeRegisterAbility(
        reqAccountRegisterAbilityOption,
        function(response) {
          // alert("response : " + JSON.stringify(response));
          if (response == null) {
            that.accountRegisterAbilityList = [];
            that.nodata = true;
            return;
          }
          that.exchangeRegisterAbilityList = response;
          if (that.exchangeRegisterAbilityList.length < 1) {
            that.nodata = true;
          } else {
            that.nodata = false;
          }
        }
      );
    },
    // reqAccountRegisterAbility() {
    //   var that = this;
    //   var reqAccountRegisterAbilityOption = new ReqAccountRegisterAbilityOption();

    //   this.accountId = this.$route.query.accountId;
    //   this.accountName = this.$route.query.acountName;
    //   this.accountNickName = this.$route.query.nickName;
    //   // alert("accountId : " + this.$route.query.accountId)
    //   reqAccountRegisterAbilityOption.accountId = this.accountId;
    //   if (this.searchKeyCommodity) {
    //     reqAccountRegisterAbilityOption.commodityNamePartical = this.searchKeyCommodity;
    //   }

    //   var pageOption = new IndexedPageOption();
    //   pageOption.needTotalCount = true;
    //   pageOption.pageIndex = this.currentPage - 1;
    //   pageOption.pageSize = this.pageSize;
    //   this.$api.reqAccountRegisterAbility(
    //     reqAccountRegisterAbilityOption,
    //     pageOption,
    //     function(response) {
    //       if (
    //         response == null ||
    //         response.page == null ||
    //         response.page.length < 1
    //       ) {
    //         that.accountRegisterAbilityList = [];
    //         that.nodata = true;
    //         return;
    //       }
    //       that.accountRegisterAbilityList = response.page;
    //       that.nodata = false;
    //       that.totalNum = response.total;
    //     }
    //   );
    // },
    query() {
      // alert("敬请期待")
      this.reqExchangeRegisterAbility();
    },
    showAddAccountRegisterAbilityDialog() {
      this.accountId = this.$route.query.accountId;
      // this.sledExchangeId =
      this.isShowAdditionDialog = true;
    },
    confirmAddition() {
      this.isShowAdditionDialog = false;
      this.reqExchangeRegisterAbility();
    },
    cancelAddition() {
      this.isShowAdditionDialog = false;
    },
    showRemoveCommodityAbilityDialog(commodityAbility) {
      if (confirm("确认删除 " + commodityAbility.commodityName + "?")) {
        var that = this;
        this.$api.deleteAccountRegisterAbility(
          commodityAbility.registerAbilityId,
          function(response) {
            if (response != null && response.errorMsg) {
              alert(response.errorMsg);
            } else {
              alert("删除成功");
              that.reqExchangeRegisterAbility();
            }
          }
        );
      }
    },
    // showEditAccountRegisterAbilityDialog(accountRegisterAbility) {
    //   this.selectedAccountRegisterAbility = accountRegisterAbility;
    //   this.isShowEditionDialog = true;
    // },
    // confirmEdition() {
    //   this.isShowEditionDialog = false;
    // },
    // cancelEdition() {
    //   this.isShowEditionDialog = false;
    // },
    showRemoveExchangeRegisterAbilityDialog(exchangeRegisterAbility) {
      if (confirm("确认删除 " + exchangeRegisterAbility.exchangeName + "?")) {
        var that = this;
        this.$api.deleteAccountRegisterAbilityByExchange(
          exchangeRegisterAbility.accountId,
          exchangeRegisterAbility.sledExchangeId,
          function(response) {
            if (response != null && response.errorMsg) {
              alert(response.errorMsg);
            } else {
              alert("删除成功");
              that.reqExchangeRegisterAbility();
            }
          }
        );
      }
    }
  }
};
</script>

<style scoped>
.body-header-input {
  width: 150px;
  margin-right: 20px;
}
.td-commodity-container {
  /* word-wrap:break-word; */
  width: 100%;
  margin-top: 5px;
  margin-bottom: 5px;
  margin-left: 30px;
  padding-right: 50px;
  display: flex;
  /* justify-content: space-around; */
  /* justify-items: flex-start; */
  flex-wrap: wrap;
}
.commodity-item {
  /* padding-left: 5px;
  padding-right: 5px; */
  margin-left: 5px;
  margin-right: 5px;
  margin-top: 2px;
  margin-bottom: 2px;
}
</style>
