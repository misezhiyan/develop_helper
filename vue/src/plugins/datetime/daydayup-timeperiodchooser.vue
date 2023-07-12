<template>
  <div>
    时间段选择插件
    <el-table :data="timePeriodList" :row-class-name="matchRowClass">
      <!--    <el-table :data="timePeriodList" >-->
      <el-table-column prop="start" label="开始时间"/>
      <el-table-column prop="end" label="结束时间"/>
      <el-table-column label="操作">
        <template #default="scope">
          <el-link type="primary" :underline="false" @click="delPeriod(scope.row)">删除</el-link>
        </template>
      </el-table-column>
    </el-table>
    <el-form label-width="120px">
      <el-form-item label="开始时间">
        <el-time-picker
            v-model="start"
            placeholder="开始时间"
            :value-format="pickerFormat"
            :format="pickerFormat"
            :picker-options="{
                selectableRange: '06:00:00 - 23:59:00',
                format: pickerFormat
            }"
        >
        </el-time-picker>
      </el-form-item>
      <el-form-item label="结束时间">
        <el-time-picker
            v-model="end"
            placeholder="开始时间"
            :value-format="pickerFormat"
            :format="pickerFormat"
            :picker-options="{
                selectableRange: '08:00:00 - 23:59:00',
                format: pickerFormat
            }"
        >
        </el-time-picker>
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
    start: {
      type: String
    },
    end: {
      type: String
    },
    timePeriodList: {
      type: Array,
      default: []
    },
    norepeat: {
      type: Boolean,
      default: true
    },
    fatherAdd: {
      type: Function,
      default: null
    },
    periodDel: {
      type: Function,
      default: null
    }
  },
  components: {},
  data() {
    return {
      pickerFormat: 'HH:mm',
    }
  },
  methods: {
    init: function () {
    },
    addPeriod: function () {
      if (!this.checkTime()) {
        return;
      }
      if (!this.start || !this.end) {
        this.$message.error("选择时间段不能为空");
        return
      }
      if (this.norepeat) {
        if (this.hasRepeatTime()) {
          this.$message.error("与其它时间段有重叠");
          return
        }
      }
      if (this.fatherAdd) {
        this.fatherAdd({start: this.start, end: this.end});
      }
    },
    hasRepeatTime: function () {
      let isRepeat = false;
      for (let i = 0; i < this.timePeriodList.length; i++) {
        this.timePeriodList[i].className = 'repeat';
        if (this.start <= this.timePeriodList[i].start && this.end > this.timePeriodList[i].start) {
          isRepeat = true;
        } else if (this.start > this.timePeriodList[i].start && this.start < this.timePeriodList[i].end) {
          isRepeat = true;
        }
        if (isRepeat) {
          this.timePeriodList[i].className = 'repeat';
          return isRepeat;
        }
      }

      return isRepeat;
    },
    delPeriod: function (row) {
      if (this.periodDel) {
        this.periodDel(row);
      }
      // let index = this.timePeriodList.indexOf(row);
      // if (index != -1) {
      //   this.timePeriodList.splice(index, 1)
      // }
    },
    matchRowClass: function (row, rowIndex) {
      console.log('matchRowClass')
      return 'repeat'
    },
    checkTime: function () {
      if (this.start && this.start && this.end <= this.start) {
        this.$message.error("结束时间必须大于开始时间");
        return false
      }
      return true
    },
    pressEnter: function () {
      alert(1)
    }
  }
}
</script>

<style scoped>
.notRepeat {
  background-color: #0a0a0a;
}

.repeat {
  background: #c41a16;
}
</style>