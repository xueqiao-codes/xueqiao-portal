<template>
  <div class="page">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item
          v-if="from == 'commodityActiveConfig'"
          :to="{ path: '/commodityActiveConfig' }"
        >行情订阅管理 活跃合约规律</el-breadcrumb-item>
        <el-breadcrumb-item
          v-else-if="from == 'quotationAccount'"
          :to="{ path: '/quotationAccount' }"
        >行情订阅管理 行情账号</el-breadcrumb-item>
        <el-breadcrumb-item
          v-else-if="from == 'subscribedContract'"
          :to="{ path: '/subscribedContract' }"
        >行情订阅管理 订阅商品合约</el-breadcrumb-item>
        <el-breadcrumb-item
          v-if="from == 'tab'"
          :to="{ path: '/subscribedPreview/' + from }"
        >行情订阅管理 重新规划预览</el-breadcrumb-item>
        <el-breadcrumb-item
          v-else
          :to="{ path: '/subscribedPreview/' + from }"
        >重新规划订阅 — 预览</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="header">
      <div
        v-if="from == 'tab'"
        class="header-text"
      >行情订阅管理</div>
      <div
        v-else
        class="header-text"
      >重新规划订阅 —— 预览</div>
      <ul
        v-if="from == 'tab'"
        class="header-tab"
      >
        <li @click="gotoTabCommodityActiveConfig">活跃合约规律</li>
        <li @click="gotoTabSubcribedContract">订阅商品合约</li>
        <li @click="gotoTabQuotationAccount">行情账号</li>
        <li @click="gotoTabSubscribedQuotation">已订阅行情</li>
        <li @click="gotoTabPlanedSubscribedPreview">已规划订阅</li>
        <li class="active">重新规划预览</li>
      </ul>
    </div>
    <div class="body">
      <div class="body-header">
        <div class="body-header-left">
          <span>商品：</span>
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

          <span>上次规划时间：</span>
          <span class="body-header-input">{{lastReplanSubscribedTime}}</span>

          <el-button
            class="body-header-component"
            type="primary"
            size="small"
            @click="showSubmitDialog"
          >提交</el-button>
        </div>
      </div>
      <div class="body-content">
        <table>
          <tr bgColor=#F8FCFF>
            <th width="300">行情环境</th>
            <th width="300">交易所</th>
            <th width="300">商品</th>

            <th width="200">订阅(前)</th>
            <th width="200">订阅(后)</th>
            <th width="300">备份数量(前)</th>
            <th width="300">备份数量(后)</th>
            <th width="300">合约编号(前)</th>
            <th width="300">合约编号(后)</th>
            <th width="100">更多</th>

            <!-- <th width="300">活跃月份(前)</th>
            <th width="300">活跃月份(后)</th>
            <th width="300">活跃订阅(前)</th>
            <th width="300">活跃订阅(后)</th>
            <th width="300">非活跃月份(前)</th>
            <th width="300">非活跃月份(后)</th>
            <th width="300">非活跃订阅(前)</th>
            <th width="300">非活跃订阅(后)</th> -->

          </tr>
          <tr
            v-for="(rePlanSubscribedInfoPreview, index) in rePlanSubscribedInfoPreviewList"
            v-bind:key="index"
          >
            <td :class="getStatus(rePlanSubscribedInfoPreview, 1)">{{QUOTATION_PLATFORM_ENV[rePlanSubscribedInfoPreview.platformEnv].label}}</td>
            <td :class="getStatus(rePlanSubscribedInfoPreview, 1)">{{rePlanSubscribedInfoPreview.exchangeName}}</td>
            <td :class="getStatus(rePlanSubscribedInfoPreview, 1)">{{rePlanSubscribedInfoPreview.commodityName}}</td>
            <td :class="getStatus(rePlanSubscribedInfoPreview, 2)">{{BOOLEAN[rePlanSubscribedInfoPreview.isCurrentSubcribe]}}</td>
            <td :class="getStatus(rePlanSubscribedInfoPreview, 2)">{{BOOLEAN[rePlanSubscribedInfoPreview.isReplanSubcribe]}}</td>

            <td
              v-if="rePlanSubscribedInfoPreview.isCurrentSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >{{rePlanSubscribedInfoPreview.currentFields.backupCounts}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >-</td>
            <td
              v-if="rePlanSubscribedInfoPreview.isReplanSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >{{rePlanSubscribedInfoPreview.rePlanFields.backupCounts}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >-</td>
            <td
              v-if="rePlanSubscribedInfoPreview.isCurrentSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >{{rePlanSubscribedInfoPreview.currentFields.fixedCode}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >-</td>
            <td
              v-if="rePlanSubscribedInfoPreview.isReplanSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >{{rePlanSubscribedInfoPreview.rePlanFields.fixedCode}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >-</td>

            <td :class="getStatus(rePlanSubscribedInfoPreview, 1)">
              <el-popover
                placement="bottom"
                width="1200"
                trigger="click"
              >
                <div class="popover">
                  <table>
                    <tr bgColor=#48FCFF>
                      <th width="300">活跃月份(前)</th>
                      <th width="300">活跃月份(后)</th>
                      <th width="300">活跃订阅(前)</th>
                      <th width="300">活跃订阅(后)</th>
                      <th width="300">非活跃月份(前)</th>
                      <th width="300">非活跃月份(后)</th>
                      <th width="300">非活跃订阅(前)</th>
                      <th width="300">非活跃订阅(后)</th>
                    </tr>
                    <tr>
                      <td
                        v-if="rePlanSubscribedInfoPreview.isCurrentSubcribe"
                        :class="getStatus(rePlanSubscribedInfoPreview, 2)"
                      >{{rePlanSubscribedInfoPreview.currentFields.activeMonths}}</td>
                      <td
                        v-else
                        :class="getStatus(rePlanSubscribedInfoPreview, 2)"
                      >-</td>
                      <td
                        v-if="rePlanSubscribedInfoPreview.isReplanSubcribe"
                        :class="getStatus(rePlanSubscribedInfoPreview, 2)"
                      >{{rePlanSubscribedInfoPreview.rePlanFields.activeMonths}}</td>
                      <td
                        v-else
                        :class="getStatus(rePlanSubscribedInfoPreview, 2)"
                      >-</td>
                      <td
                        v-if="rePlanSubscribedInfoPreview.isCurrentSubcribe"
                        :class="getStatus(rePlanSubscribedInfoPreview, 1)"
                      >{{rePlanSubscribedInfoPreview.currentFields.activeSubscribeNum}}</td>
                      <td
                        v-else
                        :class="getStatus(rePlanSubscribedInfoPreview, 1)"
                      >-</td>
                      <td
                        v-if="rePlanSubscribedInfoPreview.isReplanSubcribe"
                        :class="getStatus(rePlanSubscribedInfoPreview, 1)"
                      >{{rePlanSubscribedInfoPreview.rePlanFields.activeSubscribeNum}}</td>
                      <td
                        v-else
                        :class="getStatus(rePlanSubscribedInfoPreview, 1)"
                      >-</td>
                      <td
                        v-if="rePlanSubscribedInfoPreview.isCurrentSubcribe"
                        :class="getStatus(rePlanSubscribedInfoPreview, 2)"
                      >{{rePlanSubscribedInfoPreview.currentFields.inactiveMonths}}</td>
                      <td
                        v-else
                        :class="getStatus(rePlanSubscribedInfoPreview, 2)"
                      >-</td>
                      <td
                        v-if="rePlanSubscribedInfoPreview.isReplanSubcribe"
                        :class="getStatus(rePlanSubscribedInfoPreview, 2)"
                      >{{rePlanSubscribedInfoPreview.rePlanFields.inactiveMonths}}</td>
                      <td
                        v-else
                        :class="getStatus(rePlanSubscribedInfoPreview, 2)"
                      >-</td>
                      <td
                        v-if="rePlanSubscribedInfoPreview.isCurrentSubcribe"
                        :class="getStatus(rePlanSubscribedInfoPreview, 1)"
                      >{{rePlanSubscribedInfoPreview.currentFields.inActiveSubscribeNum}}</td>
                      <td
                        v-else
                        :class="getStatus(rePlanSubscribedInfoPreview, 1)"
                      >-</td>
                      <td
                        v-if="rePlanSubscribedInfoPreview.isReplanSubcribe"
                        :class="getStatus(rePlanSubscribedInfoPreview, 1)"
                      >{{rePlanSubscribedInfoPreview.rePlanFields.inActiveSubscribeNum}}</td>
                      <td
                        v-else
                        :class="getStatus(rePlanSubscribedInfoPreview, 1)"
                      >-</td>
                    </tr>
                  </table>
                </div>
                <a
                  class="td-item-more"
                  href="#"
                  slot="reference"
                >>>></a>
              </el-popover>
            </td>

            <!-- <td
              v-if="rePlanSubscribedInfoPreview.isCurrentSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >{{rePlanSubscribedInfoPreview.currentFields.activeMonths}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >-</td>
            <td
              v-if="rePlanSubscribedInfoPreview.isReplanSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >{{rePlanSubscribedInfoPreview.rePlanFields.activeMonths}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >-</td>
            <td
              v-if="rePlanSubscribedInfoPreview.isCurrentSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >{{rePlanSubscribedInfoPreview.currentFields.activeSubscribeNum}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >-</td>
            <td
              v-if="rePlanSubscribedInfoPreview.isReplanSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >{{rePlanSubscribedInfoPreview.rePlanFields.activeSubscribeNum}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >-</td>
            <td
              v-if="rePlanSubscribedInfoPreview.isCurrentSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >{{rePlanSubscribedInfoPreview.currentFields.inactiveMonths}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >-</td>
            <td
              v-if="rePlanSubscribedInfoPreview.isReplanSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >{{rePlanSubscribedInfoPreview.rePlanFields.inactiveMonths}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 2)"
            >-</td>
            <td
              v-if="rePlanSubscribedInfoPreview.isCurrentSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >{{rePlanSubscribedInfoPreview.currentFields.inActiveSubscribeNum}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >-</td>
            <td
              v-if="rePlanSubscribedInfoPreview.isReplanSubcribe"
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >{{rePlanSubscribedInfoPreview.rePlanFields.inActiveSubscribeNum}}</td>
            <td
              v-else
              :class="getStatus(rePlanSubscribedInfoPreview, 1)"
            >-</td> -->
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
      rePlanSubscribedInfoPreviewList: null,
      rePlanSubscribedState: null,
      lastReplanSubscribedTime: "-"
    };
  },
  mounted() {
    this.from = this.$route.params.from;
    this.reqPreviewSubscribedContract();
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
      this.reqPreviewSubscribedContract();
    },
    reqPreviewSubscribedContract() {
      var options = {
        text: "订阅规划中...",
        lock: true,
        background: "rgba(0, 0, 0, 0.1)"
      };
      var loadingInstance = Loading.service(options);

      var that = this;
      var reqRePlanSubscribedInfoPreviewOption = new ReqRePlanSubscribedInfoPreviewOption();

      if (this.searchKeyCommodity) {
        reqRePlanSubscribedInfoPreviewOption.commodityNamePartical = this.searchKeyCommodity;
      }
      if (
        this.searchKeyPlatformEnv != null &&
        this.searchKeyPlatformEnv != "NONE"
      ) {
        reqRePlanSubscribedInfoPreviewOption.platformEnv =
          TechPlatformEnv[this.searchKeyPlatformEnv];
      }

      this.$api.reqPreviewSubscribedContract(
        reqRePlanSubscribedInfoPreviewOption,
        function(response) {
          that.nodata = true;
          that.rePlanSubscribedInfoPreviewList = [];

          if (response != null && response.errorMsg) {
            if (loadingInstance != null) {
              loadingInstance.close();
            }
            alert(response.errorMsg);
          } else {
            if (response == null || response.state == null) {
              alert("接口返回结果为空");
              loadingInstance.close();
            } else {
              if (response.state == 0) {
                alert("重新规划结果为空");
                loadingInstance.close();
              } else if (response.state == 1) {
                setTimeout(function() {
                  loadingInstance.close();
                  that.reqPreviewSubscribedContract();
                }, 3000);
              } else if (response.state == 2) {
                loadingInstance.close();
                if (response.page != null || response.page.length > 0) {
                  that.nodata = false;
                  that.rePlanSubscribedState = response.state;
                  that.rePlanSubscribedInfoPreviewList = response.page;

                  var lastUpdateTime = new Date(response.lastUpdateTimestampMs);
                  that.lastReplanSubscribedTime = lastUpdateTime.toLocaleString();
                } else {
                  alert("重新规划结束，但结果为空");
                }
              } else if (response.state == 3) {
                loadingInstance.close();
                alert("重新规划失败");
              }
            }
          }
        }
      );
    },
    submitSubscribeInfo() {
      var that = this;
      var platformEnv = TechPlatformEnv.NONE;
      this.$api.submitSubscribeInfo(platformEnv, function(response) {
        if (response != null && response.errorMsg) {
          alert(response.errorMsg);
        } else {
          alert("提交成功");
        }
      });
    },
    showSubmitDialog() {
      if (confirm("确认提交？")) {
        this.submitSubscribeInfo();
      }
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
        if (level == 2) {
          return "table-item-bg-default-2";
        } else {
          return "table-item-bg-default-1";
        }
        // return "table-item-bg-default";
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
.td-item-more {
  height: 100%;
}
.popover {
  /* background-color: rgba(0, 0, 0, 0.3); */
  border: 2px solid #a5a5a5;
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
.table-item-bg-default-1 {
  background-color: rgba(0, 0, 0, 0);
}
.table-item-bg-default-2 {
  background-color: rgba(0, 0, 0, 0.03);
}
.table-item-bg-error {
  background-color: rgba(255, 64, 64, 0.5);
}
</style>
