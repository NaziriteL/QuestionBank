(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-08664b31","chunk-3a911802","chunk-57b576f7","chunk-2d0d7fc5"],{"14ce":function(e,t,n){"use strict";n("e5e1")},"50c1":function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",e._l(e.questionItems,(function(e,t){return n("div",{key:t},[n("QuestionItem",{attrs:{questionItem:e}})],1)})),0)},i=[],a=n("5530"),o=(n("6e63"),function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("p",[e._v(e._s(e.questionItem.mainTitle))]),n("p",[e._v(e._s(e.questionItem.subTitle))]),n("p",[e._v("题干："+e._s(e.questionItem.content))]),n("p",[e._v("A:"+e._s(e.questionItem.options[0])+" B:"+e._s(e.questionItem.options[1]))]),n("p",[e._v("C:"+e._s(e.questionItem.options[2])+" D:"+e._s(e.questionItem.options[3]))]),n("p",[e._v("答案："+e._s(e.answer))])])}),s=[],u={name:"QuestionItem",props:["questionItem"],data:function(){return{}},computed:{answer:function(){var e=[0,0,0,0],t=[],n=this.questionItem.answer,r=0;for(r=3;r>=0;r--)n%2!=0&&(e[r]=1),n=parseInt(n/2);return 1==e[0]&&t.push("A"),1==e[1]&&t.push("B"),1==e[2]&&t.push("C"),1==e[3]&&t.push("D"),t}}},l=u,c=n("2877"),p=Object(c["a"])(l,o,s,!1,null,null,null),d=p.exports,v=n("2f62"),m={name:"QuestionList",computed:Object(a["a"])({},Object(v["d"])("testdata",{questionItems:"questionItems"})),components:{QuestionItem:d}},f=m,_=Object(c["a"])(f,r,i,!1,null,null,null);t["a"]=_.exports},"613e":function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e._l(e.tabs,(function(t){return n("button",{key:t.title,class:["tab-button",{active:e.currentTab===t.title}],on:{click:function(n){e.currentTab=t.title}}},[e._v(" "+e._s(t.displayName)+" ")])})),n(e.currentTabComponent,{tag:"component",staticClass:"tab"})],2)},i=[],a=n("e220"),o=n("e71c"),s={name:"PaperMake",components:{PaperMakeCustom:a["default"],PaperMakeRandom:o["default"]},data:function(){return{currentTab:"Random",tabs:[{title:"Random",displayName:"智能组卷"},{title:"Custom",displayName:"人工组卷"}]}},computed:{currentTabComponent:function(){return"PaperMake"+this.currentTab}}},u=s,l=(n("14ce"),n("2877")),c=Object(l["a"])(u,r,i,!1,null,"6066d4aa",null);t["default"]=c.exports},7768:function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"questionInput"},[n("p",[e._v("在此处完成试题导入")]),n("div",[n("select",{directives:[{name:"model",rawName:"v-model",value:e.currentOption,expression:"currentOption"}],on:{change:function(t){var n=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.currentOption=t.target.multiple?n:n[0]}}},[n("option",{attrs:{disabled:"",value:""}},[e._v("请选择主标题")]),e._l(e.options,(function(t,r){return n("option",{key:r},[e._v(" "+e._s(t.value)+" ")])}))],2),n("select",{directives:[{name:"model",rawName:"v-model",value:e.currentSub,expression:"currentSub"}],on:{change:function(t){var n=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.currentSub=t.target.multiple?n:n[0]}}},[n("option",{attrs:{disabled:"",value:""}},[e._v("请选择副标题")]),e._l(e.options[e.MainId2].optionsubs,(function(t,r){return n("option",{key:r},[e._v(" "+e._s(t.value)+" ")])}))],2),n("p",[e._v(" 知识点为："+e._s(e.currentOption)+"."+e._s(e.currentSub)+" ")]),n("p",[n("textarea",{attrs:{cols:"50",rows:"10","v-model":e.question}},[e._v("请输入试题题干")])]),n("p",[e._v("选项A:"),n("textarea",{attrs:{cols:"50",rows:"1","v-model":e.A}})]),n("p",[e._v("选项B:"),n("textarea",{attrs:{cols:"50",rows:"1","v-model":e.B}})]),n("p",[e._v("选项C:"),n("textarea",{attrs:{cols:"50",rows:"1","v-model":e.C}})]),n("p",[e._v("选项D:"),n("textarea",{attrs:{cols:"50",rows:"1","v-model":e.D}})]),n("p",[e._v(" 试题类型： "),n("input",{directives:[{name:"model",rawName:"v-model",value:e.questionType,expression:"questionType"}],attrs:{id:"single",type:"radio",value:"0"},domProps:{checked:e._q(e.questionType,"0")},on:{change:function(t){e.questionType="0"}}}),n("label",{attrs:{for:"single"}},[e._v("单选")]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.questionType,expression:"questionType"}],attrs:{id:"multiple",type:"radio",value:"1"},domProps:{checked:e._q(e.questionType,"1")},on:{change:function(t){e.questionType="1"}}}),n("label",{attrs:{for:"multiple"}},[e._v("多选")]),n("br"),e._t("default",[e._v("试题类型为"+e._s(e.questionType))])],2)]),0==e.questionType?n("p",[e._v(" 答案（单选）： "),n("input",{directives:[{name:"model",rawName:"v-model",value:e.answerForSingle,expression:"answerForSingle"}],attrs:{id:"answerforsingle",type:"radio",value:"A"},domProps:{checked:e._q(e.answerForSingle,"A")},on:{change:function(t){e.answerForSingle="A"}}}),n("label",{attrs:{for:"answerforsingle"}},[e._v("A")]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.answerForSingle,expression:"answerForSingle"}],attrs:{id:"answerforsingle",type:"radio",value:"B"},domProps:{checked:e._q(e.answerForSingle,"B")},on:{change:function(t){e.answerForSingle="B"}}}),n("label",{attrs:{for:"answerforsingle"}},[e._v("B")]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.answerForSingle,expression:"answerForSingle"}],attrs:{id:"answerforsingle",type:"radio",value:"C"},domProps:{checked:e._q(e.answerForSingle,"C")},on:{change:function(t){e.answerForSingle="C"}}}),n("label",{attrs:{for:"answerforsingle"}},[e._v("C")]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.answerForSingle,expression:"answerForSingle"}],attrs:{id:"answerforsingle",type:"radio",value:"D"},domProps:{checked:e._q(e.answerForSingle,"D")},on:{change:function(t){e.answerForSingle="D"}}}),n("label",{attrs:{for:"answerforsingle"}},[e._v("D")]),n("br"),e._t("default",[e._v("答案为："+e._s(e.answerForSingle))])],2):n("p",[e._v(" 答案（多选）： "),n("input",{directives:[{name:"model",rawName:"v-model",value:e.answerForMultiple,expression:"answerForMultiple"}],attrs:{id:"answerformultiple",type:"checkbox",value:"A"},domProps:{checked:Array.isArray(e.answerForMultiple)?e._i(e.answerForMultiple,"A")>-1:e.answerForMultiple},on:{change:function(t){var n=e.answerForMultiple,r=t.target,i=!!r.checked;if(Array.isArray(n)){var a="A",o=e._i(n,a);r.checked?o<0&&(e.answerForMultiple=n.concat([a])):o>-1&&(e.answerForMultiple=n.slice(0,o).concat(n.slice(o+1)))}else e.answerForMultiple=i}}}),n("label",{attrs:{for:"answerformultiple"}},[e._v("A")]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.answerForMultiple,expression:"answerForMultiple"}],attrs:{id:"answerformultiple",type:"checkbox",value:"B"},domProps:{checked:Array.isArray(e.answerForMultiple)?e._i(e.answerForMultiple,"B")>-1:e.answerForMultiple},on:{change:function(t){var n=e.answerForMultiple,r=t.target,i=!!r.checked;if(Array.isArray(n)){var a="B",o=e._i(n,a);r.checked?o<0&&(e.answerForMultiple=n.concat([a])):o>-1&&(e.answerForMultiple=n.slice(0,o).concat(n.slice(o+1)))}else e.answerForMultiple=i}}}),n("label",{attrs:{for:"answerformultiple"}},[e._v("B")]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.answerForMultiple,expression:"answerForMultiple"}],attrs:{id:"answerformultiple",type:"checkbox",value:"C"},domProps:{checked:Array.isArray(e.answerForMultiple)?e._i(e.answerForMultiple,"C")>-1:e.answerForMultiple},on:{change:function(t){var n=e.answerForMultiple,r=t.target,i=!!r.checked;if(Array.isArray(n)){var a="C",o=e._i(n,a);r.checked?o<0&&(e.answerForMultiple=n.concat([a])):o>-1&&(e.answerForMultiple=n.slice(0,o).concat(n.slice(o+1)))}else e.answerForMultiple=i}}}),n("label",{attrs:{for:"answerformultiple"}},[e._v("C")]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.answerForMultiple,expression:"answerForMultiple"}],attrs:{id:"answerformultiple",type:"checkbox",value:"D"},domProps:{checked:Array.isArray(e.answerForMultiple)?e._i(e.answerForMultiple,"D")>-1:e.answerForMultiple},on:{change:function(t){var n=e.answerForMultiple,r=t.target,i=!!r.checked;if(Array.isArray(n)){var a="D",o=e._i(n,a);r.checked?o<0&&(e.answerForMultiple=n.concat([a])):o>-1&&(e.answerForMultiple=n.slice(0,o).concat(n.slice(o+1)))}else e.answerForMultiple=i}}}),n("label",{attrs:{for:"answerformultiple"}},[e._v("D")]),n("br"),e._v(" 答案为："+e._s(e.answerForMultiple)+" ")])])},i=[],a=(n("c740"),n("7db0"),n("bc3a")),o=n.n(a),s=(n("2106"),{name:"QuestionInput",data:function(){return{id:0,question:"",A:"",B:"",C:"",D:"",questionType:0,answer:[0,0,0,0],answernum:0,answerForSingle:"",answerForMultiple:[],currentOption:"概述",currentSub:"基本概念",options:[{id:1,value:"概述",optionsubs:[{id:1,value:"基本概念"},{id:2,value:"交换原理"},{id:3,value:"网络应用需求"},{id:4,value:"网络体系架构"},{id:5,value:"网络性能评估"}]},{id:2,value:"直连网络",optionsubs:[{id:1,value:"物理层基本通信"},{id:2,value:"数据链路层控制"},{id:3,value:"可靠传输机制"},{id:4,value:"多路访问机制"}]},{id:3,value:"网络互联",optionsubs:[{id:1,value:"网桥与交换机"},{id:2,value:"网络互联与路由器"},{id:3,value:"IP服务模型与协议"},{id:4,value:"路由算法与协议"},{id:5,value:"IP地址及其划分"},{id:6,value:"网络层与其他协议"}]},{id:4,value:"传输层与资源分配",optionsubs:[{id:1,value:"UDP协议"},{id:2,value:"TCP协议"},{id:3,value:"拥塞控制"}]},{id:5,value:"应用层",optionsubs:[{id:1,value:"应用层"}]}]}},computed:{MainId2:function(){var e=this,t=this.options.findIndex((function(t){return t.value===e.currentOption}));return t}},methods:{handleSubmit:function(){"应用层"===this.currentOption&&(this.currentSub="应用层");var e=0;for(e=0;e<4;e++)this.answer[e]=0;if(0==this.questionType)switch(this.answerForSingle){case"A":this.answer[0]=1;break;case"B":this.answer[1]=1;break;case"C":this.answer[2]=1;break;case"D":this.answer[3]=1;break}else this.answerForMultiple.find((function(e){}))&&(this.answer[0]=1),this.answerForMultiple.find((function(e){}))&&(this.answer[1]=1),this.answerForMultiple.find((function(e){}))&&(this.answer[2]=1),this.answerForMultiple.find((function(e){}))&&(this.answer[3]=1);this.answernum=this.answer[3]+2*this.answer[2]+4*this.answer[1]+8*this.answer[0],o.a.post("/#",{id:0,mainTitle:this.currentOption,subTitle:this.currentSub,content:this.question,A:this.A,B:this.B,C:this.C,D:this.D,questionType:this.questionType,answer:this.answernum}).then((function(e){0==e.data.operateResult?console.log("操作失败"):1==e.data.operateResult?console.log("操作成功"):""==e.data.operateResult?console.log("重复值"):console.log("数据传输出错")})).catch((function(e){console.log(e)}))}}}),u=s,l=n("2877"),c=Object(l["a"])(u,r,i,!1,null,null,null);t["default"]=c.exports},"78c1":function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("button",{on:{click:function(t){return e.handleClick()}}},[e._v("通信测试")]),e._m(0)])},i=[function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("table",{staticClass:"pure-table"},[n("thead",[n("tr",[n("th",[e._v("#")]),n("th",[e._v("Make")]),n("th",[e._v("Model")]),n("th",[e._v("Year")])])]),n("tbody",[n("tr",[n("td",[e._v("1")]),n("td",[e._v("Honda")]),n("td",[e._v("Accord")]),n("td",[e._v("2009")])]),n("tr",[n("td",[e._v("2")]),n("td",[e._v("Toyota")]),n("td",[e._v("Camry")]),n("td",[e._v("2012")])]),n("tr",[n("td",[e._v("3")]),n("td",[e._v("Hyundai")]),n("td",[e._v("Elantra")]),n("td",[e._v("2010")])])])])}],a=n("bc3a"),o=n.n(a),s={name:"Test",methods:{handleClick:function(){console.log("开始发送"),o.a.post("/login",{username:111,password:123}).then((function(e){console.log("收到")})).catch((function(e){}))}}},u=s,l=n("2877"),c=Object(l["a"])(u,r,i,!1,null,null,null);t["default"]=c.exports},7959:function(e,t,n){},bb51:function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"home"},[n("div",{attrs:{id:"nav"}},[n("ul",{staticStyle:{"font-size":"60px","margin-left":"50px","margin-top":"100px"},attrs:{type:"none"}},[n("li",[n("button",{on:{click:function(t){e.currentHomeTab="PaperMake"}}},[e._v("组卷")])]),n("li",[n("button",{on:{click:function(t){e.currentHomeTab="QuestionInput"}}},[e._v("试题导入")])]),n("li",[n("button",{on:{click:function(t){e.currentHomeTab="Test"}}},[e._v("功能测试")])]),n("li",[n("button",{on:{click:function(t){e.currentHomeTab="QuestionList"}}},[e._v("试题列表测试")])])])]),n("div",{attrs:{id:"main"}},[n(this.currentHomeTab,{tag:"component",staticClass:"homeTab"})],1)])},i=[],a=n("613e"),o=n("7768"),s=n("78c1"),u=n("50c1"),l={name:"Home",components:{PaperMake:a["default"],QuestionInput:o["default"],Test:s["default"],QuestionList:u["a"]},data:function(){return{currentHomeTab:"PaperMake",homeTabs:[{title:"PaperMake",displayName:"组卷"},{title:"QuestionInput",displayName:"试题导入"},{title:"Test",displayName:"功能测试界面"},{title:"QuestionList",displayName:"试题列表测试"}]}},computed:{}},c=l,p=(n("f875"),n("2877")),d=Object(p["a"])(c,r,i,!1,null,"b2d87d80",null);t["default"]=d.exports},c740:function(e,t,n){"use strict";var r=n("23e7"),i=n("b727").findIndex,a=n("44d2"),o="findIndex",s=!0;o in[]&&Array(1)[o]((function(){s=!1})),r({target:"Array",proto:!0,forced:s},{findIndex:function(e){return i(this,e,arguments.length>1?arguments[1]:void 0)}}),a(o)},e220:function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e._v("人工组卷界面 "),n("div",{attrs:{id:"category"}},[n("p",[e._v("试题选择界面")]),n("select",{directives:[{name:"model",rawName:"v-model",value:e.currentOption,expression:"currentOption"}],on:{change:function(t){var n=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.currentOption=t.target.multiple?n:n[0]}}},[n("option",{attrs:{disabled:"",value:""}},[e._v("请选择主标题")]),e._l(e.options,(function(t,r){return n("option",{key:r},[e._v(" "+e._s(t.value)+" ")])}))],2),n("select",{directives:[{name:"model",rawName:"v-model",value:e.currentSub,expression:"currentSub"}],on:{change:function(t){var n=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.currentSub=t.target.multiple?n:n[0]}}},[n("option",{attrs:{disabled:"",value:""}},[e._v("请选择副标题")]),e._l(e.options[e.MainId].optionsubs,(function(t,r){return n("option",{key:r},[e._v(" "+e._s(t.value)+" ")])}))],2),n("div",{attrs:{id:"selectframe"}},e._l(e.questionItems,(function(t,r){return n("div",{key:r},[n("p",[e._v(e._s(t.mainTitle))]),n("p",[e._v(e._s(t.subTitle))]),n("p",[e._v("题干："+e._s(t.content))]),n("p",[e._v("A:"+e._s(t.options[0])+" B:"+e._s(t.options[1]))]),n("p",[e._v("C:"+e._s(t.options[2])+" D:"+e._s(t.options[3]))]),n("p",[e._v("答案："+e._s(e.answer))]),n("p",[n("button",{on:{click:function(n){return e.add(t)}}},[e._v("加入试卷")])])])})),0),n("div",{attrs:{id:"helpbar"}},[n("p",[e._v("已选试题界面")]),n("p"),e._l(e.questionSheets,(function(t,r){return n("div",{key:r},[n("p",[e._v(e._s(t.mainTitle))]),n("p",[e._v(e._s(t.subTitle))]),n("p",[e._v("题干："+e._s(t.content))]),n("p",[e._v("A:"+e._s(t.options[0])+" B:"+e._s(t.options[1]))]),n("p",[e._v("C:"+e._s(t.options[2])+" D:"+e._s(t.options[3]))]),n("p",[e._v("答案："+e._s(e.answer))]),n("p",[n("button",{on:{click:function(n){return e.questionDelete(t)}}},[e._v("删去试题")])])])}))],2),n("p",[n("button",{on:{click:function(t){return e.handleSubmit()}}},[e._v("提交并下载")])])])])},i=[],a=n("5530"),o=(n("c740"),n("bc3a"),n("2106"),n("2f62")),s={name:"PaperMakeCustom",computed:Object(a["a"])(Object(a["a"])({},Object(o["d"])("papermakecustomdata",{questionItems:"questionItems",questionSheets:"questionSheets"})),{},{MainId:function(){var e=this,t=this.options.findIndex((function(t){return t.value===e.currentOption}));return t}}),data:function(){return{currentOption:"概述",currentSub:"基本概念",options:[{id:1,value:"概述",optionsubs:[{id:1,value:"基本概念"},{id:2,value:"交换原理"},{id:3,value:"网络应用需求"},{id:4,value:"网络体系架构"},{id:5,value:"网络性能评估"}]},{id:2,value:"直连网络",optionsubs:[{id:1,value:"物理层基本通信"},{id:2,value:"数据链路层控制"},{id:3,value:"可靠传输机制"},{id:4,value:"多路访问机制"}]},{id:3,value:"网络互联",optionsubs:[{id:1,value:"网桥与交换机"},{id:2,value:"网络互联与路由器"},{id:3,value:"IP服务模型与协议"},{id:4,value:"路由算法与协议"},{id:5,value:"IP地址及其划分"},{id:6,value:"网络层与其他协议"}]},{id:4,value:"传输层与资源分配",optionsubs:[{id:1,value:"UDP协议"},{id:2,value:"TCP协议"},{id:3,value:"拥塞控制"}]},{id:5,value:"应用层",optionsubs:[{id:1,value:"应用层"}]}],Trans:[{mainTitle:"",subTitle:""}]}},methods:Object(a["a"])({},Object(o["c"])("papermakecustomdata",["add","questionDelete","set","reset","handleSubmit"])),created:function(){this.axios.post("/#",{mainTitle:this.currentOption,subTitle:this.currentSub}).then((function(e){this.set(e.data.questionItems)})).catch((function(e){}))},watch:{currentSub:function(e){this.axios.post("/#",{mainTitle:this.currentOption,subTitle:e}).then((function(e){this.set(e.data.questionItems)})).catch((function(e){}))}}},u=s,l=n("2877"),c=Object(l["a"])(u,r,i,!1,null,null,null);t["default"]=c.exports},e5e1:function(e,t,n){},f875:function(e,t,n){"use strict";n("7959")}}]);
//# sourceMappingURL=chunk-08664b31.b106657b.js.map