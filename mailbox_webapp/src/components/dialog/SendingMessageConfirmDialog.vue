<template>
  <div
    v-if="isShow"
    class="dialog-bg dialog-z-order"
  >
    <div class="dialog-container">
      <div class="dialog-header">
        <div class="dialog-title">消息发送确认</div>
        <div class="dialog-close">
          <a
            href="#"
            @click="close"
          ><img src="../../assets/img/icon_close.png" /></a>
        </div>
      </div>
      <div class="dialog-content">
        <div class="sm-item">
          <div class="sm-item-key">
            <el-checkbox v-model="checkChannel"></el-checkbox>
            <span>发送途径</span>
          </div>
          <div class="sm-item-value long-item-value">
            <el-checkbox-group
              v-model="selectedChannelList"
              disabled
            >
              <el-checkbox label="4">客户端消息</el-checkbox>
              <el-checkbox label="1">电子邮件</el-checkbox>
              <el-checkbox label="2">手机短信</el-checkbox>
            </el-checkbox-group>
          </div>
        </div>
        <div class="lg-item">
          <div class="lg-item-key">
            <el-checkbox v-model="checkReceiver"></el-checkbox>
            <span>接收对象</span>
          </div>
          <div class="lg-item-multi-line-value receiver-item-value">
            <el-select
              class="lg-item-multi-line-value receiver-item-value"
              v-model="selectedCompanyList"
              filterable
              multiple
              disabled
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
              v-model="selectedGroupList"
              filterable
              multiple
              disabled
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
              <el-checkbox-group
                v-model="selectedRoleList"
                disabled
              >
                <el-checkbox label="1">交易员</el-checkbox>
                <el-checkbox label="2">管理员</el-checkbox>
              </el-checkbox-group>
            </div>
          </div>
        </div>
        <div class="sm-item">
          <div class="sm-item-key">
            <el-checkbox v-model="checkType"></el-checkbox>
            <span>通知类型</span>
          </div>
          <div class="sm-item-value">
            <el-select
              class="sm-item-value"
              v-model="selectedType"
              filterable
              disabled
              placeholder="请选择通知类型"
            >
              <el-option
                v-for="item in M_TYPE"
                :key="item.VALUE"
                :label="item.LABEL"
                :value="item.KEY"
              >
              </el-option>
            </el-select>
          </div>
        </div>
        <div class="sm-item">
          <div class="sm-item-key">
            <el-checkbox v-model="checkLevel"></el-checkbox>
            <span>通知等级</span>
          </div>
          <div class="sm-item-value">
            <el-select
              class="sm-item-value"
              v-model="selectedLevel"
              filterable
              disabled
              placeholder="请选择通知等级"
            >
              <el-option
                v-for="item in M_LEVEL"
                :key="item.VALUE"
                :label="item.LABEL"
                :value="item.KEY"
              >
              </el-option>
            </el-select>
          </div>
        </div>
        <div class="sm-item">
          <div class="sm-item-key">
            <el-checkbox v-model="checkTitle"></el-checkbox>
            <span>标题</span>
          </div>
          <div class="sm-item-value title-item-value">
            <el-input
              v-model="selectedTitle"
              disabled
              placeholder="请输入标题"
            ></el-input>
          </div>
        </div>
        <div class="lg-item">
          <div class="lg-item-key">
            <el-checkbox v-model="checkSummary"></el-checkbox>
            <span>概要</span>
          </div>
          <div class="sm-item-auto-value summary-item-value">
            <el-input
              type="textarea"
              rows="3"
              disabled
              placeholder="请输入概要"
              v-model="selectedSummary"
            >
            </el-input>
          </div>
        </div>
        <div class="lg-item">
          <div class="lg-item-key">
            <el-checkbox v-model="checkContent"></el-checkbox>
            <span>内容</span>
          </div>
          <div class="sm-item-auto-value content-item-value">
            <Editor
              v-model="editorContent"
              :preview="true"
            ></Editor>
          </div>
        </div>
        <el-button
          class="dialog-small-button"
          type="primary"
          size="medium"
          @click="confirm"
        >发送</el-button>
        <el-button
          class="dialog-small-button"
          size="medium"
          @click="close"
        >取消</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import Editor from "../RtfEditor";
