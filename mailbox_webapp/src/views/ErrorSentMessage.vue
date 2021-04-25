<template>
  <div class="page">
    <div class="body">
      <div class="body-header">
        <div class="body-header-left">
          <span>发送时间：</span>
          <div class="date-picker-left">
            <el-date-picker
              class="date-picker-left"
              v-model="searchKeyStartCreateTime"
              type="date"
              value-format="timestamp"
              placeholder="开始日期"
            ></el-date-picker>
          </div>
          <!-- <el-date-picker
            class="date-picker-left"
            v-model="searchKeyStartCreateTime"
            type="date"
            placeholder="开始日期"
          ></el-date-picker> -->
          <span>至</span>
          <div class="date-picker-right body-header-component">
            <el-date-picker
              v-model="searchKeyEndCreateTime"
              type="date"
              value-format="timestamp"
              placeholder="结束日期"
            >
            </el-date-picker>
          </div>
          <!-- <el-date-picker
            class="date-picker-right body-header-component"
            v-model="searchKeyEndCreateTime"
            type="date"
            placeholder="结束日期"
          >
          </el-date-picker> -->
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
            @click="query"
          >刷新</el-button>
        </div>
      </div>
      <div class="body-content">
        <table>
          <tr bgColor=#F8FCFF>
            <th width="200">发送时间</th>
            <th width="300">发送方式</th>
            <th width="150">通知类型</th>
            <th width="150">通知等级</th>
            <th width="300">标题</th>
            <th width="150">状态</th>
            <th width="400">错误描述</th>
            <th width="200">操作者</th>
            <th width="300">操作</th>
          </tr>
          <tr
            v-for="(job, index) in messageJobList"
            v-bind:key="index"
          >
            <td>{{convertTimestampToString(job.createTimestamp)}}</td>
            <td>
              <span
                class="td-item"
                v-for="item in job.channelList"
                :key="item.VALUE"
              >{{M_SENDING_CHANNEL_MAP[item].LABEL}}</span>
            </td>
            <td>
              <span v-if="job.content">{{M_TYPE[job.content.type].LABEL}}</span>
              <span v-else>--</span>
            </td>
            <td>
              <span v-if="job.content">{{M_LEVEL_MAP[job.content.level].LABEL}}</span>
              <span v-else>--</span>
            </td>
            <td>
              <span v-if="job.content">{{job.content.title}}</span>
              <span v-else>--</span>
            </td>
            <td>
              <span>{{M_JOB_STATUS[job.status].LABEL}}</span>
            </td>
            <td>{{job.errorDescription}}</td>
            <td>
              <span v-if="job.operator">{{job.operator}}</span>
              <span v-else>--</span>
            </td>
            <td>
              <a
                class="td-item"
                href="#"
                @click="showReceiverInfoDialog(job)"
              >接收对象</a>
              <a
                class="td-item"
                href="#"
                @click="showMessage(job.content)"
              >消息内容</a>
              <a v-if="isResendable(job)"
                class="td-item"
                href="#"
                @click="showResendDialog(job)"
              >重发</a>
            </td>
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
      v-bind:isShow="isShowMessageDialog"
      :messageContent="selectedMessageContent"
      @close="closePreview"
    ></d-message-preview>
    <d-receiver-info
      v-bind:isShow="isShowReceiverInfoDialog"
      :title="selectedTitle"
      :message="selectedJob"
      :companyOptions="companyOptions"
      @close="closeReceiverInfoDialog"
    ></d-receiver-info>
  </div>
</template>

