<template>
  <div class="page">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/quotationAccount' }">行情订阅管理 行情账号</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="header">
      <div class="header-text">行情订阅管理</div>
      <ul class="header-tab">
        <li @click="gotoTabCommodityActiveConfig">活跃合约规律</li>
        <li @click="gotoTabSubcribedContract">订阅商品合约</li>
        <li class="active">行情账号</li>
        <li @click="gotoTabSubscribedQuotation">已订阅行情</li>
        <li @click="gotoTabPlanedSubscribedPreview">已规划订阅</li>
        <li @click="gotoTabSubscribedPreview">重新规划预览</li>
      </ul>
    </div>
    <div class="body">
      <div class="body-header">
        <div class="body-header-left">
          <div class="body-header-left-item">
            <span>部署区域：</span>
            <el-select
              v-model="searchKeyDeployment"
              @change="onDeploySetChange"
              placeholder="部署区域"
              class="body-header-input body-header-component"
            >
              <el-option
                v-for="item in DEPLOYMENT_SET"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </div>
          <div class="body-header-left-item">
            <span>行情环境：</span>
            <el-select
              v-model="searchKeyPlatformEnv"
              @change="onPlatformEnvChange"
              placeholder="行情环境"
              class="body-header-input body-header-component"
            >
              <el-option
                v-for="item in QUOTATION_PLATFORM_ENV_COMPACT"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </div>
          <div class="body-header-left-item">
            <span>账号：</span>
            <el-autocomplete
              class="body-header-input body-header-component"
              v-model="searchKeyAccount"
              :fetch-suggestions="queryFilterAccount"
              placeholder="请输入内容"
              clearable
            ></el-autocomplete>
          </div>
          <div class="body-header-left-item">
            <span>账号别名：</span>
            <el-autocomplete
              class="body-header-input body-header-component"
              v-model="searchKeyNickName"
              :fetch-suggestions="queryFilterAccountNickname"
              placeholder="请输入内容"
              clearable
            ></el-autocomplete>
          </div>
          <div class="body-header-left-item">
            <span>平台：</span>
            <el-select
              v-model="searchKeyPlatform"
              placeholder="平台"
              class="body-header-input body-header-component"
            >
              <el-option
                v-for="item in QUOTATION_TECH_PLATFORM"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </div>
          <div class="body-header-left-item">
            <span>券商：</span>
            <el-input
              class="body-header-input body-header-component"
              placeholder="券商"
              v-model="searchKeyBroker"
              clearable
            >
            </el-input>
          </div>
          <div class="body-header-left-item">
            <span>商品：</span>
            <el-input
              class="body-header-input body-header-component"
              placeholder="商品"
              v-model="searchKeyCommodity"
              clearable
            >
            </el-input>
          </div>
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
            @click="showAddQuotationAccountDialog"
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
            <th width="100">ID</th>
            <th width="200">账号</th>
            <th width="200">账号别名</th>
            <th width="100">平台</th>
            <th width="200">券商</th>
            <th width="200">行情环境</th>
            <th width="200">席位</th>
            <th width="200">可订阅合约数量</th>
            <th width="200">附加信息</th>
            <th width="200">接入状态</th>
            <th width="200">使用状态</th>
            <th width="200">不可用原因</th>
            <th width="400">操作</th>
          </tr>
          <tr
            v-for="(quotationAccountInfo, index) in quotationAccountInfoList"
            v-bind:key="index"
          >
            <td>{{quotationAccountInfo.accountId}}</td>
            <td>{{quotationAccountInfo.accountName}}</td>
            <td>{{quotationAccountInfo.nickName}}</td>
            <td>{{QUOTATION_TECH_PLATFORM[quotationAccountInfo.platform].label}}</td>
            <td>{{quotationAccountInfo.brokerName}}</td>
            <td>{{QUOTATION_PLATFORM_ENV[quotationAccountInfo.platformEnv].label}}</td>
            <td>{{quotationAccountInfo.brokerAccessName}}</td>
            <td>{{quotationAccountInfo.maxRegisterCount}}</td>
            <td><a
                href="#"
                @click="showQuotationPropertyDialog(quotationAccountInfo)"
              >查看</a></td>
            <td>{{QUOTATION_ACCOUNT_ACCESS_STATE[quotationAccountInfo.accessState].label}}</td>
            <td>{{QUOTATION_ACCOUNT_STATE[quotationAccountInfo.accountState].label}}</td>
            <td v-if="quotationAccountInfo.invalidReason == ''">-</td>
            <td v-else>{{quotationAccountInfo.invalidReason}}</td>

            <td>
              <!-- <router-link
                class="body-table-operation"
                :to="'/accountRegisterAbility/' + quotationAccountInfo.accountId"
              >管理</router-link> -->
              <a
                href="#"
                class="body-table-operation"
                @click="gotoAccountRegisterAbilityPage(quotationAccountInfo)"
              >管理</a>
              <a
                href="#"
                class="body-table-operation"
                @click="showEditQuotationAccountDialog(quotationAccountInfo)"
              >编辑</a>
              <a
                v-if="quotationAccountInfo.accountState == QUOTATION_ACCOUNT_ENABLED"
                href="#"
                class="body-table-operation"
                @click="showDisabledQuotationAccountDialog(quotationAccountInfo)"
              >停用</a>
              <a
                v-else
                href="#"
                class="body-table-operation"
                @click="showEnabledQuotationAccountDialog(quotationAccountInfo)"
              >启用</a>
              <a
                href="#"
                class="body-table-operation"
                @click="showRemoveQuotationAccountDialog(quotationAccountInfo)"
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
      @confirm="confirmAddition"
      @close="cancelAddition"
    ></dialog-addition>
    <dialog-edition
      v-bind:isShow="isShowEditionDialog"
      :quotationAccountInfo="selectedQuotationAccountInfo"
      @confirm="confirmEdition"
      @close="cancelEdition"
    ></dialog-edition>
    <dialog-quotation-property
      v-bind:isShow="isShowQuotationPropertyDialog"
      :quotationAccountInfo="selectedQuotationAccountInfo"
      @close="closeQuotationPropertyDialog"
    ></dialog-quotation-property>
  </div>
