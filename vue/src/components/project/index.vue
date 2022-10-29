<template>
    项目管理
    <el-select v-model="dbId" placeholder="Select1" >
        <el-option v-for="dbItem in dbList"
                   :key="dbItem.dbIp"
                   :label="dbItem.nickName"
                   :value="dbItem.dbIp"/>
    </el-select>

<!--    <el-button @click="createProj">创建项目</el-button>-->

<!--    <el-form :model="projForm" label-width="120px" v-if="formShow">-->
<!--      <el-form-item label="项目名称">-->
<!--        <el-input v-model="projForm.projName"></el-input>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="使用数据库">-->
<!--        <el-select v-model="projForm.dbId">-->
<!--          <template>-->
<!--          <el-option-->
<!--              v-for="dbItem in dbList"-->
<!--              :key="dbItem.id"-->
<!--              :label="dbItem.nickName"-->
<!--              :value="dbItem.id"-->
<!--          ></el-option>-->
<!--          </template>-->
<!--        </el-select>-->
<!--      </el-form-item>-->
<!--      <el-form-item>-->
<!--        <el-button @click="submitProj">提交</el-button>-->
<!--        <el-button @click="cancelProj">取消</el-button>-->
<!--      </el-form-item>-->
<!--    </el-form>-->
</template>

<script>
// import {getMenuList} from "@/rely/axios/develophelper";

import {getDbList} from "@/rely/axios/develophelper";

export default {
  name: "menuIndex",
  data() {
    return {
      dbId: '',
      formShow: true,
      // dbList: [],
      dbList: [{"id": 5, "dbType": "mysql", "nickName": "本地", "dbIp": "127.0.0.1", "dbPort": 3306, "defaultConnectDb": "test", "driverClassName": "com.mysql.cj.jdbc.Driver", "dbUser": "root", "dbPwd": "root", "status": 1, "createTime": "2022-10-10T03:44:18.000+00:00", "updateTime": "2022-10-10T03:44:18.000+00:00"}, {"id": 17, "dbType": "mysql", "nickName": "数字信用测试环境", "dbIp": "172.16.19.9", "dbPort": 3306, "defaultConnectDb": "vls_dc_credit", "driverClassName": "com.mysql.jdbc.Driver", "dbUser": "yct", "dbPwd": "qdchyct0828", "status": 1, "createTime": "2022-10-20T11:00:44.000+00:00", "updateTime": "2022-10-20T11:00:44.000+00:00"}],
      projForm: {
        projName: '',
        dbId: ''
      }
    }
  },
  created() {
  },
  methods: {
    getDbList: function () {
      getDbList({}).then(response => {
        if (response.resCode == '0000') {
          console.log(JSON.stringify(response.list))
          this.dbList = response.list
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    createProj: function () {
      this.formShow = true
      this.getDbList()
    },
    submitProj: function () {
      alert(1)
    },
    cancelProj: function () {
      this.formShow = false
    }
  }
}
</script>

<style scoped>

</style>