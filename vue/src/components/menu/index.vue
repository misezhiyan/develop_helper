<template>
  <div>
    菜单维护
    <el-button @click="addMenu({menuName:'根菜单',id:-1})">新增根菜单</el-button>
    <el-tree width="100%" :data="menuTree" node-key="id" :default-expand-all="true" :props="menuProps">
      <template #default="{node, data}">
        <span>{{ node.label }}</span>
        <span style="margin-right: 0px">
          <el-button @click="addMenu(data)">新增子项</el-button>
          <el-button @click="delMenu(data)">删除</el-button>
        </span>
      </template>
    </el-tree>

    <el-form :model="menuForm" lable-width="120px" :hidden="menuFormHidden">
      <el-form-item label="菜单名称">
        <el-input v-model="menuForm.menuName"/>
      </el-form-item>
      <el-form-item label="菜单地址">
        <el-input v-model="menuForm.path"/>
      </el-form-item>
      <el-form-item label="菜单Code">
        <el-input v-model="menuForm.menuCode"/>
      </el-form-item>
      <el-form-item label="父菜单">
        <el-input v-model="menuForm.parentName"/>
      </el-form-item>

      <el-form-item>
        <el-button @click="submitMenu">提交</el-button>
        <el-button @click="cancelMenu">取消</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
import { ElMessage, ElMessageBox } from 'element-plus'
import {getMenuList, addMenu, delMenu} from "@/rely/axios/develophelper";

export default {
  name: "menuIndex",
  data() {
    return {
      menuTree: [],
      menuProps: {
        label: 'menuName',
        children: 'children'
      },
      menuForm: {
        menuName: '',
        menuPath: '',
        menuCode: '',
        parentName: '',
        parentId: -1
      },
      menuFormHidden: true
    }
  },
  created() {
    this.getMenuList()
  },
  methods: {
    getMenuList: function () {
      getMenuList().then(res => {
        if (res.resCode == '0000') {
          this.menuTree = res.menuList
        }
      })
    },
    addMenu: function (parentMenu) {
      this.menuForm.parentId = parentMenu.id;
      this.menuForm.parentName = parentMenu.menuName;
      this.menuFormHidden = false;
    },
    delMenu: function (delMenuNeed) {
      ElMessageBox.confirm(
          '确认删除菜单?',
          'Warning',
          {
            confirmButtonText: 'CONFIRM',
            cancelButtonText: 'Cancel',
            type: 'warning',
          }
      ).then(() => {

        delMenu(delMenuNeed).then(res =>{
          this.getMenuList();
          ElMessage({
            type: 'success',
            message: 'DELETE SUCCESS',
          })
        }).catch(err =>{
          ElMessage({
            type: 'error',
            message: 'DELETE FAIL',
          })
        })
      }).catch(err => {
        ElMessage({
          type: 'error',
          message: 'DELETE FAIL',
        })
      })
    },
    submitMenu: function () {
      addMenu(this.menuForm).then(res => {
        if (res.resCode == '0000') {
          this.menuFormHidden = true;
          this.getMenuList()
        }
      }).catch(err => {
        alert("error");
      })
    },
    cancelMenu: function () {
      this.menuFormHidden = true;
    }
  }
}
</script>

<style scoped>

</style>