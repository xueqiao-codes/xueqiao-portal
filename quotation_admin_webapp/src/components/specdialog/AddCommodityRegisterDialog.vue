<template>
  <div
    v-if="isShow"
    class="dialog-bg"
  >
    <div class="dialog-container">
      <div class="dialog-header">
        <div class="dialog-title">添加订阅商品</div>
        <div class="dialog-close">
          <a
            href="#"
            @click="close"
          ><img src="../../assets/img/icon_close.png" /></a>
        </div>
      </div>
      <div class="dialog-content">
        <div class="input-item">
          <div class="input-key my-input-key">
            <span>行情环境：</span>
          </div>
          <div class="input-value my-input-value">
            <el-select
              v-model="selectedPlatfromEnv"
              placeholder="请选择"
              @change="onPlatformEnvChange"
              class="my-input-value"
            >
              <el-option
                v-for="item in platformEnvOptionsCompact"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key my-input-key">
            <span>商品：</span>
          </div>
          <div class="input-value my-input-value">
            <el-cascader
              expand-trigger="hover"
              :options="commodityOptions"
              placeholder="选择行情环境后才有效"
              v-model="selectedCommodityOption"
              :show-all-levels="false"
              @change="onCommodityChange"
              class="my-input-value"
            ></el-cascader>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key my-input-key">
            <span>类型：</span>
          </div>
          <div class="input-value my-input-value">
            <el-select
              v-model="selectedContractActiveType"
              placeholder="请选择"
              @change="onContractActiveTypeChange"
              class="my-input-value"
            >
              <el-option
                v-for="item in CONTRACT_ACTIVE_TYPE"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </div>
        </div>
        <div v-if="selectedContractActiveType == CONTRACT_ACTIVE_TYPE_ACTIVE_MONTH">
          <div class="multi-input-item">
            <div class="multi-input-key my-input-key"><span>活跃合约月份:</span></div>

            <div class="input-value selected-month my-input-value">
              <span
                v-for="month in activeMonthList"
                :key="month"
              >{{month}}月;&nbsp;</span>
            </div>
          </div>
          <div class="input-item">
            <div class="input-key my-input-key">
              <span>活跃数量(近月优先)：</span>
            </div>
            <div class="input-value my-input-value">
              <el-select
                v-model="selectedActiveShowCount"
                placeholder="请选择"
                class="my-input-value"
              >
                <el-option
                  v-for="item in contractCountOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                >
                </el-option>
              </el-select>
            </div>
          </div>
          <div class="multi-input-item">
            <div class="multi-input-key my-input-key"><span>非活跃合约月份:</span></div>

            <div class="input-value selected-month my-input-value">
              <span
                v-for="month in inactiveMonthList"
                :key="month"
              >{{month}}月;&nbsp;</span>
            </div>
          </div>
          <div class="input-item">
            <div class="input-key my-input-key">
              <span>非活跃数量(近月优先)：</span>
            </div>
            <div class="input-value my-input-value">
              <el-select
                v-model="selectedInactiveShowCount"
                placeholder="请选择"
                class="my-input-value"
              >
                <el-option
                  v-for="item in contractCountOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                >
                </el-option>
              </el-select>
            </div>
          </div>
        </div>
        <div v-else-if="selectedContractActiveType == CONTRACT_ACTIVE_TYPE_FIXED_CODE">
          <div class="input-item">
            <div class="input-key my-input-key"><span>合约号:</span></div>
            <div class="input-value my-input-value">
              <el-select
                v-model="selectedContractFixedCode"
                placeholder="请选择"
                @change="onContractActiveTypeChange"
                class="my-input-value"
              >
                <el-option
                  v-for="item in contractFixedCodeList"
                  :key="item"
                  :label="item"
                  :value="item"
                >
                </el-option>
              </el-select>
            </div>
          </div>
        </div>
        <div v-else></div>
      </div>
      <div class="dialog-button-container">
        <el-button
          type="primary"
          size="medium"
          @click="confirm"
        >确定</el-button>
        <el-button
          size="medium"
          @click="close"
        >取消</el-button>
      </div>
    </div>
    <dialog-commodity-active-config-addition
      v-bind:isShow="isShowCommodityActiveConfigAdditionDialog"
      :selectedOptions="selectedCommodityOption"
      :activeType="selectedContractActiveType"
      @confirm="confirmCommodityActiveConfigAddition"
      @close="cancelCommodityActiveConfigAddition"
    ></dialog-commodity-active-config-addition>
  </div>
</template>

