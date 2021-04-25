<template>
  <div class="page">
    <div class="sm-item">
      <div class="sm-item-key"><span>模板</span></div>
      <div class="sm-item-value">
        <el-select
          class="sm-item-value"
          v-model="selectedTemplateOption"
          filterable
          @change="onTemplateOptionChange"
          placeholder="选择模板"
        >
          <el-option
            v-for="item in templateOptions"
            :key="item.templateId"
            :label="item.templateName"
            :value="item.templateId"
          >
          </el-option>
        </el-select>
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
        <Editor
          v-model="editorContent"
          :initText="initEditorContent"
        ></Editor>
      </div>
    </div>
    <div class="sm-item">
      <div class="sm-item-key"><span></span></div>
      <div class="sm-item-multi-value">
        <el-button
          class="sm-item-multi-inner-button"
          type="primary"
          @click="submitMessage"
        >提交</el-button>
        <el-button
          class="sm-item-multi-inner-button"
          @click="previewTemplate"
        >预览</el-button>
        <el-button
          class="sm-item-multi-inner-button"
          @click="saveAsTemplate"
        >保存为模板</el-button>
      </div>
    </div>
    <d-message-preview
      v-bind:isShow="isShowPreviewDialog"
      :messageContent="selectedMessageContent"
      @close="closePreview"
    ></d-message-preview>
    <d-confirm-message
      v-bind:isShow="isShowSendingConfirmDialog"
      :companyOptions="companyOptions"
      :groupOptions="groupOptions"
      :selectedChannelList="selectedChannelList"
      :selectedCompanyList="selectedCompanyList"
      :selectedGroupList="selectedGroupList"
      :selectedRoleList="selectedRoleList"
      :selectedType="selectedType"
      :selectedLevel="selectedLevel"
      :selectedTitle="selectedTitle"
      :selectedSummary="selectedSummary"
      :editorContent="editorContent"
      @confirm="confirmSending"
      @close="cancelSending"
    ></d-confirm-message>
  </div>
</template>

<script>
import Editor from "../components/RtfEditor";
import MessagePreviewDialog from "@/components/dialog/MessagePreviewDialog.vue";
import SendingMessageConfirmDialog from "@/components/dialog/SendingMessageConfirmDialog.vue";