</template>

<script>
import AddQuotationAccountDialog from "../components/specdialog/AddQuotationAccountDialog.vue";
import EditQuotationAccountDialog from "../components/specdialog/EditQuotationAccountDialog.vue";
import QuotationAccountPropertyDialog from "../components/specdialog/QuotationAccountPropertyDialog.vue";
import { Alert } from 'element-ui';
export default {
  components: {
    "dialog-addition": AddQuotationAccountDialog,
    "dialog-edition": EditQuotationAccountDialog,
    "dialog-quotation-property": QuotationAccountPropertyDialog
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
      isShowQuotationPropertyDialog: false,

      // dialog param
      selectedQuotationAccountInfo: null,

      // search options
      quotationAccountOptions: [],
      quotationAccountNicknameOptions: [],

      // search key
      searchKeyDeployment: this.$config.DEPLOYMENT_SET.ITEMS[0].value,
      searchKeyPlatformEnv: this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS[0].value,
      searchKeyAccount: null,
      searchKeyNickName: null,
      searchKeyPlatform: null,
      searchKeyBroker: null,
      searchKeyCommodity: null,

      // data
      nodata: true,
      quotationAccountInfoList: null,

      // const config
      DEPLOYMENT_SET: this.$config.DEPLOYMENT_SET.ITEMS,
      QUOTATION_PLATFORM_ENV_COMPACT: this.$config
        .QUOTATION_PLATFORM_ENV_COMPACT.ITEMS,
      QUOTATION_TECH_PLATFORM: this.$config.QUOTATION_TECH_PLATFORM.ITEMS,
      QUOTATION_PLATFORM_ENV: this.$config.QUOTATION_PLATFORM_ENV.ITEMS,
      QUOTATION_TECH_PLATFORM: this.$config.QUOTATION_TECH_PLATFORM.ITEMS,
      QUOTATION_ACCOUNT_ENABLED: QuotationAccountState.ACCOUNT_ENABLED,
      QUOTATION_ACCOUNT_STATE: this.$config.QUOTATION_ACCOUNT_STATE.ITEMS,
      QUOTATION_ACCOUNT_ACCESS_STATE: this.$config
        .QUOTATION_ACCOUNT_ACCESS_STATE.ITEMS
    };
  },
  mounted() {
    this.reqQuotationAccountInfo();
    this.reqQuotationAccountInfoForSearchOptions();
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
        that.$router.push("/subscribedPreview/quotationAccount");
      });
    },
    gotoAccountRegisterAbilityPage(quotationAccountInfo) {
      ///accountRegisterAbility/
      this.$router.push({
        path: "/accountRegisterAbility",
        query: {
          accountId: quotationAccountInfo.accountId,
          acountName: quotationAccountInfo.accountName,
          nickName: quotationAccountInfo.nickName,
          platformEnv: quotationAccountInfo.platformEnv
        }
      });
    },
    onDeploySetChange() {
      this.$store.commit('setQuotationAccountDeploySet', this.searchKeyDeployment)
      this.reqQuotationAccountInfo();
    },
    onPlatformEnvChange() {
      // alert("this.searchKeyPlatformEnv : " + this.searchKeyPlatformEnv)
      this.$store.commit('setQuotationAccountPlatformEnv', this.searchKeyPlatformEnv)
      // alert("this.$store.state.quotationAccount.platfromEnv : " + this.$store.state.quotationAccount.platfromEnv)
      this.reqQuotationAccountInfo();
    },
    setSearchKeys() {
      if (this.$store.state.quotationAccount.deploySet != null && this.$store.state.quotationAccount.deploySet != undefined) {
        this.searchKeyDeployment = this.$store.state.quotationAccount.deploySet//this.$config.DEPLOYMENT_SET.ITEMS[this.$store.state.quotationAccount.deploySet].value
        // alert("this.searchKeyPlatformEnv : setSearchKeys " + this.searchKeyPlatformEnv)
      }
      if (this.$store.state.quotationAccount.platfromEnv != null && this.$store.state.quotationAccount.platfromEnv != undefined) {
        this.searchKeyPlatformEnv = this.$store.state.quotationAccount.platfromEnv//this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS[this.$store.state.quotationAccount.platfromEnv].value
      }
    },
    onPageChange(currentPage) {
      this.currentPage = currentPage;
      this.reqQuotationAccountInfo();
    },
    handleSizeChange(size) {
      this.pageSize = size;
      this.reqQuotationAccountInfo();
    },
    queryFilterAccount(queryString, cb) {
      var restaurants = this.quotationAccountOptions;
      var results = queryString
        ? restaurants.filter(this.createFilter(queryString))
        : restaurants;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    queryFilterAccountNickname(queryString, cb) {
      var restaurants = this.quotationAccountNicknameOptions;
      var results = queryString
        ? restaurants.filter(this.createFilter(queryString))
        : restaurants;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter(queryString) {
      return restaurant => {
        return (
          restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) ===
          0
        );
      };
    },
    reqQuotationAccountInfo() {
      this.setSearchKeys()
      var that = this;
      var reqQuotationAccountInfoOption = new ReqQuotationAccountInfoOption();

      if (this.searchKeyAccount) {
        reqQuotationAccountInfoOption.accountNamePartical = this.searchKeyAccount;
      }
      if (this.searchKeyNickName) {
        reqQuotationAccountInfoOption.accountNickNamePartical = this.searchKeyNickName;
      }
      if (this.searchKeyBroker) {
        reqQuotationAccountInfoOption.brokerNamePartical = this.searchKeyBroker;
      }
      if (this.searchKeyCommodity) {
        reqQuotationAccountInfoOption.commodityNamePartical = this.searchKeyCommodity;
      }
      if (
        this.searchKeyPlatformEnv != null &&
        this.searchKeyPlatformEnv != "NONE"
      ) {
        reqQuotationAccountInfoOption.platformEnv =
          TechPlatformEnv[this.searchKeyPlatformEnv];
      } else {
        reqQuotationAccountInfoOption.platformEnv = null;
      }
      if (this.searchKeyPlatform != null && this.searchKeyPlatform != "NONE") {
        reqQuotationAccountInfoOption.platform =
          TechPlatform[this.searchKeyPlatform];
      } else {
        reqQuotationAccountInfoOption.platform = null;
      }
      if (this.searchKeyDeployment) {
        reqQuotationAccountInfoOption.deploySet = DeploySet[this.searchKeyDeployment]
      }

      var pageOption = new IndexedPageOption();
      pageOption.needTotalCount = true;
      pageOption.pageIndex = this.currentPage - 1;
      pageOption.pageSize = this.pageSize;
      this.$api.reqQuotationAccountInfo(
        reqQuotationAccountInfoOption,
        pageOption,
        function(response) {
          if (response != null && response.errorMsg) {
            alert(JSON.stringify(response));
          } else {
            if (
              response == null ||
              response.page == null ||
              response.page.length < 1
            ) {
              that.quotationAccountInfoList = [];
              that.nodata = true;
              return;
            }
            // alert("response.page : " + JSON.stringify(response.page))
            that.quotationAccountInfoList = response.page;
            that.nodata = false;
            that.totalNum = response.total;
          }
        }
      );
    },
    reqQuotationAccountInfoForSearchOptions() {
      var that = this;
      var reqQuotationAccountInfoOption = new ReqQuotationAccountInfoOption();

      this.$api.reqQuotationAccountInfo(
        reqQuotationAccountInfoOption,
        null,
        function(response) {
          if (response != null && response.errorMsg) {
            alert(JSON.stringify(response));
          } else {
            if (
              response != null ||
              response.page != null ||
              response.page.length > 0
            ) {
              that.getQuotationAccountOptions(response.page);
            }
          }
        }
      );
    },
    getQuotationAccountOptions(quotationAccountInfoList) {
      for (var index = 0; index < quotationAccountInfoList.length; index++) {
        var item = {
          value: quotationAccountInfoList[index].accountName,
          label: quotationAccountInfoList[index].accountName
        };
        this.quotationAccountOptions.push(item);
        item = {
          value: quotationAccountInfoList[index].nickName,
          label: quotationAccountInfoList[index].nickName
        };
        this.quotationAccountNicknameOptions.push(item);
      }
    },
    query() {
      // alert("敬请期待")
      this.reqQuotationAccountInfo();
    },
    showAddQuotationAccountDialog() {
      this.isShowAdditionDialog = true;
    },
    confirmAddition() {
      this.isShowAdditionDialog = false;
      this.reqQuotationAccountInfo();
    },
    cancelAddition() {
      this.isShowAdditionDialog = false;
    },
    showEditQuotationAccountDialog(quotationAccountInfo) {
      this.selectedQuotationAccountInfo = quotationAccountInfo;
      this.isShowEditionDialog = true;
    },
    confirmEdition() {
      this.isShowEditionDialog = false;
      this.reqQuotationAccountInfo();
    },
    cancelEdition() {
      this.isShowEditionDialog = false;
    },
    showQuotationPropertyDialog(quotationAccountInfo) {
      this.selectedQuotationAccountInfo = quotationAccountInfo;
      this.isShowQuotationPropertyDialog = true;
    },
    closeQuotationPropertyDialog() {
      this.isShowQuotationPropertyDialog = false;
    },
    showDisabledQuotationAccountDialog(quotationAccountInfo) {
      if (confirm("确认停用？")) {
        var that = this;
        var updateQuotationAccountInfo = new QuotationAccountInfo();
        updateQuotationAccountInfo.accountId = quotationAccountInfo.accountId;
        updateQuotationAccountInfo.accountState =
          QuotationAccountState.ACCOUNT_DISABLED;
        this.$api.updateQuotationAccountInfo(
          updateQuotationAccountInfo,
          function(response) {
            if (response != null && response.errorMsg) {
              alert(JSON.stringify(response));
            } else {
              alert("已停用");
              that.reqQuotationAccountInfo();
            }
          }
        );
      }
    },
    showEnabledQuotationAccountDialog(quotationAccountInfo) {
      if (confirm("确认启用？")) {
        var that = this;
        var updateQuotationAccountInfo = new QuotationAccountInfo();
        updateQuotationAccountInfo.accountId = quotationAccountInfo.accountId;
        updateQuotationAccountInfo.accountState =
          QuotationAccountState.ACCOUNT_ENABLED;
        this.$api.updateQuotationAccountInfo(
          updateQuotationAccountInfo,
          function(response) {
            if (response != null && response.errorMsg) {
              alert(JSON.stringify(response));
            } else {
              alert("已启用");
              that.reqQuotationAccountInfo();
            }
          }
        );
      }
    },
    showRemoveQuotationAccountDialog(quotationAccountInfo) {
      if (confirm("确认删除？")) {
        var that = this;
        this.$api.deleteQuotationAccount(
          quotationAccountInfo.accountId,
          function(response) {
            if (response != null && response.errorMsg) {
              alert(JSON.stringify(response));
            } else {
              alert("已删除");
              that.reqQuotationAccountInfo();
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
}
.body-header-left-item {
  margin-top: 5px;
  margin-bottom: 5px;
  margin-right: 20px;
}
</style>
