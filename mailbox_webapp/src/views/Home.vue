<template>
  <div class="page">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item
          v-for="(item, index) in $store.state.navigationStack"
          :key="index"
          :to="item.router"
        >
          {{item.name}}
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="main">
      <el-row class="tac">
        <el-col :span="3">
          <el-menu
            default-active="1"
            class="el-menu-vertical-demo"
          >
            <el-menu-item
              index="1"
              @click="gotoSendingMessagePage"
            >
              <span slot="title">发送通知</span>
            </el-menu-item>
            <el-menu-item
              index="2"
              @click="gotoSentMessagePage"
            >
              <span slot="title">已发送</span>
            </el-menu-item>
            <el-menu-item
              index="3"
              @click="gotoErrorSentMessagePage"
            >
              <span slot="title">异常通知</span>
            </el-menu-item>
            <el-menu-item
              index="4"
              @click="gotoTemplatePage"
            >
              <a slot="title">模板管理</a>
            </el-menu-item>
          </el-menu>
        </el-col>
        <el-col :span="21">
          <router-view />
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
  components: {},
  data() {
    return {
      defaultIndex: 1,
    };
  },
  mounted() {
      this.defaultIndex = 1;
  },
  methods: {
    gotoSendingMessagePage() {
      this.$router.push("/sending");
    },
    gotoSentMessagePage() {
      this.$router.push("/sent");
    },
    gotoErrorSentMessagePage() {
      this.$router.push("/errorMessage");
    },
    gotoTemplatePage() {
      this.$router.push("/template");
    }
  }
};
</script>

<style scoped>
.page {
  width: 100%;
  height: 100%;
}
.main {
  margin: 5px;
  height: 100%;
  background-color: white;
}
.content {
  height: 100%;
}
</style>

