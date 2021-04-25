<template>
  <div class="about">
    <!-- <h1>This is an about page</h1> -->
    <div>
      <Editor v-model="editorContent"
      ></Editor>
    </div>
    <div>
      <button @click="getRtfContent">get rtf content</button>
    </div>
  </div>
</template>

<script>
// import Editor from "@tinymce/tinymce-vue";
import Editor from "../components/RtfEditor"
import { all } from 'q';
export default {
  components: {
    Editor: Editor
  },
  data() {
    return {
      editorContent: "I am dapaul"
    };
  },
  methods: {
    initEditor() {},
    getRtfContent() {
      alert("editorContent : " + this.editorContent)
    }
  }
};
</script>

