"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[315],{2315:function(e,s,t){t.r(s),t.d(s,{default:function(){return r}});var a=t(3396),n=t(7139);function i(e,s,t,i,u,l){const d=(0,a.up)("el-option"),g=(0,a.up)("el-select"),r=(0,a.up)("el-tag");return(0,a.wg)(),(0,a.iD)(a.HY,null,[(0,a._)("div",null,[(0,a.Uk)(" 表结构生成java对象 "),(0,a.Wm)(g,{modelValue:u.selectedDbId,"onUpdate:modelValue":s[0]||(s[0]=e=>u.selectedDbId=e),onChange:l.dbChange},{default:(0,a.w5)((()=>[((0,a.wg)(!0),(0,a.iD)(a.HY,null,(0,a.Ko)(u.dbList,(e=>((0,a.wg)(),(0,a.j4)(d,{key:e.id,label:e.nickName,value:e.id},null,8,["label","value"])))),128))])),_:1},8,["modelValue","onChange"])]),(0,a.Wm)(r,{type:u.useTagType},{default:(0,a.w5)((()=>[(0,a.Uk)((0,n.zw)(u.useTag),1)])),_:1},8,["type"])],64)}var u=t(1394),l={name:"tableToJavaIndex",data(){return{selectedDbId:{},dbList:[],useTag:"未验证",useTagType:"warning"}},created(){this.getDbList()},methods:{getDbList:function(){(0,u.getDbList)({}).then((e=>{"0000"==e.resCode?this.dbList=e.list:this.$message.error(e.resMsg)}))},dbChange:function(){let e;for(let s=0;s<this.dbList.length;s++)this.dbList[s].id==this.selectedDbId&&(e=this.dbList[s]);(0,u.testConnect)(e).then((e=>{"0000"==e.resCode?(this.$message({message:e.resMsg,type:"success"}),this.useTag="可用",this.useTagType="success"):(this.$message.error(e.resMsg),this.useTag="不可用",this.useTagType="danger")})).catch((e=>{this.$message.error("请求异常"),this.useTag="不可用",this.useTagType="danger"}))},createTemplate:function(){}}},d=t(89);const g=(0,d.Z)(l,[["render",i]]);var r=g}}]);
//# sourceMappingURL=315.6b59766c.js.map