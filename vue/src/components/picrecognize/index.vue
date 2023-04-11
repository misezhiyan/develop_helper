<template>
  <div style="background:#EEE;height:30px">
    <el-button @click="recognizeLogModel = true">新增</el-button>
  </div>
  <el-table :data="list" width="100%" height="100%" border>
    <!--    <el-table-column prop="id" label="ID" width="100" align="center"/>-->
    <el-table-column prop="picUrl" label="图片地址" align="center"/>
    <el-table-column prop="picName" label="图片名称" align="center"/>
    <el-table-column prop="picRecog" label="是否识别" align="center"/>
    <el-table-column prop="createTime" label="上传时间" align="center"/>
    <el-table-column prop="updateTime" label="更新时间" align="center"/>
    <el-table-column prop="id" label="操作" width="180" fixed="right" align="center">
      <template v-slot="scope">
        <el-button @click="getRecognizeStepList(scope.row)">识别过程</el-button>
        <el-button @click="delRecognize(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog v-model="recognizeLogModel" width="80%">
    <el-upload
        drag
        action="http://localhost:8070/apipicrecognize/picrecognizelog/recognize"
        :auto-upload="true"
        :on-success="uploadEnd"
    >拖拽上传
    </el-upload>
  </el-dialog>
</template>

<script>
import {picrecognizeloglist, picrecognizelogDel} from '@/rely/axios/picrecognize'

export default {
  name: 'picrecognizeLog',
  data() {
    return {
      list: [],
      recognizeLogModel: false,
      recognizeLogForm: {},
    }
  },
  created() {
    this.getRecognizeLogList();
  },
  methods: {
    getRecognizeLogList: function () {
      picrecognizeloglist({}).then(response => {
        if (response.resCode == '0000') {
          this.list = response.list
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    uploadEnd: function (response) {
      if ('0000' == response.resCode) {
        console.log(response)
        this.$message.info(response.resMsg);
        this.getRecognizeLogList();
      } else {
        this.$message.error(response.resMsg);
      }
    },
    delRecognize(row) {
      picrecognizelogDel({id: row.id}).then(response => {
        if (response.resCode == '0000') {
          this.getRecognizeLogList();
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    getRecognizeStepList(row) {
      console.log(row)
    }
  }
}
</script>

<style>
/*.el-table th.gutter {*/
/*  display: table-cell !important;*/
/*}*/

.el-table--border th.gutter:last-of-type {
  display: block !important;
}
</style>