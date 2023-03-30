<template>
  <div>
    项目管理
    <el-button @click="createProj">新增项目</el-button>
    <el-table :data="projectList" @row-dblclick="showModuleList">
      <el-table-column prop="projectName" label="项目名称">
        <template #default="scope">
          <el-link type="primary" @click="editProject(scope.row)">{{ scope.row.projectName }}</el-link>
        </template>
      </el-table-column>
      <el-table-column prop="projectCode" label="项目编码"/>
      <el-table-column prop="baseUrl" label="项目基本路径"/>
      <el-table-column prop="createTime" label="创建时间"/>
      <el-table-column prop="id" label="操作">
        <template #default="scope">
          <el-button @click="delProject(scope.row)">删除项目</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="projFormDialogModel" v-on:open="openProjFormDialog" v-on:close="closeProjFormDialog" title="项目表单" width="60%" align-center append-to-body>
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

    <el-dialog v-model="moduleListDialog" title="模块列表" width="80%" align-center append-to-body>
      <el-button @click="addProjectModules">新增模块</el-button>
      <el-table :data="moduleList" @row-dblclick="showComponentList">
        <el-table-column prop="id" label="id"/>
        <el-table-column prop="moduleName" label="模块名称">
          <template #default="scope">
            <el-link @click="editProjectModule(scope.row)" type="primary">{{ scope.row.moduleName }}</el-link>
          </template>
        </el-table-column>
        <el-table-column prop="moduleCode" label="模块编码"/>
        <el-table-column prop="modulePath" label="模块地址"/>
        <el-table-column prop="javaPackage" label="java代码地址"/>
        <el-table-column prop="resourcePackage" label="配置文件代码地址"/>
        <el-table-column prop="frontPackage" label="前端代码地址"/>
        <el-table-column prop="createTime" label="创建时间"/>
        <el-table-column prop="id" label="操作">
          <template #default="scope">
            <el-button @click="delProjectModule(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>

    <el-dialog v-model="projectModuleFormDialogModel" v-on:close="closeProjModuleFormDialog" title="模块表单" width="100%" align-center append-to-body>
      <el-form :model="projectModuleForm" label-width="120px">
        <el-form-item label="项目编码">
          <el-input v-model="projectModuleForm.projectCode" disabled/>
        </el-form-item>
        <!--        <el-form-item label="项目名称">-->
        <!--          <el-input v-model="projectModuleForm.projectName" disabled/>-->
        <!--        </el-form-item>-->
        <el-form-item label="模块名称">
          <el-input v-model="projectModuleForm.moduleName"/>
        </el-form-item>
        <el-form-item v-if="projectModuleForm.id" label="模块编码">
          <el-input v-model="projectModuleForm.moduleCode" disabled/>
        </el-form-item>
        <el-form-item label="模块地址">
          <el-input v-model="projectModuleForm.modulePath"/>
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

    <el-drawer v-model="componentDrawer" title="组件抽屉" size="60%">
      <div>
        <el-button @click="addProjComponent ">新增组件</el-button>
        <el-table :data="componentList">
          <el-table-column prop="id" label="id"/>
          <el-table-column prop="componentName" label="组件名称">
            <template #default="scope">
              <el-link type="primary" @click="editProjComponent(scope.row)">{{ scope.row.componentName }}</el-link>
            </template>
          </el-table-column>
          <el-table-column prop="componentCode" label="组件编码"/>
          <el-table-column prop="componentFlag" label="组件标识"/>
          <!--          <el-table-column prop="relyComponent" label="依赖组件编码"/>-->
          <el-table-column prop="relyComponentName" label="依赖组件"/>
          <el-table-column prop="createTime" label="创建时间"/>
          <el-table-column prop="id" label="操作">
            <template #default="scope">
              <el-button @click="editProjComponent(scope.row)">编辑</el-button>
              <el-button @click="delProjComponent(scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>

        <el-drawer
            v-model="componentInnerDrawer"
            :title="componentInnerDrawerTitle"
            :append-to-body="true"
            v-on:open="openComponentInnerDrawer"
            v-on:close="closeComponentInnerDrawer"
        >
          <div>
            <el-form :model="projectComponentForm" label-width="120px">
              <el-form-item label="模块编码">
                <el-input v-model="projectComponentForm.moduleCode" disabled/>
              </el-form-item>
              <el-form-item label="组件名称">
                <el-input v-model="projectComponentForm.componentName"/>
              </el-form-item>
              <el-form-item label="组件编码">
                <el-input v-model="projectComponentForm.componentCode" disabled/>
              </el-form-item>
              <el-form-item label="组件标识">
                <el-input v-model="projectComponentForm.componentFlag"/>
              </el-form-item>
              <el-form-item label="依赖组件">
                <el-select
                    v-model="projectComponentForm.relyComponent"
                    filterable
                    placeholder="请选择依赖组件"
                >
                  <el-option v-for="component in componentChooseList"
                             :key="component.componentCode"
                             :label="component.componentName"
                             :value="component.componentCode"/>
                </el-select>
              </el-form-item>
              <el-form-item>
                <el-button @click="submitProjComponent">提交</el-button>
                <el-button @click="cancelProjComponent">取消</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-drawer>

      </div>
    </el-drawer>

  </div>
