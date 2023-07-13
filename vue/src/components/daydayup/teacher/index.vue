<template>
  <div>
    <el-button @click="openForm('add')">添加老师</el-button>
    <el-table :data="teacherList">
      <el-table-column prop="name" label="姓名"/>
      <el-table-column prop="birthday" label="出生日期"/>
      <el-table-column prop="id" label="操作">
        <template #default="scope">
          <el-link type="primary" @click="scheduleCources(scope.row)">排课</el-link>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="teacherFormModel" v-on:close="clearTeacherForm" title="老师表单" width="60%" align-center append-to-body>
      <el-form :model="teacherForm" label-width="120px">
        <el-form-item label="姓名">
          <el-input v-model="teacherForm.name"/>
        </el-form-item>
        <el-form-item label="出生日期">
          <el-input v-model="teacherForm.birthday"/>
        </el-form-item>
        <el-form-item>
          <el-button @click="submitTeacher">提交</el-button>
          <el-button @click="cancelTeacher">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog v-model="coursesFormModel" v-on:close="clearCoursesForm" title="排课表单" width="60%" align-center append-to-body>
      <DaydayupDate :father-method="chooseDate"/>
    </el-dialog>

    <el-dialog v-model="sceduleFormModel" v-on:close="clearSceduleForm" :title="sceduleForm.scheduleDate + '课程表单'" width="60%" align-center append-to-body>
      <DaydayupTimePeriodchooser :time-period-list="sceduleList" :loading="scheduleLoading" :start="sceduleForm.start" :end="sceduleForm.end" :father-add="addScedule" :period-del="delScedule"/>
    </el-dialog>
  </div>

</template>

<script>
import DaydayupDate from "@/plugins/datetime/daydayup-date"
import DaydayupTimePeriodchooser from "@/plugins/datetime/daydayup-timeperiodchooser"

export default {
  name: 'daydayupTeacher',
  components: {
    DaydayupDate,
    DaydayupTimePeriodchooser
  },
  props: {
    msg: String
  },
  created() {
    this.getTeacherList();
  },
  data() {
    return {
      teacherList: [],
      teacherFormModel: false,
      teacherForm: {
        id: '',
        name: '',
        birthday: ''
      },
      coursesFormModel: false,
      sceduleForm: {
        teacherId: '',
        scheduleDate: '',
        start: '',
        end: '',
      },
      sceduleFormModel: false,
      sceduleList: [],
      scheduleLoading: false,
    }
  },
  methods: {
    openForm: function (openType) {
      this.teacherFormModel = true
    },
    clearTeacherForm: function () {
      this.teacherForm = {
        id: '',
        name: '',
        birthday: ''
      }
    },
    submitTeacher: function () {
      this.daydayupInstanceApi.saveTeacher(this.teacherForm).then((response) => {
        if (response.resCode == '0000') {
          this.teacherFormModel = false
          this.getTeacherList();
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    cancelTeacher: function (openType) {
      this.teacherFormModel = false
    },
    getTeacherList: function () {
      this.daydayupInstanceApi.teacherList().then((response) => {
        if (response.resCode == '0000') {
          this.teacherList = response.list;
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    scheduleCources: function (row) {
      this.sceduleForm.teacherId = row.id
      this.coursesFormModel = true
    },
    clearCoursesForm: function () {
      this.sceduleForm.scheduleDate = ''
    },
    chooseDate: function (year, month, date) {
      this.sceduleForm.scheduleDate = year + month + date
      this.sceduleFormModel = true
      this.getScheduleList();
    },
    clearSceduleForm: function () {
      this.sceduleForm.start = ''
      this.sceduleForm.end = ''
      this.sceduleList = []
    },
    addScedule: function (sceduleForm) {
      this.sceduleForm.start = sceduleForm.start
      this.sceduleForm.end = sceduleForm.end
      console.log('addScedule')
      console.log(this.sceduleForm)
      this.daydayupInstanceApi.saveSchedule(this.sceduleForm).then((response) => {
        if (response.resCode == '0000') {
          this.sceduleForm.start = ''
          this.sceduleForm.end = ''
          this.getScheduleList();
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    getScheduleList: function () {
      this.scheduleLoading = true
      this.daydayupInstanceApi.scheduleList(this.sceduleForm).then((response) => {
        if (response.resCode == '0000') {
          this.sceduleList = response.list;
          this.scheduleLoading = false
        } else {
          this.$message.error(response.resMsg);
          this.scheduleLoading = false
        }
      });
    },
    delScedule: function (sceduleRow) {
      this.daydayupInstanceApi.delSchedule(sceduleRow).then((response) => {
        if (response.resCode == '0000') {
          this.getScheduleList();
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
  }
}
</script>