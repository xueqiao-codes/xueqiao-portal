<template>
  <div
    v-if="isShow"
    class="dialog-bg"
  >
    <div class="dialog-container">
      <div class="dialog-header">
        <div class="dialog-title">添加商品活跃合约规律</div>
        <div class="dialog-close">
          <a
            href="#"
            @click="close"
          ><img src="../../assets/img/icon_close.png" /></a>
        </div>
      </div>
      <div class="dialog-content">
        <div class="input-item">
          <div class="input-key">
            <span>商品：</span>
          </div>
          <div class="input-value">
            <el-cascader
              expand-trigger="hover"
              @change="onCommodityChange"
              :options="options"
              v-model="selectedOptions"
              :show-all-levels="false"
            ></el-cascader>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key">
            <span>类型：</span>
          </div>
          <div class="input-value">
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
            <div class="multi-input-key">
              <span>选择活跃合约月份：</span>
            </div>

            <div class="input-value frame-border">
              <div class="input-month">
                <span class="month-item"><input
                    type="checkbox"
                    id="0"
                    value=1
                    v-model="checkedMonths"
                  >1月</span>
                <span class="month-item"><input
                    type="checkbox"
                    id="1"
                    value=2
                    v-model="checkedMonths"
                  >2月</span>
                <span class="month-item"><input
                    type="checkbox"
                    id="2"
                    value=3
                    v-model="checkedMonths"
                  >3月</span>
                <span class="month-item"><input
                    type="checkbox"
                    id="3"
                    value=4
                    v-model="checkedMonths"
                  >4月</span>
              </div>
              <div class="input-month">
                <span class="month-item"><input
                    type="checkbox"
                    id="4"
                    value=5
                    v-model="checkedMonths"
                  >5月</span>
                <span class="month-item"><input
                    type="checkbox"
                    id="5"
                    value=6
                    v-model="checkedMonths"
                  >6月</span>
                <span class="month-item"><input
                    type="checkbox"
                    id="6"
                    value=7
                    v-model="checkedMonths"
                  >7月</span>
                <span class="month-item"><input
                    type="checkbox"
                    id="7"
                    value=8
                    v-model="checkedMonths"
                  >8月</span>
              </div>
              <div class="input-month">
                <span class="month-item"><input
                    type="checkbox"
                    id="8"
                    value=9
                    v-model="checkedMonths"
                  >9月</span>
                <span class="month-item"><input
                    type="checkbox"
                    id="9"
                    value=10
                    v-model="checkedMonths"
                  >10月</span>
                <span class="month-item"><input
                    type="checkbox"
                    id="10"
                    value=11
                    v-model="checkedMonths"
                  >11月</span>
                <span class="month-item"><input
                    type="checkbox"
                    id="11"
                    value=12
                    v-model="checkedMonths"
                  >12月</span>
              </div>

            </div>
          </div>
          <div class="multi-input-item">
            <div class="multi-input-key"><span>活跃合约月份:</span></div>

            <div class="input-value selected-month">
              <span
                v-for="month in checkedMonths"
                :key="month"
              >{{month}}月;&nbsp;</span>
            </div>
          </div>
        </div>
        <div v-else>
          <div class="input-item">
            <div class="input-key">
              <span>合约号：</span>
            </div>
            <div class="input-value">
              <el-select
                v-model="selectedFixedContractCode"
                placeholder="选择商品后才有效"
                class="my-input-value"
              >
                <el-option
                  v-for="item in fixed_contract_code_options"
                  :key="item.value"
                  :label="item.code"
                  :value="item.code"
                >
                </el-option>
              </el-select>
            </div>
          </div>
        </div>
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
  </div>
</template>

