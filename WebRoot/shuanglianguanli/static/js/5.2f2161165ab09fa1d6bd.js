webpackJsonp([5],{"3cXf":function(t,s,e){t.exports={default:e("q1bu"),__esModule:!0}},"6UtL":function(t,s,e){"use strict";Object.defineProperty(s,"__esModule",{value:!0});var a=e("3cXf"),i=e.n(a),n={name:"detail",inject:["reload"],data:function(){return{localId:null,resmess:"",tree:!0,dialogShenhe:!1,innerdialogshenhe:!1,dialogshtg:!1,dialogshwtg:!1,dialoghtxmjd:!1,innerdialoghtxmjd:!1,fileUpload:!1,xmlevel:null,route:null,xmjd:!0,id:null,user_id:null,resolve:!1,shenbaojilu:!1,jindujilu:!1,tipcontent1:"审核未通过，请仔细审阅分解任务进行编辑",tipcontent2:"分解任务进度全达到100%才可提交审核",card:{},note:[],resolvetask:[],shenbao:[],report:{content:"",jd:0,xh:0,jdStatus:"",files:[]},shenhe:{content:"",files:[]},finish:{htjd:100,passcontent:"",noPasscontent:""},noPass:{shpy:"",resolvetask1:[]},minNum:0,maxNum:100,searchContent:"",navdata:[],navdata2:[],defaultProps:{children:"children",label:"name"},defaultProps2:{children:"childrenstand",label:"name"}}},methods:{submit:function(){console.log(this.searchContent);var t=this;$.ajax({type:"post",url:this.baseUrl+"/ydjxzg/mb/standardList.action",data:{id:"",name:this.searchContent},dataType:"json",success:function(s){console.log(s),t.navdata2=s.standlist,t.tree=!1}})},handleEdit:function(){console.log(this.$route.query);var t=this.$route.query.id;localStorage.setItem("fid",t),localStorage.setItem("bjid",this.$route.query.userid),localStorage.getItem("creid")==window.sessionStorage.getItem("user_id")?this.$router.push({path:"/edit",name:"edit",query:{id:t}}):this.$message({message:"您没有权限操作此项目!",type:"warning"})},projectTree:function(){this.$router.push({path:"/tree",name:"tree",query:{id:this.card.id,dj:this.card.target_dj}})},numChange:function(t){},handleSuccess:function(t,s,e){console.log(t,s,e),t&&(this.$message.success(s.name+"提交成功"),console.log(this.report),this.fileUpload=!0,this.$router.go(0))},handleError:function(t,s,e){console.log(t,s,e),t&&(this.$message.warning(s.name+"提交失败"),this.fileUpload=!1)},submitUpload:function(){if(""==this.report.content)this.$message.warning("汇报内容不能为空！");else if(""==this.report.xh)this.$message.warning("经费消耗不能为空！");else{var t=this;if("重要"==t.card.importancedj)var s=1;else if("普通"==t.card.importancedj)s=2;else if("暂缓"==t.card.importancedj)s=3;console.log(this.report),$.ajax({type:"post",url:t.baseUrl+"/ydjxzg/mb/report.action",data:{report_name:t.card.target_name,importancedj:s,actual_funds:t.report.xh,report_desc:t.report.content,target_id:t.card.id,manager_id:t.card.manager_id,progress:t.report.jd},dataType:"json",success:function(s){console.log(s),1==s.mess&&(t.report.files.length>=1?t.$refs.upload.submit():(t.$notify({title:"提交成功",type:"success"}),console.log(t.report),t.$router.go(0)))}})}},back:function(){this.$router.go(-1)},handleRemove:function(t,s){console.log(t,s),t.size/1024/1024>5?this.$message.warning(t.name+"超过5MB已强制移除!"):this.$message.success(t.name+"已移除")},handlePreview:function(t){console.log(t)},handleChange:function(t,s){console.log(t,s);for(var e=0;e<s.length;e++){t.size/1024/1024>5&&this.$message.warning(t.name+"文件大小不能超过5MB!")}this.dialogShenhe?this.shenhe.files.push(t.name):this.report.files.push(t.name)},handleUpload:function(t){console.log(t);var s=t.size/1024/1024<=5;return s||this.$message.error(t.name+"超过5MB已强制移除!"),s},handleNodeClick:function(t){console.log(t)},handleNodeClick2:function(t){console.log(t)},quickQuery:function(){console.log(this.searchContent);var t=this;$.ajax({type:"post",url:this.baseUrl+"/ydjxzg/mb/standardList.action",data:{id:"",name:this.searchContent},dataType:"json",success:function(s){console.log(s),t.navdata2=s.standlist,t.tree=!1}})},isFollow:function(){this.card.follow=1;var t=this;$.ajax({type:"post",url:t.baseUrl+"/ydjxzg/mb/targetFollow.action",data:{targetid:t.card.id,follow:t.card.follow},dataType:"json",success:function(s){console.log(s),1==s.mess&&t.$message.success("已关注！")}})},cancelFollow:function(){this.card.follow=0;var t=this;$.ajax({type:"post",url:t.baseUrl+"/ydjxzg/mb/targetFollow.action",data:{targetid:t.card.id,follow:t.card.follow},dataType:"json",success:function(s){console.log(s),1==s.mess&&t.$message.warning("已取消关注！")}})},shenhebtn:function(){console.log("审核"),this.dialogShenhe=!0},innerShenhe:function(){""==this.shenhe.content?this.$message.warning("汇报内容不能为空！"):this.innerdialogshenhe=!0},shenheSure:function(){console.log(this.shenhe);var t=this;$.ajax({type:"post",url:t.baseUrl+"/ydjxzg/mb/commitDeclare.action",data:{targetid:t.card.id,report_desc:t.shenhe.content},dataType:"json",success:function(s){console.log(s),t.shenhe.files.length>=1?t.$refs.uploadshenhe.submit():(t.$notify({title:"提交成功！",type:"success"}),t.$router.go(0))}})},taskShenhe:function(){this.$message.success("提交完成！"),this.dialogTaskshenhe=!1},checkDetail:function(t){this.$router.push({path:"/detail",name:"detail",query:{id:t}})},shenheFinish:function(t){(t=t||window.event).stopPropagation?t.stopPropagation():t.cancelBubble=!0,this.$message.success("审核已通过！")},shenhetongguo:function(){this.dialogshtg=!0},shenheweitongguo:function(){this.dialogshwtg=!0},revisejd:function(){var t=this;t.noPass.shpy="",t.noPass.resolvetask1=[],$.ajax({type:"post",url:t.baseUrl+"/ydjxzg/mb/goRegression.action",data:{targetid:t.card.id},dataType:"json",success:function(s){if(console.log(s),s.comment&&s.targetlist){t.noPass.shpy=s.comment;for(var e=0;e<s.targetlist.length;e++)s.targetlist[e].msg="",t.noPass.resolvetask1.push(s.targetlist[e])}}}),this.dialoghtxmjd=!0},htjdSure:function(){this.innerdialoghtxmjd=!0},htxmjd:function(){var t=this;if(t.noPass.shpy)for(var s=[],e=0;e<t.noPass.resolvetask1.length;e++)s.push({comment:t.noPass.resolvetask1[e].msg,name:t.noPass.resolvetask1[e].target_name,manager_id:t.noPass.resolvetask1[e].manager_id,target_id:t.noPass.resolvetask1[e].id,progress:t.noPass.resolvetask1[e].progress});console.log(i()(s)),$.ajax({type:"post",url:t.baseUrl+"/ydjxzg/mb/checkRegression.action",data:i()(s),contentType:"application/json;charset=UTF-8",dataType:"json",success:function(s){console.log(s),1==s.mess?t.$router.go(0):t.$message.error("回退失败请重试！")}})},passSure:function(){if(""==this.finish.passcontent)this.$message.warning("审核通过评语不能为空！");else{var t=this;$.ajax({type:"post",url:t.baseUrl+"/ydjxzg/mb/checktarget.action",data:{comment:t.finish.passcontent,result:1,target_id:t.card.id,propress:""},dataType:"json",success:function(s){console.log(s),1==s.mess?t.$router.go(0):t.$message.success("工作审核通过设置失败请重试！")}})}},nopassSure:function(){if(""==this.finish.noPasscontent)this.$message.warning("审核未通过评语不能为空！");else if(100==this.finish.htjd)this.$message.warning("请给出建议进度！");else{var t=this;console.log(t.finish.htjd),$.ajax({type:"post",url:t.baseUrl+"/ydjxzg/mb/checktarget.action",data:{comment:t.finish.noPasscontent,result:0,target_id:t.card.id,progress:t.finish.htjd},dataType:"json",success:function(s){console.log(s),1==s.mess?t.$router.go(0):t.$message.error("工作审核未通过设置失败请重试！")}}),this.dialogshwtg=!1,this.card.shenhe=-2,this.card.jd=this.finish.htjd,4==this.xmlevel&&(this.tipcontent1="任务完成才可提交审核"),this.finish.noPasscontent}},openhidden:function(t){var s=$(".hidden").eq(t).css("display");"block"==s?($(".hidden").eq(t).css("display","none"),$(".icon").eq(t).removeClass("el-icon-caret-bottom").addClass("el-icon-caret-right")):"none"==s&&($(".hidden").eq(t).css("display","block"),$(".icon").eq(t).removeClass("el-icon-caret-right").addClass("el-icon-caret-bottom"))},init:function(){console.log(this.$route.query),localStorage.setItem("idTree",this.$route.query),this.id=this.$route.query.id,this.user_id=window.sessionStorage.getItem("user_id");var t=this;$.ajax({type:"post",url:t.baseUrl+"/ydjxzg/mb/targetDetails.action",data:{targetid:t.id,user_id:t.user_id},dataType:"json",success:function(s){if(console.log(s,"resres"),sessionStorage.setItem("shifoufenjie",s.targetDetails.progress),t.xmlevel=s.targetDetails.level,1==s.targetDetails.importancedj?s.targetDetails.importancedj="重要":2==s.targetDetails.importancedj?s.targetDetails.importancedj="普通":3==s.targetDetails.importancedj&&(s.targetDetails.importancedj="暂缓"),t.card=s.targetDetails,t.resmess=s.mess,0==s.targetDetails.parent_id&&(t.card.upManager="无"),1==s.targetDetails.level?t.card.sj="":2==s.targetDetails.level?t.card.sj="上级规划":3==s.targetDetails.level?t.card.sj="上级工作":4==s.targetDetails.level&&(t.card.sj="上级项目"),1==s.targetDetails.target_stand_contion?t.card.zgbz="＞"+s.targetDetails.target_stand_info:2==s.targetDetails.target_stand_contion?t.card.zgbz="≥"+s.targetDetails.target_stand_info:3==s.targetDetails.target_stand_contion?t.card.zgbz="＜"+s.targetDetails.target_stand_info:4==s.targetDetails.target_stand_contion?t.card.zgbz="≤"+s.targetDetails.target_stand_info:5==s.targetDetails.target_stand_contion?t.card.zgbz="＝"+s.targetDetails.target_stand_info:6==s.targetDetails.target_stand_contion?t.card.zgbz="≠"+s.targetDetails.target_stand_info:t.card.zgbz=s.targetDetails.target_stand_info,s.targetDetails.userEntity)for(var e=0;e<s.targetDetails.userEntity.length;e++)0==e?t.card.cyr=s.targetDetails.userEntity[e].name+"、":e==s.targetDetails.userEntity.length-1?t.card.cyr=t.card.cyr+s.targetDetails.userEntity[e].name:t.card.cyr=t.card.cyr+(s.targetDetails.userEntity[e].name+"、");s.subprojects&&(0!=s.subprojects.length?(t.resolve=!0,t.resolvetask=s.subprojects):t.resolve=!1),s.declareList&&(0!=s.declareList.length?(t.shenbaojilu=!0,1==s.declareList.importancedj?s.declareList.importancedj="重要":2==s.declareList.importancedj?s.declareList.importancedj="普通":3==s.declareList.importancedj&&(s.declareList.importancedj="暂缓"),t.shenbao=s.declareList):t.shenbaojilu=!1),s.reportlist&&(0!=s.reportlist.length?(t.jindujilu=!0,t.note=s.reportlist):t.jindujilu=!1),2==t.xmlevel?t.tipcontent2="分解出来的项目均完成才可提交审核":3==t.xmlevel?t.tipcontent2="分解出来的任务均完成才可提交审核":4==t.xmlevel&&(t.tipcontent2="任务完成才可提交审核",t.tipcontent1="任务完成才可提交审核"),t.minNum=0-t.card.progress,t.maxNum=100-t.card.progress}})}},mounted:function(){this.localId=localStorage.getItem("user_id"),console.log(this.localId,"localId");var t=localStorage.getItem("creid"),s=window.sessionStorage.getItem("user_id"),e=document.getElementsByClassName("btn1");e[0].style.backgroundColor=t==s?"#85CE61":"#cccccc",this.init();var a=this;$.ajax({type:"post",url:this.baseUrl+"/ydjxzg/mb/standard.action",dataType:"json",success:function(t){console.log(t),a.navdata=t.standardlist}})},watch:{$route:{handler:function(t){"detail"==t.name&&this.init()},deep:!0}}},l={render:function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{attrs:{id:"detail"}},[e("el-row",{attrs:{gutter:12}},[e("el-col",{attrs:{span:16}},[e("el-card",{attrs:{shadow:"always"}},[e("div",{staticClass:"ghxq"},[e("div",{staticClass:"xmxqtit"},[e("i",{staticClass:"iconfont icon-xiangqing"}),t._v(" "),e("span",{staticClass:"tit"},[t._v("项目详情")]),t._v(" "),e("div",{staticClass:"follow"},[1==t.card.follow?e("el-button",{attrs:{size:"small",icon:"el-icon-star-on"},on:{click:function(s){return t.cancelFollow()}}},[t._v("已关注")]):e("el-button",{attrs:{size:"small",icon:"el-icon-star-off"},on:{click:function(s){return t.isFollow()}}},[t._v("重点关注")])],1),t._v(" "),e("el-button",{staticClass:"btn",attrs:{size:"small",plain:""},on:{click:function(s){return t.projectTree()}}},[e("i",{staticClass:"iconfont icon-shu"}),t._v("查看项目树")]),t._v(" "),e("el-button",{staticClass:"btn1",attrs:{size:"small",plain:""},on:{click:function(s){return t.handleEdit()}}},[e("i",{staticClass:"el-icon-edit-outline"}),t._v("编辑")])],1),t._v(" "),e("div",{staticClass:"mc project",staticStyle:{margin:"0"}},[e("span",{staticClass:"left"},[t._v("项目名称：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.target_name))])]),t._v(" "),e("div",{staticClass:"yxj project"},[e("span",{staticClass:"left"},[t._v("紧急程度：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.importancedj))])]),t._v(" "),t.card.upManager?e("div",{staticClass:"leader project"},[e("span",{staticClass:"left"},[t._v("上级领导：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.upManager))])]):t._e(),t._v(" "),t.card.parent_name?e("div",{staticClass:"sjmc project"},[e("span",{staticClass:"left"},[t._v("上级规划：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.parent_name))])]):t._e(),t._v(" "),e("div",{staticClass:"date project"},[e("span",{staticClass:"left"},[t._v("项目时间：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.start_time)+"~"+t._s(t.card.end_time))])]),t._v(" "),e("div",{staticClass:"jfys project"},[e("span",{staticClass:"left"},[t._v("项目经费：")]),e("p",{staticClass:"right"},[t._v("已消耗 "+t._s(t.card.actual_funds)+" 万元 / 预算 "+t._s(t.card.funds)+" 万元")])]),t._v(" "),e("div",{staticClass:"jfys project"},[e("span",{staticClass:"left"},[t._v("诊改指标：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.target_stand_name))])]),t._v(" "),e("div",{staticClass:"jfys project"},[e("span",{staticClass:"left"},[t._v("诊改标准：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.zgbz))])]),t._v(" "),e("div",{staticClass:"fzr project"},[e("span",{staticClass:"left"},[t._v("负责人：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.manager_name))])]),t._v(" "),e("div",{staticClass:"cyr project"},[e("span",{staticClass:"left"},[t._v("参与人：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.cyr))])]),t._v(" "),e("div",{staticClass:"jd project"},[e("span",{staticClass:"left"},[t._v("进度状态：")]),t._v(" "),e("p",{staticClass:"right",staticStyle:{position:"relative"}},[e("el-slider",{attrs:{disabled:""},model:{value:t.card.progress,callback:function(s){t.$set(t.card,"progress",s)},expression:"card.progress"}}),t._v(" "),e("span",{staticStyle:{position:"absolute",right:"5px",top:"-7px","font-size":"14px"}},[t._v(t._s(t.card.progress)+"%")])],1)]),t._v(" "),e("div",{staticClass:"xmjj project"},[e("span",{staticClass:"left"},[t._v("项目简介：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.target_info))])])]),t._v(" "),1!=t.xmlevel?e("div",{staticClass:"commitbtn"},["-1"==t.card.check_status?e("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:t.tipcontent2,placement:"top"}},[e("el-button",{staticClass:"disabledbtn",attrs:{size:"small"}},[t._v("提交完成审核")])],1):"0"==t.card.check_status&&t.card.manager_id==t.user_id?e("el-button",{attrs:{size:"small"},on:{click:function(s){return t.shenhebtn()}}},[t._v("提交完成审核")]):"0"==t.card.check_status&&t.card.manager_id!=t.user_id?e("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"您没有权限操作此项目",placement:"top"}},[e("el-button",{staticClass:"disabledbtn",attrs:{size:"small"}},[t._v("提交完成审核")])],1):"1"==t.card.check_status&&t.card.creator_id==t.user_id?e("div",{staticClass:"dsh"},[e("el-button",{attrs:{type:"success",size:"small"},on:{click:function(s){return t.shenhetongguo()}}},[t._v("审核通过")]),t._v(" "),e("el-button",{attrs:{type:"danger",size:"small"},on:{click:function(s){return t.shenheweitongguo()}}},[t._v("审核未通过")])],1):"1"==t.card.check_status&&t.card.creator_id!=t.user_id?e("el-button",{attrs:{type:"danger",size:"small",disabled:""}},[t._v("待审核")]):"2"==t.card.check_status?e("el-button",{attrs:{type:"success",size:"small"},on:{click:t.shenheFinish}},[t._v("审核通过")]):t._e(),t._v(" "),"-2"==t.card.check_status&&t.card.manager_id!=t.user_id?e("el-button",{attrs:{type:"danger",size:"small",disabled:""}},[t._v("审核未通过")]):t._e(),t._v(" "),"-2"==t.card.check_status&&t.card.manager_id==t.user_id&&4!=t.xmlevel?e("el-button",{attrs:{type:"danger",size:"small"},on:{click:function(s){return t.revisejd()}}},[t._v("审核未通过")]):t._e(),t._v(" "),"-2"==t.card.check_status&&t.card.manager_id==t.user_id&&4==t.xmlevel?e("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"审核未通过，请完成后重新提交审核",placement:"top"}},[e("el-button",{staticClass:"disabledbtn",attrs:{size:"small"}},[t._v("提交完成审核")])],1):t._e()],1):t._e(),t._v(" "),"4"==t.xmlevel?e("div",{staticClass:"projectNote",staticStyle:{"margin-top":"20px"}},[e("div",{staticClass:"xmxqtit"},[e("i",{staticClass:"iconfont icon-lishijilu"}),t._v(" "),t.jindujilu?e("span",{staticClass:"tit"},[t._v("进度记录")]):e("span",{staticClass:"tit"},[t._v("进度记录(暂无)")])]),t._v(" "),t.note?e("div",t._l(t.note,function(s,a){return e("div",{key:a,staticClass:"history"},[e("div",{staticClass:"history_date"},[t._v(t._s(s.report_time))]),t._v(" "),e("div",{staticClass:"projectName note"},[e("span",{staticClass:"left"},[t._v("项目名字：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.target_name))])]),t._v(" "),e("div",{staticClass:"zhongyaochengdu note"},[e("span",{staticClass:"left"},[t._v("紧急程度：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.importancedj))])]),t._v(" "),e("div",{staticClass:"history_jd note"},[e("span",{staticClass:"left"},[t._v("当前进度：")]),e("p",{staticClass:"right"},[t._v("项目完成"+t._s(s.progress)+"%")])]),t._v(" "),e("div",{staticClass:"history_xh note"},[e("span",{staticClass:"left"},[t._v("本次经费消耗：")]),e("p",{staticClass:"right"},[t._v(t._s(s.actual_funds)+"万元")])]),t._v(" "),e("div",{staticClass:"history_content note"},[e("span",{staticClass:"left"},[t._v("汇报内容：")]),e("p",{staticClass:"right"},[t._v(t._s(s.report_desc))])]),t._v(" "),e("div",{staticClass:"history_file note"},[e("span",{staticClass:"left"},[t._v("附件：")]),t._v(" "),s.attachment&&s.attachment.length>=1?e("div",{staticClass:"right"},t._l(s.attachment,function(s,a){return e("span",{key:a,staticClass:"document"},[e("i",{staticClass:"iconfont icon-fujian"}),t._v(t._s(s.name))])}),0):e("div",{staticClass:"right"},[e("span",[t._v("无附件")])])])])}),0):t._e()]):t._e(),t._v(" "),"4"!=t.xmlevel?e("div",{staticClass:"resolvetask"},[e("div",{staticClass:"resolvetit"},[e("i",{staticClass:"iconfont icon-fenjie"}),t._v(" "),t.resolve?e("span",{staticClass:"tit"},[t._v("本项目的分解任务")]):t._e(),t._v(" "),t.resolve?t._e():e("span",{staticClass:"tit"},[t._v("本项目的分解任务（暂无）")])]),t._v(" "),t.resolve?e("div",t._l(t.resolvetask,function(s,a){return e("div",{key:a,staticClass:"resolve",on:{click:function(e){return t.checkDetail(s.id)}}},[e("div",{staticClass:"taskname task"},[e("span",{staticClass:"left"},[t._v("任务名称：")]),e("p",{staticClass:"right"},[t._v(t._s(s.target_name))])]),t._v(" "),e("div",{staticClass:"taskfzr task"},[e("span",{staticClass:"left"},[t._v("负责人：")]),e("p",{staticClass:"right"},[t._v(t._s(s.manager_name))])]),t._v(" "),e("div",{staticClass:"taskimportant task"},[e("span",{staticClass:"left"},[t._v("经费消耗：")]),e("p",{staticClass:"right"},[t._v(t._s(s.actual_funds)+"万元/"+t._s(s.funds)+"万元")])]),t._v(" "),-2!=s.check_status&&-1!=s.check_status&&0!=s.check_status?e("div",{staticClass:"taskbtn task"},[e("span",{staticClass:"left"},[t._v("审核状态：")]),t._v(" "),e("span",{staticClass:"right"},[1==s.check_status?e("span",{staticClass:"dsh sh"},[t._v("待审核")]):t._e(),t._v(" "),2==s.check_status?e("span",{staticClass:"tgsh sh"},[t._v("审核通过")]):t._e()])]):"-2"==s.check_status||"-1"==s.check_status||"0"==s.check_status?e("div",{staticClass:"taskjd task"},[e("span",{staticClass:"left"},[t._v("进度状态：")]),t._v(" "),e("p",{staticClass:"right",staticStyle:{position:"relative"}},[e("el-slider",{attrs:{disabled:""},model:{value:s.progress,callback:function(e){t.$set(s,"progress",e)},expression:"item.progress"}}),t._v(" "),e("span",{staticStyle:{position:"absolute",right:"5px",top:"-7px","font-size":"14px"}},[t._v(t._s(s.progress)+"%")])],1)]):t._e()])}),0):t._e()]):t._e(),t._v(" "),1!=t.xmlevel?e("div",{staticClass:"shenbaojilu"},[e("div",{staticClass:"shenbaotit"},[e("i",{staticClass:"iconfont icon-huibaojilu"}),t._v(" "),t.shenbaojilu?e("span",{staticClass:"tit"},[t._v("申报记录")]):e("span",{staticClass:"tit"},[t._v("申报记录（暂无）")])]),t._v(" "),t._l(t.shenbao,function(s,a){return e("div",{key:a,staticClass:"shenbao_history"},[e("div",{staticClass:"shenbao_header"},[e("div",{staticClass:"shenbao_time"},[t._v(t._s(s.declare_time))])]),t._v(" "),e("div",{staticClass:"shenbao_xm shenbao"},[e("span",{staticClass:"left"},[t._v("项目名称：")]),e("p",{staticClass:"right"},[t._v(t._s(t.card.target_name))])]),t._v(" "),e("div",{staticClass:"shenbao_result shenbao"},[e("span",{staticClass:"left"},[t._v("申报结果：")]),t._v(" "),e("p",{staticClass:"right"},["-1"==s.result?e("span",{staticClass:"result",staticStyle:{background:"#CAE3FA",color:"#358FE2"}},[t._v("待审核")]):t._e(),t._v(" "),"1"==s.result?e("span",{staticClass:"result",staticStyle:{background:"#E4FCD0",color:"#7CB349"}},[t._v("成功")]):t._e(),t._v(" "),"0"==s.result?e("span",{staticClass:"result",staticStyle:{background:"#FDD6D9",color:"#E42739"}},[t._v("失败")]):t._e()])]),t._v(" "),e("div",{staticClass:"shenbao_huifu shenbao"},[e("span",{staticClass:"left"},[t._v("申报评语：")]),e("p",{staticClass:"right"},[t._v(t._s(s.comment))])]),t._v(" "),e("div",{staticClass:"shenbao_fzr shenbao"},[e("span",{staticClass:"left"},[t._v("负责人：")]),e("p",{staticClass:"right"},[t._v(t._s(s.manager_name))])]),t._v(" "),e("div",{staticClass:"shenbao_jf shenbao"},[e("span",{staticClass:"left"},[t._v("经费消耗：")]),e("p",{staticClass:"right"},[t._v(t._s(s.actual_funds)+"万元/"+t._s(s.funds)+"万元")])]),t._v(" "),e("div",{staticClass:"shenbao_content shenbao"},[e("span",{staticClass:"left"},[t._v("汇报内容：")]),e("p",{staticClass:"right"},[t._v(t._s(s.report_desc))])]),t._v(" "),e("div",{staticClass:"shenbao_file shenbao"},[e("span",{staticClass:"left"},[t._v("附件：")]),t._v(" "),s.files&&s.files.length>=1?e("div",{staticClass:"right"},t._l(s.files,function(s,a){return e("span",{key:a,staticClass:"document"},[e("i",{staticClass:"iconfont icon-fujian"}),t._v(t._s(s.name))])}),0):e("div",{staticClass:"right"},[e("span",[t._v("无附件")])])])])})],2):t._e(),t._v(" "),t.localId==t.card.manager_id&&"0"==t.resmess?e("div",{staticClass:"jdReport"},[e("div",{staticClass:"xmxqtit"},[e("i",{staticClass:"iconfont icon-huibaojilu"}),t._v(" "),e("span",{staticClass:"tit"},[t._v("进度汇报")])]),t._v(" "),e("div",{staticClass:"report_content report"},[e("span",{staticClass:"left"},[t._v("汇报内容：")]),t._v(" "),e("div",{staticClass:"right"},[e("el-input",{attrs:{type:"textarea",autosize:{minRows:2},placeholder:"建议不超过200字"},model:{value:t.report.content,callback:function(s){t.$set(t.report,"content",s)},expression:"report.content"}})],1)]),t._v(" "),e("div",{staticClass:"report_jd report"},[e("span",{staticClass:"left"},[t._v("进度变化量：")]),t._v(" "),e("div",{staticClass:"right"},[e("el-input-number",{attrs:{size:"small",min:t.minNum,max:t.maxNum,label:""},on:{change:t.numChange},model:{value:t.report.jd,callback:function(s){t.$set(t.report,"jd",s)},expression:"report.jd"}}),t._v(" "),e("div",{staticStyle:{"font-size":"12px",display:"inline-block","margin-left":"10px"}},[t._v("（可输入范围："+t._s(t.minNum)+"~"+t._s(t.maxNum)+"）")])],1)]),t._v(" "),e("div",{staticClass:"report_xh report"},[e("span",{staticClass:"left"},[t._v("本次经费消耗：")]),t._v(" "),e("div",{staticClass:"right",staticStyle:{width:"200px"}},[e("el-input",{staticStyle:{width:"130px"},attrs:{type:"number",size:"small",min:0,label:""},model:{value:t.report.xh,callback:function(s){t.$set(t.report,"xh",s)},expression:"report.xh"}}),t._v("\n                            　万元\n                        ")],1)]),t._v(" "),e("div",{staticClass:"report_files report"},[e("span",{staticClass:"left"},[t._v("汇报附件：")]),t._v(" "),e("el-upload",{ref:"upload",staticClass:"upload-demo right",attrs:{drag:"",action:"https://jsonplaceholder.typicode.com/posts/","on-preview":t.handlePreview,"on-remove":t.handleRemove,"on-success":t.handleSuccess,"on-error":t.handleError,"on-change":t.handleChange,"before-upload":t.handleUpload,"auto-upload":!1,multiple:""}},[e("i",{staticClass:"el-icon-upload"}),t._v(" "),e("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),e("em",[t._v("点击上传")])])])],1),t._v(" "),e("el-button",{staticClass:"submitbtn",attrs:{size:"small",type:"success"},on:{click:t.submitUpload}},[t._v("提交")]),t._v(" "),e("el-button",{staticClass:"backbtn",attrs:{size:"small",plain:""},on:{click:function(s){return t.back()}}},[t._v("返回")])],1):t._e()])],1),t._v(" "),e("el-col",{staticClass:"right_card",attrs:{span:8}},[e("el-card",[e("div",{staticClass:"tipstit"},[t._v("诊改标准库速查")]),t._v(" "),e("div",{staticClass:"search"},[e("el-input",{staticStyle:{"margin-right":"5px"},attrs:{placeholder:"请输入搜索内容","prefix-icon":"el-icon-search",clearable:""},nativeOn:{keyup:function(s){return!s.type.indexOf("key")&&t._k(s.keyCode,"enter",13,s.key,"Enter")?null:t.submit(s)}},model:{value:t.searchContent,callback:function(s){t.searchContent=s},expression:"searchContent"}}),t._v(" "),e("el-button",{staticStyle:{background:"#fdfdfd"},attrs:{plain:""},on:{click:function(s){return t.quickQuery()}}},[t._v("搜索")])],1),t._v(" "),t.tree?e("div",{staticClass:"tree"},[e("el-tree",{attrs:{data:t.navdata,props:t.defaultProps},on:{"node-click":t.handleNodeClick}})],1):e("div",{staticClass:"tree"},[e("el-tree",{attrs:{data:t.navdata2,props:t.defaultProps2},on:{"node-click":t.handleNodeClick2}})],1)])],1)],1),t._v(" "),e("el-dialog",{attrs:{title:"提交完成审核",visible:t.dialogShenhe,width:"60%"},on:{"update:visible":function(s){t.dialogShenhe=s}}},[e("div",{staticClass:"shenhe_content shenhe"},[e("span",{staticClass:"left"},[t._v("汇报内容：")]),t._v(" "),e("div",{staticClass:"right"},[e("el-input",{attrs:{type:"textarea",autosize:{minRows:2},placeholder:"建议不超过200字"},model:{value:t.shenhe.content,callback:function(s){t.$set(t.shenhe,"content",s)},expression:"shenhe.content"}})],1)]),t._v(" "),e("div",{staticClass:"shenhe_files shenhe"},[e("span",{staticClass:"left"},[t._v("汇报附件：")]),t._v(" "),e("el-upload",{ref:"uploadshenhe",staticClass:"upload-demo right",attrs:{drag:"",action:"https://jsonplaceholder.typicode.com/posts/","on-preview":t.handlePreview,"on-remove":t.handleRemove,"on-success":t.handleSuccess,"on-error":t.handleError,"on-change":t.handleChange,"before-upload":t.handleUpload,"auto-upload":!1,multiple:""}},[e("i",{staticClass:"el-icon-upload"}),t._v(" "),e("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),e("em",[t._v("点击上传")])])])],1),t._v(" "),e("el-dialog",{attrs:{title:"操作提示",visible:t.innerdialogshenhe,width:"50%","append-to-body":""},on:{"update:visible":function(s){t.innerdialogshenhe=s}}},[e("span",[t._v("您只有一次提交审核的机会，确定工作已经完成了吗？")]),t._v(" "),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(s){t.innerdialogshenhe=!1}}},[t._v("取 消")]),t._v(" "),e("el-button",{attrs:{type:"primary"},on:{click:function(s){return t.shenheSure()}}},[t._v("确 定")])],1)]),t._v(" "),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(s){t.dialogShenhe=!1}}},[t._v("取 消")]),t._v(" "),e("el-button",{attrs:{type:"primary"},on:{click:function(s){return t.innerShenhe()}}},[t._v("确 定")])],1)],1),t._v(" "),e("el-dialog",{attrs:{title:"审核通过",visible:t.dialogshtg,width:"60%"},on:{"update:visible":function(s){t.dialogshtg=s}}},[e("div",{staticClass:"shpy shtg"},[e("span",{staticClass:"left"},[t._v("审核通过评语：")]),t._v(" "),e("span",{staticClass:"right"},[e("el-input",{attrs:{type:"textarea",autosize:{minRows:4},placeholder:"建议不超过200字"},model:{value:t.finish.passcontent,callback:function(s){t.$set(t.finish,"passcontent",s)},expression:"finish.passcontent"}})],1)]),t._v(" "),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(s){t.dialogshtg=!1}}},[t._v("取 消")]),t._v(" "),e("el-button",{attrs:{type:"primary"},on:{click:function(s){return t.passSure()}}},[t._v("确 定")])],1)]),t._v(" "),e("el-dialog",{attrs:{title:"审核未通过",visible:t.dialogshwtg,width:"60%"},on:{"update:visible":function(s){t.dialogshwtg=s}}},[e("div",{staticClass:"shwtgpy shwtg"},[e("span",{staticClass:"left"},[t._v("审核未通过评语：")]),t._v(" "),e("span",{staticClass:"right"},[e("el-input",{attrs:{type:"textarea",autosize:{minRows:4},placeholder:"建议不超过200字"},model:{value:t.finish.noPasscontent,callback:function(s){t.$set(t.finish,"noPasscontent",s)},expression:"finish.noPasscontent"}})],1)]),t._v(" "),e("div",{staticClass:"htjd shwtg",staticStyle:{"margin-top":"20px"}},[e("span",{staticClass:"left",staticStyle:{"line-height":"40px"}},[t._v("建议进度：")]),t._v(" "),e("span",{staticClass:"right",staticStyle:{position:"relative"}},[e("el-slider",{model:{value:t.finish.htjd,callback:function(s){t.$set(t.finish,"htjd",s)},expression:"finish.htjd"}}),t._v(" "),e("span",{staticStyle:{position:"absolute",right:"5px",top:"-7px","font-size":"14px"}},[t._v(t._s(t.finish.htjd)+"%")])],1)]),t._v(" "),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(s){t.dialogshwtg=!1}}},[t._v("取 消")]),t._v(" "),e("el-button",{attrs:{type:"primary"},on:{click:function(s){return t.nopassSure()}}},[t._v("确 定")])],1)]),t._v(" "),e("el-dialog",{staticClass:"dialoghtxmjd",attrs:{title:"请选择回退项目进度",visible:t.dialoghtxmjd,width:"60%"},on:{"update:visible":function(s){t.dialoghtxmjd=s}}},[e("div",{staticClass:"htjd"},[e("div",{staticClass:"fktit tit"},[t._v("审核评语：")]),t._v(" "),e("div",{staticClass:"shenbaopy ht"},[e("p",{staticClass:"pingyu right"},[t._v(t._s(t.noPass.shpy))])])]),t._v(" "),e("div",{staticClass:"htjd"},[e("div",{staticClass:"zxmtit tit"},[t._v("本项目的分解任务")]),t._v(" "),e("ul",{staticClass:"tasklist"},t._l(t.noPass.resolvetask1,function(s,a){return e("li",{key:a,staticClass:"list"},[e("div",{staticClass:"proname ht",on:{click:function(s){return t.openhidden(a)}}},[e("span",{staticClass:"left"},[e("i",{staticClass:"icon el-icon-caret-right"}),t._v("项目名称：")]),e("span",{staticClass:"right"},[t._v(t._s(s.target_name))])]),t._v(" "),e("div",{staticClass:"hidden"},[e("div",{staticClass:"shenbao_htjd ht"},[e("span",{staticClass:"left"},[t._v("建议进度：")]),t._v(" "),e("span",{staticClass:"right"},[e("el-slider",{model:{value:s.progress,callback:function(e){t.$set(s,"progress",e)},expression:"item.progress"}})],1)]),t._v(" "),e("div",{staticClass:"jd ht"},[e("span",{staticClass:"left"},[t._v("回退评语：")]),t._v(" "),e("span",{staticClass:"right"},[e("el-input",{attrs:{type:"textarea",autosize:{minRows:2},placeholder:"建议不超过200字"},model:{value:s.msg,callback:function(e){t.$set(s,"msg",e)},expression:"item.msg"}})],1)])])])}),0)]),t._v(" "),e("el-dialog",{attrs:{title:"提示",visible:t.innerdialoghtxmjd,width:"50%","append-to-body":""},on:{"update:visible":function(s){t.innerdialoghtxmjd=s}}},[e("span",[t._v("未通过审核的项目只有一次回退本项目分解的任务机会，请确认您是否将应回退的任务都选择完了？")]),t._v(" "),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(s){return t.htxmjd()}}},[t._v("是")]),t._v(" "),e("el-button",{attrs:{type:"primary"},on:{click:function(s){t.innerdialoghtxmjd=!1}}},[t._v("否")])],1)]),t._v(" "),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(s){t.dialoghtxmjd=!1}}},[t._v("取 消")]),t._v(" "),e("el-button",{attrs:{type:"primary"},on:{click:function(s){return t.htjdSure()}}},[t._v("确 定")])],1)],1)],1)},staticRenderFns:[]};var o=e("C7Lr")(n,l,!1,function(t){e("qVc9")},null,null);s.default=o.exports},q1bu:function(t,s,e){var a=e("Rv9F"),i=a.JSON||(a.JSON={stringify:JSON.stringify});t.exports=function(t){return i.stringify.apply(i,arguments)}},qVc9:function(t,s){}});
//# sourceMappingURL=5.2f2161165ab09fa1d6bd.js.map