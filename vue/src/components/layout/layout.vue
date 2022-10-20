<template>
  <el-container>
    <el-aside>
      <menu-sidebar/>
<!--      <menu-tmplate/>-->
    </el-aside>
    <el-main>
      <router-view/>
    </el-main>
  </el-container>
</template>

<script>

import menuSidebar from "@/components/layout/menu/menuSidebar";
import menuTmplate from "@/components/layout/menu/menuTmplate";

export default {
  name: 'layOut',
  components: {
    menuSidebar,
    menuTmplate
  },
  // computed: {
  //   key() {
  //     return this.$route.path
  //   }
  // }
}
</script>