</template>

<script>
import {addProject, addProjectComponent, addProjectModule, delProject, delProjectComponent, delProjectModule, projectComponentList, projectList, projModulesList, updateProject, updProjectComponent, updProjectModule} from "@/rely/axios/develophelper";

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
      projectCode: '',
      moduleListDialog: false,
      moduleList: [],
      projectModuleFormDialogModel: false,
      projectModuleForm: {
        projectCode: '',
        projectName: '',
        moduleCode: '',
        moduleName: '',
        modulePath: '',
        javaPackage: '',
        resourcePackage: '',
        frontPackage: ''
      },
      moduleCode: '',
      componentDrawer: false,
      componentList: [],
      componentChooseList: [],
      componentInnerDrawer: false,
      componentInnerDrawerTitle: '新增组件抽屉',
      projectComponentForm: {
        moduleCode: '',
        componentName: '',
        componentCode: '',
        componentFlag: '',
        relyComponent: '',
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
    showModuleList: function (row, column, event) {
      this.projectCode = row.projectCode;
      this.projModulesList(row.projectCode);
      this.moduleListDialog = true;
    },
    projModulesList: function (projectCode) {
      projModulesList({projectCode: projectCode}).then(response => {
        if (response.resCode == '0000') {
          this.moduleList = response.list;
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    addProjectModules: function () {
      this.projectModuleForm.projectCode = this.projectCode;
      this.projectModuleFormDialogModel = true
    },
    submitProjModule: function () {
      if (!this.projectModuleForm.id) {
        addProjectModule(this.projectModuleForm).then(response => {
          if (response.resCode == '0000') {
            this.projectModuleFormDialogModel = false;
            this.projModulesList(this.projectCode);
          } else {
            this.$message.error(response.resMsg);
          }
        })
      } else {
        updProjectModule(this.projectModuleForm).then(response => {
          if (response.resCode == '0000') {
            this.projectModuleFormDialogModel = false;
            this.projModulesList(this.projectCode);
          } else {
            this.$message.error(response.resMsg);
          }
        })
      }
    },
    cancelProjModule: function (row) {
      this.projectModuleFormDialogModel = false
    },
    editProjectModule: function (row) {
      this.projectModuleForm.id = row.id;
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
    delProjectModule: function (row) {
      this.projectModuleForm.id = row.id;
      delProjectModule(this.projectModuleForm).then(response => {
        if (response.resCode == '0000') {
          this.projectModuleFormDialogModel = false;
          this.getProjectList();
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    closeProjModuleFormDialog: function () {
      this.projectModuleForm = {
        projectCode: '',
        projectName: '',
        moduleCode: '',
        moduleName: '',
        mudulePath: '',
        javaPackage: '',
        resourcePackage: '',
        frontPackage: ''
      }
    },
    showComponentList: function (row, column, event) {
      this.moduleCode = row.moduleCode;
      this.getComponentList();
      this.componentDrawer = true;
    },
    getComponentList: function () {
      projectComponentList({moduleCode: this.moduleCode}).then(response => {
        if (response.resCode == '0000') {
          this.componentList = response.list;
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    addProjComponent: function () {
      this.componentInnerDrawer = true;
      this.projectComponentForm.moduleCode = this.moduleCode;
      this.componentInnerDrawerTitle = '新增组件';
    },
    editProjComponent: function (row) {
      this.componentChooseList = [{componentCode: '', componentName: '空'}, ...this.componentList.filter(cp => cp.componentCode != row.componentCode)]
      // this.componentChooseList = this.componentList
      this.projectComponentForm.moduleCode = this.moduleCode;
      this.projectComponentForm.id = row.id;
      this.projectComponentForm.componentName = row.componentName;
      this.projectComponentForm.componentCode = row.componentCode;
      this.projectComponentForm.componentFlag = row.componentFlag;
      this.projectComponentForm.relyComponent = row.relyComponent;

      this.componentInnerDrawerTitle = '修改组件';
      this.componentInnerDrawer = true;
    },
    submitProjComponent: function () {
      if (!this.projectComponentForm.id) {
        addProjectComponent(this.projectComponentForm).then(response => {
          if (response.resCode == '0000') {
            this.componentInnerDrawer = false;
            this.getComponentList();
          } else {
            this.$message.error(response.resMsg);
          }
        })
      } else {
        updProjectComponent(this.projectComponentForm).then(response => {
          if (response.resCode == '0000') {
            this.componentInnerDrawer = false;
            this.getComponentList();
          } else {
            this.$message.error(response.resMsg);
          }
        })
      }
    },
    cancelProjComponent: function () {
      this.componentInnerDrawer = false
    },
    delProjComponent: function (row) {
      delProjectComponent({id: row.id}).then(response => {
        if (response.resCode == '0000') {
          this.componentInnerDrawer = false;
          this.getComponentList();
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    openComponentInnerDrawer: function () {

      console.log('open')

      // componentChooseList
    },
    closeComponentInnerDrawer: function () {
      this.projectComponentForm = {
        moduleCode: this.moduleCode,
        componentName: '',
        componentCode: '',
        componentFlag: '',
        relyComponent: ''
      }
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