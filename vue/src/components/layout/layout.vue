<template>
  <el-container>
    <!--    <el-aside class="aside_main" :class="{aside_main_show:!asideStatus}">-->
    <el-aside :width="asideLength" style="background-color:#4cd213" v-on:mouseleave="hideAside" v-on:mouseenter="showAside">
      <!--      <div>-->
      <!--        <el-icon>-->
      <!--          <ArrowDown/>-->
      <!--        </el-icon>-->
      <!--      </div>-->
      <!--      <div class="aside_open_close" @click="asidechange">-->
      <!--        <i class="el-icon-arrow-left" v-if="aside_open_close">-->
      <!--          <el-icon><DArrowLeft /></el-icon>-->
      <!--        </i>-->
      <!--        <i class="el-icon-arrow-right" v-else>-->
      <!--          <el-icon>-->
      <!--            <Back/>-->
      <!--          </el-icon>-->
      <!--        </i>-->
      <!--      </div>-->
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
  data() {
    return {
      asideStatus: false,
      aside_open_close: false,
      asideLength: '10px'
    }
  },
  methods: {
    // 侧边栏收缩与展开
    asidechange() {
      this.asideStatus = !this.asideStatus
      if (this.asideStatus) {
        setTimeout(() => {
          this.aside_open_close = true
        }, 500)
      } else {
        setTimeout(() => {
          this.aside_open_close = false
        }, 500)
      }
    },
    test() {
      alert(1)
      console.log(1)
    },
    hideAside() {
      this.asideLength = '10px'
    },
    showAside() {
      this.asideLength = '300px'
    }
  }
  // computed: {
  //   key() {
  //     return this.$route.path
  //   }
  // }
}
</script>
<style>
.aside_main {
  width: 100%;
  float: right;
  /*transition: width 0.5s;*/
}

.aside_main_show {
  width: 0px !important;
}
</style>