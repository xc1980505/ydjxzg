webpackJsonp([11],{C11b:function(a,t){},KfDQ:function(a,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var e={name:"szjg",data:function(){return{xData:[],yData:[],activeName:"first",char:!1,baroption1:{id:"chart1",title:"人才引进排名",xAxis:[{data:[],axisLabel:{rotate:-20}}],yAxis:[{name:"(人)"}],series:[{name:"人数",data:[]}]},baroption2:{id:"chart2",title:"拥有专业中级以上职称的教师数量",xAxis:[{data:[],axisLabel:{rotate:-20}}],yAxis:[{name:"(人)"}],series:[{name:"人数",data:[]}]},baroption3:{id:"chart3",title:"师资学历对比图",legend:{data:["本科","大专","研究生","中专"],right:"10%",bottom:"0"},xAxis:[{data:[],axisLabel:{rotate:-20}}],yAxis:[{name:"(人)"}],series:[{name:"本科",type:"bar",stack:"学历",data:[]},{name:"大专",type:"bar",stack:"学历",data:[]},{name:"研究生",type:"bar",stack:"学历",data:[]},{name:"中专",type:"bar",stack:"学历",data:[]}]},baroption4:{id:"chart4",title:"师资职称对比图",legend:{data:["初级教师","中级教师","高级教师"],right:"10%",bottom:"0"},xAxis:[{data:[],axisLabel:{rotate:-20}}],yAxis:[{name:"(人)"}],series:[{name:"初级教师",type:"bar",stack:"广告",data:[]},{name:"中级教师",type:"bar",stack:"广告",data:[]},{name:"高级教师",type:"bar",stack:"广告",data:[]}]},baroption5:{id:"chart5",title:"双师型教师比例排名",xAxis:[{data:[],axisLabel:{rotate:0}}],yAxis:[{name:"(人)"}],series:[{name:"比例",data:[]}]},baroption6:{id:"chart6",title:"专兼职教师数量对比图",legend:{data:["专职教师","兼职教师"],right:"10%",bottom:"0"},xAxis:[{data:[],axisLabel:{rotate:-20}}],yAxis:[{name:"(人)"}],series:[{name:"专职教师",type:"bar",stack:"教师",data:[]},{name:"兼职教师",type:"bar",stack:"教师",data:[]}]},baroption7:{id:"chart7",title:"文化课专业课教师数量对比图",legend:{data:["文化课教师","专业课教师"],right:"10%",bottom:"0"},xAxis:[{data:[],axisLabel:{rotate:-20}}],yAxis:[{name:"(人)"}],series:[{name:"文化课教师",type:"bar",stack:"教师",data:[]},{name:"专业课教师",type:"bar",stack:"教师",data:[]}]},baroption:{color:["#029348"],tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},xAxis:[{type:"category",data:null,axisLabel:{interval:0,rotate:-20,fontSize:12}}],yAxis:[{name:"(人)",type:"value"}],series:[{name:"人数",type:"bar",data:null,itemStyle:{normal:{label:{show:!0,position:"top",textStyle:{color:"#029348",fontSize:14}}}}}]},stack:{color:["rgb(53,143,226)","rgb(124,179,73)","rgb(228,39,57)","rgb(128,146,149)","rgb(118,131,149)","rgb(239,134,41)","rgb(80,80,80)","rgb(240,240,240)"],tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},legend:{right:"10%",bottom:"0"},xAxis:[{type:"category",data:null,axisLabel:{interval:0,rotate:-20,fontSize:12}}],yAxis:[{name:"(人)",type:"value"}],series:[]},value1:"全部",value2:"全部",value3:"全部",options1:[{key:"1",value:["chart1","-20",["电脑室","化学实验室","图书室","体育室"],[561,245,543,423]],label:"全部"},{key:"2",value:["chart1","0",["教室","化学室","书本","椅子"],[261,255,343,223]],label:"专业"}],options2:[{key:"1",value:["chart2","-20",["电脑室","化学实验室","图书室","体育室"],[561,245,543,423]],label:"全部"},{key:"2",value:["chart2","0",["教室","化学室","书本","椅子"],[261,255,343,223]],label:"专业"}],options3:[{key:"1",value:["chart5","0",["电脑室","化学实验室","图书室","体育室"],["邮件营销","联盟广告","视频广告"],[{name:"邮件营销",type:"bar",stack:"广告",data:[120,132,101,134]},{name:"联盟广告",type:"bar",stack:"广告",data:[220,182,191,234]},{name:"视频广告",type:"bar",stack:"广告",data:[150,232,201,154]}]],label:"全部"},{key:"2",value:["chart5","0",["电脑室","化学实验室","图书室","体育室"],["营销","广告","视频"],[{name:"营销",type:"bar",stack:"广告",data:[20,32,11,34]},{name:"广告",type:"bar",stack:"广告",data:[22,12,11,23]},{name:"视频",type:"bar",stack:"广告",data:[10,22,21,14]}]],label:"专业"}]}},methods:{handleClick:function(a,t){},handleCurrentChange:function(a){this.currentRow=a},getValue:function(a){console.log(a);var t=this.$echarts.init(document.getElementById(a[0]));a.length>4?(this.stack.xAxis[0].axisLabel.rotate=a[1],this.stack.xAxis[0].data=a[2],this.stack.legend.data=a[3],this.stack.series=a[4],t.clear(),t.setOption(this.stack,!0)):(this.baroption.xAxis[0].axisLabel.rotate=a[1],this.baroption.xAxis[0].data=a[2],this.baroption.series[0].data=a[3],t.clear(),t.setOption(this.baroption,!0))}},components:{barCharts:s("zeHI").a},mounted:function(){var a=this;$.ajax({type:"post",url:a.baseUrl+"/ydjxzg/hx/xsgl.action",data:{reg:"zyszjg",style:"1"},dataType:"json",success:function(t){if(console.log(t),t.rcyjpm){a.xData=[],a.yData=[];for(var s=1;s<t.rcyjpm.length;s++)a.xData.push(t.rcyjpm[s].mc),a.yData.push(t.rcyjpm[s].zcount);a.baroption1.xAxis[0].data=a.xData,a.baroption1.series[0].data=a.yData}if(t.zjjssl){a.xData=[],a.yData=[];for(s=1;s<t.zjjssl.length;s++)a.xData.push(t.zjjssl[s].mc),a.yData.push(t.zjjssl[s].zcount);a.baroption2.xAxis[0].data=a.xData,a.baroption2.series[0].data=a.yData}if(t.zyszxldjbt){a.xData=[],a.yData=[];for(s=1;s<t.zyszxldjbt.length;s++){a.xData.push(t.zyszxldjbt[s].nf);for(var e=0;e<t.zyszxldjbt[s].tjList.length;e++)a.baroption3.series[e].data.push(t.zyszxldjbt[s].tjList[e].zcount)}a.baroption3.xAxis[0].data=a.xData,console.log(a.baroption3)}if(t.jszcdjt){a.xData=[],a.yData=[];for(s=1;s<t.jszcdjt.length;s++){a.xData.push(t.jszcdjt[s].nf);for(e=0;e<t.jszcdjt[s].tjList.length;e++)a.baroption4.series[e].data.push(t.jszcdjt[s].tjList[e].zcount)}a.baroption4.xAxis[0].data=a.xData,console.log(a.baroption4)}if(t.ssxjsblpm){a.xData=[],a.yData=[];for(s=1;s<t.ssxjsblpm.length;s++)a.xData.push(t.ssxjsblpm[s].mc),a.yData.push(100*t.ssxjsblpm[s].zj);a.baroption5.yAxis[0].name="%",a.baroption5.xAxis[0].data=a.xData,a.baroption5.series[0].data=a.yData}if(t.zjzjsdjt){a.xData=[],a.yData=[];for(s=1;s<t.zjzjsdjt.length;s++){a.xData.push(t.zjzjsdjt[s].nf);for(e=0;e<t.zjzjsdjt[s].tjList.length;e++)a.baroption6.series[e].data.push(t.zjzjsdjt[s].tjList[e].zcount)}a.baroption6.xAxis[0].data=a.xData,console.log(a.baroption6)}if(t.whzyjsdjt){a.xData=[],a.yData=[];for(s=1;s<t.whzyjsdjt.length;s++){a.xData.push(t.whzyjsdjt[s].nf);for(e=0;e<t.whzyjsdjt[s].tjList.length;e++)a.baroption7.series[e].data.push(t.whzyjsdjt[s].tjList[e].zcount)}a.baroption7.xAxis[0].data=a.xData,console.log(a.baroption7)}a.char=!0},error:function(a){console.log(a)}})}},l={render:function(){var a=this,t=a.$createElement,s=a._self._c||t;return s("div",{attrs:{id:"szjg"}},[s("el-tabs",{on:{"tab-click":a.handleClick},model:{value:a.activeName,callback:function(t){a.activeName=t},expression:"activeName"}},[s("el-tab-pane",{attrs:{label:"人才引进排名",name:"first",lazy:""}},[s("el-row",{staticClass:"row",attrs:{gutter:12}},[s("el-col",{staticClass:"col"},[s("el-card",{attrs:{shadow:"always"}},[s("div",{staticClass:"shaixuan_box"},[s("div",{staticStyle:{display:"inline-block"}},[s("span",[a._v("筛选：")]),a._v(" "),s("el-select",{staticStyle:{width:"148px"},attrs:{placeholder:"请选择",size:"small"},on:{change:a.getValue},model:{value:a.value1,callback:function(t){a.value1=t},expression:"value1"}},a._l(a.options1,function(a){return s("el-option",{key:a.key,attrs:{label:a.label,value:a.value}})}))],1)]),a._v(" "),a.char?s("barCharts",{attrs:{op:a.baroption1}}):a._e()],1)],1),a._v(" "),s("el-col",{staticClass:"coltips"},[s("el-card",{staticClass:"tipheight tip_select",attrs:{shadow:"always"}},[s("div",{staticClass:"tips"},[a._v("说明:")]),a._v(" "),s("p",{staticClass:"tippoint"},[a._v("根据教育部2010年《中等职业学校设置标准(教职成[2010]12号)》文件要求，中职学校占地面积"),s("span",{staticStyle:{color:"red"}},[a._v("不少于40000m²")]),a._v("。")])])],1)],1)],1),a._v(" "),s("el-tab-pane",{attrs:{label:"拥有专业中级以上职称的教师数量",name:"second",lazy:""}},[s("el-row",{staticClass:"row",attrs:{gutter:12}},[s("el-col",{staticClass:"col"},[s("el-card",{attrs:{shadow:"always"}},[s("div",{staticClass:"shaixuan_box"},[s("div",{staticStyle:{display:"inline-block"}},[s("span",[a._v("筛选：")]),a._v(" "),s("el-select",{staticStyle:{width:"148px"},attrs:{placeholder:"请选择",size:"small"},on:{change:a.getValue},model:{value:a.value2,callback:function(t){a.value2=t},expression:"value2"}},a._l(a.options2,function(a){return s("el-option",{key:a.key,attrs:{label:a.label,value:a.value}})}))],1)]),a._v(" "),a.char?s("barCharts",{attrs:{op:a.baroption2}}):a._e()],1)],1),a._v(" "),s("el-col",{staticClass:"coltips"},[s("el-card",{staticClass:"tipheight tip_select",attrs:{shadow:"always"}},[s("div",{staticClass:"tips"},[a._v("说明:")]),a._v(" "),s("p",{staticClass:"tippoint"},[a._v("根据教育部2010年《中等职业学校设置标准(教职成[2010]12号)》文件要求，中职学校占地面积"),s("span",{staticStyle:{color:"red"}},[a._v("不少于40000m²")]),a._v("。")])])],1)],1)],1),a._v(" "),s("el-tab-pane",{attrs:{label:"师资学历对比图",name:"third",lazy:""}},[s("el-row",{staticClass:"row",attrs:{gutter:12}},[s("el-col",{staticClass:"col"},[s("el-card",{attrs:{shadow:"always"}},[a.char?s("barCharts",{attrs:{op:a.baroption3}}):a._e()],1)],1),a._v(" "),s("el-col",{staticClass:"coltips"},[s("el-card",{staticClass:"tipheight",attrs:{shadow:"always"}},[s("div",{staticClass:"tips"},[a._v("说明:")]),a._v(" "),s("p",{staticClass:"tippoint"},[a._v("根据教育部2010年《中等职业学校设置标准(教职成[2010]12号)》文件要求，中职学校占地面积"),s("span",{staticStyle:{color:"red"}},[a._v("不少于40000m²")]),a._v("。")])])],1)],1)],1),a._v(" "),s("el-tab-pane",{attrs:{label:"师资职称对比图",name:"fourth",lazy:""}},[s("el-row",{staticClass:"row",attrs:{gutter:12}},[s("el-col",{staticClass:"col"},[s("el-card",{attrs:{shadow:"always"}},[a.char?s("barCharts",{attrs:{op:a.baroption4}}):a._e()],1)],1),a._v(" "),s("el-col",{staticClass:"coltips"},[s("el-card",{staticClass:"tipheight",attrs:{shadow:"always"}},[s("div",{staticClass:"tips"},[a._v("说明:")]),a._v(" "),s("p",{staticClass:"tippoint"},[a._v("根据教育部2010年《中等职业学校设置标准(教职成[2010]12号)》文件要求，中职学校占地面积"),s("span",{staticStyle:{color:"red"}},[a._v("不少于40000m²")]),a._v("。")])])],1)],1)],1),a._v(" "),s("el-tab-pane",{attrs:{label:"双师型教师比例排名表",name:"fifth",lazy:""}},[s("el-row",{staticClass:"row",attrs:{gutter:12}},[s("el-col",{staticClass:"col"},[s("el-card",{attrs:{shadow:"always"}},[s("div",{staticClass:"shaixuan_box"},[s("div",{staticStyle:{display:"inline-block"}},[s("span",[a._v("筛选：")]),a._v(" "),s("el-select",{staticStyle:{width:"148px"},attrs:{placeholder:"请选择",size:"small"},on:{change:a.getValue},model:{value:a.value3,callback:function(t){a.value3=t},expression:"value3"}},a._l(a.options3,function(a){return s("el-option",{key:a.key,attrs:{label:a.label,value:a.value}})}))],1)]),a._v(" "),a.char?s("barCharts",{attrs:{op:a.baroption5}}):a._e()],1)],1),a._v(" "),s("el-col",{staticClass:"coltips"},[s("el-card",{staticClass:"tipheight tip_select",attrs:{shadow:"always"}},[s("div",{staticClass:"tips"},[a._v("说明:")]),a._v(" "),s("p",{staticClass:"tippoint"},[a._v("根据教育部2010年《中等职业学校设置标准(教职成[2010]12号)》文件要求，中职学校占地面积"),s("span",{staticStyle:{color:"red"}},[a._v("不少于40000m²")]),a._v("。")])])],1)],1)],1),a._v(" "),s("el-tab-pane",{attrs:{label:"专兼职教师数量对比图",name:"sixth",lazy:""}},[s("el-row",{staticClass:"row",attrs:{gutter:12}},[s("el-col",{staticClass:"col"},[s("el-card",{attrs:{shadow:"always"}},[a.char?s("barCharts",{attrs:{op:a.baroption6}}):a._e()],1)],1),a._v(" "),s("el-col",{staticClass:"coltips"},[s("el-card",{staticClass:"tipheight",attrs:{shadow:"always"}},[s("div",{staticClass:"tips"},[a._v("说明:")]),a._v(" "),s("p",{staticClass:"tippoint"},[a._v("根据教育部2010年《中等职业学校设置标准(教职成[2010]12号)》文件要求，中职学校占地面积"),s("span",{staticStyle:{color:"red"}},[a._v("不少于40000m²")]),a._v("。")])])],1)],1)],1),a._v(" "),s("el-tab-pane",{attrs:{label:"文化课专业课教师数量对比图",name:"seventh",lazy:""}},[s("el-row",{staticClass:"row",attrs:{gutter:12}},[s("el-col",{staticClass:"col"},[s("el-card",{attrs:{shadow:"always"}},[a.char?s("barCharts",{attrs:{op:a.baroption7}}):a._e()],1)],1),a._v(" "),s("el-col",{staticClass:"coltips"},[s("el-card",{staticClass:"tipheight",attrs:{shadow:"always"}},[s("div",{staticClass:"tips"},[a._v("说明:")]),a._v(" "),s("p",{staticClass:"tippoint"},[a._v("根据教育部2010年《中等职业学校设置标准(教职成[2010]12号)》文件要求，中职学校占地面积"),s("span",{staticStyle:{color:"red"}},[a._v("不少于40000m²")]),a._v("。")])])],1)],1)],1)],1)],1)},staticRenderFns:[]};var i=s("VU/8")(e,l,!1,function(a){s("C11b")},null,null);t.default=i.exports}});
//# sourceMappingURL=11.31a85646eb775728367b.js.map