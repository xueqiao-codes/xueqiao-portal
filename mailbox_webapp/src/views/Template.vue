<template>
  <div class="page">
    <div class="body">
      <div class="body-header">
        <div class="body-header-left">
          <span>模板名称：</span>
          <el-input
            class="body-header-input body-header-component"
            placeholder="模板名称"
            v-model="searchKeyTemplateName"
            clearable
          >
          </el-input>
          <span>发送途径：</span>
          <el-select
            v-model="searchKeyChannel"
            placeholder="发送途径"
            clearable
            class="body-header-input body-header-component"
          >
            <el-option
              v-for="item in M_SENDING_CHANNEL"
              :key="item.VALUE"
              :label="item.LABEL"
              :value="item.KEY"
            >
            </el-option>
          </el-select>
          <span>通知类型：</span>
          <el-select
            v-model="searchKeyType"
            placeholder="通知类型"
            clearable
            class="body-header-input body-header-component"
          >
            <el-option
              v-for="item in M_TYPE"
              :key="item.VALUE"
              :label="item.LABEL"
              :value="item.KEY"
            >
            </el-option>
          </el-select>
          <span>通知级别：</span>
          <el-select
            v-model="searchKeyLevel"
            placeholder="通知级别"
            clearable
            class="body-header-input body-header-component"
          >
            <el-option
              v-for="item in M_LEVEL"
              :key="item.VALUE"
              :label="item.LABEL"
              :value="item.KEY"
            >
            </el-option>
          </el-select>
          <el-button
            class="body-header-component"
            type="primary"
            size="small"
            @click="query"
          >查询</el-button>
        </div>
        <div class="body-header-right">
          <el-button
            type="primary"
            size="small"
            @click="gotoEditTempaltePage"
          >新增模板</el-button>
        </div>
      </div>
      <div class="body-content">
        <table>
          <tr bgColor=#F8FCFF>
            <th width="300">模板名称</th>
            <th width="300">发送方式</th>
            <th width="200">通知类型</th>
            <th width="150">通知等级</th>
            <th width="400">标题</th>
            <th width="350">操作</th>
          </tr>
          <tr
            v-for="(template, index) in templateList"
            v-bind:key="index"
          >
            <td>{{template.templateName}}</td>
            <td>
              <div v-if="template.channelList && template.channelList.length > 0">
                <span
                  class="td-item"
                  v-for="item in template.channelList"
                  :key="item.VALUE"
                >{{M_SENDING_CHANNEL_MAP[item].LABEL}}</span>
              </div>
              <div v-else><span>--</span></div>
            </td>
            <td>
              <span v-if="template.content">{{M_TYPE[template.content.type].LABEL}}</span>
              <span v-else>--</span>
            </td>
            <td>
              <span v-if="template.content">{{M_LEVEL_MAP[template.content.level].LABEL}}</span>
              <span v-else>--</span>
            </td>
            <td>
              <span v-if="template.content">{{template.content.title}}</span>
              <span v-else>--</span>
            </td>
            <td>
              <a
                class="td-item"
                href="#"
                @click="showReceiverInfoDialog(template)"
              >接收对象</a>
              <a
                class="td-item"
                href="#"
                @click="previewTemplate(template)"
              >消息内容</a>
              <a
                class="td-item"
                href="#"
                @click="gotoEditTemplatePage(template)"
              >编辑</a>
              <a
                class="td-item"
                href="#"
                @click="applyTemplate(template)"
              >使用</a><a
                class="td-item"
                href="#"
                @click="deleteTemplate(template)"
              >删除</a></td>
          </tr>
        </table>
        <div
          class="body-content-nodata"
          v-if="nodata"
        >无数据</div>
      </div>
      <div class="pagination">
        <el-pagination
          background
          layout="total, sizes, prev, pager, next, jumper"
          :total="totalNum"
          :page-size="pageSize"
          :current-page="currentPage"
          @size-change="handleSizeChange"
          @current-change="onPageChange"
        >
        </el-pagination>
      </div>
    </div>
    <d-message-preview
      v-bind:isShow="isShowPreviewDialog"
      :messageContent="selectedMessageContent"
      @close="closePreview"
    ></d-message-preview>
    <d-receiver-info
      v-bind:isShow="isShowReceiverInfoDialog"
      :title="selectedTitle"
      :message="selectedTemplate"
      :companyOptions="companyOptions"
      @close="closeReceiverInfoDialog"
    ></d-receiver-info>
  </div>
</template>

