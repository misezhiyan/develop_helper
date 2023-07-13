<template>
  <div>
    <el-button @click="openForm('add')">添加学生</el-button>
    <el-table :data="studentList">
      <el-table-column prop="name" label="姓名"/>
      <el-table-column prop="sex" label="性别"/>

      <el-table-column prop="id" label="操作">
        <template #default="scope">
          <el-link type="primary" @click="chooseSchedule(scope.row)">选课</el-link>
        </template>
      </el-table-column>
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

    <el-dialog v-model="scheduleFormModel" v-on:close="closeScheduleForm" title="选课表单" width="60%" align-center append-to-body>
      <div v-loading="loading">
        <el-table :data="scheduleList">
          <el-table-column prop="name" label="老师"/>
          <el-table-column prop="scheduleDate" label="日期"/>
          <el-table-column prop="start" label="开始时间"/>
          <el-table-column prop="end" label="结束时间"/>
          <el-table-column prop="status" label="是否已占用">
            <template #default="scope">
              <el-link type="primary" :disabled="scope.row.status != 0 && scope.row.status != 1" @click="chooseCourse(scope.row)">{{ changeScheduleOpt(scope.row.status) }}</el-link>
            </template>
          </el-table-column>
        </el-table>
      </div>
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
      loading: false,
      studentList: [],
      studentFormModel: false,
      studentForm: {
        id: '',
        name: '',
        sex: ''
      },
      choosedStudentId: '',
      scheduleFormModel: false,
      scheduleList: []
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
    },
    chooseSchedule: function (row) {
      this.choosedStudentId = row.id
      this.scheduleFormModel = true
      this.getScheduleList();
    },
    getScheduleList: function () {
      this.loading = true
      this.daydayupInstanceApi.scheduleOccupyList({studentId: this.choosedStudentId}).then((response) => {
        if (response.resCode == '0000') {
          this.scheduleList = response.list;
          this.loading = false
        } else {
          this.$message.error(response.resMsg);
          this.loading = false
        }
      });
    },
    closeScheduleForm: function () {
      this.scheduleList = []
      this.choosedStudentId = ''
    },
    changeScheduleOpt: function (status) {
      // 无人占用
      if (status == 0) {
        return '预约'
        // 自己占用
      } else if (status == 1) {
        return '解除预约'
        // 他人占用
      } else if (status == 2) {
        return '不可预约'
        // 未知
      } else {
        return status
      }
    },
    chooseCourse: function (row) {
      this.daydayupInstanceApi.scheduleOccupy({studentId: this.choosedStudentId, schedule: row}).then((response) => {
        if (response.resCode == '0000') {
          this.getScheduleList()
        } else {
          this.$message.error(response.resMsg);
        }
      });
    }
  }
}
</script>