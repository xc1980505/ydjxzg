webpackJsonp([14],{"274U":function(a,t){},nrSB:function(a,t,e){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s={name:"kcgk",data:function(){return{list:[],pagesize:10,currpage:1,activeName:"first",chart:!1,xData:[],yData:[],tableHeader1:["课程","课程性质","年级名称","专业"],tableProp1:["kcmc","kcxzmc","njmc","zymc"],tableData1:[],baroption1:{id:"chart1",title:"精品课程数量同比图",param:[],dm:[],btn:"1",xAxis:[{data:["信息工程系","机电工程汽车系","人文系","财贸经济系","外语系","规划建筑工程系","园林与食品工程学院","互联网学院","艺术系"],axisLabel:{rotate:0}}],yAxis:[{name:"(人)"}],series:[{name:"人数",data:[1570,1300,1146,915,710,616,500,415,320]}]},baroption2:{id:"chart2",title:"新增/淘汰课程同比图",param:[],dm:[],btn:"1",legend:{data:["新增","淘汰"],right:"10%",bottom:"0"},xAxis:[{data:[],axisLabel:{rotate:0}}],yAxis:[{name:"(人)"}],series:[{name:"新增课程",type:"bar",data:[]},{name:"淘汰课程",type:"bar",data:[]}]},baroption3:{id:"chart3",title:"使用在线教学课程数量同比图",param:[],dm:[],btn:"1",xAxis:[{data:["信息工程系","机电工程汽车系","人文系","财贸经济系","外语系","规划建筑工程系","园林与食品工程学院","互联网学院","艺术系"],axisLabel:{rotate:0}}],yAxis:[{name:"(人)"}],series:[{name:"人数",data:[1570,1300,1146,915,710,616,500,415,320]}]},value1:"全部",value2:"全部",options1:[{key:"1",value:[{date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2016-05-04",name:"张小虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2016-05-01",name:"李小虎",address:"上海市普陀区金沙江路 1519 弄"},{date:"2016-05-03",name:"赵小虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2016-05-04",name:"张小虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2016-05-01",name:"李小虎",address:"上海市普陀区金沙江路 1519 弄"},{date:"2016-05-03",name:"赵小虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2016-05-04",name:"张小虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2016-05-01",name:"李小虎",address:"上海市普陀区金沙江路 1519 弄"},{date:"2016-05-03",name:"赵小虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2016-05-04",name:"张小虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2016-05-04",name:"张小虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2016-05-01",name:"李小虎",address:"上海市普陀区金沙江路 1519 弄"},{date:"2016-05-03",name:"赵小虎",address:"上海市普陀区金沙江路 1516 弄"}],label:"全部"},{key:"2",value:[{date:"2018-05-02",name:"王虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2018-05-04",name:"张虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2018-05-01",name:"李虎",address:"上海市普陀区金沙江路 1519 弄"},{date:"2018-05-03",name:"赵虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2018-05-02",name:"王虎",address:"上海市普陀区金沙江路 1518 弄"}],label:"实验室"}],options2:[{key:"1",value:[{date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2016-05-04",name:"张小虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2016-05-01",name:"李小虎",address:"上海市普陀区金沙江路 1519 弄"},{date:"2016-05-03",name:"赵小虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2016-05-04",name:"张小虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2016-05-01",name:"李小虎",address:"上海市普陀区金沙江路 1519 弄"},{date:"2016-05-03",name:"赵小虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2016-05-04",name:"张小虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2016-05-01",name:"李小虎",address:"上海市普陀区金沙江路 1519 弄"},{date:"2016-05-03",name:"赵小虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2016-05-04",name:"张小虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2016-05-04",name:"张小虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2016-05-01",name:"李小虎",address:"上海市普陀区金沙江路 1519 弄"},{date:"2016-05-03",name:"赵小虎",address:"上海市普陀区金沙江路 1516 弄"}],label:"全部"},{key:"2",value:[{date:"2017-05-02",name:"王虎",address:"上海市普陀区金沙江路 1518 弄"},{date:"2017-05-04",name:"张虎",address:"上海市普陀区金沙江路 1517 弄"},{date:"2017-05-01",name:"李虎",address:"上海市普陀区金沙江路 1519 弄"},{date:"2017-05-03",name:"赵虎",address:"上海市普陀区金沙江路 1516 弄"},{date:"2017-05-02",name:"王虎",address:"上海市普陀区金沙江路 1518 弄"}],label:"学生宿舍"}]}},methods:{handleClick:function(a,t){},formatter:function(a,t){return a.address},getValue:function(a){this.tableData=a},handleCurrentChange:function(a){this.currpage=a},handleSizeChange:function(a){this.pagesize=a}},components:{barCharts:e("zeHI").a},mounted:function(){var a=this;$.ajax({type:"post",url:a.baseUrl+"/ydjxzg/hx/xsgl.action",data:{reg:"xxkcgk",style:"1"},dataType:"json",success:function(t){if(401==t.code)location.href=a.baseUrl01,console.log("判断进入了401，马上开始跳转");else if(403==t.code)console.log("判断进入了403，马上开始跳转"),sessionStorage.setItem("login","nop"),a.$router.push({path:"/p403m",name:"p403m"});else{if(console.log(t),t.jpkctbt){a.xData=[],a.yData=[],a.baroption1.param.push(t.jpkctbt[0].param1);for(var e=1;e<t.jpkctbt[1].length;e++)a.xData.push(t.jpkctbt[1][e].mc),a.yData.push(t.jpkctbt[1][e].zcount),t.jpkctbt[1][e].dm&&a.baroption1.dm.push(t.jpkctbt[1][e].dm);a.baroption1.xAxis[0].data=a.xData,a.baroption1.series[0].data=a.yData}for(e=0;e<t.kcList[1].length;e++)a.tableData1.push(t.kcList[1][e]);if(t.xzttkc){a.xData=[],a.yData=[],a.baroption2.param.push(t.xzttkc[0].param1);for(e=0;e<t.xzttkc[1].length;e++)a.xData.push(t.xzttkc[1][e].mc),a.baroption2.series[0].data.push(t.xzttkc[1][e].zcount),a.baroption2.series[1].data.push(t.xzttkc[1][e].xcount);a.baroption2.xAxis[0].data=a.xData,console.log(a.baroption2)}if(t.zxkctbt){a.xData=[],a.yData=[],a.baroption3.param.push(t.zxkctbt[0].param1);for(e=0;e<t.zxkctbt[1].length;e++)a.xData.push(t.zxkctbt[1][e].mc),a.yData.push(t.zxkctbt[1][e].zcount),t.zxkctbt[1][e].dm&&a.baroption3.dm.push(t.zxkctbt[1][e].dm);a.baroption3.xAxis[0].data=a.xData,a.baroption3.series[0].data=a.yData}if(t.kcList){a.xData=[],a.yData=[],a.baroption3.param.push(t.zxkctbt[0].param1);for(e=0;e<t.zxkctbt[1].length;e++)a.xData.push(t.zxkctbt[1][e].mc),a.yData.push(t.zxkctbt[1][e].zcount),t.zxkctbt[1][e].dm&&a.baroption3.dm.push(t.zxkctbt[1][e].dm);a.baroption3.xAxis[0].data=a.xData,a.baroption3.series[0].data=a.yData}a.chart=!0}},error:function(a){console.log(a)}})}},l={render:function(){var a=this,t=a.$createElement,e=a._self._c||t;return e("div",{attrs:{id:"kecheng"}},[e("el-tabs",{on:{"tab-click":a.handleClick},model:{value:a.activeName,callback:function(t){a.activeName=t},expression:"activeName"}},[e("el-tab-pane",{attrs:{label:"课程清单",name:"first",lazy:""}},[e("el-row",{staticStyle:{width:"90%",margin:"0 auto"},attrs:{gutter:12}},[e("el-card",{staticStyle:{"margin-top":"40px",padding:"0"},attrs:{shadow:"always"}},[e("div",{staticClass:"title"},[a._v("课程清单")]),a._v(" "),e("div",{staticClass:"shaixuan_box",staticStyle:{"margin-left":"10px","font-size":"14px"}},[e("div",{staticStyle:{display:"inline-block"}},[e("span",[a._v("筛选：")]),a._v(" "),e("el-select",{staticStyle:{width:"148px"},attrs:{placeholder:"请选择",size:"small"},on:{change:a.getValue},model:{value:a.value1,callback:function(t){a.value1=t},expression:"value1"}},a._l(a.options1,function(a){return e("el-option",{key:a.key,attrs:{label:a.label,value:a.value}})}),1)],1),a._v(" "),e("div",{staticStyle:{display:"inline-block"}},[e("el-select",{staticStyle:{width:"148px"},attrs:{placeholder:"请选择",size:"small"},on:{change:a.getValue},model:{value:a.value2,callback:function(t){a.value2=t},expression:"value2"}},a._l(a.options2,function(a){return e("el-option",{key:a.key,attrs:{label:a.label,value:a.value}})}),1)],1),a._v(" "),e("el-button",{staticStyle:{float:"right"},attrs:{type:"primary",size:"small",icon:"el-icon-document"}},[a._v("导出")])],1),a._v(" "),e("el-table",{staticStyle:{width:"100%"},attrs:{data:a.tableData1.slice((a.currpage-1)*a.pagesize,a.currpage*a.pagesize),stripe:"","default-sort":{prop:"date",order:"descending"}}},[a.tableHeader1[0]?e("el-table-column",{attrs:{prop:a.tableProp1[0],label:a.tableHeader1[0],sortable:""}}):a._e(),a._v(" "),a.tableHeader1[1]?e("el-table-column",{attrs:{prop:a.tableProp1[1],label:a.tableHeader1[1],sortable:""}}):a._e(),a._v(" "),a.tableHeader1[2]?e("el-table-column",{attrs:{prop:a.tableProp1[2],label:a.tableHeader1[2],sortable:""}}):a._e(),a._v(" "),a.tableHeader1[3]?e("el-table-column",{attrs:{prop:a.tableProp1[3],label:a.tableHeader1[3],sortable:""}}):a._e(),a._v(" "),a.tableHeader1[4]?e("el-table-column",{attrs:{prop:a.tableProp1[4],label:a.tableHeader1[4],sortable:""}}):a._e(),a._v(" "),a.tableHeader1[5]?e("el-table-column",{attrs:{prop:a.tableProp1[5],label:a.tableHeader1[5],sortable:""}}):a._e(),a._v(" "),a.tableHeader1[6]?e("el-table-column",{attrs:{prop:a.tableProp1[6],label:a.tableHeader1[6],sortable:""}}):a._e(),a._v(" "),a.tableHeader1[7]?e("el-table-column",{attrs:{prop:a.tableProp1[7],label:a.tableHeader1[7],sortable:""}}):a._e(),a._v(" "),a.tableHeader1[8]?e("el-table-column",{attrs:{prop:a.tableProp1[8],label:a.tableHeader1[8],sortable:""}}):a._e()],1)],1),a._v(" "),e("el-pagination",{staticStyle:{"margin-top":"30px"},attrs:{background:"",layout:"prev, pager, next, sizes, total, jumper","page-sizes":[5,10,15,20],"page-size":a.pagesize,total:a.tableData1.length},on:{"current-change":a.handleCurrentChange,"size-change":a.handleSizeChange}})],1)],1),a._v(" "),e("el-tab-pane",{attrs:{label:"精品课程数量同比图",name:"second",lazy:""}},[e("el-row",{staticClass:"row",attrs:{gutter:12}},[e("el-col",{staticClass:"col"},[e("el-card",{attrs:{shadow:"always"}},[a.chart?e("barCharts",{attrs:{op:a.baroption1}}):a._e()],1)],1),a._v(" "),e("el-col",{staticClass:"coltips"},[e("el-card",{staticClass:"tipheight",attrs:{shadow:"always"}},[e("div",{staticClass:"tips"},[a._v("说明:")]),a._v(" "),e("p",{staticClass:"tippoint"},[a._v("根据教育部2010年《中等职业学校设置标准(教职成[2010]12号)》文件要求，中职学校占地面积"),e("span",{staticStyle:{color:"red"}},[a._v("不少于40000m²")]),a._v("。")])])],1)],1)],1),a._v(" "),e("el-tab-pane",{attrs:{label:"新增/淘汰课程同比图",name:"third",lazy:""}},[e("el-row",{staticClass:"row",attrs:{gutter:12}},[e("el-col",{staticClass:"col"},[e("el-card",{attrs:{shadow:"always"}},[a.chart?e("barCharts",{attrs:{op:a.baroption2}}):a._e()],1)],1),a._v(" "),e("el-col",{staticClass:"coltips"},[e("el-card",{staticClass:"tipheight",attrs:{shadow:"always"}},[e("div",{staticClass:"tips"},[a._v("说明:")]),a._v(" "),e("p",{staticClass:"tippoint"},[a._v("根据教育部2010年《中等职业学校设置标准(教职成[2010]12号)》文件要求，中职学校占地面积"),e("span",{staticStyle:{color:"red"}},[a._v("不少于40000m²")]),a._v("。")])])],1)],1)],1),a._v(" "),e("el-tab-pane",{attrs:{label:"使用在线教学课程数量同比图",name:"fourth",lazy:""}},[e("el-row",{staticClass:"row",attrs:{gutter:12}},[e("el-col",{staticClass:"col"},[e("el-card",{attrs:{shadow:"always"}},[a.chart?e("barCharts",{attrs:{op:a.baroption3}}):a._e()],1)],1),a._v(" "),e("el-col",{staticClass:"coltips"},[e("el-card",{staticClass:"tipheight",attrs:{shadow:"always"}},[e("div",{staticClass:"tips"},[a._v("说明:")]),a._v(" "),e("p",{staticClass:"tippoint"},[a._v("根据教育部2010年《中等职业学校设置标准(教职成[2010]12号)》文件要求，中职学校占地面积"),e("span",{staticStyle:{color:"red"}},[a._v("不少于40000m²")]),a._v("。")])])],1)],1)],1)],1)],1)},staticRenderFns:[]};var r=e("C7Lr")(s,l,!1,function(a){e("274U")},null,null);t.default=r.exports}});
//# sourceMappingURL=14.850ea82b6d67ac54b90e.js.map