"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[13],{7013:function(e,t,r){r.r(t),r.d(t,{default:function(){return c}});var n=r(3396),l=r(7139);function a(e,t,r,a,i,s){const d=(0,n.up)("el-table-column"),o=(0,n.up)("el-button"),c=(0,n.up)("el-table");return(0,n.wg)(),(0,n.iD)("div",null,[(0,n.Uk)((0,l.zw)(r.msg)+" ",1),(0,n.Wm)(c,{data:i.dbList,height:"100%",border:""},{default:(0,n.w5)((()=>[(0,n.Wm)(d,{prop:"id",label:"唯一标识",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"nickName",label:"昵称",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"dbType",label:"数据库类型",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"dbIp",label:"IP",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"dbPort",label:"数据库端口",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"defaultConnectDb",label:"默认连接库",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"dbUser",label:"数据库账号",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"dbPwd",label:"数据库密码",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"driverClassName",label:"数据库驱动",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"createTime",label:"创建时间",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"updateTime",label:"更新时间",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"status",label:"状态",width:"180",align:"center"}),(0,n.Wm)(d,{prop:"status",label:"操作",width:"180",fixed:"right",align:"center"},{default:(0,n.w5)((e=>[(0,n.Wm)(o,{onClick:t=>s.showDetail(e.row)},{default:(0,n.w5)((()=>[(0,n.Uk)("详情")])),_:2},1032,["onClick"]),(0,n.Wm)(o,{onClick:t=>s.testConnect(e.row)},{default:(0,n.w5)((()=>[(0,n.Uk)("测试链接")])),_:2},1032,["onClick"])])),_:1})])),_:1},8,["data"])])}var i=r(1394),s={name:"dbIndex",props:{msg:String},data(){return{dbList:[]}},created(){this.getDbList()},methods:{getDbList:function(){(0,i.getDbList)({}).then((e=>{"0000"==e.resCode?this.dbList=e.list:this.$message.error(e.resMsg)}))},showDetail:function(e){alert(e.dbPort)},testConnect:function(e){(0,i.testConnect)(e).then((e=>{"0000"==e.resCode?this.$message({message:e.resMsg,type:"success"}):this.$message.error(e.resMsg)})).catch((e=>{this.$message.error("请求异常")}))}}},d=r(89);const o=(0,d.Z)(s,[["render",a]]);var c=o}}]);
//# sourceMappingURL=13.2c6845ff.js.map