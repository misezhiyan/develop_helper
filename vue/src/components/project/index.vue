<template>
  项目管理

  <el-button @click="createProj">新增项目</el-button>

  <el-form :model="projForm" label-width="120px" v-if="formShow">
    <el-form-item label="项目名称">
      <el-input v-model="projForm.projName"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button @click="showDbList">添加数据库</el-button>
      <el-table :data="selectedDbList">
        <el-table-column prop="id" label="ID"/>
        <el-table-column prop="nickName" label="昵称"/>
        <el-table-column prop="dbIp" label="IP地址"/>
        <el-table-column prop="dbPort" label="端口"/>
        <el-table-column prop="dbType" label="数据库类型"/>
        <el-table-column prop="defaultConnectDb" label="默认链接库"/>
        <el-table-column prop="driverClassName" label="驱动类"/>
        <el-table-column prop="dbUser" label="账号"/>
        <el-table-column prop="dbPwd" label="密码"/>
        <el-table-column prop="status" label="状态"/>
        <el-table-column prop="createTime" label="创建时间"/>
      </el-table>
    </el-form-item>
    <el-form-item>
      <el-button @click="submitProj">提交</el-button>
      <el-button @click="cancelProj">取消</el-button>
    </el-form-item>
  </el-form>

  <el-drawer v-model="dbDrawer" title="数据库链接">
    <template #default>
      <div>
        <el-select v-model="dbId" placeholder="选择数据库1" @change="dbChange">
          <el-option v-for="dbItem in dbList"
                     :key="dbItem.id"
                     :label="dbItem.nickName"
                     :value="dbItem.id"/>
        </el-select>
      </div>
    </template>
  </el-drawer>

</template>

<script>
import {getDbList} from "@/rely/axios/develophelper";

export default {
  name: "menuIndex",
  // components: {ElDrawer},
  data() {
    return {
      dbId: '',
      formShow: false,
      dbDrawer: false,
      dbList: [],
      selectedDbList: [],
      // dbList: [{"id": 5, "dbType": "mysql", "nickName": "本地", "dbIp": "127.0.0.1", "dbPort": 3306, "defaultConnectDb": "test", "driverClassName": "com.mysql.cj.jdbc.Driver", "dbUser": "root", "dbPwd": "root", "status": 1, "createTime": "2022-10-10T03:44:18.000+00:00", "updateTime": "2022-10-10T03:44:18.000+00:00"}, {"id": 17, "dbType": "mysql", "nickName": "数字信用测试环境", "dbIp": "172.16.19.9", "dbPort": 3306, "defaultConnectDb": "vls_dc_credit", "driverClassName": "com.mysql.jdbc.Driver", "dbUser": "yct", "dbPwd": "qdchyct0828", "status": 1, "createTime": "2022-10-20T11:00:44.000+00:00", "updateTime": "2022-10-20T11:00:44.000+00:00"}],
      projForm: {
        projName: '',
        dbId: ''
      }
    }
  },
  created() {
    this.getDbList();
  },
  methods: {
    showDbList: function () {
      this.dbDrawer = true
    },
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
    },
    submitProj: function () {
      alert(1)
    },
    cancelProj: function () {
      this.formShow = false
    },
    dbChange: function (val) {
      for (let i = 0; i < this.dbList.length; i++) {
        if (val == this.dbList[i].id && !this.dbContain(this.dbList[i])) {
          this.selectedDbList.push(this.dbList[i]);
        }
      }
      this.dbDrawer = false;
    },
    dbContain: function (dbTmp) {
      for (let i = 0; i < this.selectedDbList.length; i++) {
        if (dbTmp.id == this.selectedDbList[i].id) {
          return true;
        }
      }
      return false;
    }
  }
}
</script>

<style scoped>

</style>