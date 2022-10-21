<template>
<div>
  表结构生成java对象
  <el-select v-model="selectedDb">
    <el-option v-for="dbOption in dbList"
               :key="dbOption.id"
               :label="dbOption.nickName"
               :value="dbOption.id"
    />
  </el-select>
</div>
</template>

<script>
import {getDbList} from '@/rely/axios/develophelper.js'

export default {
  name: "tableToJavaIndex",
  data(){
    return {
      selectedDb:{},
      dbList:[]
    }
  },
  created() {
    this.getDbList()
  },
  methods:{
    getDbList:function () {
      getDbList({}).then(response => {
        if (response.resCode == '0000') {
          console.log(response.list)
          this.dbList = response.list
        } else {
          this.$message.error(response.resMsg);
        }
      });
    }
  }
}
</script>

<style scoped>

</style>