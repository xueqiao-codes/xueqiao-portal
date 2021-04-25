<template>
  <div class="page">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/subscribedQuotation' }">行情订阅管理 已订阅行情</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="header">
      <div class="header-text">行情订阅管理</div>
      <ul class="header-tab">
        <li @click="gotoTabCommodityActiveConfig">活跃合约规律</li>
        <li @click="gotoTabSubcribedContract">订阅商品合约</li>
        <li @click="gotoTabQuotationAccount">行情账号</li>
        <li class="active">已订阅行情</li>
        <li @click="gotoTabPlanedSubscribedPreview">已规划订阅</li>
        <li @click="gotoTabSubscribedPreview">重新规划预览</li>
      </ul>
    </div>
    <div class="body">
      <div class="body-header">
        <div class="body-header-left">
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
          <span>商品：</span>
          <el-input
            class="body-header-input body-header-component"
            placeholder="商品名"
            v-model="searchKeyCommodity"
            clearable
          >
          </el-input>
          <span>账号别名：</span>
          <el-autocomplete
            class="body-header-input body-header-component"
            v-model="searchKeyAccountName"
            :fetch-suggestions="queryFilterAccount"
            clearable
            placeholder="请输入内容"
          ></el-autocomplete>

          <el-button
            class="body-header-component"
            type="primary"
            size="small"
            @click="query"
          >查询</el-button>
        </div>
      </div>
      <div class="body-content">
        <table>
          <tr bgColor=#F8FCFF>
            <th width="400">交易所</th>
            <th width="400">商品</th>
            <th width="400">账号别名(账号)</th>
            <th width="400">行情环境</th>
            <th width="800">订阅的活跃合约</th>
            <th width="400">订阅的非活跃合约</th>
            <!-- <th width="400">不可用原因</th> -->
          </tr>
          <tr
            v-for="(subscribedContract, index) in subscribedContractList"
            v-bind:key="index"
          >
            <td>{{subscribedContract.exchangeName}}</td>
            <td>{{subscribedContract.commodityName}}</td>
            <td>{{subscribedContract.accountName}}</td>
            <td>{{QUOTATION_PLATFORM_ENV[subscribedContract.platformEnv].label}}</td>
            <td v-if="subscribedContract.isActiveMonth">{{subscribedContract.contractName}}</td>
            <td v-else>-</td>
            <td v-if="!subscribedContract.isActiveMonth">{{subscribedContract.contractName}}</td>
            <td v-else>-</td>
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
  </div>
</template>

<script>
export default {
  data() {
    return {
      // page
      totalNum: 0,
      currentPage: 1,
      pageSize: 10,

      // search options
      quotationAccountOptions: [],

      // search key
      searchKeyDeployment: this.$config.DEPLOYMENT_SET.ITEMS[0].value,
      searchKeyPlatformEnv: this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS[0].value,
      searchKeyCommodity: null,
      searchKeyAccountName: null,

      // const
      DEPLOYMENT_SET: this.$config.DEPLOYMENT_SET.ITEMS,
      QUOTATION_PLATFORM_ENV_COMPACT: this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS,
      QUOTATION_PLATFORM_ENV: this.$config.QUOTATION_PLATFORM_ENV.ITEMS,

      // data
      nodata: true,
      subscribedContractList: null
    };
  },
  mounted() {
    this.reqSubscribedContract();
    this.reqQuotationAccountInfo();
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
    onPageChange(currentPage) {
      this.currentPage = currentPage;
      this.reqSubscribedContract();
    },
    handleSizeChange(size) {
      this.pageSize = size;
      this.reqSubscribedContract();
    },
    onDeploySetChange() {
      this.$store.commit('setSubscribedQuotationDeploySet', this.searchKeyDeployment)
      this.reqSubscribedContract()
    },
    onPlatformEnvChange() {
      this.$store.commit('setSubscribedQuotationPlatformEnv', this.searchKeyPlatformEnv)
      this.reqSubscribedContract()
    },
    setSearchKeys() {
      if (this.$store.state.subscribedQuotation.deploySet != null && this.$store.state.subscribedQuotation.deploySet != undefined) {
        this.searchKeyDeployment = this.$store.state.subscribedQuotation.deploySet
      }
      if (this.$store.state.subscribedQuotation.platfromEnv != null && this.$store.state.subscribedQuotation.platfromEnv != undefined) {
        this.searchKeyPlatformEnv = this.$store.state.subscribedQuotation.platfromEnv
      }
    },
    reqQuotationAccountInfo() {
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
    queryFilterAccount(queryString, cb) {
      var restaurants = this.quotationAccountOptions;
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
    getQuotationAccountOptions(quotationAccountInfoList) {
      for (var index = 0; index < quotationAccountInfoList.length; index++) {
        var item = {
          value: quotationAccountInfoList[index].nickName,
          label: quotationAccountInfoList[index].nickName
        };
        this.quotationAccountOptions.push(item);
      }
    },
    query() {
      this.reqSubscribedContract();
    },
    reqSubscribedContract() {
      this.setSearchKeys()
      var that = this;
      var reqSubscribedContractOption = new ReqSubscribedContractOption();

      if (this.searchKeyAccountName) {
        reqSubscribedContractOption.accountNamePartical = this.searchKeyAccountName;
      }
      if (this.searchKeyCommodity) {
        reqSubscribedContractOption.commodityNamePartical = this.searchKeyCommodity;
      }
      if (this.searchKeyPlatformEnv) {
        reqSubscribedContractOption.platformEnv =
          TechPlatformEnv[this.searchKeyPlatformEnv];
      }
      if (this.searchKeyDeployment) {
        reqSubscribedContractOption.deploySet = DeploySet[this.searchKeyDeployment]
      }

      // alert("reqSubscribedContractOption : " + JSON.stringify(reqSubscribedContractOption))

      var pageOption = new IndexedPageOption();
      pageOption.needTotalCount = true;
      pageOption.pageIndex = this.currentPage - 1;
      pageOption.pageSize = this.pageSize;

      // alert("pageOption : " + JSON.stringify(pageOption))

      this.$api.reqSubscribedContract(
        reqSubscribedContractOption,
        pageOption,
        function(response) {

          // alert("response : " + JSON.stringify(response))

          if (response != null && response.errorMsg) {
            alert(response.errorMsg);
          } else {
            if (
              response == null ||
              response.page == null ||
              response.page.length < 1
            ) {
              that.nodata = true;
              that.subscribedContractList = [];
              return;
            } else {
              that.nodata = false;
              that.subscribedContractList = response.page;
              that.totalNum = response.total;
            }
          }
        }
      );
    }
  }
};
</script>

<style scoped>
.body-header-input {
  width: 150px;
  margin-right: 20px;
}
</style>