<script>
import AddCommodityActiveConfigDialog from "./AddCommodityActiveConfigDialog.vue";
export default {
  components: {
    "dialog-commodity-active-config-addition": AddCommodityActiveConfigDialog
  },
  props: ["isShow", "platformEnv"],
  data() {
    return {
      // dialog
      isShowCommodityActiveConfigAdditionDialog: false,

      // const
      CONTRACT_ACTIVE_TYPE: this.$config.CONTRACT_ACTIVE_TYPE.ITEMS,
      CONTRACT_ACTIVE_TYPE_ACTIVE_MONTH: this.$config.CONTRACT_ACTIVE_TYPE
        .ITEMS[0].value,
      CONTRACT_ACTIVE_TYPE_FIXED_CODE: this.$config.CONTRACT_ACTIVE_TYPE
        .ITEMS[1].value,

      // options
      commodityOptions: [],
      platformEnvOptionsCompact: this.$config.QUOTATION_PLATFORM_ENV_COMPACT
        .ITEMS,
      platformEnvOptions: this.$config.QUOTATION_PLATFORM_ENV.ITEMS,
      registerPriorityOptions: this.$config.QUOTATION_REGISTER_PRIORITY.ITEMS,
      contractCountOptions: this.$config.QUOTATION_CONTRACT_COUNT.ITEMS,

      // selected data
      selectedPlatfromEnv: null,
      selectedContractActiveType: null,
      selectedCommodityOption: null,
      selectedRegisterPriority: 1, // 暂时不需要用户输入，直接给定为 1
      selectedActiveShowCount: null,
      selectedInactiveShowCount: null,
      selectedContractFixedCode: null,

      // data
      isCommodityActiveConfigExist: false,
      // contractActiveType: null,
      contractFixedCodeList: null,
      activeMonthList: null,
      inactiveMonthList: null
    };
  },
  watch: {
    isShow() {
      if (this.isShow) {
        this.selectedPlatfromEnv = this.platformEnv; //this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS[0].value
        this.selectedContractActiveType = null;
        this.selectedCommodityOption = null;
        this.selectedRegisterPriority = 1; // 暂时不需要用户输入，直接给定为 1
        this.selectedActiveShowCount = null;
        this.selectedInactiveShowCount = null;
        this.selectedContractFixedCode = null;

        this.isCommodityActiveConfigExist = false;
        this.activeMonthList = [];
        this.inactiveMonthList = [];
        // this.contractActiveType = null;
        this.contractFixedCode = null;

        this.reqCommodityTree(TechPlatformEnv[this.selectedPlatfromEnv]);
      }
    }
  },
  mounted() {
    // alert(TechPlatformEnv[this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS[0].value])
    // this.reqCommodityTree(TechPlatformEnv[this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS[0].value])
  },
  methods: {
    close() {
      this.$emit("close");
    },
    confirm() {
      this.doAddition();
    },
    onPlatformEnvChange(option) {
      // alert("option : " + option)
      this.reqCommodityTree(TechPlatformEnv[option]);
    },
    reqCommodityTree(platformEnv) {
      var that = this;
      // var platformEnv = TechPlatformEnv.REAL;
      this.$api.reqCommodityTree(platformEnv, function(response) {
        if (response == null) {
          alert("出错，reqCommodityTree接口调用无返回");
        } else if (response.errorMsg) {
          alert(response.errorMsg);
        } else {
          if (response.treeJson != null) {
            var treeJson = JSON.parse(response.treeJson);
            that.commodityOptions = treeJson.children;
            // alert("that.commodityOptions : " + )
            return;
          }
          that.commodityOptions = [];
          alert("查找商品树失败");
        }
      });
    },
    onCommodityChange(options) {
      // alert("onCommodityChange : " + JSON.stringify(this.selectedCommodityOption))
      if (!this.selectedContractActiveType) {
        return;
      }
      var commodityId = this.selectedCommodityOption[2];
      this.getCommodityActiveConfigInfo(
        commodityId,
        this.selectedContractActiveType
      );
    },
    onContractActiveTypeChange() {
      // alert("onContractActiveTypeChange : " + this.selectedContractActiveType);
      if (!this.selectedCommodityOption) {
        return;
      }
      var commodityId = this.selectedCommodityOption[2];
      this.getCommodityActiveConfigInfo(
        commodityId,
        this.selectedContractActiveType
      );
    },
    getCommodityActiveConfigInfo(commodityId, contractActiveType) {
      var that = this;
      this.isCommodityActiveConfigExist = false;

      var reqCommodityActiveConfigOption = new ReqCommodityActiveConfigOption();
      reqCommodityActiveConfigOption.commodityId = commodityId;
      reqCommodityActiveConfigOption.activeType = ContractActiveType[contractActiveType];

      // alert("reqCommodityActiveConfigOption : " + JSON.stringify(reqCommodityActiveConfigOption))
      // var pageOption = new IndexedPageOption();
      // pageOption.needTotalCount = false;
      // pageOption.pageIndex = 0;
      // pageOption.pageSize = 1;


      this.$api.reqCommodityActiveConfig(
        reqCommodityActiveConfigOption,
        null,
        function(response) {
          if (response == null) {
            alert("出错，reqCommodityTree接口调用无返回");
            that.activeMonthList = [];
            that.inactiveMonthList = [];
            // that.contractActiveType = null;
            that.contractFixedCode = null;
            return;
          } else if (response.errorMsg) {
            alert(response.errorMsg);
            that.activeMonthList = [];
            that.inactiveMonthList = [];
            // that.contractActiveType = null;
            that.contractFixedCode = null;
            return;
          } else if (response.page == null || response.page.length < 1) {
            that.activeMonthList = [];
            that.inactiveMonthList = [];
            // that.contractActiveType = null;
            that.contractFixedCode = null;
            // alert("该商品未添加活跃合约规律，请先添加")
            if (confirm("该商品未添加活跃合约规律, 是否现在添加？")) {
              that.showAddCommodityActiveConfigDialog();
            }
            return;
          }
          // alert("page : " + JSON.stringify(response.page));

          that.isCommodityActiveConfigExist = true;
          if (contractActiveType == that.CONTRACT_ACTIVE_TYPE_ACTIVE_MONTH) {
            var commodityActiveConfig = response.page[0];
            that.activeMonthList = commodityActiveConfig.activeMonths;
            that.inactiveMonthList = that.getInactiveMonthList(
              that.activeMonthList
            );
            that.contractFixedCodeList = null;
          } else if (
            contractActiveType == that.CONTRACT_ACTIVE_TYPE_FIXED_CODE
          ) {
            that.activeMonthList = [];
            that.inactiveMonthList = [];
            that.contractFixedCodeList = [];
            for (var index = 0; index < response.page.length; index++) {
              var commodityActiveConfig = response.page[index];
              // alert("commodityActiveConfig : " + JSON.stringify(commodityActiveConfig))
              if (commodityActiveConfig.fixedCode) {
                that.contractFixedCodeList.push(commodityActiveConfig.fixedCode);
              }
            }
          }
        }
      );
    },
    getInactiveMonthList(activeMonthList) {
      var monthList = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
      var unactiveMonthList = [];
      for (var index = 0; index < monthList.length; index++) {
        let month = monthList[index];
        if (activeMonthList.indexOf(month) == -1) {
          unactiveMonthList.push(month);
        }
      }
      return unactiveMonthList;
    },
    showAddCommodityActiveConfigDialog() {
      this.isShowCommodityActiveConfigAdditionDialog = true;
    },
    confirmCommodityActiveConfigAddition() {
      this.isShowCommodityActiveConfigAdditionDialog = false;

      var commodityId = this.selectedCommodityOption[2];
      this.getCommodityActiveConfigInfo(
        commodityId,
        this.selectedContractActiveType
      );
      alert("添加成功");
    },
    cancelCommodityActiveConfigAddition() {
      this.isShowCommodityActiveConfigAdditionDialog = false;
    },
    doAddition() {
      // 数据校验
      if (!this.selectedPlatfromEnv || this.selectedPlatfromEnv == "NONE") {
        alert("请选择行情环境");
        return;
      }
      if (!this.selectedCommodityOption) {
        alert("请选择商品");
        return;
      }
      var commodityId = this.selectedCommodityOption[2];
      if (commodityId < 1) {
        alert("无效商品ID：" + commodityId);
        return;
      }
      if (!this.selectedContractActiveType) {
        alert("请选择类型");
        return;
      }
      // 默认为1，不需要用户输入
      if (!this.selectedRegisterPriority) {
        alert("请选择订阅优先级");
        return;
      }
      if (this.isCommodityActiveConfigExist == false) {
        alert("该商品未添加活跃合约规律，请先添加");
        return;
      }

      var that = this;
      var commodityRegister = new CommodityRegister();

      commodityRegister.sledCommodityId = commodityId;
      commodityRegister.registerPriority = this.selectedRegisterPriority;
      commodityRegister.platformEnv = TechPlatformEnv[this.selectedPlatfromEnv];
      commodityRegister.activeType =
        ContractActiveType[this.selectedContractActiveType];

      if (
        this.selectedContractActiveType == this.CONTRACT_ACTIVE_TYPE_ACTIVE_MONTH
      ) {
        if (this.activeMonthList == null || this.activeMonthList.length < 1) {
          alert("该商品未添加活跃合约规律，请先添加");
          return;
        }
        if (!this.selectedActiveShowCount) {
          alert("请选择活跃合约展示数量");
          return;
        }
        if (!this.selectedInactiveShowCount) {
          alert("请选择非活跃合约展示数量");
          return;
        }
        commodityRegister.activeShowCount = this.selectedActiveShowCount;
        commodityRegister.inactiveShowCount = this.selectedInactiveShowCount;
      } else if (
        this.selectedContractActiveType == this.CONTRACT_ACTIVE_TYPE_FIXED_CODE
      ) {
        if (!this.selectedContractFixedCode) {
          alert("请选择合约号")
        }
        commodityRegister.fixedCode = this.selectedContractFixedCode;
      } else {
        alert("合约类型错误，请尝试刷新页面后重试");
        return;
      }

      this.$api.addCommodityRegister(commodityRegister, function(response) {
        if (response != null && response.errorMsg) {
          alert(response.errorMsg);
        } else {
          alert("添加成功");

          that.$store.commit(
            "setSubscribedContractPlatformEnv",
            that.selectedPlatfromEnv
          );

          that.$emit("confirm");
        }
      });
    }
  }
};
</script>

<style scoped>
.my-input-key {
  width: 250px;
}
.my-input-value {
  width: 250px;
}
</style>

