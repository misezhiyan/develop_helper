<template>
  <div>
    项目管理
    <el-button @click="createProj">新增项目</el-button>
    <el-table :data="projectList">
      <el-table-column prop="id" label="id"/>
      <el-table-column prop="projectName" label="项目名称"/>
      <el-table-column prop="baseUrl" label="项目基本路径"/>
      <el-table-column prop="createTime" label="创建时间"/>
      <el-table-column prop="id" label="操作">
        <template #default="scope">
          <el-button @click="editProject(scope.row)">编辑</el-button>
          <el-button @click="showProject(scope.row)">详情</el-button>
          <el-button @click="delProject(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="projFormDialogModel" v-on:open="openProjFormDialog" v-on:close="closeProjFormDialog" title="项目编辑" width="60%" align-center append-to-body>
      <el-form :model="projectForm" label-width="120px">
        <el-form-item label="项目名称">
          <el-input v-model="projectForm.projectName"></el-input>
        </el-form-item>
        <el-form-item label="项目基本地址">
          <el-input v-model="projectForm.baseUrl"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="showDbList">添加数据库</el-button>
          <el-table :data="projectForm.dbList">
            <el-table-column prop="id" label="ID"/>
            <el-table-column prop="nickName" label="昵称"/>
            <el-table-column prop="dbIp" label="IP地址"/>
            <el-table-column prop="dbPort" label="端口"/>
            <el-table-column prop="dbType" label="数据库类型"/>
            <el-table-column prop="defaultConnectDb" label="默认链接库"/>
            <el-table-column prop="driverClassName" label="驱动类"/>
            <el-table-column prop="dbUser" label="账号"/>
            <el-table-column prop="dbPwd" label="密码"/>
            <el-table-column prop="status" label="状态"/>
            <el-table-column prop="createTime" label="创建时间"/>
          </el-table>
        </el-form-item>
        <el-form-item>
          <el-button @click="submitProj">提交</el-button>
          <el-button @click="cancelProj">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-drawer v-model="dbDrawer" title="数据库链接">
      <template #default>
        <div>
          <el-select v-model="dbId" placeholder="选择数据库1" @change="dbChange">
            <el-option v-for="dbItem in dbList"
                       :key="dbItem.id"
                       :label="dbItem.nickName"
                       :value="dbItem.id"/>
          </el-select>
        </div>
      </template>
    </el-drawer>
  </div>
</template>

<script>
import {getDbList, addProject, updateProject, delProject, projectList} from "@/rely/axios/develophelper";

export default {
  name: "menuIndex",
  data() {
    return {
      dbId: '',
      projFormDialogModel: false,
      dbDrawer: false,
      dbList: [],
      projectForm: {
        projectName: '',
        baseUrl: '',
        dbList: []
      },
      projectList: [],
    }
  },
  created() {
    this.getProjectList();
  },
  methods: {
    showDbList: function () {
      this.dbDrawer = true
    },
    getDbList: function () {
      getDbList({}).then(response => {
        if (response.resCode == '0000') {
          this.dbList = response.list
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    createProj: function () {
      this.projFormDialogModel = true
      if (!this.dbList || this.dbList.length < 1)
        this.getDbList();
    },
    submitProj: function () {

      let projData = JSON.parse(JSON.stringify(this.projectForm))
      if (projData.dbList) {
        projData.dbList.forEach(db => {
          db.dbId = db.id;
          db.id = '';
        })
      }

      if (!projData.id) {
        addProject(projData).then(response => {
          if (response.resCode == '0000') {
            this.projFormDialogModel = false;
            this.getProjectList();
          } else {
            this.$message.error(response.resMsg);
          }
        });
      } else {
        updateProject(projData).then(response => {
          if (response.resCode == '0000') {
            this.projFormDialogModel = false;
            this.getProjectList();
          } else {
            this.$message.error(response.resMsg);
          }
        });
      }
    },
    cancelProj: function () {
      this.projFormDialogModel = false
    },
    openProjFormDialog: function () {
      if (!this.dbList || this.dbList.length < 1)
        this.getDbList();
    },
    closeProjFormDialog: function () {
      this.projectForm = {
        projectName: '',
        baseUrl: '',
        dbList: []
      }
    },
    dbChange: function (val) {
      for (let i = 0; i < this.dbList.length; i++) {
        if (val == this.dbList[i].id && !this.dbContain(this.dbList[i])) {
          this.projectForm.dbList.push(this.dbList[i]);
        }
      }
      this.dbDrawer = false;
    },
    dbContain: function (dbTmp) {
      for (let i = 0; i < this.projectForm.dbList.length; i++) {
        if (dbTmp.id == this.projectForm.dbList[i].id) {
          return true;
        }
      }
      return false;
    },
    getProjectList: function () {
      projectList().then(response => {
        if (response.resCode == '0000') {
          this.projectList = response.projectList
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    editProject: function (row) {
      this.projectForm = row;
      this.projFormDialogModel = true
    },
    showProject: function (row) {
    },
    delProject: function (row) {
      delProject(JSON.parse(JSON.stringify(row))).then(response => {
        if (response.resCode == '0000') {
          this.projFormDialogModel = false;
          this.getProjectList();
        } else {
          this.$message.error(response.resMsg);
        }
      });
    }
  }
}
</script>

<style scoped>

</style>