<script>
import MessagePreviewDialog from "@/components/dialog/MessagePreviewDialog.vue";
import ReceiverInfoDialog from "@/components/dialog/ReceiverInfoDialog.vue";
import { all } from "q";
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
      M_SENDING_CHANNEL_MAP: this.$config.ENUM.M_SENDING_CHANNEL.MAP,
      M_LEVEL_MAP: this.$config.ENUM.M_LEVEL.MAP,
      M_JOB_STATUS: this.$config.ENUM.M_JOB_STATUS.ITEMS,

      // search
      searchKeyStartCreateTime: null,
      searchKeyEndCreateTime: null,
      searchKeyChannel: null,
      searchKeyType: null,
      searchKeyLevel: null,

      // page
      totalNum: 0,
      currentPage: 1,
      pageSize: 10,

      // data
      nodata: true,
      messageJobList: [],

      // dialog
      isShowMessageDialog: false,
      selectedMessageContent: null,

      isShowReceiverInfoDialog: false,
      selectedJob: null,
      selectedTitle: null,

      companyOptions: []
    };
  },
  mounted() {
    this.$util.resetNavigationStack();
    this.$util.pushNavigationStack({
      name: "通知运行管理 异常通知",
      router: { path: "/errorMessage" }
    });

    this.reqMBMessageJob();
    this.reqCompanyReceiver();
  },
  methods: {
    onPageChange(currentPage) {
      this.currentPage = currentPage;
      this.reqMBMessageJob();
    },
    handleSizeChange(size) {
      this.pageSize = size;
      this.reqMBMessageJob();
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
      this.reqMBMessageJob();
    },
    reqMBMessageJob() {
      var that = this;
      var option = new QueryMBMessageJobOption();
      if (this.searchKeyStartCreateTime) {
        option.queryStartCreateTimestamp = this.searchKeyStartCreateTime / 1000;
      }
      if (this.searchKeyEndCreateTime) {
        option.queryEndCreateTimestamp = this.searchKeyEndCreateTime / 1000;
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
      option.statusSet = [];
      option.statusSet.push(MJStatus.MJS_SENDING);
      option.statusSet.push(MJStatus.MJS_EXCEPTION_STOP);
      option.statusSet.push(MJStatus.MJS_NETWORK_ERROR_RETRY);
      option.statusSet.push(MJStatus.MJS_NETWORK_ERROR_STOP);

      // alert(
      //   "option : " +
      //     JSON.stringify(option) +
      //     ", this.searchKeyType : " +
      //     this.searchKeyType
      // );
      // return;

      var pageOption = new IndexedPageOption();
      pageOption.needTotalCount = true;
      pageOption.pageIndex = this.currentPage - 1;
      pageOption.pageSize = this.pageSize;

      this.$api.reqMBMessageJob(option, pageOption, function(response) {
        if (response != null && response.errorMsg) {
          alert(response.errorMsg);
        } else {
          if (
            response == null ||
            response.messageJobList == null ||
            response.messageJobList.length < 1
          ) {
            that.messageJobList = [];
            that.totalNum = 0;
            that.nodata = true;
            return;
          }
          that.messageJobList = response.messageJobList;
          that.totalNum = response.totalNum;
          that.nodata = false;

          // alert("that.messageJobList : " + JSON.stringify(that.messageJobList));
        }
      });
    },
    showMessage(jobContent) {
      var that = this;
      this.$util.getRTFContent(jobContent.content, function(messageText) {
        that.selectedMessageContent = {
          title: jobContent.title,
          summary: jobContent.summary,
          content: messageText
        };
        that.isShowMessageDialog = true;
      });
    },
    closePreview() {
      this.isShowMessageDialog = false;
    },
    showReceiverInfoDialog(job) {
      if (!this.companyOptions) {
        alert("页面过期，请尝试刷新后重试");
        return;
      }
      this.selectedTitle = job.content.title;
      this.selectedJob = job;
      this.isShowReceiverInfoDialog = true;
    },
    closeReceiverInfoDialog() {
      this.isShowReceiverInfoDialog = false;
    },
    showResendDialog(job) {
      if (confirm("确认重发消息（" + job.content.title + ")?")) {
        var that = this;
        this.$api.updateMessageJobStatus(
          job.jobId,
          MJStatus.MJS_SENDING,
          function(response) {
            if (response != null) {
              if (response.success) {
                alert("重发成功");
                that.reqMBMessageJob();
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
          }
        );
      }
    },
    isResendable(job) {
      if (job.status == MJStatus.MJS_EXCEPTION_STOP) {
        return true;
      } else if (job.status == MJStatus.MJS_NETWORK_ERROR_STOP) {
        return true;
      }
      return false;
    },
    convertTimestampToString(timestamp) {
      return this.$timeUtil.getYYYY_MM_DD_HH_MM_SS(timestamp * 1000);
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
.date-picker-left {
  display: flex;
  width: 135px;
  margin-right: 2px;
}
.date-picker-right {
  display: flex;
  width: 135px;
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

