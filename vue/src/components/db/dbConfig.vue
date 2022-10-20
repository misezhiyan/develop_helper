<template>
  <div>
    {{ msg }}
    <el-form :model="dbForm" label-width:="120px">
      <el-form-item label="数据库类型">
        <el-select
            v-model="dbForm.dbType"
            filterable
            allow-create
            default-first-option
            :reserve-keyword="false"
            placeholder="数据库类型"
            @change="changeDbType()">
          <el-option v-for="dbType in dbTypeOptions"
                     :key="dbType.value"
                     :label="dbType.label"
                     :value="dbType.value"/>
        </el-select>
      </el-form-item>

      <el-form-item label="数据库名称">
        <el-input v-model="dbForm.nickName" placeholder="数据库名称" style="width: 225px">
        </el-input>
      </el-form-item>
      <el-form-item label="数据库IP">
        <el-input v-model="dbForm.dbIp" placeholder="数据库IP" style="width: 225px">
        </el-input>
      </el-form-item>
      <el-form-item label="数据库端口">
        <el-input v-model="dbForm.dbPort" placeholder="数据库端口" style="width: 225px">
        </el-input>
      </el-form-item>
      <el-form-item label="数据库默认链接库">
        <el-input v-model="dbForm.defaultConnectDb" placeholder="数据库默认链接库" style="width: 225px">
        </el-input>
      </el-form-item>
      <el-form-item label="数据库驱动类">
        <el-input v-model="dbForm.driverClassName" placeholder="数据库驱动类" style="width: 225px">
        </el-input>
      </el-form-item>
      <el-form-item label="数据库用户名">
        <el-input v-model="dbForm.dbUser" placeholder="数据库用户名" style="width: 225px">
        </el-input>
      </el-form-item>
      <el-form-item label="数据库密码">
        <el-input v-model="dbForm.dbPwd" placeholder="数据库密码" style="width: 225px">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="testConnect()">
          测试链接
        </el-button>
        <el-button @click="submitDbConfig()">
          提交
        </el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
export default {
  name: 'dbConfig',
  props: {
    msg: String,

  },
  data() {
    return {
      dbTypeOptions: [{
        label: 'MYSQL',
        value: 'mysql'
      }, {
        label: 'ORACLE',
        value: 'oracle'
      }],
      dbForm: {
        dbType: 'mysql',
        nickName: '本地',
        dbIp: '127.0.0.1',
        dbPort: '3306',
        defaultConnectDb: 'test',
        driverClassName: 'com.mysql.cj.jdbc.Driver',
        dbUser: 'root',
        dbPwd: 'root'
      }
    }
  },
  methods: {
    changeDbType: function () {
      // alert(this.dbForm.dbType)
    },
    testConnect: function () {
      // var data = {
      //   type: this.dbForm.dbType,
      //   ip: this.dbForm.dbIp,
      //   port: this.dbForm.dbPort,
      //   dbname: this.dbForm.dbName,
      //   user: this.dbForm.dbUser,
      //   pwd: this.dbForm.dbPwd
      // }

      this.develophelperApi.testConnect(this.dbForm).then((response) =>{
        if (response.resCode == '0000') {
          this.$message({
            message: response.resMsg,
            type: 'success'
          })
        } else {
          this.$message.error(response.resMsg);
        }
      });
    },
    submitDbConfig: function () {

      // private String type;
      // private String ip;
      // private String port;
      // private String dbname;
      // private String user;
      // private String pwd;

      // var data = {
      //   type: this.dbForm.dbType,
      //   ip: this.dbForm.dbIp,
      //   port: this.dbForm.dbPort,
      //   dbname: this.dbForm.dbName,
      //   user: this.dbForm.dbUser,
      //   pwd: this.dbForm.dbPwd
      // }

      this.develophelperApi.saveconnect(this.dbForm).then((response) => {
        if (response.resCode == '0000') {
          this.$message({
            message: response.resMsg,
            type: 'success'
          })
        } else {
          this.$message.error(response.resMsg);
        }
      }).catch(err => {
        this.$message.error('错了哦，这是一条错误消息');
      })

    }
  }
}
</script>