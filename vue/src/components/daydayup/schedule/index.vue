<template>
  <div>
    <el-table :data="scheduleList">
      <el-table-column prop="name" label="老师"/>
      <el-table-column prop="scheduleDate" label="日期"/>
      <el-table-column prop="start" label="开始时间"/>
      <el-table-column prop="end" label="结束时间"/>
    </el-table>
  </div>
</template>

<script>
export default {
  name: 'daydayupSchedule',
  props: {
    msg: String,
  },
  created() {
    this.getScheduleList();
  },
  data() {
    return {
      scheduleList: [],
    }
  },
  methods: {
    getScheduleList: function () {
      this.daydayupInstanceApi.scheduleInfoList().then((response) => {
        if (response.resCode == '0000') {
          this.scheduleList = response.list;
        } else {
          this.$message.error(response.resMsg);
        }
      });
    }
  }
}
</script>