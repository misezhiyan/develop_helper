<template>
  <div>
    代码生成策略
    1、新增生成对象，设置生成名称，生成路径
    2、对象匹配模板
    3、点击生成策略

    <el-button @click="addGeneratePolicy">新增策略</el-button>

    <el-table :data="generatePolicyList" @row-dblclick="showGeneratePolicyDetail">
      <el-table-column prop="id" label="id"/>
      <el-table-column prop="policyName" label="策略名称"/>
      <el-table-column prop="createTime" label="创建时间"/>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button @click="delGeneratePolicy(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="generatePolicyDialog">
      <el-form :model="generatePolicyForm" label-width="20%">
        <el-form-item label="策略名称">
          <el-input v-model="generatePolicyForm.policyName"/>
        </el-form-item>
        <el-form-item>
          <el-button @click="submitGeneratePolicy">提交</el-button>
          <el-button @click="cancelGeneratePolicy">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog v-model="generatePolicyDetailListDialog" width="90%">
      <el-button @click="addGeneratePolicyDetail">新增策略文件</el-button>
      <el-table :data="generatePolicyDetailList">
        <el-table-column prop="id" label="id"/>
        <el-table-column prop="policyId" label="policyId"/>
        <el-table-column prop="nickName" label="策略名称"/>
        <el-table-column prop="generateName" label="文件匹配名称"/>
        <el-table-column prop="generateSrcPath" label="源文件夹"/>
        <el-table-column prop="generateRelativePath" label="相对路径"/>
        <el-table-column prop="generateFilesuffix" label="文件后缀"/>
        <el-table-column prop="importRule" label="规则标识"/>
        <el-table-column prop="templateId" label="templateId"/>
        <el-table-column prop="templateName" label="模板名称"/>
        <el-table-column prop="createTime" label="createTime"/>
        <el-table-column prop="id" label="操作">
          <template #default="scope">
            <el-button @click="updPolicyDetail(scope.row)">编辑</el-button>
            <el-button @click="delPolicyDetail(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>

    <el-dialog v-model="generatePolicyDetailDialog" v-on:open="generatePolicyDetailDialogOpen">
      <el-form :model="generatePolicyDetailForm" label-width="20%">
        <el-form-item label="策略文件昵称">
          <el-input v-model="generatePolicyDetailForm.nickName"/>
        </el-form-item>
        <el-form-item label="文件匹配名称">
          <el-input v-model="generatePolicyDetailForm.generateName"/>
        </el-form-item>
        <el-form-item label="生成文件源文件夹">
          <el-input v-model="generatePolicyDetailForm.generateSrcPath"/>
        </el-form-item>
        <el-form-item label="生成文件相对路径">
          <el-input v-model="generatePolicyDetailForm.generateRelativePath"/>
        </el-form-item>
        <el-form-item label="规则标识">
          <el-input v-model="generatePolicyDetailForm.importRule"/>
        </el-form-item>
        <el-form-item label="文件类型">
          <el-input v-model="generatePolicyDetailForm.generateFilesuffix"/>
        </el-form-item>
        <el-form-item label="关联模板">
          <el-select v-model="templateId" placeholder="选择模板">
            <el-option
                v-for="tp in templateList"
                :key="tp.templateId"
                :lable="tp.templateName"
                :value="tp.templateId">

              <!--            <span>{{tp.lable}}</span>-->
              <!--            <span>{{tp.value}}</span>-->
              <span>{{ tp.templateName }}</span>

            </el-option>

          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button @click="submitGeneratePolicyDetail">提交</el-button>
          <el-button @click="cancelGeneratePolicyDetail">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>

</template>

<script>
import {generatePolicyList, addGeneratePolicy, delGeneratePolicy, generatePolicyDetailList, addGeneratePolicyDetail, updGeneratePolicyDetail, delGeneratePolicyDetail, templateList} from "@/rely/axios/develophelper";

