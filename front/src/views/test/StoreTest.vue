<template>
  <div>
    <h1>This is an about page</h1>
    {{ counter }}
    {{ times2 }}
    {{ times2 }}
    {{ userName }}
    <button @click="inc">변경</button>
    <button @click="load">로드</button>
  </div>
</template>
<script>
import { computed } from 'vue'
import { useStore } from 'vuex'

export default {
  setup () {
    const store = useStore()
    // state는 moduleName으로 쪼개서 들어간다.
    const userName = computed(() => store.getters['module1/getUserName'])
    // getters와 mutation은 전역으로 들어가서 store.getters.Counter.time2가 아니라 store.getters.time2이다
    const inc = () => store.dispatch('module1/changeUserName', userName.value)
    const load = () => store.dispatch('module1/loadUserName')

    return { inc, load, userName }
  }
}
</script>
