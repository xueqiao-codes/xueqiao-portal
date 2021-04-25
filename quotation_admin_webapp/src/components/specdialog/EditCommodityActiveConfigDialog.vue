<template>
  <div
    v-if="isShow"
    class="dialog-bg"
  >
    <div class="dialog-container">
      <div class="dialog-header">
        <div class="dialog-title">编辑商品</div>
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
            <span>{{activeConfig.commodityName}}</span>
          </div>
        </div>
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
  props: ["isShow", "activeConfig"],
  data() {
    return {
      checkedMonths: [],
      commodityName: ""
    };
  },
  watch: {
    isShow() {
      if (this.isShow) {
        this.checkedMonths = [];
        if (this.activeConfig.activeMonths) {
          for (
            let index = 0;
            index < this.activeConfig.activeMonths.length;
            index++
          ) {
            this.checkedMonths.push(this.activeConfig.activeMonths[index]);
          }
        }
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
    doEdition() {
      if (this.checkedMonths == null || this.checkedMonths.length < 1) {
        alert("请选择活跃月份");
        return false;
      }
      var that = this;
      var commodityActiveConfig = new CommodityActiveConfig();
      commodityActiveConfig.sledCommodityId = this.activeConfig.sledCommodityId
      commodityActiveConfig.activeMonths = this.checkedMonths;
      this.$api.updateCommodityActiveConfig(commodityActiveConfig, function(
        response
      ) {
        that.$emit("confirm");
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

