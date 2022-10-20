<template>
  <lay-out/>
</template>

<script>
import layOut from './components/layout/layout'
export default {
  name: 'App',
  components: {
    layOut
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
