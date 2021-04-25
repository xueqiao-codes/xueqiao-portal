<template>
  <div>
    <div
      ref="editor"
      style="text-align:left"
    ></div>
    <!-- <button v-on:click="getContent">查看内容</button> -->
  </div>
</template>

<script>
import E from "wangeditor";
export default {
  name: "editor",
  props: ["value", "initText", "preview"],
  data() {
    return {
      editorContent: "",
      editor: null
    };
  },
  methods: {
    getContent: function() {
      alert(this.value);
    }
  },
  watch: {
    // value() {
    //   this.editor.txt.html(this.value);
    // }
    initText() {
      this.editor.txt.html(this.initText);
    }
  },
  mounted() {
    this.editor = new E(this.$refs.editor);
    var that = this;
    this.editor.customConfig.onchange = html => {
      this.editorContent = html;
      // that.value = html;
      this.$emit("input", html);
    };
    if (this.preview) {
      this.editor.customConfig.menus = [];
    } else {
      this.editor.customConfig.menus = [
        "head", // 标题
        "bold", // 粗体
        "fontSize", // 字号
        "fontName", // 字体
        "italic", // 斜体
        "underline", // 下划线
        "strikeThrough", // 删除线
        "foreColor", // 文字颜色
        "backColor", // 背景颜色
        "link", // 插入链接
        "list", // 列表
        "justify", // 对齐方式
        "quote", // 引用
        //   "emoticon", // 表情
        "image", // 插入图片
        "table", // 表格
        //   "video", // 插入视频
        //   "code", // 插入代码
        "undo", // 撤销
        "redo" // 重复
      ];
    }
    this.editor.customConfig.uploadImgShowBase64 = true;
    this.editor.customConfig.zIndex = 10;
    this.editor.create();
    this.editor.txt.html(this.value);

    if (this.preview) {
      this.editor.$textElem.attr("contenteditable", false);
    } else {
      this.editor.$textElem.attr("contenteditable", true);
    }
  }
};
</script>

<style scoped>
</style>