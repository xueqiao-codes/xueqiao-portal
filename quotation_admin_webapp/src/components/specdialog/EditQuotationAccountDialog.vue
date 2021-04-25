<template>
  <div
    v-if="isShow"
    class="dialog-bg"
  >
    <div class="dialog-container">
      <div class="dialog-header">
        <div class="dialog-title">编辑行情账号</div>
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
            <span>{{quotationAccountInfo.accountName}}</span>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key key-width">
            <span>密码：</span>
          </div>
          <div class="input-value">
            <el-input
              type="password"
              placeholder="需要修改密码则输入新密码，则否留空"
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
            <span>{{QUOTATION_PLATFORM_ENV[quotationAccountInfo.platformEnv].label}}</span>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key key-width">
            <span>平台：</span>
          </div>
          <div class="input-value">
            <span>{{QUOTATION_TECH_PLATFORM[quotationAccountInfo.platform].label}}</span>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key key-width">
            <span>券商：</span>
          </div>
          <div class="input-value">
            <span>{{quotationAccountInfo.brokerName}}</span>
          </div>
        </div>
        <div class="input-item">
          <div class="input-key key-width">
            <span>席位：</span>
          </div>
          <div class="input-value">
            <el-select
              v-model="selectedBrokerAccessOption"
              placeholder="席位"
              @change="onBrokerAccessChange"
              class="input-value"
            >
              <el-option
                v-for="item in brokerAccessOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </div>
        </div>
        <!-- {{selectedBrokerAccessOption}} -->
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
          <a href="#" class="input-operation" @click="addPropertyInputFrame">添加</a>
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
              <el-select v-model="accountProperty.key" placeholder="请选择" class="selector-width">
                <el-option
                  v-for="item in accountPropertyKeys"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </div>
            <div class="input-operation">
              <a href="#" style="color:rgba(255, 173, 101, 1)" @click="removePropertyInputFrame(index)">删除</a>
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
import config from "../../func/config/config.js"
export default {
  props: ["isShow", "quotationAccountInfo"],
  data() {
    return {
      // const config
      DEPLOYMENT_SET: this.$config.DEPLOYMENT_SET.ITEMS,
      QUOTATION_PLATFORM_ENV : this.$config.QUOTATION_PLATFORM_ENV.ITEMS,
      QUOTATION_PLATFORM_ENV_COMPACT : this.$config.QUOTATION_PLATFORM_ENV_COMPACT.ITEMS,
      QUOTATION_TECH_PLATFORM: this.$config.QUOTATION_TECH_PLATFORM.ITEMS,
      accountPropertyKeys: config.ACCOUNT_PROPERTY_KEYS.KEYS,

      // broker access list options
      brokerAccessOptions: [],

      // selected data
      selectedAccountpwd: null,
      selectedNickName: null,
      selectedDeployment: null,
      selectedMaxRegisterCount: null,
      selectedBrokerAccessOption: null,

      // 由于控件的原因，需要区别一下是否有选择
      isBrokerAccessChanged: false,

      accountPropertyList: []
    };
  },
  watch: {
    isShow() {
      if (this.isShow) {
        this.init()
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
    init() {
      // alert("init : " + JSON.stringify(this.quotationAccountInfo))
      this.selectedAccountpwd = this.quotationAccountInfo.accountpwd
      this.selectedNickName = this.quotationAccountInfo.nickName
      this.selectedDeployment = this.$config.DEPLOYMENT_SET.ITEMS[this.quotationAccountInfo.deploySet].value
      this.selectedMaxRegisterCount = this.quotationAccountInfo.maxRegisterCount
      this.selectedBrokerAccessOption = this.quotationAccountInfo.brokerAccessName

      this.isBrokerAccessChanged = false
      // this.selectedBrokerAccessOption = {
      //   label: this.quotationAccountInfo.brokerAccessName,
      //   value: this.quotationAccountInfo.brokerAccessId
      // }

      // 获取券商树 并 遍历出对应的席位列表
      this.reqBrokerTree(this.quotationAccountInfo.platformEnv)

      if (this.quotationAccountInfo.accountProperties == null) {
        this.accountPropertyList = []
        return
      }
      this.accountPropertyList = []
      for (var key in this.quotationAccountInfo.accountProperties) {
        var property = {
          key: key,
          value: this.quotationAccountInfo.accountProperties[key]
        }
        this.accountPropertyList.push(property)
      }
    },
    addPropertyInputFrame() {
      var item = {
        key: "",
        value: ""
      };
      this.accountPropertyList.push(item);
    },
    removePropertyInputFrame(index) {
      this.accountPropertyList.splice(index, 1)
    },
    reqBrokerTree(platformEnv) {
      var that = this;
      this.$api.reqBrokerTree(platformEnv, function(response) {
        if (response.errorMsg) {
          alert(JSON.stringify(response))
        } else {
          var treeJson = JSON.parse(response.treeJson);
          // that.brokerOptions = treeJson.children;
          that.getBrokerAccessList(treeJson.children)
        }
      });
    },
    getBrokerAccessList(brokerOptions) {
      if (brokerOptions == null) {
        return
      }
      const PLATFROM = this.QUOTATION_TECH_PLATFORM[this.quotationAccountInfo.platform].value
      const BROKER_ID = this.quotationAccountInfo.brokerId

      for (var index = 0; index < brokerOptions.length; index++) {
        if (PLATFROM == brokerOptions[index].value) {
          var children = brokerOptions[index].children
          for (var subIndex = 0; subIndex < children.length; subIndex++) {
            if (BROKER_ID == children[subIndex].value) {
              this.brokerAccessOptions = children[subIndex].children
            }
          }
        }
      }
    },
    onBrokerAccessChange(option) {
      // alert("onBrokerAccessChange : " + option)
      this.isBrokerAccessChanged = true
    },
    doEdition() {
      // 数据校验
      // if (!this.selectedAccountpwd) {
      //   alert("请输入密码");
      //   return false;
      // }
      if (!this.selectedNickName) {
        alert("请输入账号别名");
        return false;
      }
      if (!this.selectedDeployment) {
        alert("请选择部署区域");
        return false;
      }
      if (!this.selectedBrokerAccessOption) {
        alert("请选择席位");
        return false;
      }
      if (this.selectedMaxRegisterCount == undefined || this.selectedMaxRegisterCount == null) {
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
      var accountInfo = new QuotationAccountInfo();

      accountInfo.accountId = this.quotationAccountInfo.accountId

      if (this.selectedAccountpwd) {
        accountInfo.accountpwd = this.selectedAccountpwd
      }
      
      accountInfo.nickName = this.selectedNickName
      if (this.isBrokerAccessChanged) {
        accountInfo.brokerAccessId = this.selectedBrokerAccessOption
      }
      accountInfo.deploySet = DeploySet[this.selectedDeployment]
      accountInfo.maxRegisterCount = this.selectedMaxRegisterCount

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

      accountInfo.accountProperties = accountProperties

      this.$api.updateQuotationAccountInfo(accountInfo, function(
        response
      ) {
        if (response.errorMsg) {
          alert(JSON.stringify(response))
        } else {
          alert("修改成功")

          that.$store.commit('setQuotationAccountDeploySet', that.selectedDeployment)
          that.$store.commit('setQuotationAccountPlatformEnv', that.$config.QUOTATION_PLATFORM_ENV.ITEMS[that.quotationAccountInfo.platformEnv].value)

          that.$emit("confirm");
        }
      });
    }
  }
};
</script>

<style scoped>
.my-dialog{
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

