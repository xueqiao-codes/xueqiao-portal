<template>
  <div
    v-if="isShow"
    class="dialog-bg"
  >
    <div class="dialog-container">
      <div class="dialog-header">
        <div class="dialog-title">添加行情账号</div>
        <div class="dialog-close">
          <a
            href="#"
            @click="close"
          ><img src="../../assets/img/icon_close.png" /></a>
        </div>
      </div>
      <div class="dialog-content  my-dialog">
        <div class="input-item">
          <div class="input-key key-width">
            <span>账号：</span>
          </div>
          <div class="input-value">
            <el-input
              placeholder="账号"
              v-model="selectedAccountName"
              clearable
            >
            </el-input>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key key-width">
            <span>密码：</span>
          </div>
          <div class="input-value">
            <el-input
              placeholder="密码"
              type="password"
              v-model="selectedAccountpwd"
              clearable
            >
            </el-input>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key key-width">
            <span>账号别名：</span>
          </div>
          <div class="input-value">
            <el-input
              placeholder="账号别名"
              v-model="selectedNickName"
              clearable
            >
            </el-input>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key key-width">
            <span>部署区域：</span>
          </div>
          <div class="input-value">
            <el-select
              v-model="selectedDeployment"
              placeholder="部署区域"
              class="input-value"
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
        </div>
        <div class="input-item">
          <div class="input-key key-width">
            <span>行情环境：</span>
          </div>
          <div class="input-value">
            <el-select
              v-model="selectedPlatfromEnv"
              placeholder="行情环境"
              @change="onPlatformEnvChange"
              class="input-value"
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
        </div>
        <div class="input-item">
          <div class="input-key key-width">
            <span>平台/券商/席位：</span>
          </div>
          <div class="input-value">
            <el-cascader
              expand-trigger="hover"
              placeholder="选择行情环境后才有效"
              :options="brokerOptions"
              v-model="selectedBrokerOptions"
              class="input-value"
            ></el-cascader>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key key-width">
            <span>可订阅合约数量：</span>
          </div>
          <div class="input-value">
            <el-input
              placeholder="可订阅合约数量"
              v-model="selectedMaxRegisterCount"
              type="number"
              clearable
            >
            </el-input>
          </div>
        </div>

        <div class="property-title">
          <span>附加信息</span>
          <a
            href="#"
            class="input-operation"
            @click="addPropertyInputFrame"
          >添加</a>
        </div>
        <div
          v-for="(accountProperty, index) in accountPropertyList"
          v-bind:key="index"
        >
          <div class="input-item">
            <div class="input-key key-width">
              <span>key{{index + 1}}：</span>
            </div>
            <div class="input-value">
              <el-select
                v-model="accountProperty.key"
                placeholder="请选择"
                class="selector-width"
              >
                <el-option
                  v-for="item in accountPropertyKeys"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                >
                </el-option>
              </el-select>
            </div>
            <div class="input-operation">
              <a
                href="#"
                style="color:rgba(255, 173, 101, 1)"
                @click="removePropertyInputFrame(index)"
              >删除</a>
            </div>
          </div>
          <div class="multi-input-item">
            <div class="multi-input-key key-width">
              <span>value{{index + 1}}：</span>
            </div>
            <div class="input-value">
              <el-input
                type="textarea"
                :rows="3"
                v-model="accountProperty.value"
                clearable
              >
              </el-input>
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
import config from "../../func/config/config.js";
export default {
  props: ["isShow"],
  data() {
    return {
      // options
      accountPropertyKeys: config.ACCOUNT_PROPERTY_KEYS.KEYS,
      QUOTATION_PLATFORM_ENV_COMPACT: this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS,
      brokerOptions: [],

      // const
      DEPLOYMENT_SET: this.$config.DEPLOYMENT_SET.ITEMS,

      // selected data
      selectedAccountName: null,
      selectedAccountpwd: null,
      selectedNickName: null,
      selectedDeployment: null,
      selectedPlatfromEnv: null,
      selectedMaxRegisterCount: null,
      selectedBrokerOptions: null,

      // data
      accountPropertyList: []
    };
  },
  mounted() {
    // this.reqCommodityTree();
  },
  watch: {
    isShow() {
      if (this.isShow) {
        this.accountPropertyList = [];
        this.selectedAccountName = null;
        this.selectedAccountpwd = null;
        if (this.$store.state.quotationAccount.deploySet == null || this.$store.state.quotationAccount.deploySet == undefined) {
          this.selectedDeployment = this.$config.DEPLOYMENT_SET.ITEMS[0].value
        } else {
          this.selectedDeployment = this.$store.state.quotationAccount.deploySet
        }
        this.selectedNickName = null;
        if (this.$store.state.quotationAccount.platfromEnv == null || this.$store.state.quotationAccount.platfromEnv == undefined) {
          this.selectedPlatfromEnv = this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS[0].value
        } else {
          this.selectedPlatfromEnv = this.$store.state.quotationAccount.platfromEnv
        }
        this.selectedMaxRegisterCount = null;
        this.selectedBrokerOptions = null;

        this.reqBrokerTree(TechPlatformEnv[this.selectedPlatfromEnv]);
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
    addPropertyInputFrame() {
      var item = {
        key: "",
        value: ""
      };
      this.accountPropertyList.push(item);
    },
    removePropertyInputFrame(index) {
      this.accountPropertyList.splice(index, 1);
    },
    onPlatformEnvChange(option) {
      // alert("onPlatformEnvChange : " + TechPlatformEnv[option])
      this.reqBrokerTree(TechPlatformEnv[option]);
    },
    reqBrokerTree(platformEnv) {
      var that = this;
      this.$api.reqBrokerTree(platformEnv, function(response) {
        if (response.errorMsg) {
          alert(JSON.stringify(response))
        } else {
          var treeJson = JSON.parse(response.treeJson);
          that.brokerOptions = treeJson.children;
        }
      });
    },
    doAddition() {
      // 数据校验
      if (!this.selectedAccountName) {
        alert("请输入账号");
        return false;
      }
      if (!this.selectedAccountpwd) {
        alert("请输入密码");
        return false;
      }
      if (!this.selectedDeployment) {
        alert("请选择部署区域");
        return false;
      }
      if (!this.selectedNickName) {
        alert("请输入账号别名");
        return false;
      }
      if (!this.selectedPlatfromEnv) {
        alert("请选择行情环境");
        return false;
      }
      if (this.selectedBrokerOptions == null) {
        alert("请选择平台/券商/席位");
        return false;
      }
      if (!this.selectedMaxRegisterCount) {
        alert("请输入可订阅合约数量");
        return false;
      }
      if (this.accountPropertyList != null && this.accountPropertyList.length > 0) {
        for (var index = 0; index < this.accountPropertyList.length; index++) {
          if (!this.accountPropertyList[index].key) {
            alert("请选择key" + (index + 1))
          }
          if (!this.accountPropertyList[index].value) {
            alert("请输入value" + (index + 1))
          }
        }
      }
      var that = this;
      var quotationAccountInfo = new QuotationAccountInfo();

      quotationAccountInfo.accountName = this.selectedAccountName
      quotationAccountInfo.accountpwd = this.selectedAccountpwd
      quotationAccountInfo.nickName = this.selectedNickName
      quotationAccountInfo.deploySet = DeploySet[this.selectedDeployment]
      quotationAccountInfo.platformEnv = TechPlatformEnv[this.selectedPlatfromEnv]
      quotationAccountInfo.platform = TechPlatform[this.selectedBrokerOptions[0]]
      quotationAccountInfo.brokerId = this.selectedBrokerOptions[1]
      quotationAccountInfo.brokerAccessId = this.selectedBrokerOptions[2]
      quotationAccountInfo.maxRegisterCount = this.selectedMaxRegisterCount

      var tempAccountPropertyKey = []
      var accountProperties = new Map()
      if (this.accountPropertyList != null && this.accountPropertyList.length > 0) {
        for (var index = 0; index < this.accountPropertyList.length; index++) {
          if (tempAccountPropertyKey.indexOf(this.accountPropertyList[index].key) == -1) {
            tempAccountPropertyKey.push(this.accountPropertyList[index].key)
            accountProperties[this.accountPropertyList[index].key] = this.accountPropertyList[index].value
          } else {
            alert("附加信息不能添加相同的key")
            return
          }
        }
      }
      // if (accountProperties.length > 0) {
        quotationAccountInfo.accountProperties = accountProperties
      // }

      // alert("quotationAccountInfo : " + JSON.stringify(quotationAccountInfo));
      this.$api.addQuotationAccountInfo(quotationAccountInfo, function(
        response
      ) {
        if (response.errorMsg) {
          alert(JSON.stringify(response))
        } else {
          alert("添加成功")

          // that.$store.commit('setQuotationAccountDeploySet', quotationAccountInfo.deploySet)
          // that.$store.commit('setQuotationAccountPlatformEnv', quotationAccountInfo.platformEnv)

          that.$store.commit('setQuotationAccountDeploySet', that.selectedDeployment)
          that.$store.commit('setQuotationAccountPlatformEnv', that.selectedPlatfromEnv)

          that.$emit("confirm");
        }
      });
    }
  }
};
</script>

<style scoped>
.my-dialog {
  max-height: 600px;
  overflow: auto;
}
.key-width {
  width: 140px;
}
.property-title {
  margin-top: 40px;
  line-height: 14px;
  color: rgba(48, 48, 48, 1);
  font-size: 18px;
  text-align: left;
  font-family: STHeitiSC-Light;
}
.input-operation {
  margin-left: 10px;
  line-height: 14px;
  /* font-size: 14px; */
  text-align: left;
  font-family: STHeitiSC-Light;
}
.selector-width {
  width: 300px;
}
</style>
