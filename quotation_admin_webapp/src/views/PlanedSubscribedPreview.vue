<template>
  <div class="page">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/planedSubscribedPreview' }">行情订阅管理 已规划订阅</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="header">
      <div class="header-text">行情订阅管理</div>
      <ul class="header-tab">
        <li @click="gotoTabCommodityActiveConfig">活跃合约规律</li>
        <li @click="gotoTabSubcribedContract">订阅商品合约</li>
        <li @click="gotoTabQuotationAccount">行情账号</li>
        <li @click="gotoTabSubscribedQuotation">已订阅行情</li>
        <li class="active">已规划订阅</li>
        <li @click="gotoTabSubscribedPreview">重新规划预览</li>
      </ul>
    </div>
    <div class="body">
      <div class="body-header">
        <div class="body-header-left">
          <span>商品名：</span>
          <el-input
            class="body-header-input body-header-component"
            placeholder="商品名"
            v-model="searchKeyCommodity"
            clearable
          >
          </el-input>
          <span>行情环境：</span>
          <el-select
            v-model="searchKeyPlatformEnv"
            placeholder="行情环境"
            class="body-header-input body-header-component"
          >
            <el-option
              v-for="item in QUOTATION_PLATFORM_ENV"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
          <el-button
            class="body-header-component"
            type="primary"
            size="small"
            @click="query"
          >查询</el-button>
        </div>
        <div class="body-header-right">
        </div>
      </div>
      <div class="body-content">
        <table>
          <tr bgColor=#F8FCFF>
            <th width="300">行情环境</th>
            <th width="300">交易所</th>
            <th width="300">商品</th>
            <th width="300">备份数量</th>
            <th width="300">活跃月份</th>
            <th width="300">活跃订阅</th>
            <th width="300">非活跃月份</th>
            <th width="300">非活跃订阅</th>
            <th width="300">合约编号</th>
          </tr>
          <tr
            v-for="(planningSubscribedInfo, index) in planningSubscribedInfoList"
            v-bind:key="index"
          >
            <td>{{QUOTATION_PLATFORM_ENV[planningSubscribedInfo.platformEnv].label}}</td>
            <td>{{planningSubscribedInfo.exchangeName}}</td>
            <td>{{planningSubscribedInfo.commodityName}}</td>
            <td>{{planningSubscribedInfo.fields.backupCounts}}</td>
            <td>{{planningSubscribedInfo.fields.activeMonths}}</td>
            <td>{{planningSubscribedInfo.fields.activeSubscribeNum}}</td>
            <td>{{planningSubscribedInfo.fields.inactiveMonths}}</td>
            <td>{{planningSubscribedInfo.fields.inActiveSubscribeNum}}</td>
            <td>{{planningSubscribedInfo.fields.fixedCode}}</td>
          </tr>
        </table>
        <div
          class="body-content-nodata"
          v-if="nodata"
        >无数据</div>
      </div>
      <div class="pagination">
      </div>
    </div>
  </div>
</template>

<script>
import { Loading } from "element-ui";
export default {
  data() {
    return {
      // param
      from: "commodityActiveConfig",

      // search key
      searchKeyCommodity: null,
      searchKeyPlatformEnv: null,

      // const
      QUOTATION_PLATFORM_ENV: this.$config.QUOTATION_PLATFORM_ENV.ITEMS,
      BOOLEAN: {
        false: "否",
        true: "是"
      },

      // data
      nodata: true,
      //   rePlanSubscribedInfoPreviewList: null,
      planningSubscribedInfoList: null,
      rePlanSubscribedState: null,
      lastReplanSubscribedTime: "-"
    };
  },
  mounted() {
    this.from = this.$route.params.from;
    this.reqPlanningSubscribedInfo();
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
    query() {
      this.reqPlanningSubscribedInfo();
    },
    reqPlanningSubscribedInfo() {
      var that = this;

      var reqPlanningSubscribedInfoOption = new ReqPlanningSubscribedInfoOption();

      if (this.searchKeyCommodity) {
        reqPlanningSubscribedInfoOption.commodityNamePartical = this.searchKeyCommodity;
      }
      if (
        this.searchKeyPlatformEnv != null &&
        this.searchKeyPlatformEnv != "NONE"
      ) {
        reqPlanningSubscribedInfoOption.platformEnv =
          TechPlatformEnv[this.searchKeyPlatformEnv];
      }

      // alert("reqPlanningSubscribedInfoOption : " + JSON.stringify(reqPlanningSubscribedInfoOption))
      this.$api.reqPlanningSubscribedInfo(
        reqPlanningSubscribedInfoOption,
        function(response) {
          // alert("response : " + JSON.stringify(response))
          if (response != null && response.errorMsg) {
            alert(response.errorMsg);
          } else {
            if (response == null) {
              that.planningSubscribedInfoList = [];
              that.nodata = true;
              return;
            }
            that.planningSubscribedInfoList = response;
            if (that.planningSubscribedInfoList.length < 1) {
              that.nodata = true;
            } else {
              that.nodata = false;
            }
          }
        }
      );
    },
    getStatus(rePlanSubscribedInfoPreview, level) {
      if (!rePlanSubscribedInfoPreview.isReplanSubcribe) {
        if (level == 2) {
          return "table-item-bg-red-2";
        } else {
          return "table-item-bg-red-1";
        }
      } else if (
        !rePlanSubscribedInfoPreview.isCurrentSubcribe &&
        rePlanSubscribedInfoPreview.isReplanSubcribe
      ) {
        if (level == 2) {
          return "table-item-bg-green-2";
        } else {
          return "table-item-bg-green-1";
        }
      } else if (rePlanSubscribedInfoPreview.isFieldsDifferent) {
        if (level == 2) {
          return "table-item-bg-blue-2";
        } else {
          return "table-item-bg-blue-1";
        }
      } else {
        return "table-item-bg-default";
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
.table-item-bg-red-1 {
  background-color: rgba(255, 64, 64, 0.1);
}
.table-item-bg-red-2 {
  background-color: rgba(255, 64, 64, 0.2);
}
.table-item-bg-green-1 {
  background-color: rgba(46, 204, 34, 0.1);
}
.table-item-bg-green-2 {
  background-color: rgba(46, 204, 34, 0.2);
}
.table-item-bg-blue-1 {
  background-color: rgba(30, 123, 230, 0.1);
}
.table-item-bg-blue-2 {
  background-color: rgba(30, 123, 230, 0.2);
}
.table-item-bg-default {
  background-color: transparent;
}
.table-item-bg-error {
  background-color: rgba(255, 64, 64, 0.5);
}
</style>
