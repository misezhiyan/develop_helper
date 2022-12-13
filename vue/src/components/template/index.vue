<template>
  模板模块
  <el-button @click="createTemplate">创建模板</el-button>
  <el-table :data="templateList">
    <!--    <el-table-column prop="templateId" label="ID" width="60"/>-->
    <el-table-column prop="templateName" label="templateName" width="180"/>
    <el-table-column prop="templateContent" label="templateContent"/>
    <el-table-column prop="createTime" label="createTime" width="300"/>
    <el-table-column label="操作" width="300">
      <template #default="scope">
        <el-button @click="editTemplate(scope.row)">编辑</el-button>
        <el-button @click="testTemplate(scope.row)">测试</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog v-model="templateDialogModel" v-on:close="closeTemplateDialog" :title="templateDialogTitle" width="30%" align-center append-to-body>
    <el-form ref="templateDetailFormRef" :model="templateDetailForm">
      <el-form-item :label="模板名称" prop="templateName">
        <el-input v-model="templateDetailForm.templateName" placeholder="模板名称"></el-input>
      </el-form-item>
      <el-form-item :label="模板内容" prop="templateContent">
        <el-input v-model="templateDetailForm.templateContent" type="textarea" :autosize="{minRows:4}" placeholder="输入文本"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="cancelTemplate">取消</el-button>
        <el-button @click="submitTemplate">确定</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>

  <el-dialog v-model="templateTestDialogModel" v-on:close="closeTemplateTestDialog" :title="templateTestDialogTitle" width="30%" align-center append-to-body>
    <el-button @click="addTemplateField">新增</el-button>
    <el-button @click="showTemplateResult">查看匹配结果</el-button>
    <el-table :data="templateFieldsList">
      <el-table-column prop="fieldName" label="参数名称" width="180"/>
      <el-table-column prop="fieldValue" label="测试赋值" width="180">
        <template #default="scope">
          <el-input v-model="scope.row.fieldValue" placeholder="输入参数值"/>
        </template>
      </el-table-column>
      <el-table-column prop="id" label="操作" width="180">
        <template #default="scope">
          <el-button @click="delTemplateField(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-dialog>

  <el-dialog v-model="templateFieldDialogModel" v-on:close="closeTemplateFieldDialog" :title="templateFieldDialogTitle" width="30%" align-center append-to-body>
    <el-form ref="templateFieldFormRef" :model="templateFieldForm">
      <el-form-item prop="fieldName" label="fieldName" width="180">
        <el-input v-model="templateFieldForm.fieldName" placeholder="参数名称"></el-input>
      </el-form-item>
      <el-form-item label="操作" width="180">
        <el-button @click="cancelTemplateField">取消</el-button>
        <el-button @click="submitTemplateField">确定</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>

  <el-dialog v-model="templateMatchResultDialogModel" v-on:close="closetemplateMatchResultDialog" :title="templateMatchResultDialogTitle" width="30%" align-center append-to-body>
    <div>{{ templateMatchResult }}</div>
  </el-dialog>

</template>

<script>
import {templateList, addTemplate, udpTemplate, templateFieldsList, templateFieldAdd, showTemplateResult} from "@/rely/axios/develophelper";

export default {
  name: "templateIndex",
  data: function () {
    return {
      templateDialogTitle: '模板编辑',
      templateDialogModel: false,
      templateDetailForm: {
        templateId: undefined,
        templateName: '',
        templateContent: ''
      },
      templateList: [],
      templateTestId: '',
      templateTestDialogModel: false,
      templateTestDialogTitle: '模板测试框',
      templateFieldsList: [],
      templateFieldDialogModel: false,
      templateFieldDialogTitle: '模板参数',
      templateFieldForm: {
        fieldName: ''
      },
      templateMatchResultDialogModel: false,
      templateMatchResultDialogTitle: '模板匹配结果',
      templateMatchResult: '',
    }
  },
  created() {
    this.loadTemplateList();
  },
  methods: {
    createTemplate: function () {
      this.templateDetailForm.templateId = undefined
      this.templateDetailForm.templateName = ''
      this.templateDetailForm.templateContent = ''
      this.templateDialogModel = true;
    },
    closeTemplateDialog: function () {
      this.$refs['templateDetailFormRef'].resetFields()
    },
    cancelTemplate: function () {
      this.templateDialogModel = false;
    },
    submitTemplate: function () {
      if (this.templateDetailForm.templateId) {
        udpTemplate(this.templateDetailForm).then(response => {
          if (response.resCode == '0000') {
            this.templateDialogModel = false;
            this.loadTemplateList();
          } else {
            this.$message.error(response.resMsg);
          }
        })
      } else {
        addTemplate(this.templateDetailForm).then(response => {
          if (response.resCode == '0000') {
            this.templateDialogModel = false;
            this.loadTemplateList();
          } else {
            this.$message.error(response.resMsg);
          }
        })
      }
    },
    loadTemplateList: function () {
      templateList({}).then(response => {
        if (response.resCode == '0000') {
          this.templateList = response.templateList;
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    editTemplate: function (row) {
      this.templateDetailForm.templateId = row.templateId
      this.templateDetailForm.templateName = row.templateName
      this.templateDetailForm.templateContent = row.templateContent
      this.templateDialogModel = true;
    },
    testTemplate: function (row) {
      this.templateTestId = row.templateId
      this.getTemplateFieldsList();
      this.templateTestDialogModel = true;
    },
    getTemplateFieldsList() {
      this.templateFieldForm.templateId = this.templateTestId
      templateFieldsList(this.templateFieldForm).then(response => {
        if (response.resCode == '0000') {
          this.templateFieldsList = response.fieldsList;
        } else {
          this.$message.error(response.resMsg);
          return false;
        }
      })
    },
    addTemplateField: function (row) {
      this.templateFieldDialogModel = true;
    },
    showTemplateResult: function () {
      showTemplateResult({templateId: this.templateTestId, fieldList: this.templateFieldsList}).then(response => {
        console.log(response)
        if (response.resCode == '0000') {
          this.templateMatchResultDialogModel = true;
          this.templateMatchResult = response.result
        } else {
          this.$message.error(response.resMsg);
          return false;
        }
      })
    },
    delTemplateField: function (row) {
      console.log(row)
    },
    closeTemplateTestDialog: function () {
      this.templateTestId = undefined
      this.templateTestDialogModel = false;
    },
    closeTemplateFieldDialog: function () {
      this.templateFieldDialogModel = false
      this.templateFieldForm.fieldName = '';
    },
    cancelTemplateField: function () {
      this.templateFieldDialogModel = false;
      this.templateFieldForm.fieldName = '';
    },
    submitTemplateField: function () {
      templateFieldAdd(this.templateFieldForm).then(response => {
        if (response.resCode == '0000') {
          this.templateFieldDialogModel = false;
          this.getTemplateFieldsList();
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    closetemplateMatchResultDialog: function () {
      this.templateMatchResultDialogModel = false;
      this.templateMatchResult = ''
    }
  }
}
</script>

<style scoped>

</style>