<template>
  <div
    v-if="isShow"
    class="dialog-bg"
  >
    <div class="dialog-container">
      <div class="dialog-header">
        <div class="dialog-title">编辑可订阅商品</div>
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
            <span>交易所：</span>
          </div>
          <div class="input-value my-input-value">
            <span>{{accountRegisterAbility.exchangeName}}</span>
          </div>
        </div>
        <!-- <div class="input-item">
          <div class="input-key">
            <span>商品：</span>
          </div>
          <div class="input-value my-input-value">
            <span>{{accountRegisterAbility.commodityName}}</span>
          </div>
        </div> -->
        <div class="input-item">
          <div class="input-key">
            <span>支持所有商品：</span>
          </div>
          <el-switch
            style="display: block"
            v-model="isSupportTypeAll"
            active-text="是"
            inactive-text="否"
          >
          </el-switch>
        </div>
        <div
          v-show="!isSupportTypeAll"
          class="checkbox-frame"
        >
          <div class="frame-title">
            <div class="input-key">
              <span>商品</span>
            </div>
            <div class="frame-title-operation">
              <a href="#" class="frame-title-operation-item" @click="selectAllCommodities">全选</a>
              <a href="#" class="frame-title-operation-item" @click="reverseCommodities">反选</a>
              <a href="#" class="frame-title-operation-item" @click="clearCommodities">清除</a>
            </div>
          </div>
          <div class="frame-border my-input-frame">
            <div
              class="my-input-item"
              v-for="(commodity, index) in commodityOptions"
              v-bind:key="index"
            >
              <span class="checkbox-item">
                <input
                  type="checkbox"
                  v-bind:id="index"
                  v-bind:value="commodity.id"
                  v-model="checkedCommodityList"
                >{{commodity.name}}
              </span>
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
  props: ["isShow", "accountRegisterAbility"],
  data() {
    return {
      // options
      commodityTypeOptions: [],
      commodityOptions: [],

      // selected data
      selectedOption: null,
      checkedCommodityList: [],
      isSupportTypeAll: false
    };
  },
  mounted() {
    this.reqCommodityTypeTree();
  },
  watch: {
    isShow() {
      if (this.isShow) {
        this.isSupportTypeAll = false;
        // alert("accountId : " + this.accountId)
      }
    }
  },
  methods: {
    close() {
      this.$emit("close");
    },
    confirm() {
      // this.$emit("confirm");
      this.doAddition()
    },
    addPropertyInputFrame() {
      var item = {
        key: "",
        value: ""
      };
      this.accountPropertyList.push(item);
    },
    reqCommodityTypeTree() {
      var that = this;
      var platformEnv = TechPlatformEnv.REAL;
      this.$api.reqCommodityTypeTree(platformEnv, function(response) {
        if (response.errorMsg) {
          alert(JSON.stringify(response))
        } else {
          var treeJson = JSON.parse(response.treeJson);
          that.commodityTypeOptions = treeJson.children;
        }
      });
    },
    onCommodityTypeChange(selectedOption) {
      // alert("onCommodityTypeChange : " + JSON.stringify(selectedOption))
      this.reqContractTreeCommodityNodes(selectedOption[0], selectedOption[1])
    },
    reqContractTreeCommodityNodes(sledExchangeId, commodityType) {
      // alert("sledExchangeId : " + sledExchangeId + ", commodityType : " + commodityType)
      var that = this
      var commodityTypeValue = SledCommodityType[commodityType]
      var platformEnv = TechPlatformEnv.REAL;
      this.$api.reqContractTreeCommodityNodes(sledExchangeId, commodityTypeValue, platformEnv, function(response) {
        // alert("reqContractTreeCommodityNodes : " + JSON.stringify(response))
        that.commodityOptions = response
      })
    },
    selectAllCommodities() {
      if (this.commodityOptions) {
        this.clearCommodities()
        for (var index = 0; index < this.commodityOptions.length; index++) {
          this.checkedCommodityList.push(this.commodityOptions[index].id)
        }
      }
    },
    reverseCommodities() {
      if (this.commodityOptions) {
        var tempReverseCommodities = []
        for (var index = 0; index < this.commodityOptions.length; index++) {
          if (this.checkedCommodityList.indexOf(this.commodityOptions[index].id) == -1) {
            tempReverseCommodities.push(this.commodityOptions[index].id)
          }
        }
        this.checkedCommodityList = tempReverseCommodities
      }
    },
    clearCommodities() {
      this.checkedCommodityList = []
    },
    doAddition() {
      var accountId = this.accountId // 由上个页面传递过来
      // 参数检验
      if (!accountId || accountId < 1) {
        alert("获取不到账号信息")
        return
      }
      // alert("accountId : " + accountId)
      if (this.selectedOption == null) {
        alert("请选择交易所及商品类型")
        return
      }
      if (this.isSupportTypeAll) {

      } else {
        if (this.checkedCommodityList == null || this.checkedCommodityList.length < 1) {
          alert("请选择商品")
          return
        }
      }
      
      var sledCommodityId = 0
      var sledExchangeId = this.selectedOption[0]
      var supportType = null  // 根据不同的类型做不同的处理

      var abilities = []

      if (this.isSupportTypeAll) {
        var ability = new AccountRegisterAbility()
        ability.accountId = accountId
        ability.sledExchangeId = sledExchangeId
        ability.supportType = SupportType.ALL

        abilities.push(ability)
      } else {
        for (var index = 0; index < this.checkedCommodityList.length; index++) {
          var ability = new AccountRegisterAbility()
          ability.accountId = accountId
          ability.sledExchangeId = sledExchangeId
          ability.supportType = SupportType.SET
          ability.sledCommodityId = this.checkedCommodityList[index]

          abilities.push(ability)
        }
      }
      
      var that = this
      // alert("abilities : " + JSON.stringify(abilities))
      this.$api.batAddAccountRegisterAbility(abilities, function(response) {
        if (response != null && response.errorMsg) {
          alert(response.errorMsg)
        } else {
          alert("添加成功")
          that.$emit("confirm");
        }
      })
    }
  }
};
</script>

<style scoped>
.my-input-value {
  width: 350px;
}
.my-input-frame {
  display: flex;
  flex-wrap: wrap;
}
.my-input-item {
  width: 150px;
  text-align: left;
  margin-left: 8px;
  margin-right: 8px;
  margin-top: 3px;
  margin-bottom: 3px;
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
}
.checkbox-frame {
  margin-top: 30px;
  width: 500px;
}
.frame-title{
    display: flex;
    justify-content: space-between;
    margin-bottom: 5px;
}
.frame-title-operation {
    text-align: right;
    float: right;
}
.frame-title-operation-item{
    margin-left: 20px;
}
</style>

