webpackJsonp([11],{AKB8:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=s("9r/T"),n={data:function(){return{currpage:"1",pagesize:5,allID:null,toDeleteSelected:!1,toDelete:!1,deleteID:null,content:null,toMark:!1,selected:[],quanshan:0,quanshan01:0,tipNum:0,tableData:[]}},methods:{handleSizeChange:function(t){this.pagesize=t},handleCurrentChange:function(t){this.currpage=t},filterTag:function(t,e){return e.status===t},markSelected:function(){var t=this;$.ajax({type:"POST",data:{mess_id:this.allID.toString()},url:t.baseUrl+"/ydjxzg/mb/upmess.action",dataType:"json",success:function(e){t.getTipNum()}})},deleteSelected:function(){this.toDeleteSelected=!0},select:function(t){this.selected=t;for(var e=[],s=0;s<this.selected.length;s++)e.push(this.selected[s].mess_id);this.allID=e,this.deleteID=e,sessionStorage.setItem("quanxuan01",t.length),this.quanshan=sessionStorage.getItem("quanshan01")},toggleSelection:function(t){t||this.$refs.stationtip.clearSelection()},ensureToDelete:function(){var t=this;$.ajax({type:"POST",data:{mess_id:this.deleteID.toString()},url:t.baseUrl+"/ydjxzg/mb/demess.action",dataType:"json",success:function(e){t.$message.success("删除成功！"),t.getTipNum()}}),this.toDelete=!1,this.toDeleteSelected=!1},deleteone:function(t){this.deleteID=t.mess_id,this.toDelete=!0},mark:function(t){this.content=t.message;var e=this;$.ajax({type:"POST",data:{mess_id:t.mess_id.toString()},url:e.baseUrl+"/ydjxzg/mb/upmess.action",dataType:"json",success:function(t){e.getTipNum()}}),this.toMark=!0},getTipNum:function(){var t=this,e=sessionStorage.getItem("user_id");$.ajax({type:"POST",data:{user_id:e},url:t.baseUrl+"/ydjxzg/mb/getmess.action",dataType:"json",success:function(e){for(var s=[],a=0;a<e.mess.length;a++)s.unshift(e.mess[a]);t.tableData=s}});for(var s=[],a=0;a<this.tableData.length;a++)"未读"==this.tableData[a].status&&s.push(this.tableData[a]);this.tipNum=s.length,this.$emit("func",this.tipNum)}},created:function(){this.getTipNum()},mounted:function(){Object(a.setTimeout)(this.getTipNum,3e3),setInterval(this.getTipNum,6e4)}},l={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{attrs:{id:"station"}},[s("el-table",{ref:"stationtip",staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:t.tableData.slice((t.currpage-1)*t.pagesize,t.currpage*t.pagesize)},on:{"selection-change":t.select}},[s("el-table-column",{attrs:{type:"selection",width:"55"}}),t._v(" "),s("el-table-column",{attrs:{sortable:"",prop:"create_date",label:"日期",width:"300"}}),t._v(" "),s("el-table-column",{attrs:{prop:"message",label:"内容",width:""}}),t._v(" "),s("el-table-column",{attrs:{prop:"status",label:"标签",width:"80",filters:[{text:"未读",value:"未读"},{text:"已读",value:"已读"}],"filter-method":t.filterTag,"filter-placement":"bottom-end"},scopedSlots:t._u([{key:"default",fn:function(e){return[s("el-tag",{attrs:{type:"未读"==e.row.status?"primary":"success","close-transition":""}},[t._v(t._s(e.row.status))])]}}])}),t._v(" "),s("el-table-column",{attrs:{label:"操作",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[s("el-button",{attrs:{type:"text",size:"small"},on:{click:function(s){return t.mark(e.row)}}},[t._v("查看")]),t._v(" "),s("el-button",{attrs:{type:"text",size:"small"},on:{click:function(s){return t.deleteone(e.row)}}},[t._v("删除")])]}}])})],1),t._v(" "),s("el-button",{attrs:{type:"text"},on:{click:t.deleteSelected}},[t._v("删除所选")]),t._v(" "),s("el-button",{attrs:{type:"text"},on:{click:t.markSelected}},[t._v("标记为已读")]),t._v(" "),s("div",{staticClass:"fenye"},[s("el-pagination",{attrs:{"current-page":1,"page-sizes":[2,3,5,7],"page-size":t.pagesize,layout:"total, sizes, prev, pager, next, jumper",total:this.tableData.length},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1),t._v(" "),s("el-dialog",{attrs:{title:"通知",visible:t.toMark,width:"30%"},on:{"update:visible":function(e){t.toMark=e}}},[s("span",[t._v("\n      "+t._s(t.content)+"\n    ")]),t._v(" "),s("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{on:{click:function(e){t.toMark=!1}}},[t._v("取 消")]),t._v(" "),s("el-button",{attrs:{type:"primary"},on:{click:function(e){t.toMark=!1}}},[t._v("确 定")])],1)]),t._v(" "),s("el-dialog",{attrs:{title:"警告",visible:t.toDelete,width:"30%"},on:{"update:visible":function(e){t.toDelete=e}}},[s("span",[t._v("\n      您确定要删除该条消息吗？\n    ")]),t._v(" "),s("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{on:{click:function(e){t.toDelete=!1}}},[t._v("取 消")]),t._v(" "),s("el-button",{attrs:{type:"primary"},on:{click:t.ensureToDelete}},[t._v("确 定")])],1)]),t._v(" "),s("el-dialog",{attrs:{title:"警告",visible:t.toDeleteSelected,width:"30%"},on:{"update:visible":function(e){t.toDeleteSelected=e}}},[s("span",[t._v("\n      您确定要删除该条消息吗？\n    ")]),t._v(" "),s("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{on:{click:function(e){t.toDelete=!1}}},[t._v("取 消")]),t._v(" "),s("el-button",{attrs:{type:"primary"},on:{click:t.ensureToDelete}},[t._v("确 定")])],1)])],1)},staticRenderFns:[]};var i=s("C7Lr")(n,l,!1,function(t){s("jHSn")},"data-v-0303f824",null);e.default=i.exports},jHSn:function(t,e){}});
//# sourceMappingURL=11.d711e2b3f1992b591d3d.js.map