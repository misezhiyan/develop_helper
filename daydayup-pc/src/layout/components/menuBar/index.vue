<template>
  <el-menu default-active="1" active-text-color="#409EFF" text-color="#FFF" class="el-menu" :collapse="collapsed">
    <menuItem :menus="menus" />
  </el-menu>
</template>
  
<script lang="ts" setup>
import { reactive } from 'vue';
import menuItem from './menuItem.vue';

defineProps({
  collapsed: {
    type: Boolean
  }
})

const menus = reactive(
  [{
    path: "/",
    redirect: "/index",
    name: "Index",
    meta: {
      title: '首页',
      icon: 'house'
    },
    children: [{
      path: "index",
      name: "Index",
      meta: {
        title: '首页',
        icon: 'house'
      },
    }]
  }, {
    path: "/user",
    redirect: '/user/student',
    name: "User",
    meta: {
      title: '用户管理',
      affix: true,
      icon: 'UserFilled'
    },
    children: [{
      path: "student",
      name: "Student",
      meta: {
        title: '生源信息',
        icon: 'UserFilled'
      },
    }, {
      path: "teacher",
      name: "Teacher",
      meta: {
        title: '师资信息',
        icon: 'UserFilled'
      },
    }]
  }, {
    path: '/system',
    // redirect: '/user/student',
    name: 'System',
    meta: {
      title: '系统管理',
      affix: true,
      icon: 'UserFilled'
    },
    children: [{
      path: "menu",
      name: "Menu",
      meta: {
        title: '菜单管理',
        icon: 'UserFilled'
      }
    }, {
      path: "auth",
      name: "Auth",
      meta: {
        title: '权限管理',
        icon: 'UserFilled'
      }
    }, {
      path: "role",
      name: "Role",
      meta: {
        title: '角色管理',
        icon: 'UserFilled'
      }
    }],
  }
  ])

</script>
  
<style lang="scss">
.el-menu {
  width: 200px;
  // min-height: 300px;
  // height: 100vh;
  background-color: $menuBg;
  overflow: hidden;
  border: none;

  .el-sub-menu {
    .el-menu-item {
      background-color: $subMenuBg;
    }
  }
}
</style>