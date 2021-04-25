export default {
  navigationStack: [],
  methods: {
    resetNavigationStack() {
      this.navigationStack = []
    },
    pushNavigationStack(item) {
      this.navigationStack.push(item)
    }
  }
}