import { all, allSettled, allResolved } from "q";
export default {
  name: "home",
  components: {
    Editor: Editor,
    "d-message-preview": MessagePreviewDialog,
    "d-confirm-message": SendingMessageConfirmDialog
  },
  data() {
    return {
      // const
      M_TYPE: this.$config.ENUM.M_TYPE.ITEMS,
      M_LEVEL: this.$config.ENUM.M_LEVEL.ITEMS,
      HOSTING_USER_ROLE: this.$config.ENUM.HOSTING_USER_ROLE.ITEMS,
      M_LEVEL_MAP: this.$config.ENUM.M_LEVEL.MAP,

      SUMMARY_SMS_LIMIT: this.$config.HELP.SUMMARY_SMS_LIMIT,
      MESSAGE_VARIABLE_USAGE: this.$config.HELP.MESSAGE_VARIABLE_USAGE,

      templateOptions: [],
      companyOptions: [],
      groupOptions: [],

      // route query
      queryTemplateId: null,
      queryTemplateName: null,

      selectedTemplate: null,
      selectedTemplateOption: null,
      selectedCompanyList: [],
      selectedGroupList: [],
      selectedRoleList: this.$config.ENUM.HOSTING_USER_ROLE.VALUES,
      selectedType: this.$config.ENUM.M_TYPE.ITEMS[0].KEY,
      selectedLevel: this.$config.ENUM.M_LEVEL.ITEMS[0].KEY,
      selectedTitle: null,
      selectedSummary: null,
      selectedSummaryCount: 0,

      selectedChannelList: [],
      initEditorContent: "",
      editorContent: "",

      disableGroupSelector: true,

      // dialog
      isShowPreviewDialog: false,
      selectedMessageContent: null,

      isShowSendingConfirmDialog: false
    };
  },
  mounted() {
    this.selectedChannelList = ["4"];
    this.$util.resetNavigationStack();
    this.$util.pushNavigationStack({
      name: "通知运行管理 发送通知",
      router: { path: "/sending" }
    });

    this.getQueryParams();
    this.initQuery();
  },
  watch: {
    selectedSummary() {
      this.selectedSummaryCount = this.selectedSummary.length;
    }
  },
  methods: {
    initQuery() {
      this.reqMBMessageTemplateSelector();
      this.reqCompanyReceiver();
      // this.reqGroupReceiver(1351);
    },
    getQueryParams() {
      this.queryTemplateId = this.$route.query.templateId;
      this.queryTemplateName = this.$route.query.templateName;

      if (this.queryTemplateId && this.queryTemplateName) {
        this.selectedTemplateOption = this.queryTemplateName;
        this.reqTemplate(this.queryTemplateId);
      }
      // alert("getQueryParams ---- this.queryTemplateId : " + this.queryTemplateId + ", this.queryTemplateName : " + this.queryTemplateName)
    },
    reqMBMessageTemplateSelector() {
      var that = this;
      this.$api.reqMBMessageTemplateSelector(function(response) {
        if (response != null && response.errorMsg) {
          alert(response.errorMsg);
        } else {
          if (response == null || response.length < 1) {
            that.templateOptions = [];
            return;
          }
          that.templateOptions = response;
        }
      });
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
      // var that = this;
      // this.$api.reqGroupReceiver(companyId, function(response) {
      //   if (response != null && response.errorMsg) {
      //     alert(response.errorMsg);
      //   } else {
      //     if (response == null || response.length < 1) {
      //       that.groupOptions = [];
      //       return;
      //     }
      //     that.groupOptions = response;
      //     // alert("that.groupOptions : " + JSON.stringify(that.groupOptions))
      //   }
      // });
      var that = this;
      this.$apiUtil.reqGroupReceiver(companyId, function(groupOptions) {
        that.groupOptions = groupOptions;
      });
    },
    onTemplateOptionChange() {
      if (this.selectedTemplateOption && this.selectedTemplateOption > 0) {
        this.reqTemplate(this.selectedTemplateOption);
      }
    },
    reqTemplate(templateId) {
      var that = this;
      var option = new QueryMBMessageTemplateOption();
      option.templateIdSet = [];
      option.templateIdSet.push(templateId);

      // alert("option : " + JSON.stringify(option) + ", this.searchKeyType : " + this.searchKeyType);
      // return;

      var pageOption = new IndexedPageOption();
      pageOption.needTotalCount = false;
      pageOption.pageIndex = 0;
      pageOption.pageSize = 1;

      this.$api.reqTemplate(option, pageOption, function(response) {
        if (response != null && response.errorMsg) {
          alert(response.errorMsg);
        } else {
          if (
            !response ||
            !response.templateList ||
            response.templateList.length < 1
          ) {
            that.selectedTemplate = null;
            return;
          }
          that.selectedTemplate = response.templateList[0];
          that.applyTemplate();
          // alert("that.selectedTemplate : " + JSON.stringify(that.selectedTemplate));
        }
      });
    },
    applyTemplate() {
      if (!this.selectedTemplate) {
        return;
      }
      this.selectedChannelList = this.$util.getStringChannelList(
        this.selectedTemplate.channelList
      );
      this.selectedCompanyList = this.$util.getCompanyListFromHostingList(
        this.selectedTemplate.hostingList
      );

      if (this.selectedCompanyList && this.selectedCompanyList.length == 1) {
        this.reqGroupReceiver(this.selectedCompanyList[0]);
        this.disableGroupSelector = false;
      } else {
        this.disableGroupSelector = true;
      }

      this.selectedGroupList = this.$util.getGroupListFromHostingList(
        this.selectedTemplate.hostingList
      );
      this.selectedRoleList = this.$util.getRoleListFromHostingList(
        this.selectedTemplate.hostingList
      );
      this.selectedType = this.M_TYPE[this.selectedTemplate.content.type].KEY;
      this.selectedLevel = this.M_LEVEL_MAP[
        this.selectedTemplate.content.level
      ].KEY;
      this.selectedTitle = this.selectedTemplate.content.title;
      this.selectedSummary = this.selectedTemplate.content.summary;
      if (this.selectedSummary) {
        this.selectedSummaryCount = this.selectedSummary.length;
      }
      var that = this;
      this.$util.getRTFContent(this.selectedTemplate.content.content, function(
        contentText
      ) {
        that.initEditorContent = contentText;
        that.editorContent = contentText;
      });
    },
    clear() {
      this.groupOptions = [];
      this.selectedTemplateOption = null;
      this.selectedTemplate = null;
      this.selectedCompanyList = [];
      this.selectedGroupList = [];
      (this.selectedRoleList = this.$config.ENUM.HOSTING_USER_ROLE.VALUES),
        (this.selectedType = this.$config.ENUM.M_TYPE.ITEMS[0].KEY);
      this.selectedLevel = this.$config.ENUM.M_LEVEL.ITEMS[0].KEY;
      this.selectedTitle = null;
      this.selectedSummary = null;
      this.selectedChannelList = ["4"];
      this.editorContent = "";
      this.disableGroupSelector = true;
    },
    onCompanyOptionsChange() {
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
    checkParams() {
      if (!this.selectedChannelList || this.selectedChannelList.length < 1) {
        alert("请选择发送途径");
        return 1;
      }
      // if (!this.selectedRole) {
      //   alert("请选择用户角色");
      //   return 1;
      // }
      if (!this.selectedTitle) {
        alert("请输入消息标题");
        return 1;
      }
      if (this.selectedTitle && this.selectedTitle.length > 32) {
        alert("标题字数过长，请重新填写");
        return 1;
      }
      if (!this.selectedSummary) {
        alert("请输入消息概要");
        return 1;
      }
      if (this.selectedSummary && this.selectedSummary.length > 128) {
        alert("概要字数过长，请重新填写");
        return 1;
      }
      if (!this.editorContent) {
        alert("请输入消息内容");
        return 1;
      }
      return 0;
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
    // addMBMessage() {
    //   if (this.checkParams()) {
    //     return;
    //   }
    //   var that = this;
    //   var message = new MBMessage();

    //   message.policy = MSendingPolicy.MSP_NOW;
    //   message.channelList = this.selectedChannelList;
    //   message.hostingList = this.$util.getMReceiverHostingList(
    //     this.selectedCompanyList,
    //     this.selectedGroupList,
    //     this.selectedRoleList
    //   );
    //   message.content = this.getMessageContent();
    //   message.operator = this.$cookie.getCookie("oa_user_name");

    //   // alert("message : " + JSON.stringify(message))
    //   // return;

    //   this.$api.addMBMessage(message, function(response) {
    //     if (response != null) {
    //       if (response.success) {
    //         alert("消息提交成功");
    //         that.clear();
    //         that.gotoSentMessagePage();
    //       } else if (response.message) {
    //         alert(response.message);
    //       } else if (response.errorMsg) {
    //         alert(response.errorMsg);
    //       } else {
    //         alert(that.$string.message.callMethodFail);
    //       }
    //     } else {
    //       alert(that.$string.message.serverBusy);
    //     }
    //   });
    // },
    submitMessage() {
      if (this.checkParams()) {
        return;
      }
      this.showSendingConfirmDialog();
    },
    saveAsTemplate() {
      if (!confirm("确定要将该通知保存为模板吗？")) {
        return;
      }
      var templateName = prompt("请输入模板名");
      if (!templateName) {
        alert("模板名不能为空");
        return;
      }

      // alert("templateName : " + templateName);
      var that = this;
      var template = new MBMessageTemplate();
      template.templateName = templateName;
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
            that.reqMBMessageTemplateSelector();
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
    previewTemplate(template) {
      this.selectedMessageContent = {
        title: this.selectedTitle,
        summary: this.selectedSummary,
        content: this.editorContent
      };
      this.isShowPreviewDialog = true;
    },
    closePreview() {
      this.isShowPreviewDialog = false;
    },
    gotoSentMessagePage() {
      this.$router.push("/sent");
    },
    showSendingConfirmDialog() {
      this.isShowSendingConfirmDialog = true;
    },
    confirmSending() {
      this.isShowSendingConfirmDialog = false;
      this.clear();
      this.gotoSentMessagePage();
    },
    cancelSending() {
      this.isShowSendingConfirmDialog = false;
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

