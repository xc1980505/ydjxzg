webpackJsonp([8],{"52YO":function(e,t){},oKWu:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a("9r/T"),l={name:"add",inject:["reload"],data:function(){return{creator_id:null,create:{cengmian:"0",level:"1",id:"",mc:"",important:"2",start:"",end:"",jfys:null,fzr:"",fid:"",cyr:[],khzb:"",khzbId:"",zgmb:"",mark:"",jd:0,jj:""},rules:{mc:[{required:!0,message:"请输入规划名称",trigger:"blur"}],fzr:[{required:!0,message:"请选择负责人",trigger:"change"}],jfys:[{required:!0,message:"请输入金额",trigger:"blur"}],start:[{required:!0,message:"请选择开始时间",trigger:"change"}],end:[{required:!0,message:"请选择结束时间",trigger:"change"}],cyr:[{required:!0,message:"请选择参与人",trigger:"change"}],khzb:[{required:!0,message:"请输入考核指标",trigger:"change"}],zgmb:[{required:!0,message:"请输入诊改目标",trigger:"change"}],jj:[{required:!0,message:"请输入规划简介",trigger:"blur"}]},options:[],option1:[{value:"1",label:"＞"},{value:"2",label:"≥"},{value:"3",label:"＜"},{value:"4",label:"≤"},{value:"5",label:"＝"},{value:"6",label:"≠"}],option2:[{value:"1",label:"重要"},{value:"2",label:"普通"},{value:"3",label:"暂缓"}],option3:[{value:"0",label:"学校层面"},{value:"1",label:"专业层面"},{value:"2",label:"课程层面"}],restaurants1:[],restaurants:[]}},methods:{querySearch:function(e,t){var a=this.restaurants;t(e?a.filter(this.createFilter(e)):a)},createFilter:function(e){return function(t){return 0===t.value.toLowerCase().indexOf(e.toLowerCase())}},queSearch:function(e,t){var a=this.restaurants1;t(e?a.filter(this.createFilter(e)):a)},fzr:function(e){localStorage.setItem("fid",e),this.create.fid=e.id,console.log(e.id)},loadAll:function(){var e=this.$route.query.creator_id;this.creator_id=e;var t=[],a=[],r=this;$.ajax({type:"post",url:r.baseUrl+"/ydjxzg/mb/totargetadd.action",data:{},dataType:"json",success:function(e){if(console.log(e),e.khzb)for(var l=0;l<e.khzb.length;l++)t.push({id:e.khzb[l].id,value:e.khzb[l].zbmc});if(e.userlist){for(l=0;l<e.userlist.length;l++)a.push({id:e.userlist[l].user_id,value:e.userlist[l].name});console.log(a);for(var s=0;s<e.userlist.length;s++)r.options.push({value:e.userlist[s].user_id,label:e.userlist[s].name})}}}),this.restaurants=t,this.restaurants1=a},handleSelect:function(e){this.create.khzbId=e.id},back:function(){this.$router.go(-1)},set:function(e){if(console.log(this.create.cyr,"参与人"),console.log(this.creator_id,"参与人"),this.create.start&&this.create.end){var t=new Date(this.create.start),a=new Date(this.create.end),l=t.getMonth(),s=t.getDate(),c=a.getMonth(),i=a.getDate();console.log(l,s),l+1<10?l="0"+(l+1):l+=1,s<10&&(s="0"+s),c+1<10?c="0"+(c+1):c+=1,i<10&&(i="0"+i),this.create.start=t.getFullYear()+"-"+l+"-"+s,this.create.end=a.getFullYear()+"-"+c+"-"+i}if(this.create.cyr=this.create.cyr.toString(),console.log(e),this.create.mc&&this.create.start&&this.create.end&&this.create.jfys&&this.create.fzr&&this.create.khzbId&&this.create.zgmb&&this.create.mark&&this.create.jj){var o=this;$.ajax({type:"post",url:o.baseUrl+"/ydjxzg/mb/addtarget.action",data:{creator_id:o.creator_id,target_category:e.cengmian,target_name:e.mc,manager_id:this.create.fid,funds:e.jfys,importancedj:e.important,start_time:e.start,end_time:e.end,cyr:e.cyr,target_stand:e.khzbId,target_stand_contion:e.mark,target_stand_info:e.zgmb,target_info:e.jj},dataType:"json",success:function(e){for(var t=[],a=0;a<o.create.cyr.length;a++)","!=o.create.cyr[a]&&t.push(o.create.cyr[a]);o.create.cyr=t,console.log(e),e.mess?(o.$message.success("创建成功！"),o.$router.push({path:"/zgmb"}),Object(r.setTimeout)(function(){o.reload()},500)):o.$message.error("创建规划失败！")},error:function(e){for(var t=[],a=0;a<o.create.cyr.length;a++)","!=o.create.cyr[a]&&t.push(o.create.cyr[a]);o.create.cyr=t,o.$message.error("创建失败！如有疑问，请联系管理员")}})}else{for(var n=[],u=0;u<this.create.cyr.length;u++)","!=this.create.cyr[u]&&n.push(this.create.cyr[u]);this.create.cyr=n,this.$message.error("请完善诊改年度规划！")}}},mounted:function(){this.loadAll()}},s={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"addProject"}},[a("el-row",[a("el-col",{attrs:{span:24}},[a("el-card",{attrs:{shadow:"always"}},[a("div",{staticClass:"title"},[a("span",{staticClass:"iconfont icon-icon-up"}),e._v("添加诊改年度规划")]),e._v(" "),a("el-form",{ref:"create",staticClass:"demo-ruleForm",attrs:{model:e.create,rules:e.rules}},[a("div",{staticClass:"form_item"},[a("el-form-item",{staticStyle:{width:"45%"},attrs:{label:"规划名称：",prop:"mc",required:""}},[a("el-input",{attrs:{type:"textarea",resize:"none",autosize:"",placeholder:"请输入规划名称"},model:{value:e.create.mc,callback:function(t){e.$set(e.create,"mc",t)},expression:"create.mc"}})],1),e._v(" "),a("el-form-item",{staticStyle:{width:"40%"},attrs:{label:"所属层面：",prop:"mc",required:""}},[a("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择项目重要程度"},model:{value:e.create.cengmian,callback:function(t){e.$set(e.create,"cengmian",t)},expression:"create.cengmian"}},e._l(e.option3,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)],1),e._v(" "),a("div",{staticClass:"form_item"},[a("el-form-item",{staticClass:"fzr",attrs:{label:"负责人："}},[a("el-col",{staticStyle:{width:"100%",padding:"0"},attrs:{span:12}},[a("el-autocomplete",{staticClass:"inline-input",attrs:{"fetch-suggestions":e.queSearch,placeholder:"请选择负责人",clearable:""},on:{select:e.fzr},model:{value:e.create.fzr,callback:function(t){e.$set(e.create,"fzr",t)},expression:"create.fzr"}})],1)],1),e._v(" "),a("el-form-item",{staticClass:"jfys",attrs:{label:"经费预算：",prop:"jfys"}},[a("el-input",{attrs:{type:"number",placeholder:"请输入金额",autocomplete:"off"},model:{value:e.create.jfys,callback:function(t){e.$set(e.create,"jfys",t)},expression:"create.jfys"}},[a("template",{slot:"append"},[e._v("万元")])],2)],1),e._v(" "),a("el-form-item",{staticClass:"important",attrs:{label:"紧急程度：",prop:"important"}},[a("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择项目重要程度"},model:{value:e.create.important,callback:function(t){e.$set(e.create,"important",t)},expression:"create.important"}},e._l(e.option2,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)],1),e._v(" "),a("div",{staticClass:"form_item"},[a("el-form-item",{staticClass:"starrttime",attrs:{label:"开始时间：",prop:"start"}},[a("el-date-picker",{attrs:{type:"date",placeholder:"选择开始日期"},model:{value:e.create.start,callback:function(t){e.$set(e.create,"start",t)},expression:"create.start"}})],1),e._v(" "),a("el-form-item",{staticClass:"endtime",attrs:{label:"结束时间：",prop:"end"}},[a("el-date-picker",{attrs:{type:"date",placeholder:"选择结束日期"},model:{value:e.create.end,callback:function(t){e.$set(e.create,"end",t)},expression:"create.end"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"参与人：",prop:"cyr"}},[a("el-select",{staticStyle:{width:"100%"},attrs:{multiple:"",filterable:"",placeholder:"请选择参与人"},model:{value:e.create.cyr,callback:function(t){e.$set(e.create,"cyr",t)},expression:"create.cyr"}},e._l(e.options,function(t){return a("el-option",{key:t.value,attrs:{label:t.label,value:t.value,disabled:t.label==e.create.fzr}})}),1)],1),e._v(" "),a("div",{staticClass:"khbz"},[a("el-form-item",{staticStyle:{width:"33%","margin-right":"35px"},attrs:{label:"考核指标：",prop:"khzb"}},[a("el-col",{staticStyle:{width:"100%",padding:"0"},attrs:{span:12}},[a("el-autocomplete",{staticClass:"inline-input",attrs:{"fetch-suggestions":e.querySearch,placeholder:"请输入内容",clearable:""},on:{select:e.handleSelect},model:{value:e.create.khzb,callback:function(t){e.$set(e.create,"khzb",t)},expression:"create.khzb"}})],1)],1),e._v(" "),a("el-form-item",{staticStyle:{flex:"1"},attrs:{label:"诊改目标：",prop:"zgmb"}},[a("div",{staticClass:"zhengaimubiao"},[a("el-select",{staticClass:"mb_mark",attrs:{placeholder:"请选择"},model:{value:e.create.mark,callback:function(t){e.$set(e.create,"mark",t)},expression:"create.mark"}},e._l(e.option1,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1),e._v(" "),a("el-input",{staticClass:"mb_ipt1",attrs:{placeholder:"请输入目标",autocomplete:"off"},model:{value:e.create.zgmb,callback:function(t){e.$set(e.create,"zgmb",t)},expression:"create.zgmb"}})],1)])],1),e._v(" "),a("el-form-item",{attrs:{label:"规划简介：",prop:"jj"}},[a("el-input",{attrs:{type:"textarea",autosize:{minRows:6},placeholder:"请输入简介内容"},model:{value:e.create.jj,callback:function(t){e.$set(e.create,"jj",t)},expression:"create.jj"}})],1)],1),e._v(" "),a("div",{staticClass:"add-footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.set(e.create)}}},[e._v("创 建")]),e._v(" "),a("el-button",{on:{click:function(t){return e.back()}}},[e._v("返 回")])],1)],1)],1)],1)],1)},staticRenderFns:[]};var c=a("C7Lr")(l,s,!1,function(e){a("52YO")},null,null);t.default=c.exports}});
//# sourceMappingURL=8.ead27a02bb44bc8ec2c5.js.map