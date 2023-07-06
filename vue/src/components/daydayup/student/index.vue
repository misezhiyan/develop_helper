<template>
  <div>
    <el-button @click="openForm('add')">添加学生</el-button>
    <el-table :data="studentList">
      <el-table-column prop="name" label="姓名"/>
      <el-table-column prop="sex" label="性别"/>
      <!--      <el-table-column prop="id" label="操作">-->
      <!--        <template #default="scope">-->
      <!--          <el-link type="primary" @click="editProject(scope.row)">{{ scope.row.id }}</el-link>-->
      <!--        </template>-->
      <!--      </el-table-column>-->
    </el-table>

    <el-dialog v-model="studentFormModel" v-on:close="clearStudentForm" title="学生表单" width="60%" align-center append-to-body>
      <el-form :model="studentForm" label-width="120px">
        <el-form-item label="姓名">
          <el-input v-model="studentForm.name"/>
        </el-form-item>
        <el-form-item label="性别">
          <el-input v-model="studentForm.sex"/>
        </el-form-item>
        <el-form-item>
          <el-button @click="submitStudent">提交</el-button>
          <el-button @click="cancelStudent">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'daydayupStudent',
  props: {
    msg: String,
  },
  created() {
    this.getStudentList();
  },
  data() {
    return {
      studentList: [],
      studentFormModel: false,
      studentForm: {
        id: '',
        name: '',
        sex: ''
      }
    }
  },
  methods: {
    openForm: function (openType) {
      this.studentFormModel = true
    },
    clearStudentForm: function () {
      this.studentForm = {
        id: '',
        name: '',
        sex: ''
      }
    },
    submitStudent: function () {
      console.log(this.studentForm)
      this.daydayupInstanceApi.saveStudent(this.studentForm).then((response) => {
        if (response.resCode == '0000') {
          this.studentFormModel = false
          this.getStudentList();
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    cancelStudent: function (openType) {
      this.studentFormModel = false
    },
    getStudentList: function () {
      this.daydayupInstanceApi.studentList().then((response) => {
        if (response.resCode == '0000') {
          this.studentList = response.list;
        } else {
          this.$message.error(response.resMsg);
        }
      });
    }
  }
}
</script>