export default {
  name: "dbCreateStrategy",
  data() {
    return {
      generatePolicyId: '',
      templateId: '',
      generatePolicyDialog: false,
      generatePolicyDetailListDialog: false,
      generatePolicyDetailDialog: false,
      generatePolicyList: [],
      generatePolicyDetailList: [],
      generatePolicyForm: {},
      generatePolicyDetailForm: {},
      templateList: []
    }
  },
  created() {
    this.getgeneratePolicyList()
  },
  methods: {
    getgeneratePolicyList: function () {
      generatePolicyList({}).then(response => {
        if (response.resCode == '0000') {
          this.generatePolicyList = response.generatePolicyList;
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    addGeneratePolicy: function () {
      this.loadTemplateList();
      this.generatePolicyDialog = true;
    },
    submitGeneratePolicy: function () {
      addGeneratePolicy(this.generatePolicyForm).then(response => {
        if (response.resCode == '0000') {
          this.generatePolicyDialog = false;
          this.getgeneratePolicyList()
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    cancelGeneratePolicy: function () {
      this.generatePolicyDialog = false;
    },
    delGeneratePolicy: function (row) {
      delGeneratePolicy(row).then(response => {
        if (response.resCode == '0000') {
          this.generatePolicyDetailDialog = false
          this.getgeneratePolicyList()
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    loadTemplateList: function () {
      if (this.templateList && this.templateList.length > 0) {
        return;
      }
      templateList({}).then(response => {
        if (response.resCode == '0000') {
          this.templateList = response.templateList;
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    showGeneratePolicyDetail: function (row, column, event) {
      this.generatePolicyId = row.id;
      this.getGeneratePolicyDetailList()
      this.generatePolicyDetailListDialog = true
    },
    getGeneratePolicyDetailList: function () {
      generatePolicyDetailList({policyId: this.generatePolicyId}).then(response => {
        if (response.resCode == '0000') {
          this.generatePolicyDetailList = response.generatePolicyDetailList;
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    addGeneratePolicyDetail: function () {
      this.generatePolicyDetailDialog = true;
    },
    submitGeneratePolicyDetail: function () {

      if (this.generatePolicyDetailForm.id) {
        updGeneratePolicyDetail(this.generatePolicyDetailForm).then(response => {
          if (response.resCode == '0000') {
            this.generatePolicyDetailDialog = false
            this.getGeneratePolicyDetailList()
          } else {
            this.$message.error(response.resMsg);
          }
        })
      } else {
        let detail = {
          policyId: this.generatePolicyId,
          nickName: this.generatePolicyDetailForm.nickName,
          generateSrcPath: this.generatePolicyDetailForm.generateSrcPath,
          generateRelativePath: this.generatePolicyDetailForm.generateRelativePath,
          generateFilesuffix: this.generatePolicyDetailForm.generateFilesuffix,
          importRule: this.generatePolicyDetailForm.importRule,
          // templateId: this.generatePolicyDetailForm.templateId
          templateId: this.templateId
        }
        addGeneratePolicyDetail(detail).then(response => {
          if (response.resCode == '0000') {
            this.generatePolicyDetailDialog = false
            this.getGeneratePolicyDetailList()
          } else {
            this.$message.error(response.resMsg);
          }
        })
      }
    },
    cancelGeneratePolicyDetail: function () {
    },
    generatePolicyDetailDialogOpen: function () {
      this.loadTemplateList();
    },
    delPolicyDetail: function (row) {
      delGeneratePolicyDetail({
        policyId: this.generatePolicyId,
        policyDetailId: row.id
      }).then(response => {
        if (response.resCode == '0000') {
          this.getGeneratePolicyDetailList()
        } else {
          this.$message.error(response.resMsg);
        }
      })
    },
    updPolicyDetail: function (row) {
      // console.log(this.generatePolicyForm)
      // this.generatePolicyForm = JSON.parse(JSON.stringify(row))
      // console.log(JSON.stringify(row))
      // console.log(this.generatePolicyForm)

      this.generatePolicyDetailForm.id = row.id;
      this.generatePolicyDetailForm.policyId = row.policyId;
      this.generatePolicyDetailForm.nickName = row.nickName;
      this.generatePolicyDetailForm.generateName = row.generateName;
      this.generatePolicyDetailForm.generateSrcPath = row.generateSrcPath;
      this.generatePolicyDetailForm.generateRelativePath = row.generateRelativePath;
      this.generatePolicyDetailForm.generateFilesuffix = row.generateFilesuffix;
      this.generatePolicyDetailForm.templateId = row.templateId;
      this.generatePolicyDetailForm.templateName = row.templateName;
      this.templateId = row.templateId

      // this.loadTemplateList();
      this.generatePolicyDetailDialog = true;
    }
  }
}
</script>
