<template>
  <div>
    <el-table :data="list" height="100%" border>
      <el-table-column prop="id" label="唯一标识" width="180" align="center"/>
      <el-table-column prop="status" label="操作" width="180" fixed="right" align="center">
        <template v-slot="scope">
          <el-button @click="showDetail(scope.row)">详情</el-button>
          <el-button @click="testConnect(scope.row)">测试链接</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-button @click="getRecognizeLogList">列表</el-button>
    <el-button @click="getRecognizeLogList">新增</el-button>
  </div>

</template>

<script>

import {picrecognizeloglist} from '@/rely/axios/picrecognize'

export default {
  name: 'picrecognizeLog',
  data() {
    return {
      list: []
    }
  },
  created() {
    this.getRecognizeLogList();
  },
  methods: {
    getRecognizeLogList: function () {
      picrecognizeloglist({}).then(response => {
        console.log(response)
        if (response.resCode == '0000') {
          this.dbList = response.list
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    showDetail: function (detail) {
      alert(detail.dbPort)
    }
  }
}
</script>