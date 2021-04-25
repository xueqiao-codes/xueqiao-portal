<template>
  <div class="page">
    <div class="sm-item">
      <div class="sm-item-key"><span>模板名</span></div>
      <div class="sm-item-value">
        <el-input
          v-model="selectedTemplateName"
          placeholder="请输入模板名"
        ></el-input>
      </div>
    </div>
    <div class="item-divider"></div>
    <div class="sm-item">
      <div class="sm-item-key"><span>发送途径</span></div>
      <div class="sm-item-value long-item-value">
        <el-checkbox-group v-model="selectedChannelList">
          <el-checkbox label="4">客户端消息</el-checkbox>
          <el-checkbox label="1">电子邮件</el-checkbox>
          <el-checkbox label="2">手机短信</el-checkbox>
        </el-checkbox-group>
      </div>
    </div>
    <div class="lg-item">
      <div class="lg-item-key"><span>接收对象</span></div>
      <div class="lg-item-multi-line-value">
        <el-select
          class="lg-item-multi-line-value receiver-item-value"
          v-model="selectedCompanyList"
          filterable
          multiple
          @change="onCompanyOptionsChange"
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
          :disabled="disableGroupSelector"
          placeholder="所有托管机组"
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
          <el-checkbox-group v-model="selectedRoleList">
            <el-checkbox label="1">交易员</el-checkbox>
            <el-checkbox label="2">管理员</el-checkbox>
          </el-checkbox-group>
        </div>
        <!-- <el-select
          class="lg-item-multi-line-value receiver-item-value"
          v-model="selectedRole"
          filterable
          placeholder="请选择用户角色"
        >
          <el-option
            v-for="item in HOSTING_USER_ROLE"
            :key="item.VALUE"
            :label="item.LABEL"
            :value="item.KEY"
          >
          </el-option>
        </el-select> -->
      </div>
    </div>
    <div class="sm-item">
      <div class="sm-item-key"><span>通知类型</span></div>
      <div class="sm-item-value">
        <el-select
          class="sm-item-value"
          v-model="selectedType"
          filterable
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
      <div class="sm-item-key"><span>通知等级</span></div>
      <div class="sm-item-value">
        <el-select
          class="sm-item-value"
          v-model="selectedLevel"
          filterable
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
      <div class="sm-item-key"><span>标题</span></div>
      <div class="sm-item-value title-item-value">
        <el-input
          v-model="selectedTitle"
          placeholder="请输入标题"
        ></el-input>
      </div>
    </div>
    <div class="lg-item">
      <div class="lg-item-key">
        <span>概要({{selectedSummaryCount}}/45)</span>
        <el-popover
          placement="bottom"
          :title="SUMMARY_SMS_LIMIT.TITLE"
          width="400"
          trigger="click"
          :content="SUMMARY_SMS_LIMIT.CONTENT"
        >
          <el-badge
            class="help-badge"
            slot="reference"
            type="warning"
            value="?"
          />
        </el-popover>
      </div>
      <div class="sm-item-auto-value summary-item-value">
        <el-input
          type="textarea"
          rows="3"
          placeholder="请输入概要"
          v-model="selectedSummary"
        >
        </el-input>
      </div>
    </div>
    <div class="lg-item">
      <div class="lg-item-key">
        <span>内容</span>
        <el-popover
          placement="bottom"
          :title="MESSAGE_VARIABLE_USAGE.TITLE"
          width="400"
          trigger="click"
          :content="MESSAGE_VARIABLE_USAGE.CONTENT"
        >
          <el-badge
            class="help-badge"
            slot="reference"
            type="warning"
            value="?"
          />
        </el-popover>
      </div>
      <div class="sm-item-auto-value content-item-value">
        <Editor v-model="editorContent"></Editor>
      </div>
    </div>
    <div class="sm-item">
      <div class="sm-item-key"><span></span></div>
      <div class="sm-item-multi-value">
        <el-button
          class="sm-item-multi-inner-button"
          type="primary"
          @click="saveAsTemplate"
        >保存</el-button>
        <el-button
          class="sm-item-multi-inner-button"
          @click="previewTemplate"
        >预览</el-button>
      </div>
    </div>
    <d-message-preview
      v-bind:isShow="isShowPreviewDialog"
      :messageContent="selectedMessageContent"
      @close="closePreview"
    ></d-message-preview>
  </div>
</template>

