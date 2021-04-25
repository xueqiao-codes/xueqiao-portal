<template>
  <div class="page">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/commodityActiveConfig' }">行情订阅管理 活跃合约规律</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="header">
      <div class="header-text">行情订阅管理</div>
      <ul class="header-tab">
        <li class="active">活跃合约规律</li>
        <li @click="gotoTabSubcribedContract">订阅商品合约</li>
        <li @click="gotoTabQuotationAccount">行情账号</li>
        <li @click="gotoTabSubscribedQuotation">已订阅行情</li>
        <li @click="gotoTabPlanedSubscribedPreview">已规划订阅</li>
        <li @click="gotoTabSubscribedPreview">重新规划预览</li>
      </ul>
    </div>
    <div class="body">
      <div class="body-header">
        <div class="body-header-left">
          <span>商品：</span>
          <el-input
            class="body-header-input body-header-component"
            placeholder="商品名"
            v-model="searchKeyCommodity"
            clearable
          >
          </el-input>
          <el-button
            class="body-header-component"
            type="primary"
            size="small"
            @click="query"
          >查询</el-button>
        </div>
        <div class="body-header-right">
          <el-button
            class="body-header-component"
            type="primary"
            size="small"
            @click="showAddCommodityActiveConfigDialog"
          >添加</el-button>
          <el-button
            class="body-header-component"
            type="primary"
            size="small"
            @click="gotoSubscribedPreview"
          >重新规划</el-button>
        </div>
      </div>
      <div class="body-content">
        <table>
          <tr bgColor=#F8FCFF>
            <th width="400">交易所</th>
            <th width="400">商品</th>
            <th width="400">类型</th>
            <th width="400">固定合约代号</th>
            <th width="800">活跃合约月份</th>
            <!-- <th width="600">非活跃合约月份</th> -->
            <th width="400">操作</th>
          </tr>
          <tr
            v-for="(commodityActiveConfig, index) in commodityActiveConfigList"
            v-bind:key="index"
          >
            <td>{{commodityActiveConfig.exchangeName}}</td>
            <td>{{commodityActiveConfig.commodityName}}</td>
            <td>{{CONTRACT_ACTIVE_TYPE[commodityActiveConfig.activeType].label}}</td>
            <td v-if="commodityActiveConfig.activeType == 1">{{commodityActiveConfig.fixedCode}}</td>
            <td v-else>-</td>
            <td v-if="commodityActiveConfig.activeType == 0">
              <span
                v-for="(activeMonth, index) in commodityActiveConfig.activeMonths"
                v-bind:key="index"
              >{{activeMonth}};&nbsp;&nbsp;</span>
            </td>
            <td v-else>-</td>
            <!-- <td><span v-for="(inactiveMonth, index) in getInactiveMonthList(commodityActiveConfig.activeMonths)" v-bind:key="index">{{inactiveMonth + 1}}月;</span></td> -->
            <td>
              <a v-if="commodityActiveConfig.activeType == 0"
                href="#"
                class="body-table-operation"
                @click="showEditCommodityActiveConfigDialog(commodityActiveConfig)"
              >编辑</a>
              <a
                href="#"
                class="body-table-operation"
                @click="showDeleteCommodityActiveConfigDialog(commodityActiveConfig)"
              >删除</a>
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
    <dialog-addition
      v-bind:isShow="isShowAdditionDialog"
      @confirm="confirmAddition"
      @close="cancelAddition"
    ></dialog-addition>
    <dialog-edition
      v-bind:isShow="isShowEditionDialog"
      :activeConfig="editingActiveCondfig"
      @confirm="confirmEdition"
      @close="cancelEdition"
    ></dialog-edition>
  </div>
</template>

