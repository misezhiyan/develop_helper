"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[834],{8428:function(e,t,r){r.d(t,{a5:function(){return o},iE:function(){return l},oJ:function(){return u},sF:function(){return n},wk:function(){return a}});var i=r(464);function n(e){return(0,i.F)({url:"/picrecognizelog/listLog",data:e})}function a(e){return(0,i.F)({url:"/picrecognizelog/delLog",data:e})}function u(e){return(0,i.F)({url:"/picrecognizefeature/unmatchFeatureList",data:e})}function o(e){return(0,i.F)({url:"/picrecognizefeature/matchFeature",data:e})}function l(e){return(0,i.F)({url:"/picrecognizefeature/delLog",data:e})}},9834:function(e,t,r){r.r(t),r.d(t,{default:function(){return s}});var i=r(3396);const n=(0,i._)("i",null,"图片查看器",-1);function a(e,t,r,a,u,o){const l=(0,i.up)("el-table-column"),c=(0,i.up)("el-input"),s=(0,i.up)("el-button"),d=(0,i.up)("el-table"),f=(0,i.up)("el-image"),h=(0,i.up)("el-dialog");return(0,i.wg)(),(0,i.iD)(i.HY,null,[(0,i.Wm)(d,{data:u.list,width:"100%",height:"100%",border:""},{default:(0,i.w5)((()=>[(0,i.Wm)(l,{prop:"id",label:"ID",width:"100",align:"center"}),(0,i.Wm)(l,{prop:"charc",label:"对应字符",align:"center"},{default:(0,i.w5)((e=>[(0,i.Wm)(c,{modelValue:e.row.charc,"onUpdate:modelValue":t=>e.row.charc=t},null,8,["modelValue","onUpdate:modelValue"]),(0,i.Wm)(s,{onClick:t=>o.confirmFeature(e.row)},{default:(0,i.w5)((()=>[(0,i.Uk)("确认")])),_:2},1032,["onClick"])])),_:1}),(0,i.Wm)(l,{prop:"createTime",label:"上传时间",align:"center"}),(0,i.Wm)(l,{prop:"updateTime",label:"更新时间",align:"center"}),(0,i.Wm)(l,{prop:"id",label:"操作",width:"180",fixed:"right",align:"center"},{default:(0,i.w5)((e=>[(0,i.Wm)(s,{onClick:t=>o.openFeaturePic(e.row)},{default:(0,i.w5)((()=>[(0,i.Uk)("查看图片")])),_:2},1032,["onClick"]),(0,i.Wm)(s,{onClick:t=>o.deleteFeatureLog(e.row)},{default:(0,i.w5)((()=>[(0,i.Uk)("废弃")])),_:2},1032,["onClick"])])),_:1})])),_:1},8,["data"]),(0,i.Wm)(h,{onOpen:o.featurePic,modelValue:u.featurePicModel,"onUpdate:modelValue":t[0]||(t[0]=e=>u.featurePicModel=e),width:"80%"},{default:(0,i.w5)((()=>[n,(0,i.Wm)(f,{style:{width:"300px",height:"300px"},src:u.featurePicUrl,fit:""},null,8,["src"])])),_:1},8,["onOpen","modelValue"])],64)}var u=r(8428),o={name:"picrecognizeLog",data(){return{list:[],featurePicModel:!1,showPicRow:{},featurePicUrl:""}},created(){this.getUnmatchFeatureList()},methods:{getUnmatchFeatureList:function(){(0,u.oJ)({}).then((e=>{"0000"==e.resCode?this.list=e.list:this.$message.error(e.resMsg)}))},openFeaturePic:function(e){this.showPicRow=e,this.featurePicModel=!0},featurePic:function(){this.featurePicUrl="http://localhost:8070/apipicrecognize/picrecognizefeature/featureToPic?feature="+this.showPicRow.feature+"&featureSize="+this.showPicRow.featureSize},confirmFeature:function(e){(0,u.a5)(e).then((e=>{"0000"==e.resCode?(this.$message.info(e.resMsg),this.getUnmatchFeatureList()):this.$message.error(e.resMsg)}))},deleteFeatureLog:function(e){(0,u.iE)(e).then((e=>{"0000"==e.resCode?(this.$message.info(e.resMsg),this.getUnmatchFeatureList()):this.$message.error(e.resMsg)}))}}},l=r(89);const c=(0,l.Z)(o,[["render",a]]);var s=c}}]);
//# sourceMappingURL=834.3ced3f38.js.map