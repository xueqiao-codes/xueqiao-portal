<template>
  <div
    v-if="isShow"
    class="dialog-bg"
  >
    <div class="dialog-container">
      <div class="dialog-header">
        <div class="dialog-title">编辑订阅商品</div>
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
            <span>{{platformEnvOptions[commodityRegister.platformEnv].label}}</span>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key my-input-key">
            <span>商品：</span>
          </div>
          <div class="input-value my-input-value">
              <span>{{commodityRegister.commodityName}}</span>
          </div>
        </div>
        <!-- <div class="input-item">
          <div class="input-key my-input-key">
            <span>订阅优先级：</span>
          </div>
          <div class="input-value my-input-value">
            <el-select
              v-model="selectedRegisterPriority"
              placeholder="请选择"
              class="my-input-value"
            >
              <el-option
                v-for="item in registerPriorityOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </div>
        </div> -->
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
            <span>活跃合约展示数量(近月优先)：</span>
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
            <span>非活跃合约展示数量(近月优先)：</span>
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
  props: ["isShow", "commodityRegister"],
  data() {
    return {
      // options
      platformEnvOptions: this.$config.QUOTATION_PLATFORM_ENV.ITEMS,
      registerPriorityOptions: this.$config.QUOTATION_REGISTER_PRIORITY.ITEMS,
      contractCountOptions: this.$config.QUOTATION_CONTRACT_COUNT.ITEMS,

      // data
      selectedRegisterPriority: null,
      selectedActiveShowCount: null,
      selectedInactiveShowCount: null,

      activeMonthList: null,
      inactiveMonthList: null
    };
  },
  watch: {
    isShow() {
      if (this.isShow) {
        this.selectedRegisterPriority = this.commodityRegister.registerPriority
        this.selectedActiveShowCount = this.commodityRegister.activeShowCount
        this.selectedInactiveShowCount = this.commodityRegister.inactiveShowCount

        this.activeMonthList = []
        this.inactiveMonthList = []

        this.getActiveMonths(this.commodityRegister.sledCommodityId)
      }
    }
  },
  methods: {
    close() {
      this.$emit("close");
    },
    confirm() {
      this.doEdition();
    },
    getActiveMonths(commodityId) {
      var that = this

      var reqCommodityActiveConfigOption = new ReqCommodityActiveConfigOption()
      reqCommodityActiveConfigOption.commodityId = commodityId
      reqCommodityActiveConfigOption.activeType = this.commodityRegister.activeType

      var pageOption = new IndexedPageOption()
      pageOption.needTotalCount = false
      pageOption.pageIndex = 0
      pageOption.pageSize = 1

      this.$api.reqCommodityActiveConfig(reqCommodityActiveConfigOption, pageOption, function(response) {
        if (response == null || response.page == null || response.page.length < 1) {
          that.activeMonthList = []
          that.inactiveMonthList = []
          alert("该商品未添加活跃合约规律，请先添加")
          return
        }
        // alert("page : " + JSON.stringify(response.page))
        var commodityActiveConfig = response.page[0]
        that.activeMonthList = commodityActiveConfig.activeMonths
        that.inactiveMonthList = that.getInactiveMonthList(that.activeMonthList)
      })
    },
    getInactiveMonthList (activeMonthList) {
      var monthList = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
      var unactiveMonthList = []
      for(var index = 0; index < monthList.length; index++) {
        let month = monthList[index]
        if (activeMonthList.indexOf(month) == -1) {
          unactiveMonthList.push(month)
        }
      }
      return unactiveMonthList
    },
    doEdition() {
      // 数据校验
      // if (!this.selectedRegisterPriority) {
      //   alert("请选择订阅优先级")
      // }
      if (!this.selectedActiveShowCount) {
        alert("请选择活跃合约展示数量")
      }
      if (!this.selectedInactiveShowCount) {
        alert("请选择非活跃合约展示数量")
      }

      var that = this
      var commodityRegister = new CommodityRegister()

      commodityRegister.sledCommodityId = this.commodityRegister.sledCommodityId
      commodityRegister.platformEnv = this.commodityRegister.platformEnv

      // commodityRegister.registerPriority = this.selectedRegisterPriority
      commodityRegister.activeShowCount = this.selectedActiveShowCount
      commodityRegister.inactiveShowCount = this.selectedInactiveShowCount

      this.$api.updateCommodityRegister(commodityRegister, function(response) {
        if (response != null && response.errorMsg) {
          alert(response.errorMsg)
        } else {
          alert("修改成功")
          that.$emit("confirm");
        }
      })
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

