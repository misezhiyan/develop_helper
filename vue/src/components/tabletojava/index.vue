<template>
  <div>
    表结构生成java对象
    <el-select v-model="selectedDbId" @change="dbChange">
      <el-option v-for="dbOption in dbList"
                 :key="dbOption.id"
                 :label="dbOption.nickName"
                 :value="dbOption.id"
      />
    </el-select>
  </div>

  <el-tag :type="useTagType">{{ useTag }}</el-tag>

<!--  <button @click="createTemplate">创建模板</button>-->

</template>

<script>
import {getDbList, testConnect} from '@/rely/axios/develophelper.js'

export default {
  name: "tableToJavaIndex",
  data() {
    return {
      selectedDbId: {},
      dbList: [],
      useTag: '未验证',
      useTagType: 'warning'
    }
  },
  created() {
    this.getDbList()
  },
  methods: {
    getDbList: function () {
      getDbList({}).then(response => {
        if (response.resCode == '0000') {
          this.dbList = response.list
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    dbChange: function () {
      let selectedDb;
      for (let i = 0; i < this.dbList.length; i++) {
        if (this.dbList[i].id == this.selectedDbId) {
          selectedDb = this.dbList[i];
        }
      }
      testConnect(selectedDb).then(res => {
        if (res.resCode == '0000') {
          this.$message({
            message: res.resMsg,
            type: 'success'
          })

          this.useTag = '可用'
          this.useTagType = 'success'
        } else {
          this.$message.error(res.resMsg);
          this.useTag = '不可用'
          this.useTagType = 'danger'
        }
      }).catch(error => {
        this.$message.error("请求异常");
        this.useTag = '不可用'
        this.useTagType = 'danger'
      })
    },
    createTemplate: function () {
      // this.$router.replace("/db/dbIndex")
    }

  }
}
</script>

<style scoped>

</style>