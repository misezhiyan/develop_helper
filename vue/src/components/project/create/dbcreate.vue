<template>
  <div>
    代码生成
    1、选择项目
    2、项目关联数据库，关联模板生成策略
    3、使用策略，带出表列表，选择多个表之后，批量生成后端代码

    <el-table :data="projectList" @row-dblclick="projDbClickRow">
      <el-table-column prop="id" label="id"/>
      <el-table-column prop="projectName" label="项目名称"/>
      <el-table-column prop="baseUrl" label="项目基本路径"/>
      <el-table-column prop="createTime" label="创建时间"/>
    </el-table>

    <el-dialog v-model="projDialogModel" width="80%">
      <el-form v-model="projForm">
        <el-form-item lable="projName">
          <span>项目名称：{{ projForm.projectName }}</span><br>
        </el-form-item>
        <el-form-item lable="数据库表选择">
          <el-select v-model="dbId" filterable @change="loadDbTables" placeholder="选择数据库">
            <el-option
                v-for="db in projForm.dbList"
                :key="db.id"
                :label="db.nickName"
                :value="db.id"/>
          </el-select>
          <el-select v-if="dbId" filterable v-model="tableName" @change="addSelectedTables" placeholder="选择表">
            <el-option
                v-for="tb in tableList"
                :key="tb.id"
                :label="tb.tableName"
                :value="tb.tableName"/>
          </el-select>
        </el-form-item>
        <el-form-item lable="生成策略选择">
        </el-form-item>
        <el-form-item lable="已选中表">
          <el-table :data="selectedTableList">
            <el-table-column prop="dbId" label="dbId"/>
            <el-table-column prop="dbNickName" label="数据库昵称"/>
            <el-table-column prop="tableName" label="表名"/>
            <el-table-column prop="policyId" label="生成策略Id"/>
            <el-table-column prop="policyName" label="生成策略"/>
            <el-table-column prop="tableOpt" label="操作">
              <template #default="scope">
                <el-button @click="editPolicy(scope.row)">编辑</el-button>
                <el-button @click="delSelectedTable(scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-form-item>
        <el-form-item lable="操作">
          <el-button @click="generateFiles">生成文件</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog v-model="policyDialogModel" v-on:open="openPolicyDialog" v-on:close="closePolicyDialog">
      <el-select v-model="policyId" placeholder="选择生成策略">
        <el-option
            v-for="policy in generatePolicyList"
            :key="policy.id"
            :label="policy.policyName"
            :value="policy.id"/>
      </el-select>
      <el-button @click="cancelPolicy">取消</el-button>
      <el-button @click="canfirmPolicy">确定</el-button>
    </el-dialog>

    <!--  <el-select v-model="projectId" placeholder="选择项目">-->
    <!--    <el-option-->
    <!--        v-for="proj in projectList"-->
    <!--        :key="proj.id"-->
    <!--        :lable="proj.projectName"-->
    <!--        :value="proj.projectName"/>-->
    <!--  </el-select>-->

    <!--  <el-select v-model="templateId" placeholder="选择模板">-->
    <!--    <el-option-->
    <!--        v-for="templat in templateList"-->
    <!--        :key="templat.id"-->
    <!--        :lable="templat.templateName"-->
    <!--        :value="templat.templateName"/>-->
    <!--  </el-select>-->

  </div>

</template>

<script>
import {projectList, getTableList, templateList, generatePolicyList, generateFiles} from "@/rely/axios/develophelper";

export default {
  name: "dbCreate",
  data() {
    return {
      dbId: '',
      tableName: '',
      policyId: '',
      projectId: '',
      projectList: [],
      templateId: '',
      templateList: [],
      projDialogModel: false,
      policyDialogModel: false,
      projForm: {},
      tableList: [],
      selectedTableList: [],
      generatePolicyList: [],
      editTableRow: {},
    }
  },
  created() {
    this.getProjectList();
    this.getTemplateList();
  },
  methods: {
    getProjectList: function () {
      projectList().then(response => {
        if (response.resCode == '0000') {
          this.projectList = response.projectList
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    getTemplateList: function () {
      templateList({}).then(response => {
        if (response.resCode == '0000') {
          this.templateList = response.templateList;
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    projDbClickRow: function (row, column, event) {
      this.projForm = JSON.parse(JSON.stringify(row))
      this.projDialogModel = true
    },
    loadDbTables: function (val) {
      this.tableName = '';
      this.tableList = [];
      getTableList({id: val}).then(response => {
        if (response.resCode == '0000') {
          this.tableList = response.list;
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    addSelectedTables: function (val) {
      let dbNickName = '';
      for (let i = 0; i < this.projForm.dbList.length; i++) {
        let db = this.projForm.dbList[i];
        if (db.id == this.dbId) {
          dbNickName = db.nickName;
        }
      }
      if (!this.selectedAlready(this.dbId, this.tableName)) {
        this.selectedTableList.push({dbId: this.dbId, dbNickName: dbNickName, tableName: this.tableName})
      }
    },
    selectedAlready: function (dbId, tableName) {
      for (let i = 0; i < this.selectedTableList.length; i++) {
        let selectedTable = this.selectedTableList[i];
        if (selectedTable.dbId == dbId && selectedTable.tableName == tableName)
          return true;
      }
      return false;
    },
    openPolicyDialog: function () {
      this.getgeneratePolicyList();
    },
    getgeneratePolicyList: function () {
      if (this.generatePolicyList && this.generatePolicyList.length > 0)
        return;

      generatePolicyList({}).then(response => {
        if (response.resCode == '0000') {
          this.generatePolicyList = response.generatePolicyList;
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    closePolicyDialog: function () {
      this.policyId = ''
      this.editTableRow = {}
    },
    editPolicy: function (row) {
      this.editTableRow = row;
      this.policyDialogModel = true;
    },
    delSelectedTable: function (row) {
      for (let i = 0; i < this.selectedTableList.length; i++) {
        if (this.selectedAlready(this.selectedTableList[i].dbId, this.selectedTableList[i].tableName)) {
          this.selectedTableList.splice(i, 1)
        }
      }
    },
    cancelPolicy: function () {
      this.policyDialogModel = false;
    },
    canfirmPolicy: function () {
      this.editTableRow.policyId = this.policyId;
      for (let i = 0; i < this.generatePolicyList.length; i++) {
        if (this.generatePolicyList[i].id == this.policyId)
          this.editTableRow.policyName = this.generatePolicyList[i].policyName;
      }
      this.policyDialogModel = false;
    },
    generateFiles: function () {
      console.log(JSON.stringify(this.projForm))
      generateFiles({projectId: this.projForm.id, generateTables: this.selectedTableList}).then(response => {
        if (response.resCode == '0000') {
          this.generatePolicyList = response.generatePolicyList;
        } else {
          this.$message.error(response.resMsg);
        }
      })
    }
  }
}
</script>
