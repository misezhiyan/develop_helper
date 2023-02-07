<template>
  <div>
    项目管理
    <el-button @click="createProj">新增项目</el-button>
    <el-table :data="projectList">
      <el-table-column type="expand">
        <template #default="props">
          <el-table :data="props.row.moduleList">
            <el-table-column prop="id" label="id"/>
            <el-table-column prop="projectCode" label="项目编码"/>
            <el-table-column prop="moduleName" label="模块名称"/>
            <el-table-column prop="moduleCode" label="模块编码"/>
            <el-table-column prop="modulePath" label="模块地址"/>
            <el-table-column prop="javaPackage" label="java代码地址"/>
            <el-table-column prop="resourcePackage" label="配置文件代码地址"/>
            <el-table-column prop="frontPackage" label="前端代码地址"/>
            <el-table-column prop="createTime" label="创建时间"/>
            <el-table-column prop="id" label="操作">
              <template #default="scope">
                <el-button @click="editProjectModule(scope.row)">编辑</el-button>
              </template>
            </el-table-column>
          </el-table>
        </template>
      </el-table-column>
      <el-table-column prop="id" label="id"/>
      <el-table-column prop="projectCode" label="项目编码"/>
      <el-table-column prop="projectName" label="项目名称"/>
      <el-table-column prop="baseUrl" label="项目基本路径"/>
      <el-table-column prop="createTime" label="创建时间"/>
      <el-table-column prop="id" label="操作">
        <template #default="scope">
          <el-button @click="editProject(scope.row)">编辑</el-button>
          <el-button @click="delProject(scope.row)">删除项目</el-button>
          <el-button @click="addProjectModules(scope.row)">新增模块</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="projFormDialogModel" v-on:open="openProjFormDialog" v-on:close="closeProjFormDialog" title="项目编辑" width="60%" align-center append-to-body>
      <el-form :model="projectForm" label-width="120px">
        <el-form-item label="项目名称">
          <el-input v-model="projectForm.projectName"/>
        </el-form-item>
        <el-form-item v-if="projectForm.id" label="项目编码">
          <el-input v-model="projectForm.projectCode" disabled/>
        </el-form-item>
        <el-form-item label="项目基本地址">
          <el-input v-model="projectForm.baseUrl"/>
        </el-form-item>
        <el-form-item>
          <el-button @click="submitProj">提交</el-button>
          <el-button @click="cancelProj">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog v-model="projectModuleFormDialogModel " title="项目模块" width="60%" align-center append-to-body>
      <el-form :model="projectModuleForm" label-width="120px">
        <el-form-item label="项目编码">
          <el-input v-model="projectModuleForm.projectCode" disabled/>
        </el-form-item>
        <el-form-item label="项目名称">
          <el-input v-model="projectModuleForm.projectName" disabled/>
        </el-form-item>
        <el-form-item label="模块名称">
          <el-input v-model="projectModuleForm.moduleName"/>
        </el-form-item>
        <el-form-item v-if="projectModuleForm.id" label="模块编码">
          <el-input v-model="projectModuleForm.moduleCode" disabled/>
        </el-form-item>
        <el-form-item label="模块地址">
          <el-input v-model="projectModuleForm.mudulePath"/>
        </el-form-item>
        <el-form-item label="java代码地址">
          <el-input v-model="projectModuleForm.javaPackage"/>
        </el-form-item>
        <el-form-item label="配置文件代码地址">
          <el-input v-model="projectModuleForm.resourcePackage"/>
        </el-form-item>
        <el-form-item label="前端代码地址">
          <el-input v-model="projectModuleForm.frontPackage"/>
        </el-form-item>
        <el-form-item>
          <el-button @click="submitProjModule">提交</el-button>
          <el-button @click="cancelProjModule">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import {getDbList, projModulesList, addProject, updateProject, delProject, projectList, addProjectModule} from "@/rely/axios/develophelper";

export default {
  name: "menuIndex",
  data() {
    return {
      projFormDialogModel: false,
      projectList: [],
      projectForm: {
        projectName: '',
        projectCode: '',
        baseUrl: '',
      },
      projectModuleFormDialogModel: false,
      projectModuleForm: {
        projectCode: '',
        projectName: '',
        moduleCode: '',
        moduleName: '',
        mudulePath: '',
        javaPackage: '',
        resourcePackage: '',
        frontPackage: ''
      }
    }
  },
  created() {
    this.getProjectList();
  },
  methods: {
    submitProj: function () {
      let projData = JSON.parse(JSON.stringify(this.projectForm))
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
    },
    getProjectList: function () {
      projModulesList().then(response => {
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
    addProjectModules: function (row) {
      this.projectModuleForm.projectCode = row.projectCode;
      this.projectModuleForm.projectName = row.projectName;
      this.projectModuleFormDialogModel = true
    },
    submitProjModule: function () {
      if (!this.projectModuleForm.id) {
        addProjectModule(this.projectModuleForm).then(response => {
          if (response.resCode == '0000') {
            this.projectModuleFormDialogModel = false;
            this.getProjectList();
          } else {
            this.$message.error(response.resMsg);
          }
        })
      } else {
        alert('update')
      }
    },
    cancelProjModule: function (row) {
      this.projectModuleFormDialogModel = false
    },
    editProjectModule: function (row) {
      this.projectModuleForm.projectCode = row.projectCode;
      this.projectModuleForm.moduleName = row.moduleName;
      this.projectModuleForm.moduleCode = row.moduleCode;
      this.projectModuleForm.modulePath = row.modulePath;
      this.projectModuleForm.javaPackage = row.javaPackage;
      this.projectModuleForm.resourcePackage = row.resourcePackage;
      this.projectModuleForm.frontPackage = row.frontPackage;
      this.projectModuleForm.createTime = row.createTime;

      this.projectModuleFormDialogModel = true
    },

    // todo
    createProj: function () {
      this.projFormDialogModel = true
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