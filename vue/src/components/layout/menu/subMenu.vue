<template>
  <el-sub-menu :key="subMenuDetail.id" :index="subMenuDetail.path">
    <template #title>
        <span >
            {{ subMenuDetail.menuName }}
        </span>
    </template>
    <template v-for="menuDetail in subMenuDetail.children" :key="menuDetail.id"  >
      <el-menu-item  :index="menuDetail.path">
        <span>
             {{ menuDetail.menuName }}
        </span>
      </el-menu-item>
      <sub-menu v-if="menuDetail.children.length > 0" :subMenuDetail="menuDetail"/>
    </template>
  </el-sub-menu>
</template>

<script>

export default {
  name: "subMenu",
  props: {
    subMenuDetail: {}
  }
}
</script>
