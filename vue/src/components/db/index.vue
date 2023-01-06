<template>
  <div>
    {{ msg }}
    <el-table :data="dbList" height="100%" border>
      <el-table-column prop="id" label="唯一标识" width="180" align="center"/>
      <el-table-column prop="nickName" label="昵称" width="180" align="center"/>
      <el-table-column prop="dbType" label="数据库类型" width="180" align="center"/>
      <el-table-column prop="dbIp" label="IP" width="180" align="center"/>
      <el-table-column prop="dbPort" label="数据库端口" width="180" align="center"/>
      <el-table-column prop="defaultConnectDb" label="默认连接库" width="180" align="center"/>
      <el-table-column prop="dbUser" label="数据库账号" width="180" align="center"/>
      <el-table-column prop="dbPwd" label="数据库密码" width="180" align="center"/>
      <el-table-column prop="driverClassName" label="数据库驱动" width="180" align="center"/>
      <el-table-column prop="createTime" label="创建时间" width="180" align="center"/>
      <el-table-column prop="updateTime" label="更新时间" width="180" align="center"/>
      <el-table-column prop="status" label="状态" width="180" align="center"/>
      <el-table-column prop="status" label="操作" width="180" fixed="right" align="center">
        <template v-slot="scope">
          <el-button @click="showDetail(scope.row)">详情</el-button>
          <el-button @click="testConnect(scope.row)">测试链接</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

</template>

<script>

import {getDbList, testConnect} from '@/rely/axios/develophelper.js'

export default {
  name: 'dbIndex',
  props: {
    msg: String,
  },
  data() {
    return {
      dbList: []
    }
  },
  created() {
    this.getDbList();
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
    showDetail: function (detail) {
      alert(detail.dbPort)
    },
    testConnect: function (data) {
      testConnect(data).then(res => {
        if (res.resCode == '0000') {
          this.$message({
            message: res.resMsg,
            type: 'success'
          })
        } else {
          this.$message.error(res.resMsg);
        }
      }).catch(error => {
        this.$message.error("请求异常");
      })
    }
  }
}
</script>