<script>
import MessagePreviewDialog from "@/components/dialog/MessagePreviewDialog.vue";
import ReceiverInfoDialog from "@/components/dialog/ReceiverInfoDialog.vue";
export default {
  name: "home",
  components: {
    "d-message-preview": MessagePreviewDialog,
    "d-receiver-info": ReceiverInfoDialog
  },
  data() {
    return {
      // const
      M_SENDING_CHANNEL: this.$config.ENUM.M_SENDING_CHANNEL.ITEMS,
      M_TYPE: this.$config.ENUM.M_TYPE.ITEMS,
      M_LEVEL: this.$config.ENUM.M_LEVEL.ITEMS,
      M_LEVEL_MAP: this.$config.ENUM.M_LEVEL.MAP,
      M_SENDING_CHANNEL_MAP: this.$config.ENUM.M_SENDING_CHANNEL.MAP,

      // search
      searchKeyTemplateName: null,
      searchKeyChannel: null,
      searchKeyType: null,
      searchKeyLevel: null,

      // page
      totalNum: 0,
      currentPage: 1,
      pageSize: 10,

      // data
      templateList: [],
      nodata: true,

      // dialog
      isShowPreviewDialog: false,
      selectedMessageContent: null,

      isShowReceiverInfoDialog: false,
      selectedTemplate: null,
      selectedTitle: null,

      companyOptions: []
    };
  },
  mounted() {
    this.$util.resetNavigationStack();
    this.$util.pushNavigationStack({
      name: "通知运行管理 模板管理",
      router: { path: "/template" }
    });

    this.reqTemplate();
    this.reqCompanyReceiver();
  },
  methods: {
    onPageChange(currentPage) {
      this.currentPage = currentPage;
      this.reqTemplate();
    },
    handleSizeChange(size) {
      this.pageSize = size;
      this.reqTemplate();
    },
    gotoEditTempaltePage() {
      this.$router.push("/addTemplate");
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
    query() {
      this.reqTemplate();
    },
    reqTemplate() {
      var that = this;
      var option = new QueryMBMessageTemplateOption();
      if (this.searchKeyTemplateName) {
        option.templateNamePartial = this.searchKeyTemplateName;
      }
      if (this.searchKeyChannel) {
        option.channel = MSendingChannel[this.searchKeyChannel];
      }
      if (this.searchKeyType != null && this.searchKeyType != undefined) {
        option.type = MType[this.searchKeyType];
      }
      if (this.searchKeyLevel != null && this.searchKeyLevel != undefined) {
        option.level = MLevel[this.searchKeyLevel];
      }

      // alert("option : " + JSON.stringify(option) + ", this.searchKeyType : " + this.searchKeyType);
      // return;

      var pageOption = new IndexedPageOption();
      pageOption.needTotalCount = true;
      pageOption.pageIndex = this.currentPage - 1;
      pageOption.pageSize = this.pageSize;

      this.$api.reqTemplate(option, pageOption, function(response) {
        if (response != null && response.errorMsg) {
          alert(response.errorMsg);
        } else {
          if (
            response == null ||
            response.templateList == null ||
            response.templateList.length < 1
          ) {
            that.templateList = [];
            that.totalNum = 0;
            that.nodata = true;
            return;
          }
          that.templateList = response.templateList;
          that.totalNum = response.totalNum;
          that.nodata = false;

          // alert("that.templateList : " + JSON.stringify(that.templateList));
        }
      });
    },
    applyTemplate(template) {
      // if (confirm("确定使用模板(" + template.templateName + ")?")) {
      this.$router.push({
        path: "/sending",
        query: {
          templateId: template.templateId,
          templateName: template.templateName
        }
      });
      // }
    },
    deleteTemplate(template) {
      if (confirm("确定删除模板(" + template.templateName + ")?")) {
        var that = this;
        this.$api.removeTemplate(template.templateId, function(response) {
          if (response != null) {
            if (response.success) {
              alert("删除成功");
              that.reqTemplate();
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
      }
    },
    gotoEditTemplatePage(template) {
      this.$router.push({
        path: "/editTemplate",
        query: {
          template: template
        }
      });
    },
    previewTemplate(template) {
      var that = this;
      this.$util.getRTFContent(template.content.content, function(messageText) {
        that.selectedMessageContent = {
          title: template.content.title,
          summary: template.content.summary,
          content: messageText
        };
        that.isShowPreviewDialog = true;
      });
    },
    closePreview() {
      this.isShowPreviewDialog = false;
    },
    showReceiverInfoDialog(template) {
      if (!this.companyOptions) {
        alert("页面过期，请尝试刷新后重试");
        return;
      }
      this.selectedTitle = template.templateName;
      this.selectedTemplate = template;
      this.isShowReceiverInfoDialog = true;
    },
    closeReceiverInfoDialog() {
      this.isShowReceiverInfoDialog = false;
    }
  }
};
</script>

<style scoped>
.page {
  background-color: white;
  width: 100%;
  height: 100%;
}
.main {
  padding: 5px;
  height: 100%;
}
.content {
  height: 100%;
}
.td-item {
  margin-left: 5px;
  margin-right: 5px;
}
table {
  border-collapse: collapse;
}
table,td,th {
  border: 1px solid #e5e5e5;
}
th {
  background-color: rgba(248, 252, 255, 1);
  line-height: 19px;
  color: rgba(80, 80, 80, 1);
  font-size: 18px;
  text-align: left;
  font-family: STHeitiSC-Medium;
  text-align: center;
}
td,th {
  height: 40px;
  text-align: center;
  font-size: 15px;
}
</style>

