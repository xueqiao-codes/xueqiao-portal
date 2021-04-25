<template>
  <div
    v-if="isShow"
    class="dialog-bg"
  >
    <div class="dialog-container">
      <div class="dialog-header">
        <div class="dialog-title">{{title}}</div>
        <div class="dialog-close">
          <a
            href="#"
            @click="close"
          ><img src="../../assets/img/icon_close.png" /></a>
        </div>
      </div>
      <div class="dialog-content custom-dialog">
        <div class="lg-item">
          <div class="lg-item-key"><span>接收对象</span></div>
          <div class="lg-item-multi-line-value">
            <el-select
              class="lg-item-multi-line-value receiver-item-value"
              v-model="companyList"
              filterable
              multiple
              :disabled="true"
              placeholder="所有公司"
            >
              <el-option
                v-for="item in companyOptions"
                :key="item.companyId"
                :label="item.companyCode"
                :value="item.companyId"
              >
              </el-option>
            </el-select>
            <el-select
              class="lg-item-multi-line-value receiver-item-value"
              v-model="groupList"
              filterable
              multiple
              :disabled="true"
              placeholder="所有管机组"
            >
              <el-option
                v-for="item in groupOptions"
                :key="item.groupId"
                :label="item.groupName"
                :value="item.groupId"
              >
              </el-option>
            </el-select>
            <div class="lg-item-multi-line-value receiver-item-value">
              <el-checkbox-group v-model="roleList">
                <el-checkbox label="1" disabled>交易员</el-checkbox>
                <el-checkbox label="2" disabled>管理员</el-checkbox>
              </el-checkbox-group>
            </div>
          </div>
        </div>
      </div>
      <div class="dialog-button-container">
        <el-button
          type="primary"
          size="medium"
          @click="close"
        >确定</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["isShow", "title", "message", "companyOptions"],
  data() {
    return {
      // data
      groupOptions: [],
      disableGroupSelector: true,
      companyList: [],
      groupList: [],
      roleList: []
    };
  },
  mounted() {},
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
    // confirm() {
    //   this.doSetVersionTag();
    // },
    init() {
      this.companyList = this.$util.getCompanyListFromHostingList(
        this.message.hostingList
      );

      if (this.companyList && this.companyList.length == 1) {
        this.reqGroupReceiver(this.companyList[0]);
        this.disableGroupSelector = false;
      } else {
        this.disableGroupSelector = true;
      }

      this.groupList = this.$util.getGroupListFromHostingList(
        this.message.hostingList
      );
      this.roleList = this.$util.getRoleListFromHostingList(
        this.message.hostingList
      );
    },
    checkParams() {
      if (!this.maintenance) {
        alert("页面过期，请刷新后再尝试");
        return 1;
      }
      return 0;
    },
    reqGroupReceiver(companyId) {
      var that = this;
      this.$api.reqGroupReceiver(companyId, function(response) {
        if (response != null && response.errorMsg) {
          alert(response.errorMsg);
        } else {
          if (response == null || response.length < 1) {
            that.groupOptions = [];
            return;
          }
          that.groupOptions = response;
          // alert("that.groupOptions : " + JSON.stringify(that.groupOptions))
        }
      });
    }
  }
};
</script>

<style scoped>
.custom-dialog {
  width: 850px;
}
.receiver-item-value {
    width: 600px;
}
</style>