<script>
import AddCommodityActiveConfigDialog from "../components/specdialog/AddCommodityActiveConfigDialog.vue";
import EditCommodityActiveConfigDialog from "../components/specdialog/EditCommodityActiveConfigDialog.vue";
export default {
  components: {
    "dialog-addition": AddCommodityActiveConfigDialog,
    "dialog-edition": EditCommodityActiveConfigDialog
  },
  data() {
    return {
      // dialog
      isShowAdditionDialog: false,
      isShowEditionDialog: false,

      // const
      CONTRACT_ACTIVE_TYPE: this.$config.CONTRACT_ACTIVE_TYPE.ITEMS,

      // page
      totalNum: 0,
      currentPage: 1,
      pageSize: 10,

      // search key
      searchKeyCommodity: null,

      // data
      nodata: true,
      commodityActiveConfigList: null,
      editingActiveCondfig: null
    };
  },
  mounted() {
    this.reqCommodityActiveConfig();
  },
  methods: {
    gotoTabCommodityActiveConfig() {
      this.$router.push("/commodityActiveConfig");
    },
    gotoTabSubcribedContract() {
      this.$router.push("/subscribedContract");
    },
    gotoTabQuotationAccount() {
      this.$router.push("/quotationAccount");
    },
    gotoTabSubscribedQuotation() {
      this.$router.push("/subscribedQuotation");
    },
    gotoTabPlanedSubscribedPreview() {
      this.$router.push("/planedSubscribedPreview");
    },
    gotoTabSubscribedPreview() {
      this.$router.push("/subscribedPreview/tab");
    },
    gotoSubscribedPreview() {
      var that = this;
      this.$common.replanSubscribe(function() {
        that.$router.push("/subscribedPreview/commodityActiveConfig");
      });
    },
    reqCommodityActiveConfig() {
      var that = this;

      var reqCommodityActiveConfigOption = new ReqCommodityActiveConfigOption();
      if (this.searchKeyCommodity) {
        reqCommodityActiveConfigOption.commodityNamePartical = this.searchKeyCommodity;
      }

      var pageOption = new IndexedPageOption();
      pageOption.needTotalCount = true;
      pageOption.pageIndex = this.currentPage - 1;
      pageOption.pageSize = this.pageSize;

      this.$api.reqCommodityActiveConfig(
        reqCommodityActiveConfigOption,
        pageOption,
        function(response) {
          if (response != null && response.errorMsg) {
            alert(response.errorMsg);
          } else {
            if (
              response == null ||
              response.page == null ||
              response.page.length < 1
            ) {
              that.commodityActiveConfigList = [];
              that.nodata = true;
              return;
            }
            that.nodata = false;
            that.commodityActiveConfigList = response.page;
            that.totalNum = response.total;
          }
        }
      );
    },
    query() {
      this.reqCommodityActiveConfig();
    },
    onPageChange(currentPage) {
      this.currentPage = currentPage;
      this.reqCommodityActiveConfig();
      // alert(currentPage)
    },
    handleSizeChange(size) {
      this.pageSize = size;
      this.reqCommodityActiveConfig();
    },
    showAddCommodityActiveConfigDialog() {
      // alert("addCommodity")
      this.isShowAdditionDialog = true;
    },
    confirmAddition() {
      // alert("confirmAddition")
      this.isShowAdditionDialog = false;
      this.reqCommodityActiveConfig();
      alert("添加成功");
    },
    cancelAddition() {
      this.isShowAdditionDialog = false;
    },
    showDeleteCommodityActiveConfigDialog(commodityActiveConfig) {
      var that = this;
      if (confirm("是否确认删除？")) {
        this.$api.deleteCommodityActiveConfig(
          commodityActiveConfig.sledCommodityId,
          commodityActiveConfig.activeType,
          commodityActiveConfig.fixedCode,
          function() {
            alert("删除成功");
            that.reqCommodityActiveConfig();
          }
        );
      }
    },
    showEditCommodityActiveConfigDialog(commodityActiveConfig) {
      this.editingActiveCondfig = commodityActiveConfig;
      this.isShowEditionDialog = true;
    },
    confirmEdition() {
      this.isShowEditionDialog = false;
      this.reqCommodityActiveConfig();
      alert("修改成功");
    },
    cancelEdition() {
      this.isShowEditionDialog = false;
    }
    // getInactiveMonthList (activeMonthList) {
    //   var monthList = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
    //   var unactiveMonthList = []
    //   for(var index = 0; index < monthList.length; index++) {
    //     let month = monthList[index]
    //     if (activeMonthList.indexOf(month) == -1) {
    //       unactiveMonthList.push(month)
    //     }
    //   }
    //   return unactiveMonthList
    // },
  }
};
</script>

<style scoped>
.body-header-input {
  width: 200px;
}
</style>
