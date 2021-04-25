<template>
  <div
    v-if="isShow"
    class="dialog-bg"
  >
    <div class="dialog-container">
      <div class="dialog-header">
        <div class="dialog-title">编辑订阅商品序号</div>
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
            <span>序号：</span>
          </div>
          <div class="input-value my-input-value">
            <el-input
              placeholder="序号"
              type="number"
              v-model="selectedOrderIndex"
              clearable
            >
            </el-input>
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
      selectedOrderIndex: null
    };
  },
  watch: {
    isShow() {
      if (this.isShow) {
        this.selectedOrderIndex = this.commodityRegister.orderIndex;
      }
    }
  },
  methods: {
    close() {
      this.$emit("close");
    },
    confirm() {
      this.doUpdate();
    },
    doUpdate() {
      if (!this.selectedOrderIndex || this.selectedOrderIndex < 1) {
        alert("请输出有效的序号")
      }
      var that = this;
      this.$api.setCommodityRegisterOrderIndex(
        this.commodityRegister.sledCommodityId,
        this.commodityRegister.platformEnv,
        this.selectedOrderIndex,
        this.commodityRegister.activeType,
        this.commodityRegister.fixedCode,
        function(response) {
          if (response != null && response.errorMsg) {
            alert(response.errorMsg);
          } else {
            alert("设置成功");
            that.$emit("confirm");
          }
        }
      );
    }
  }
};
</script>

<style scoped>
.my-input-key {
  width: 70px;
}
.my-input-value {
  width: 150px;
}
</style>

