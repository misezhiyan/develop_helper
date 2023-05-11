<template>
  <el-table :data="list" width="100%" height="100%" border>
    <el-table-column prop="id" label="ID" width="100" align="center"/>
    <!--    <el-table-column prop="feature" label="特征" width="100" align="center"/>-->
    <el-table-column prop="charc" label="对应字符" align="center">
      <template v-slot="scope">
        <el-input v-model="scope.row.charc"/>
        <el-button @click="confirmFeature(scope.row)">确认</el-button>
      </template>
    </el-table-column>
    <el-table-column prop="createTime" label="上传时间" align="center"/>
    <el-table-column prop="updateTime" label="更新时间" align="center"/>
    <el-table-column prop="id" label="操作" width="180" fixed="right" align="center">
      <template v-slot="scope">
        <el-button @click="openFeaturePic(scope.row)">查看图片</el-button>
        <el-button @click="deleteFeatureLog(scope.row)">废弃</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog v-on:open="featurePic" v-model="featurePicModel" width="80%">
    <i>图片查看器</i>
    <el-image style="width: 300px; height: 300px" :src="featurePicUrl" fit/>
  </el-dialog>

</template>

<script>
import {unmatchFeatureList, matchFeature, delFeatureLog} from '@/rely/axios/picrecognize'

export default {
  name: 'picrecognizeLog',
  data() {
    return {
      list: [],
      featurePicModel: false,
      showPicRow: {},
      featurePicUrl: ''
    }
  },
  created() {
    this.getUnmatchFeatureList();
  },
  methods: {
    getUnmatchFeatureList: function () {
      unmatchFeatureList({}).then(response => {
        if (response.resCode == '0000') {
          this.list = response.list
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    openFeaturePic: function (row) {
      this.showPicRow = row;
      this.featurePicModel = true;
    },
    featurePic: function () {
      this.featurePicUrl = 'http://localhost:8070/apipicrecognize/picrecognizefeature/featureToPic?feature=' + this.showPicRow.feature + '&featureSize=' + this.showPicRow.featureSize;
    },
    confirmFeature: function (row) {
      matchFeature(row).then(response => {
        if (response.resCode == '0000') {
          this.$message.info(response.resMsg);
          this.getUnmatchFeatureList();
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    deleteFeatureLog:function (row){
      delFeatureLog(row).then(response => {
        if (response.resCode == '0000') {
          this.$message.info(response.resMsg);
          this.getUnmatchFeatureList();
        } else {
          this.$message.error(response.resMsg);
        }
      });
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