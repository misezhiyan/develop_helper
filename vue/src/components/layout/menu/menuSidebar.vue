<template>
  <el-menu style="background-color: #4cd213" router v-for="menuDetail in menuList" :key="menuDetail.id">
    <!--    <template v-for="menuDetail in menuList" :key="menuDetail.id" >-->
    <el-menu-item :index="menuDetail.path" v-if="menuDetail.children.length < 1">
      <span>
        <el-icon :size="20" color="#409EFC"><Edit/></el-icon>
      </span>
      {{ menuDetail.menuName }}
    </el-menu-item>

    <!--      <sub-menu :subMenuList="menuDetail.children" v-if="menuDetail.children.length > 0"/>-->
    <sub-menu :subMenuDetail="menuDetail" v-else/>

    <!--    </template>-->
  </el-menu>
</template>

<script>
import {getMenuList} from '@/rely/axios/develophelper'
import subMenu from './subMenu'

export default {
  name: "menuSidebar",
  components: {
    // menuItem
    subMenu
  },
  data() {
    return {
      // menuName: this.menuName,
      // menuList: this.menuList
      menuName: '',
      menuList: []
    }
  },
  created() {
    this.getMenuList()
  },
  methods: {
    getMenuList: function () {
      getMenuList().then(res => {
        if (res.resCode == '0000') {
          this.menuList = res.menuList
          // this.menuName = this.menuList[0].menuName
        }
      })
      // this.menuList = [{
      //   "id": 1,
      //   "menuName": "菜单",
      //   "menuCode": "01",
      //   "path": "/menu/menuIndex",
      //   "sort": 1,
      //   "parentId": -1,
      //   "status": 1,
      //   "createTime": "2022-10-13T09:11:35.000+00:00",
      //   "updateTime": "2022-10-20T03:32:17.000+00:00",
      //   "children": []
      // }, {
      //   "id": 2,
      //   "menuName": "数据库",
      //   "menuCode": "02",
      //   "path": "/db/dbIndex",
      //   "sort": 2,
      //   "parentId": -1,
      //   "status": 1,
      //   "createTime": "2022-10-14T09:57:27.000+00:00",
      //   "updateTime": "2022-10-20T03:32:27.000+00:00",
      //   "children": [{
      //     "id": 3,
      //     "menuName": "数据库列表",
      //     "menuCode": "02",
      //     "path": "/db/dbIndex",
      //     "sort": 2,
      //     "parentId": 2,
      //     "status": 1,
      //     "createTime": "2022-10-14T09:57:27.000+00:00",
      //     "updateTime": "2022-10-20T03:32:27.000+00:00",
      //     "children": []
      //   }]
      // }]

    }
  }
}
</script>
