<template>
  <div>
    this is a test file.
    <div>
      <button @click="deleteCommodityActiveConfig">deleteCommodityActiveConfig</button>
    </div>
    <div>
      <button @click="reqCommodityActiveConfig">reqCommodityActiveConfig</button>
    </div>
    <div>
      <button @click="reqCommodityTree">reqCommodityTree</button>
    </div>
    <div>
      <button @click="test">header test</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    deleteCommodityActiveConfig() {
      this.$api.deleteCommodityActiveConfig();
    },
    reqCommodityActiveConfig() {
      this.$api.reqCommodityActiveConfig();
    },
    reqCommodityTree() {
      this.$api.reqCommodityTree();
    },
    test() {
      this.$api.test();
    }
  }
};
</script>

