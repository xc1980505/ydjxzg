webpackJsonp([5],{"8jC+":function(t,a,s){"use strict";Object.defineProperty(a,"__esModule",{value:!0});var i=s("zeHI"),e=s("SvRP"),n={props:["datainfo"],data:function(){return{data1:{title:"学校占地面积",num:"99900",num1:"1",type:"㎡",tips:"不少于40000㎡"},data2:{title:"生均用地指标",num:"40",num1:"2",type:"㎡",tips:"不少于33㎡"},data3:{title:"生均校舍面积",num:"30",num1:"3",type:"㎡",tips:"不少于20㎡"},data4:{title:"体育用地面积",num:"2300",num1:"4",type:"㎡",tips:"暂无"},data5:{title:"专任教师数量",num:"80",num1:"5",type:"人",tips:"不少于60人"},data6:{title:"高级技术职务者比例",num:"N/A",num1:"6",type:"",tips:"不低于20%"},data7:{title:"双师型教师比例",num:"35%",num1:"7",type:"",tips:"不低于30%"},data8:{title:"生均纸质图书",num:"35",num1:"8",type:"册",tips:"不少于30册"},data9:{title:"报刊种类",num:"103",num1:"9",type:"种",tips:"不低于80种"},data10:{title:"教师阅览室座位数",num:"22%",num1:"10",type:"",tips:"不低于20%"},data11:{title:"学生阅览室座位数",num:"15%",num1:"11",type:"",tips:"不低于10%"},data12:{title:"校内实训工位数",num:"321",num1:"12",type:"",tips:"暂无"},data13:{title:"校外实习基地数量",num:"145",num1:"13",type:"",tips:"暂无"},data14:{title:"计算机生均拥有量",num:"20",num1:"14",type:"台/百人",tips:"不少于15台/百人"}}},methods:{getData:function(t){var a=this;if(console.log(t),"1"==t.num1)this.$router.push({path:"/schoolMap"});else if("4"==t.num1)this.$router.push({path:"/schoolMap"});else{if("2"==t.num1){t={reg:"sjydtbt",style:"2"};var s="0"}if("3"==t.num1)t={reg:"sjxsmjtbt",style:"2"},s="0";if("5"==t.num1)t={reg:"gjgslbt",style:"2"};if("6"==t.num1)t={reg:"gzyzrjsb",style:"2"};if("7"==t.num1)t={reg:"gzyssxjsbl",style:"2"};if("8"==t.num1)t={reg:"xxzztstbt",style:"2"},s="0";if("9"==t.num1)t={reg:"bkzltbt",style:"2"};if("10"==t.num1)t={reg:"jzgylstbt",style:"2"};if("11"==t.num1)t={reg:"xsylstbt",style:"2"};if("12"==t.num1)t={reg:"xnsxgwstb",style:"2"},s="0";if("13"==t.num1)t={reg:"xwjdtb",style:"2"},s="0";if("14"==t.num1)t={reg:"jsjtbt",style:"2"},s="0";a=this;$.ajax({type:"post",url:a.baseUrl+"/ydjxzg/hx/xsgl.action",data:t,dataType:"json",success:function(t){console.log(t),"bt"==t.type&&a.$router.push({path:"/detail",name:"detail",params:{title:t.title,dataCount1:t.dataCount,param:t.param1,rotate:s,type:"bt"}}),a.$router.push({path:"/detail",name:"detail",params:{title:t.title,dataCount1:t.dataCount,param:t.param1,rotate:s}})},error:function(t){console.log(t)}})}}},mounted:function(){}},l={render:function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"card-1"},[s("div",{staticClass:"cardItems",staticStyle:{border:"0"}},[s("div",{staticClass:"item",on:{click:function(a){t.getData(t.data1)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data1.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("span",{staticClass:"itemNum itemColor1"},[t._v(t._s(t.datainfo[0].num))]),t._v(" "+t._s(t.data1.type)+"\n      ")]),t._v(" "),s("div",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data1.tips))])]),t._v(" "),s("div",{staticClass:"item",on:{click:function(a){t.getData(t.data2)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data2.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor2"},[t._v(t._s(t.datainfo[1].num))]),t._v(" "+t._s(t.data2.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data2.tips))])]),t._v(" "),s("div",{staticClass:"item",on:{click:function(a){t.getData(t.data3)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data3.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor3"},[t._v(t._s(t.datainfo[2].num))]),t._v(" "+t._s(t.data3.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data3.tips))])]),t._v(" "),s("div",{staticClass:"item borderNone",on:{click:function(a){t.getData(t.data4)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data4.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor4"},[t._v(t._s(t.datainfo[3].num))]),t._v(" "+t._s(t.data4.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data4.tips))])])]),t._v(" "),s("div",{staticClass:"cardItems"},[s("div",{staticClass:"item",on:{click:function(a){t.getData(t.data5)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data5.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor1"},[t._v(t._s(t.datainfo[4].num))]),t._v(" "+t._s(t.data5.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data5.tips))])]),t._v(" "),s("div",{staticClass:"item",on:{click:function(a){t.getData(t.data6)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data6.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor2"},[t._v(t._s(t.datainfo[5].num))]),t._v(" "+t._s(t.data6.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data6.tips))])]),t._v(" "),s("div",{staticClass:"item",on:{click:function(a){t.getData(t.data7)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data7.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor3"},[t._v(t._s(t.datainfo[6].num))]),t._v(" "+t._s(t.data7.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data7.tips))])]),t._v(" "),s("div",{staticClass:"item borderNone",on:{click:function(a){t.getData(t.data8)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data8.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor4"},[t._v(t._s(t.datainfo[7].num))]),t._v(" "+t._s(t.data8.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data8.tips))])])]),t._v(" "),s("div",{staticClass:"cardItems"},[s("div",{staticClass:"item",on:{click:function(a){t.getData(t.data9)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data9.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor1"},[t._v(t._s(t.datainfo[8].num))]),t._v(" "+t._s(t.data9.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data9.tips))])]),t._v(" "),s("div",{staticClass:"item",on:{click:function(a){t.getData(t.data10)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data10.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor2"},[t._v(t._s(t.datainfo[9].num))]),t._v(" "+t._s(t.data10.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data10.tips))])]),t._v(" "),s("div",{staticClass:"item",on:{click:function(a){t.getData(t.data11)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data11.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor3"},[t._v(t._s(t.datainfo[10].num))]),t._v(" "+t._s(t.data11.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准:"+t._s(t.data11.tips))])]),t._v(" "),s("div",{staticClass:"item borderNone",on:{click:function(a){t.getData(t.data12)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data12.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor4"},[t._v(t._s(t.datainfo[11].num))]),t._v(" "+t._s(t.data12.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data12.tips))])])]),t._v(" "),s("div",{staticClass:"cardItems",on:{click:function(a){t.getData(t.data13)}}},[s("div",{staticClass:"item",staticStyle:{"border-bottom":"1px solid #e4eaec"}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data13.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor1"},[t._v(t._s(t.datainfo[12].num))]),t._v(" "+t._s(t.data13.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data13.tips))])]),t._v(" "),s("div",{staticClass:"item",staticStyle:{"border-bottom":"1px solid #e4eaec"},on:{click:function(a){t.getData(t.data14)}}},[s("p",{staticClass:"itemName"},[t._v(t._s(t.data14.title))]),t._v(" "),s("span",{staticClass:"itemNumCon"},[s("p",{staticClass:"itemNum itemColor2"},[t._v(t._s(t.datainfo[13].num))]),t._v(" "+t._s(t.data14.type)+"\n      ")]),t._v(" "),s("p",{staticClass:"tips"},[t._v("参考标准："+t._s(t.data14.tips))])])])])},staticRenderFns:[]};var d=s("VU/8")(n,l,!1,function(t){s("Cb0+")},"data-v-7a041987",null).exports,m={name:"hxsj",data:function(){return{windowWidth:0,data1:{title:"学历教育在校生数",num1:"1",num:"N/A",type:"人",tips:"达到1200以上",style:"background:#7CB349;"},data2:{title:"师生比",num1:"2",num:"N/A",type:"",tips:"达到1:20以上",style:"background:#505050;"},data3:{title:"专业教师占专任教师占比",num1:"3",num:"N/A",type:"",tips:"不低于50%",style:"background:#E42739;"},data4:{title:"校舍建筑面积",num1:"4",num:"N/A",type:"㎡",tips:"不低于24000㎡",style:"background:#EF8629;"},data5:{title:"生均仪器设备值",num1:"5",num:"N/A",type:"元/生",tips:"工医3000，其它2500",style:"background:#358FE2;"},data6:[{num:"N/A"},{num:"N/A"},{num:"N/A"},{num:"N/A"},{num:"N/A"},{num:"N/A"},{num:"N/A"},{num:"N/A"},{num:"N/A"},{num:"N/A"},{num:"N/A"},{num:"N/A"},{num:"N/A"},{num:"N/A"}]}},components:{barCharts:i.a,cards:e.a,cardb:d},methods:{getDetail:function(t){if(console.log(t),"1"==t.num1)t={reg:"zyzsxsl",style:"2"};else if("2"==t.num1)t={reg:"gzyssb",style:"2"};else if("3"==t.num1)t={reg:"gzyzrjsbl",style:"2"};else if("4"==t.num1)this.$router.push({path:"/schoolMap"});else if("5"==t.num1){t={reg:"xsyqsbtb",style:"2"};var a="0"}var s=this;$.ajax({type:"post",url:s.baseUrl+"/ydjxzg/hx/xsgl.action",data:t,dataType:"json",success:function(t){console.log(t),s.$router.push({path:"/detail",name:"detail",params:{title:t.title,dataCount1:t.dataCount,dataCount2:t.zyxstbt,param:t.param1,rotate:a}})},error:function(t){console.log(t)}})}},mounted:function(){var t=this;$.ajax({type:"post",url:t.baseUrl+"/ydjxzg/hx/xsgl.action",data:{reg:"jbzb",style:"1"},dataType:"json",success:function(a){console.log(a),t.data1.num=a.totalCountStudent,t.data2.num=a.ssb,t.data3.num=Math.round(100*a.zyjsbfb)+"%",t.data4.num=Math.round(a.xsjzmj),t.data5.num=Math.round(a.rjsbzz),t.data6[0].num=Math.round(a.xxzdmj),t.data6[1].num=Math.round(a.sjydmj),t.data6[2].num=Math.round(a.sjxsmj),t.data6[3].num=Math.round(a.tyydmj),t.data6[4].num=a.zrjsCount,t.data6[5].num=Math.round(100*a.gjjsbfb[0].zj)+"%",t.data6[6].num=Math.round(100*a.doublejsbl.zj)+"%",t.data6[7].num=a.sjzzts,t.data6[8].num=a.qklxsl.zcount,t.data6[9].num=a.jsylszws.zcount,t.data6[10].num=a.xslszws.zcount,t.data6[11].num=a.xnsxgws,t.data6[12].num=a.xwsxjd,t.data6[13].num=a.sjjsjsl},error:function(t){console.log(t)}})}},o={render:function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{attrs:{id:"hexinshuju"}},[s("div",{staticClass:"jibentiaojian"},[s("div",{staticClass:"title"},[t._v("基本指标")]),t._v(" "),s("el-row",{staticStyle:{width:"100%",margin:"0 auto",display:"flex","justify-content":"space-between"},attrs:{gutter:12}},[s("el-col",{staticClass:"s_card",attrs:{span:6}},[s("el-card",{attrs:{shadow:"always"}},[s("cards",{attrs:{datainfo:t.data1},nativeOn:{click:function(a){t.getDetail(t.data1)}}})],1)],1),t._v(" "),s("el-col",{staticClass:"s_card",attrs:{span:6}},[s("el-card",{attrs:{shadow:"always"}},[s("cards",{attrs:{datainfo:t.data2},nativeOn:{click:function(a){t.getDetail(t.data2)}}})],1)],1),t._v(" "),s("el-col",{staticClass:"s_card",attrs:{span:6}},[s("el-card",{attrs:{shadow:"always"}},[s("cards",{attrs:{datainfo:t.data3},nativeOn:{click:function(a){t.getDetail(t.data3)}}})],1)],1)],1),t._v(" "),s("el-row",{staticStyle:{width:"100%",margin:"0 auto",display:"flex","justify-content":"space-between","margin-top":"25px"},attrs:{gutter:12}},[s("el-col",{staticClass:"s_card",attrs:{span:6}},[s("el-card",{attrs:{shadow:"always"}},[s("cards",{attrs:{datainfo:t.data4},nativeOn:{click:function(a){t.getDetail(t.data4)}}})],1)],1),t._v(" "),s("el-col",{staticClass:"s_card",attrs:{span:6}},[s("el-card",{attrs:{shadow:"always"}},[s("cards",{attrs:{datainfo:t.data5},nativeOn:{click:function(a){t.getDetail(t.data5)}}})],1)],1),t._v(" "),s("el-col",{staticClass:"s_card",attrs:{span:6}})],1)],1),t._v(" "),s("div",{staticClass:"zhongyaozhibiao",staticStyle:{"margin-top":"50px"}},[s("div",{staticClass:"title"},[t._v("重要指标")]),t._v(" "),s("el-row",{staticStyle:{width:"95.5%",display:"flex","justify-content":"center",margin:"0 auto"},attrs:{gutter:12}},[s("el-col",{attrs:{span:22}},[s("el-card",{attrs:{shadow:"always"}},[s("cardb",{attrs:{datainfo:t.data6}})],1)],1)],1)],1)])},staticRenderFns:[]};var c=s("VU/8")(m,o,!1,function(t){s("yMtV")},null,null);a.default=c.exports},"Cb0+":function(t,a){},yMtV:function(t,a){}});
//# sourceMappingURL=5.c490772d7de2ca6b54d1.js.map