<script>
export default {
  props: ["isShow", "selectedOptions", "activeType"],
  data() {
    return {
      // const
      months: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11],
      CONTRACT_ACTIVE_TYPE: this.$config.CONTRACT_ACTIVE_TYPE.ITEMS,
      CONTRACT_ACTIVE_TYPE_ACTIVE_MONTH: this.$config.CONTRACT_ACTIVE_TYPE
        .ITEMS[0].value,
      CONTRACT_ACTIVE_TYPE_FIXED_CODE: this.$config.CONTRACT_ACTIVE_TYPE
        .ITEMS[1].value,

      options: [],
      fixed_contract_code_options: [],
      checkedMonths: [],

      // selected
      selectedContractActiveType: null,
      selectedFixedContractCode: null
      // selectedOptions: null
    };
  },
  mounted() {
    // if (!this.selectedOptions) {
    this.reqCommodityTree();
    // }
  },
  watch: {
    isShow() {
      if (this.isShow) {
        this.checkedMonths = [];
        if (this.activeType) {
          this.selectedContractActiveType = this.activeType
        } else {
          this.selectedContractActiveType = this.CONTRACT_ACTIVE_TYPE_ACTIVE_MONTH;
        }
      }
    }
  },
  methods: {
    close() {
      this.$emit("close");
    },
    confirm() {
      this.doAddition();
    },
    reqCommodityTree() {
      var that = this;
      var platformEnv = TechPlatformEnv.REAL;
      this.$api.reqCommodityTree(platformEnv, function(response) {
        // alert("response : " + JSON.stringify(response.treeJson.children))
        var treeJson = JSON.parse(response.treeJson);
        that.options = treeJson.children;
      });
    },
    onCommodityChange() {
      // alert("onCommodityChange");
      this.getFixedContractCodeOptions();
    },
    onContractActiveTypeChange() {
      // alert("onContractActiveTypeChange");
      this.getFixedContractCodeOptions();
    },
    getFixedContractCodeOptions() {
      if (
        this.selectedContractActiveType == this.CONTRACT_ACTIVE_TYPE_FIXED_CODE
      ) {
        if (this.selectedOptions != null) {
          var sledCommodityId = this.selectedOptions[2];
          var platformEnv = TechPlatformEnv.REAL;
          // alert("sledCommodityId : " + sledCommodityId)
          var that = this;
          this.$api.reqContractNodes(sledCommodityId, platformEnv, function(
            response
          ) {
            // alert("response : " + JSON.stringify(response))
            if (response != null && response.errorMsg) {
              alert(response.errorMsg);
            } else {
              if (response == null || response.length < 1) {
                that.fixed_contract_code_options = [];
                return;
              }
              that.fixed_contract_code_options = response;
            }
          });
        }
      }
    },
    doAddition() {
      if (!this.selectedOptions) {
        alert("请选择商品");
        return false;
      }

      // alert("selectedOptions : " + JSON.stringify(this.selectedOptions))
      var that = this;
      var commodityActiveConfig = new CommodityActiveConfig();
      commodityActiveConfig.sledCommodityId = this.selectedOptions[2];

      commodityActiveConfig.activeType =
        ContractActiveType[this.selectedContractActiveType];
      if (
        this.selectedContractActiveType ==
        this.CONTRACT_ACTIVE_TYPE_ACTIVE_MONTH
      ) {
        if (this.checkedMonths == null || this.checkedMonths.length < 1) {
          alert("请选择活跃月份");
          return false;
        }
        commodityActiveConfig.activeMonths = this.checkedMonths;
      } else if (
        this.selectedContractActiveType == this.CONTRACT_ACTIVE_TYPE_FIXED_CODE
      ) {
        if (!this.selectedFixedContractCode) {
          alert("请选择合约号");
          return false;
        }
        commodityActiveConfig.fixedCode = this.selectedFixedContractCode;
      } else {
        alert("类型出错，请尝试刷新页面后重试");
        return false;
      }

      // alert("commodityActiveConfig : " + JSON.stringify(commodityActiveConfig))
      this.$api.addCommodityActiveConfig(commodityActiveConfig, function(
        response
      ) {
        // alert("addCommodityActiveConfig success : " + JSON.stringify(response))
        if (response != null && response.errorMsg) {
          alert(response.errorMsg);
        } else {
          that.$emit("confirm");
        }
      });
    }
  }
};
</script>

<style scoped>
.input-month {
  display: flex;
  justify-content: space-around;
}
.month-item {
  width: 70px;
}
.selected-month {
  height: 50px;
}
</style>

