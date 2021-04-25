<template>
  <div class="page">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/subscribedContract' }">行情订阅管理 订阅商品合约</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="header">
      <div class="header-text">行情订阅管理</div>
      <ul class="header-tab">
        <li @click="gotoTabCommodityActiveConfig">活跃合约规律</li>
        <li class="active">订阅商品合约</li>
        <li @click="gotoTabQuotationAccount">行情账号</li>
        <li @click="gotoTabSubscribedQuotation">已订阅行情</li>
        <li @click="gotoTabPlanedSubscribedPreview">已规划订阅</li>
        <li @click="gotoTabSubscribedPreview">重新规划预览</li>
      </ul>
    </div>
    <div class="body">
      <div class="body-header">
        <div class="body-header-left">
          <span>行情环境：</span>
          <el-select
            @change="onPlatformEnvChange"
            v-model="searchKeyPlatformEnv"
            placeholder="行情环境"
            class="body-header-input body-header-component"
          >
            <el-option
              v-for="item in QUOTATION_PLATFORM_ENV_FOR_SEARCHKEY"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
          <span>商品：</span>
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
            @click="showAddCommodityRegisterDialog"
          >添加</el-button>
          <el-button
            class="body-header-component"
            type="primary"
            size="small"
            @click="gotoSubscribedPreview"
          >重新规划</el-button>
        </div>
      </div>
      <div class="body-content">
        <table>
          <tr bgColor=#F8FCFF>
            <!-- <th width="400">行情环境</th> -->
            <th width="200">序号</th>
            <th width="400">交易所</th>
            <th width="400">商品</th>
            <th width="400">类型</th>
            <th width="400">固定合约代号</th>
            <!-- <th width="200">订阅优先级</th> -->
            <th width="400">活跃数量(近月优先)</th>
            <th width="400">非活跃数量(近月优先)</th>
            <th width="400">操作</th>
          </tr>
          <tr
            v-for="(commodityRegister, index) in commodityRegisterList"
            v-bind:key="index"
          >
            <!-- <td>{{QUOTATION_PLATFORM_ENV[commodityRegister.platformEnv].label}}</td> -->
            <td>{{commodityRegister.orderIndex}}</td>
            <td>{{commodityRegister.exchangeName}}</td>
            <td>{{commodityRegister.commodityName}}</td>
            <td>{{CONTRACT_ACTIVE_TYPE[commodityRegister.activeType].label}}</td>
            <td v-if="commodityRegister.activeType == 1">{{commodityRegister.fixedCode}}</td>
            <td v-else>-</td>
            <!-- <td>{{commodityRegister.registerPriority}}</td> -->
            <td v-if="commodityRegister.activeType == 0">{{commodityRegister.activeShowCount}}</td>
            <td v-else>-</td>
            <td v-if="commodityRegister.activeType == 0">{{commodityRegister.inactiveShowCount}}</td>
            <td v-else>-</td>

            <td>
              <a
                href="#"
                class="body-table-operation"
                @click="showEditOrderIndexDialog(commodityRegister)"
              >编序</a>
              <a v-if="commodityRegister.activeType == 0"
                href="#"
                class="body-table-operation"
                @click="showEditCommodityRegisterDialog(commodityRegister)"
              >编辑</a>
              <a
                href="#"
                class="body-table-operation"
                @click="showDeleteCommodityRegisterDialog(commodityRegister)"
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
        <el-pagination
          background
          layout="total, sizes, prev, pager, next, jumper"
          :total="totalNum"
          :page-size="pageSize"
          :current-page="currentPage"
          @size-change="handleSizeChange"
          @current-change="onPageChange"
        >
        </el-pagination>
      </div>
    </div>
    <dialog-addition
      v-bind:isShow="isShowAdditionDialog"
      v-bind:platformEnv="searchKeyPlatformEnv"
      @confirm="confirmAddition"
      @close="cancelAddition"
    ></dialog-addition>
    <dialog-edition
      v-bind:isShow="isShowEditionDialog"
      :commodityRegister="selectedCommodityRegister"
      @confirm="confirmEdition"
      @close="cancelEdition"
    ></dialog-edition>
    <dialog-ordex-index
      v-bind:isShow="isShowSetOrderIndexDialog"
      :commodityRegister="selectedCommodityRegister"
      @confirm="confirmSetOrderIndex"
      @close="cancelSetOrderIndex"
    ></dialog-ordex-index>
  </div>
</template>

