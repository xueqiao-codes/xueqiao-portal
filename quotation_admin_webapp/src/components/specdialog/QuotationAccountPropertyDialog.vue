<template>
  <div
    v-if="isShow"
    class="dialog-bg"
  >
    <div class="dialog-container">
      <div class="dialog-header">
        <div class="dialog-title">附加信息</div>
        <div class="dialog-close">
          <a
            href="#"
            @click="close"
          ><img src="../../assets/img/icon_close.png" /></a>
        </div>
      </div>
      <div class="dialog-content">
        <div v-if="accountPropertyList.length < 1">
          <span>无附加信息</span>
        </div>
        <div
          v-else
          v-for="(accountProperty, index) in accountPropertyList"
          v-bind:key="index"
        >
          <div class="input-item">
            <div class="input-key key-width">
              <span>key{{index + 1}}：</span>
            </div>
            <div class="input-value my-value">
              <span>{{accountProperty.key}}</span>
            </div>
          </div>
          <div class="multi-input-item">
            <div class="multi-input-key key-width">
              <span>value{{index + 1}}：</span>
            </div>
            <div class="input-value my-value">
              <el-input
                type="textarea"
                readonly=true
                :rows="8"
                v-model="accountProperty.value"
                class="my-value"
              >
              </el-input>

              <!-- <span>{{accountProperty.value}}</span> -->
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
        <!-- <el-button
          size="medium"
          @click="close"
        >取消</el-button> -->
      </div>
    </div>
  </div>
</template>

<script>
import config from "../../func/config/config.js";
export default {
  props: ["isShow", "quotationAccountInfo"],
  data() {
    return {
      accountPropertyList: []
    };
  },
  watch: {
    isShow() {
      if (this.isShow) {
        this.init();
      }
    }
  },
  methods: {
    close() {
      this.$emit("close");
    },
    confirm() {
      this.$emit("close");
    },
    init() {
      if (this.quotationAccountInfo.accountProperties == null) {
        this.accountPropertyList = [];
        return;
      }
      this.accountPropertyList = [];
      for (var key in this.quotationAccountInfo.accountProperties) {
        var property = {
          key: key,
          value: this.quotationAccountInfo.accountProperties[key]
        };
        this.accountPropertyList.push(property);
      }
    }
  }
};
</script>

<style scoped>
.key-width {
  width: 100px;
}
.my-value {
  width: 600px;
}
</style>

