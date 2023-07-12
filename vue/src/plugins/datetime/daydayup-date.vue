<template>
  <div>
    自定义日期插件

    <el-input v-model="year"/>
    <el-input v-model="month"/>
    <el-table :data="monthWeekList">
      <el-table-column prop="weekDay1" label="周一">
        <template #default="scope">
          <el-link type="primary" :underline="false" @click="dealFatherFunc(scope.row.weekDay1)">{{ scope.row.weekDay1 }}</el-link>
        </template>
      </el-table-column>
      <el-table-column prop="weekDay2" label="周二">
        <template #default="scope">
          <el-link type="primary" :underline="false" @click="dealFatherFunc(scope.row.weekDay2)">{{ scope.row.weekDay2 }}</el-link>
        </template>
      </el-table-column>
      <el-table-column prop="weekDay3" label="周三">
        <template #default="scope">
          <el-link type="primary" :underline="false" @click="dealFatherFunc(scope.row.weekDay3)">{{ scope.row.weekDay3 }}</el-link>
        </template>
      </el-table-column>
      <el-table-column prop="weekDay4" label="周四">
        <template #default="scope">
          <el-link type="primary" :underline="false" @click="dealFatherFunc(scope.row.weekDay4)">{{ scope.row.weekDay4 }}</el-link>
        </template>
      </el-table-column>
      <el-table-column prop="weekDay5" label="周五">
        <template #default="scope">
          <el-link type="primary" :underline="false" @click="dealFatherFunc(scope.row.weekDay5)">{{ scope.row.weekDay5 }}</el-link>
        </template>
      </el-table-column>
      <el-table-column prop="weekDay6" label="周六">
        <template #default="scope">
          <el-link type="primary" :underline="false" @click="dealFatherFunc(scope.row.weekDay6)">{{ scope.row.weekDay6 }}</el-link>
        </template>
      </el-table-column>
      <el-table-column prop="weekDay0" label="周日">
        <template #default="scope">
          <el-link type="primary" :underline="false" @click="dealFatherFunc(scope.row.weekDay0)">{{ scope.row.weekDay0 }}</el-link>
        </template>
      </el-table-column>
    </el-table>

  </div>
</template>

<script>
export default {
  name: "DaydayupDatetime",
  props:{
  fatherMethod: {
    type: Function,
    default: null
  }
  },
  created() {
    this.init();
  },
  data() {
    return {
      year: '',
      month: '',
      monthWeekList: []
    }
  },
  methods: {
    init: function () {
      let date = new Date();
      this.year = date.getFullYear()
      this.month = date.getMonth() + 1
      date.setDate(1)
      let lastDate = this.getMonthLastDay(date.getFullYear(), date.getMonth() + 1);

      let week = {
        weekDay1: '',
        weekDay2: '',
        weekDay3: '',
        weekDay4: '',
        weekDay5: '',
        weekDay6: '',
        weekDay0: '',
      }
      for (let i = 1; i <= 31 && date.getDate() <= lastDate.getDate(); i++) {
        date.setDate(i)
        if (1 == date.getDay()) {
          this.monthWeekList.push(week)
          week = {
            weekDay1: '',
            weekDay2: '',
            weekDay3: '',
            weekDay4: '',
            weekDay5: '',
            weekDay6: '',
            weekDay0: '',
          }
        }
        this.fillWeek(week, date);
      }
    },
    getMonthLastDay: function (year, month) {
      return new Date(year, month + 1, 0);
    },
    fillWeek: function (week, date) {
      switch (date.getDay()) {
        case 1:
          week.weekDay1 = date.getDate();
          break
        case 2:
          week.weekDay2 = date.getDate();
          break
        case 3:
          week.weekDay3 = date.getDate();
          break
        case 4:
          week.weekDay4 = date.getDate();
          break
        case 5:
          week.weekDay5 = date.getDate();
          break
        case 6:
          week.weekDay6 = date.getDate();
          break
        case 0:
          week.weekDay0 = date.getDate();
          break
      }
    },
    dealFatherFunc: function (date) {
      if (this.fatherMethod) {
        this.fatherMethod(this.year, this.month, date);
      }
    }
  }
}
</script>

<style scoped>

</style>