<script>
import AddCommodityRegisterDialog from "../components/specdialog/AddCommodityRegisterDialog.vue";
import EditCommodityRegisterDialog from "../components/specdialog/EditCommodityRegisterDialog.vue";
import SetCommodityRegisterOrderIndexDialog from "../components/specdialog/SetCommodityRegisterOrderIndexDialog.vue";
export default {
  components: {
    "dialog-addition": AddCommodityRegisterDialog,
    "dialog-edition": EditCommodityRegisterDialog,
    "dialog-ordex-index": SetCommodityRegisterOrderIndexDialog
  },
  data() {
    return {
      // page
      totalNum: 0,
      currentPage: 1,
      pageSize: 10,

      // const
      QUOTATION_PLATFORM_ENV: this.$config.QUOTATION_PLATFORM_ENV.ITEMS,
      QUOTATION_PLATFORM_ENV_FOR_SEARCHKEY: this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS,
      CONTRACT_ACTIVE_TYPE: this.$config.CONTRACT_ACTIVE_TYPE.ITEMS,

      // search key
      searchKeyPlatformEnv: this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS[0].value,
      searchKeyCommodity: null,

      // dialog
      isShowAdditionDialog: false,
      isShowEditionDialog: false,
      isShowSetOrderIndexDialog: false,

      // dialog data
      selectedCommodityRegister: null,

      // data
      nodata: true,
      commodityRegisterList: null
    };
  },
  mounted() {
    this.reqCommodityRegister();
  },
  methods: {
    gotoTabCommodityActiveConfig() {
      this.$router.push("/commodityActiveConfig");
    },
    gotoTabSubcribedContract() {
      this.$router.push("/subscribedContract");
    },
    gotoTabQuotationAccount() {
      this.$router.push("/quotationAccount");
    },
    gotoTabSubscribedQuotation() {
      this.$router.push("/subscribedQuotation");
    },
    gotoTabPlanedSubscribedPreview() {
      this.$router.push("/planedSubscribedPreview");
    },
    gotoTabSubscribedPreview() {
      this.$router.push("/subscribedPreview/tab");
    },
    gotoSubscribedPreview() {
      var that = this;
      this.$common.replanSubscribe(function() {
        that.$router.push("/subscribedPreview/subscribedContract");
      });
    },
    onPageChange(currentPage) {
      this.currentPage = currentPage;
      this.reqCommodityRegister();
    },
    handleSizeChange(size) {
      this.pageSize = size;
      this.reqCommodityRegister();
    },
    onPlatformEnvChange(options) {
      this.$store.commit('setSubscribedContractPlatformEnv', this.searchKeyPlatformEnv)
      this.reqCommodityRegister();
    },
    setSearchKeys() {
      if (this.$store.state.subscribedContract.platfromEnv != null && this.$store.state.subscribedContract.platfromEnv != undefined) {
        this.searchKeyPlatformEnv = this.$store.state.subscribedContract.platfromEnv
      }
    },
    reqCommodityRegister() {
      this.setSearchKeys()
      var that = this;
      var reqCommodityRegisterOption = new ReqCommodityRegisterOption();
      if (this.searchKeyCommodity) {
        reqCommodityRegisterOption.commodityNamePartical = this.searchKeyCommodity;
      }
      if (!this.searchKeyPlatformEnv) {
        this.searchKeyPlatformEnv = this.QUOTATION_PLATFORM_ENV_FOR_SEARCHKEY[0].value
      }
      reqCommodityRegisterOption.platformEnv = TechPlatformEnv[this.searchKeyPlatformEnv]

      var pageOption = new IndexedPageOption();
      pageOption.needTotalCount = true;
      pageOption.pageIndex = this.currentPage - 1;
      pageOption.pageSize = this.pageSize;
      this.$api.reqCommodityRegister(
        reqCommodityRegisterOption,
        pageOption,
        function(response) {
          // alert("reqCommodityRegister : " + JSON.stringify(response))
          if (
            response == null ||
            response.page == null ||
            response.page.length < 1
          ) {
            that.commodityRegisterList = [];
            that.nodata = true;
            return;
          }
          that.commodityRegisterList = response.page;
          that.nodata = false;
          that.totalNum = response.total;
        }
      );
    },
    query() {
      this.reqCommodityRegister();
    },
    showAddCommodityRegisterDialog() {
      this.isShowAdditionDialog = true;
    },
    confirmAddition() {
      this.isShowAdditionDialog = false;
      this.reqCommodityRegister();
    },
    cancelAddition() {
      this.isShowAdditionDialog = false;
    },
    showEditCommodityRegisterDialog(commodityRegister) {
      this.selectedCommodityRegister = commodityRegister;
      this.isShowEditionDialog = true;
    },
    confirmEdition() {
      this.isShowEditionDialog = false;
      this.reqCommodityRegister();
    },
    cancelEdition() {
      this.isShowEditionDialog = false;
    },
    showDeleteCommodityRegisterDialog(commodityRegister) {
      if (confirm("确认删除？")) {
        var that = this;
        this.$api.deleteCommodityRegister(
          commodityRegister.sledCommodityId,
          commodityRegister.platformEnv,
          commodityRegister.activeType,
          commodityRegister.fixedCode,
          function(response) {
            if (response != null && response.errorMsg) {
              alert(response.errorMsg);
            } else {
              alert("删除成功");
              that.reqCommodityRegister();
            }
          }
        );
      }
    },
    showEditOrderIndexDialog(commodityRegister) {
      this.selectedCommodityRegister = commodityRegister
      this.isShowSetOrderIndexDialog = true
    },
    confirmSetOrderIndex() {
      this.isShowSetOrderIndexDialog = false
      this.reqCommodityRegister();
    },
    cancelSetOrderIndex() {
      this.isShowSetOrderIndexDialog = false
    }
  }
};
</script>

<style scoped>
.body-header-input {
  width: 200px;
  margin-right: 20px;
}
</style>
