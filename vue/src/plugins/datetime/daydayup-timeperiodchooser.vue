<template>
  <div>
    时间段选择插件
    <el-table :data="timePeriodList">
      <el-table-column prop="start" label="开始时间"/>
      <el-table-column prop="end" label="结束时间"/>
      <el-table-column label="操作">
        <template #default="scope">
          <el-link type="primary" :underline="false" @click="delPeriod(scope.row)">删除</el-link>
        </template>
      </el-table-column>
    </el-table>

    <el-form :model="timePeriodForm" label-width="120px">
      <el-form-item label="开始时间">
        <el-input v-model="timePeriodForm.start"/>
      </el-form-item>
      <el-form-item label="结束时间">
        <el-input v-model="timePeriodForm.end"/>
      </el-form-item>
      <el-form-item label="">
        <el-button @click="addPeriod">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "DaydayupTimePeriodchooser",
  props: {
    fatherMethod: {
      type: Function,
      default: null
    }
  },
  data() {
    return {
      timePeriodForm: {},
      timePeriodList: []
    }
  },
  methods: {
    init: function () {
      // let date = new Date();
      // this.year = date.getFullYear()
      // this.month = date.getMonth() + 1
      // date.setDate(1)
      // let lastDate = this.getMonthLastDay(date.getFullYear(), date.getMonth() + 1);
    },
    addPeriod: function () {
      this.timePeriodList.push(this.timePeriodForm)
      this.timePeriodForm = {}
    },
    delPeriod: function (row) {
      this.timePeriodList.remove(row)
    }
  }
}
</script>

<style scoped>

</style>