<script>
import Editor from "../components/RtfEditor";
import MessagePreviewDialog from "@/components/dialog/MessagePreviewDialog.vue";
export default {
  name: "home",
  components: {
    Editor: Editor,
    "d-message-preview": MessagePreviewDialog
  },
  data() {
    return {
      // const
      M_TYPE: this.$config.ENUM.M_TYPE.ITEMS,
      M_LEVEL: this.$config.ENUM.M_LEVEL.ITEMS,
      HOSTING_USER_ROLE: this.$config.ENUM.HOSTING_USER_ROLE.ITEMS,

      SUMMARY_SMS_LIMIT: this.$config.HELP.SUMMARY_SMS_LIMIT,
      MESSAGE_VARIABLE_USAGE: this.$config.HELP.MESSAGE_VARIABLE_USAGE,

      companyOptions: [],
      groupOptions: [],

      selectedTemplateName: null,
      selectedCompanyList: null,
      selectedGroupList: null,
      selectedRoleList: this.$config.ENUM.HOSTING_USER_ROLE.VALUES,
      selectedType: this.$config.ENUM.M_TYPE.ITEMS[0].KEY,
      selectedLevel: this.$config.ENUM.M_LEVEL.ITEMS[0].KEY,
      selectedTitle: null,
      selectedSummary: null,
      selectedSummaryCount: 0,

      selectedChannelList: [],
      editorContent: "",

      disableGroupSelector: true,

      // dialog
      isShowPreviewDialog: false,
      selectedMessageContent: null
    };
  },
  mounted() {
    this.selectedChannelList = ["4"];
    this.$util.resetNavigationStack();
    this.$util.pushNavigationStack({
      name: "通知运行管理 模板管理",
      router: { path: "/template" }
    });
    this.$util.pushNavigationStack({
      name: "新增模板",
      router: { path: "/addTemplate" }
    });

    this.initQuery();
  },
  watch: {
    selectedSummary() {
      this.selectedSummaryCount = this.selectedSummary.length;
    }
  },
  methods: {
    initQuery() {
      this.reqCompanyReceiver();
      // this.reqGroupReceiver(1351);
    },
    reqCompanyReceiver() {
      var that = this;
      this.$api.reqCompanyReceiver(function(response) {
        if (response != null && response.errorMsg) {
          alert(response.errorMsg);
        } else {
          if (response == null || response.length < 1) {
            that.companyOptions = [];
            return;
          }
          that.companyOptions = response;
        }
      });
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
    },
    onCompanyOptionsChange() {
      // if (this.selectedCompanyList && this.selectedCompanyList.length == 1) {
      //   this.reqGroupReceiver(this.selectedCompanyList[0]);
      //   this.disableGroupSelector = false;
      // } else {
      //   this.groupOptions = [];
      //   this.selectedGroupList = [];
      //   this.disableGroupSelector = true;
      // }
      var that = this;
      this.$util.checkCompany(this.selectedCompanyList, function(groupOptions) {
        if (
          that.selectedCompanyList.length == 1 &&
          groupOptions &&
          groupOptions.length > 0
        ) {
          that.groupOptions = groupOptions;
          that.disableGroupSelector = false;
        } else if (that.selectedCompanyList.length != 1) {
          that.groupOptions = [];
          that.selectedGroupList = [];
          that.disableGroupSelector = true;
        }
      });
    },
    getMessageContent() {
      var messageContent = new MessageContent();
      messageContent.type = MType[this.selectedType];
      messageContent.level = MLevel[this.selectedLevel];
      messageContent.title = this.selectedTitle;
      messageContent.summary = this.selectedSummary;
      messageContent.content = this.editorContent;
      return messageContent;
    },
    checkParams() {
      if (!this.selectedTemplateName) {
        alert("请输入模板名");
        return 1;
      }
      if (this.selectedTitle && this.selectedTitle.length > 32) {
        alert("标题字数过长，请重新填写");
        return 1;
      }
      if (this.selectedSummary && this.selectedSummary.length > 128) {
        alert("概要字数过长，请重新填写");
        return 1;
      }
      return 0;
    },
    saveAsTemplate() {
      if (this.checkParams()) {
        return;
      }

      // alert("templateName : " + templateName);
      var that = this;
      var template = new MBMessageTemplate();
      template.templateName = this.selectedTemplateName;
      template.policy = MSendingPolicy.MSP_NOW;
      if (this.selectedChannelList && this.selectedChannelList.length > 0) {
        template.channelList = this.selectedChannelList;
      }
      template.hostingList = this.$util.getMReceiverHostingList(
        this.selectedCompanyList,
        this.selectedGroupList,
        this.selectedRoleList
      );
      template.content = this.getMessageContent();

      this.$api.addTemplate(template, function(response) {
        if (response != null) {
          if (response.success) {
            alert("模板添加成功");
            that.gotoTemplatePage();
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
    gotoTemplatePage() {
      this.$router.push("/template");
    },
    previewTemplate() {
      this.selectedMessageContent = {
        title: this.selectedTitle,
        summary: this.selectedSummary,
        content: this.editorContent
      };
      this.isShowPreviewDialog = true;
    },
    closePreview() {
      this.isShowPreviewDialog = false;
    }
  }
};
</script>

<style scoped>
.page {
  background-color: white;
  width: 100%;
  padding-bottom: 50px;
}
.main {
  padding: 5px;
  height: 100%;
}
.content {
  height: 100%;
}
.long-item-value {
  width: 400px;
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

