(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3a911802"],{"14ce":function(t,e,n){"use strict";n("e5e1")},"613e":function(t,e,n){"use strict";n.r(e);var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[t._l(t.tabs,(function(e){return n("button",{key:e.title,class:["tab-button",{active:t.currentTab===e.title}],on:{click:function(n){t.currentTab=e.title}}},[t._v(" "+t._s(e.displayName)+" ")])})),n(t.currentTabComponent,{tag:"component",staticClass:"tab"})],2)},u=[],a=n("e220"),o=n("e71c"),r={name:"PaperMake",components:{PaperMakeCustom:a["default"],PaperMakeRandom:o["default"]},data:function(){return{currentTab:"Random",tabs:[{title:"Random",displayName:"智能组卷"},{title:"Custom",displayName:"人工组卷"}]}},computed:{currentTabComponent:function(){return"PaperMake"+this.currentTab}}},s=r,c=(n("14ce"),n("2877")),l=Object(c["a"])(s,i,u,!1,null,"6066d4aa",null);e["default"]=l.exports},c740:function(t,e,n){"use strict";var i=n("23e7"),u=n("b727").findIndex,a=n("44d2"),o="findIndex",r=!0;o in[]&&Array(1)[o]((function(){r=!1})),i({target:"Array",proto:!0,forced:r},{findIndex:function(t){return u(this,t,arguments.length>1?arguments[1]:void 0)}}),a(o)},e220:function(t,e,n){"use strict";n.r(e);var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[t._v("人工组卷界面 "),n("div",{attrs:{id:"category"}},[n("p",[t._v("试题选择界面")]),n("select",{directives:[{name:"model",rawName:"v-model",value:t.currentOption,expression:"currentOption"}],on:{change:function(e){var n=Array.prototype.filter.call(e.target.options,(function(t){return t.selected})).map((function(t){var e="_value"in t?t._value:t.value;return e}));t.currentOption=e.target.multiple?n:n[0]}}},[n("option",{attrs:{disabled:"",value:""}},[t._v("请选择主标题")]),t._l(t.options,(function(e,i){return n("option",{key:i},[t._v(" "+t._s(e.value)+" ")])}))],2),n("select",{directives:[{name:"model",rawName:"v-model",value:t.currentSub,expression:"currentSub"}],on:{change:function(e){var n=Array.prototype.filter.call(e.target.options,(function(t){return t.selected})).map((function(t){var e="_value"in t?t._value:t.value;return e}));t.currentSub=e.target.multiple?n:n[0]}}},[n("option",{attrs:{disabled:"",value:""}},[t._v("请选择副标题")]),t._l(t.options[t.MainId].optionsubs,(function(e,i){return n("option",{key:i},[t._v(" "+t._s(e.value)+" ")])}))],2),n("div",{attrs:{id:"selectframe"}},t._l(t.questionItems,(function(e,i){return n("div",{key:i},[n("p",[t._v(t._s(e.mainTitle))]),n("p",[t._v(t._s(e.subTitle))]),n("p",[t._v("题干："+t._s(e.content))]),n("p",[t._v("A:"+t._s(e.options[0])+" B:"+t._s(e.options[1]))]),n("p",[t._v("C:"+t._s(e.options[2])+" D:"+t._s(e.options[3]))]),n("p",[t._v("答案："+t._s(t.answer))]),n("p",[n("button",{on:{click:function(n){return t.add(e)}}},[t._v("加入试卷")])])])})),0),n("div",{attrs:{id:"helpbar"}},[n("p",[t._v("已选试题界面")]),n("p"),t._l(t.questionSheets,(function(e,i){return n("div",{key:i},[n("p",[t._v(t._s(e.mainTitle))]),n("p",[t._v(t._s(e.subTitle))]),n("p",[t._v("题干："+t._s(e.content))]),n("p",[t._v("A:"+t._s(e.options[0])+" B:"+t._s(e.options[1]))]),n("p",[t._v("C:"+t._s(e.options[2])+" D:"+t._s(e.options[3]))]),n("p",[t._v("答案："+t._s(t.answer))]),n("p",[n("button",{on:{click:function(n){return t.questionDelete(e)}}},[t._v("删去试题")])])])}))],2),n("p",[n("button",{on:{click:function(e){return t.handleSubmit()}}},[t._v("提交并下载")])])])])},u=[],a=n("5530"),o=(n("c740"),n("bc3a"),n("2106"),n("2f62")),r={name:"PaperMakeCustom",computed:Object(a["a"])(Object(a["a"])({},Object(o["d"])("papermakecustomdata",{questionItems:"questionItems",questionSheets:"questionSheets"})),{},{MainId:function(){var t=this,e=this.options.findIndex((function(e){return e.value===t.currentOption}));return e}}),data:function(){return{currentOption:"概述",currentSub:"基本概念",options:[{id:1,value:"概述",optionsubs:[{id:1,value:"基本概念"},{id:2,value:"交换原理"},{id:3,value:"网络应用需求"},{id:4,value:"网络体系架构"},{id:5,value:"网络性能评估"}]},{id:2,value:"直连网络",optionsubs:[{id:1,value:"物理层基本通信"},{id:2,value:"数据链路层控制"},{id:3,value:"可靠传输机制"},{id:4,value:"多路访问机制"}]},{id:3,value:"网络互联",optionsubs:[{id:1,value:"网桥与交换机"},{id:2,value:"网络互联与路由器"},{id:3,value:"IP服务模型与协议"},{id:4,value:"路由算法与协议"},{id:5,value:"IP地址及其划分"},{id:6,value:"网络层与其他协议"}]},{id:4,value:"传输层与资源分配",optionsubs:[{id:1,value:"UDP协议"},{id:2,value:"TCP协议"},{id:3,value:"拥塞控制"}]},{id:5,value:"应用层",optionsubs:[{id:1,value:"应用层"}]}],Trans:[{mainTitle:"",subTitle:""}]}},methods:Object(a["a"])({},Object(o["c"])("papermakecustomdata",["add","questionDelete","set","reset","handleSubmit"])),created:function(){this.axios.post("/#",{mainTitle:this.currentOption,subTitle:this.currentSub}).then((function(t){this.set(t.data.questionItems)})).catch((function(t){}))},watch:{currentSub:function(t){this.axios.post("/#",{mainTitle:this.currentOption,subTitle:t}).then((function(t){this.set(t.data.questionItems)})).catch((function(t){}))}}},s=r,c=n("2877"),l=Object(c["a"])(s,i,u,!1,null,null,null);e["default"]=l.exports},e5e1:function(t,e,n){}}]);
//# sourceMappingURL=chunk-3a911802.4f1f89d8.js.map