import { all, allSettled, allResolved } from "q";
export default {
  props: [
    "isShow",
    "companyOptions",
    "groupOptions",
    "selectedChannelList",
    "selectedCompanyList",
    "selectedGroupList",
    "selectedRoleList",
    "selectedType",
    "selectedLevel",
    "selectedTitle",
    "selectedSummary",
    "editorContent"
  ],
  components: {
    Editor: Editor
  },
  data() {
    return {
      M_TYPE: this.$config.ENUM.M_TYPE.ITEMS,
      M_LEVEL: this.$config.ENUM.M_LEVEL.ITEMS,
      HOSTING_USER_ROLE: this.$config.ENUM.HOSTING_USER_ROLE.ITEMS,
      M_LEVEL_MAP: this.$config.ENUM.M_LEVEL.MAP,

      // check params
      checkChannel: false,
      checkReceiver: false,
      checkType: false,
      checkLevel: false,
      checkTitle: false,
      checkSummary: false,
      checkContent: false
    };
  },
  watch: {
    isShow() {
      if (this.isShow) {
        this.checkChannel = false;
        this.checkReceiver = false;
        this.checkType = false;
        this.checkLevel = false;
        this.checkTitle = false;
        this.checkSummary = false;
        this.checkContent = false;
      }
    }
  },
  methods: {
    close() {
      this.$emit("close");
    },
    confirm() {
      if (this.check()) {
        return;
      }
      this.addMBMessage();
    },
    check() {
      if (!this.checkChannel) {
        alert("请确认发送途径无误后，在发送途径项前打勾");
        return 1;
      }
      if (!this.checkReceiver) {
        alert("请确认接收对象无误后，在接收对象项前打勾");
        return 1;
      }
      if (!this.checkType) {
        alert("请确认通知类型无误后，在通知类型项前打勾");
        return 1;
      }
      if (!this.checkLevel) {
        alert("请确认通知等级无误后，在通知等级项前打勾");
        return 1;
      }
      if (!this.checkTitle) {
        alert("请确认标题无误后，在标题前打勾");
        return 1;
      }
      if (!this.checkSummary) {
        alert("请确认概要无误后，在概要前打勾");
        return 1;
      }
      if (!this.checkContent) {
        alert("请确认内容无误后，在内容前打勾");
        return 1;
      }
    },
    checkParams() {
      if (!this.selectedChannelList || this.selectedChannelList.length < 1) {
        alert("请选择发送途径");
        return 1;
      }
      if (!this.selectedTitle) {
        alert("请输入消息标题");
        return 1;
      }
      if (!this.selectedSummary) {
        alert("请输入消息概要");
        return 1;
      }
      if (!this.editorContent) {
        alert("请输入消息内容");
        return 1;
      }
      return 0;
    },
    addMBMessage() {
      if (this.checkParams()) {
        return;
      }
      var that = this;
      var message = new MBMessage();

      message.policy = MSendingPolicy.MSP_NOW;
      message.channelList = this.selectedChannelList;
      message.hostingList = this.$util.getMReceiverHostingList(
        this.selectedCompanyList,
        this.selectedGroupList,
        this.selectedRoleList
      );
      message.content = this.getMessageContent();
      message.operator = this.$cookie.getCookie("oa_user_name");

      // alert("message : " + JSON.stringify(message))
      // return;

      var that = this;
      this.$api.addMBMessage(message, function(response) {
        if (response != null) {
          if (response.success) {
            alert("消息提交成功");
            that.$emit("confirm");
          } else if (response.message) {
            alert(response.message);
          } else if (response.errorMsg) {
            alert(response.errorMsg);
          } else {
            alert(that.$string.message.callMethodFail);
          }
        } else {
          alert(that.$string.message.serverBusy);
        }
      });
    },
    getMessageContent() {
      var messageContent = new MessageContent();
      messageContent.type = MType[this.selectedType];
      messageContent.level = MLevel[this.selectedLevel];
      messageContent.title = this.selectedTitle;
      messageContent.summary = this.selectedSummary;
      messageContent.content = this.$util.genHTMLContent(this.editorContent);
      return messageContent;
    }
  }
};
</script>

<style>
.dialog-z-order {
  z-index: 100;
}
.item-key {
  width: 100px;
}
.item-value {
  text-align: left;
  width: 800px;
}
.long-item-value {
  width: 800px;
}
.receiver-item-value {
  width: 800px;
}
.title-item-value {
  width: 800px;
}
.summary-item-value {
  width: 800px;
}
.content-item-value {
  width: 800px;
}
.sm-item-multi-inner-button {
  padding-left: 10px;
  padding-right: 10px;
  width: 120px;
}
</style>

