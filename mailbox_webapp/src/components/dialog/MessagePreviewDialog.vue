<template>
  <div
    v-if="isShow"
    class="dialog-bg dialog-z-order"
  >
    <div class="dialog-container">
      <div class="dialog-content">
        <div class="sm-item">
          <div class="item-key"><span>标题</span></div>
          <div class="item-value">
            <span>{{messageContent.title}}</span>
          </div>
        </div>
        <div class="lg-item">
          <div class="item-key"><span>概要</span></div>
          <div class="item-value">
            {{messageContent.summary}}
          </div>
        </div>
        <div class="lg-item">
          <div class="item-key"><span>内容</span></div>
          <div class="item-value">
            <Editor v-model="editorContent" :preview="true"></Editor>
          </div>
        </div>
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
import Editor from "../RtfEditor";
import { all, allSettled, allResolved } from "q";
export default {
  props: ["isShow", "messageContent"],
  components: {
    Editor: Editor
  },
  data() {
    return {
      editorContent: null
    };
  },
  watch: {
    isShow() {
      if (this.isShow) {
        this.editorContent = this.messageContent.content;
        // this.$refs.editor = this.messageContent.content;
        // var that = this;
        // this.$util.getRTFContent(this.messageContent.content, function(
        //   messageText
        // ) {
        //   that.editorContent = messageText;
        // });
      }
    }
  },
  methods: {
    close() {
      this.$emit("close");
    }
  }
};
</script>

<style>
.dialog-z-order{
    z-index: 100;
}
.item-key {
  width: 100px;
}
.item-value {
  text-align: left;
  width: 800px;
}
</style>

