<template>
  <el-row>
    <el-col>
      <el-menu>
        <el-menu-item index="1">菜单0</el-menu-item>
        <el-sub-menu index="1">
          <template #title>
            <span>菜单一</span>
          </template>
          <el-menu-item index="1.1">子菜单1</el-menu-item>
          <el-sub-menu>
            <template #title>
              <span>子菜单2</span>
            </template>
            <el-menu-item index="1.2.1">子子菜单1</el-menu-item>
          </el-sub-menu>
        </el-sub-menu>
      </el-menu>
    </el-col>
  </el-row>
</template>

<script>
import {getMenuList} from '@/rely/axios/develophelper'

export default {
  name: "menuTmplate",
  components: {},
  data() {
    return {
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
          // this.menuList = res.menuList
          this.menuName = this.menuList[0].menuName
        }
      })
      this.menuList = [{
        "id": 1,
        "menuName": "菜单",
        "menuCode": "01",
        "path": "/menu/menuIndex",
        "sort": 1,
        "parentId": -1,
        "status": 1,
        "createTime": "2022-10-13T09:11:35.000+00:00",
        "updateTime": "2022-10-20T03:32:17.000+00:00",
        "children": []
      }, {
        "id": 2,
        "menuName": "数据库",
        "menuCode": "02",
        "path": "/db/dbIndex",
        "sort": 2,
        "parentId": -1,
        "status": 1,
        "createTime": "2022-10-14T09:57:27.000+00:00",
        "updateTime": "2022-10-20T03:32:27.000+00:00",
        "children": [{
          "id": 3,
          "menuName": "数据库列表",
          "menuCode": "02",
          "path": "/db/dbIndex",
          "sort": 2,
          "parentId": 2,
          "status": 1,
          "createTime": "2022-10-14T09:57:27.000+00:00",
          "updateTime": "2022-10-20T03:32:27.000+00:00",
          "children": []
        }]
      }]

    }
  }
}
</script>
