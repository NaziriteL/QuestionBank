(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4a246317"],{"057f":function(t,e,n){var i=n("fc6a"),r=n("241c").f,o={}.toString,a="object"==typeof window&&window&&Object.getOwnPropertyNames?Object.getOwnPropertyNames(window):[],l=function(t){try{return r(t)}catch(e){return a.slice()}};t.exports.f=function(t){return a&&"[object Window]"==o.call(t)?l(t):r(i(t))}},"159b":function(t,e,n){var i=n("da84"),r=n("fdbc"),o=n("17c2"),a=n("9112");for(var l in r){var u=i[l],c=u&&u.prototype;if(c&&c.forEach!==o)try{a(c,"forEach",o)}catch(s){c.forEach=o}}},"17c2":function(t,e,n){"use strict";var i=n("b727").forEach,r=n("a640"),o=r("forEach");t.exports=o?[].forEach:function(t){return i(this,t,arguments.length>1?arguments[1]:void 0)}},"1dde":function(t,e,n){var i=n("d039"),r=n("b622"),o=n("2d00"),a=r("species");t.exports=function(t){return o>=51||!i((function(){var e=[],n=e.constructor={};return n[a]=function(){return{foo:1}},1!==e[t](Boolean).foo}))}},"4de4":function(t,e,n){"use strict";var i=n("23e7"),r=n("b727").filter,o=n("1dde"),a=o("filter");i({target:"Array",proto:!0,forced:!a},{filter:function(t){return r(this,t,arguments.length>1?arguments[1]:void 0)}})},5530:function(t,e,n){"use strict";n.d(e,"a",(function(){return o}));n("b64b"),n("a4d3"),n("4de4"),n("e439"),n("159b"),n("dbb4");function i(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}function r(t,e){var n=Object.keys(t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(t);e&&(i=i.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),n.push.apply(n,i)}return n}function o(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?r(Object(n),!0).forEach((function(e){i(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):r(Object(n)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}},"746f":function(t,e,n){var i=n("428f"),r=n("5135"),o=n("e538"),a=n("9bf2").f;t.exports=function(t){var e=i.Symbol||(i.Symbol={});r(e,t)||a(e,t,{value:o.f(t)})}},8418:function(t,e,n){"use strict";var i=n("c04e"),r=n("9bf2"),o=n("5c6c");t.exports=function(t,e,n){var a=i(e);a in t?r.f(t,a,o(0,n)):t[a]=n}},"96b1":function(t,e,n){"use strict";n("e68e")},"992f":function(t,e,n){},a421:function(t,e,n){"use strict";n("992f")},a4d3:function(t,e,n){"use strict";var i=n("23e7"),r=n("da84"),o=n("d066"),a=n("c430"),l=n("83ab"),u=n("4930"),c=n("fdbf"),s=n("d039"),d=n("5135"),p=n("e8b5"),f=n("861d"),m=n("825a"),h=n("7b0b"),b=n("fc6a"),v=n("c04e"),P=n("5c6c"),g=n("7c73"),_=n("df75"),S=n("241c"),w=n("057f"),y=n("7418"),A=n("06cf"),M=n("9bf2"),C=n("d1e7"),O=n("9112"),j=n("6eeb"),k=n("5692"),F=n("f772"),x=n("d012"),W=n("90e3"),$=n("b622"),N=n("e538"),E=n("746f"),R=n("d44e"),T=n("69f3"),B=n("b727").forEach,U=F("hidden"),D="Symbol",J="prototype",H=$("toPrimitive"),I=T.set,Q=T.getterFor(D),q=Object[J],z=r.Symbol,G=o("JSON","stringify"),K=A.f,L=M.f,V=w.f,X=C.f,Y=k("symbols"),Z=k("op-symbols"),tt=k("string-to-symbol-registry"),et=k("symbol-to-string-registry"),nt=k("wks"),it=r.QObject,rt=!it||!it[J]||!it[J].findChild,ot=l&&s((function(){return 7!=g(L({},"a",{get:function(){return L(this,"a",{value:7}).a}})).a}))?function(t,e,n){var i=K(q,e);i&&delete q[e],L(t,e,n),i&&t!==q&&L(q,e,i)}:L,at=function(t,e){var n=Y[t]=g(z[J]);return I(n,{type:D,tag:t,description:e}),l||(n.description=e),n},lt=c?function(t){return"symbol"==typeof t}:function(t){return Object(t)instanceof z},ut=function(t,e,n){t===q&&ut(Z,e,n),m(t);var i=v(e,!0);return m(n),d(Y,i)?(n.enumerable?(d(t,U)&&t[U][i]&&(t[U][i]=!1),n=g(n,{enumerable:P(0,!1)})):(d(t,U)||L(t,U,P(1,{})),t[U][i]=!0),ot(t,i,n)):L(t,i,n)},ct=function(t,e){m(t);var n=b(e),i=_(n).concat(mt(n));return B(i,(function(e){l&&!dt.call(n,e)||ut(t,e,n[e])})),t},st=function(t,e){return void 0===e?g(t):ct(g(t),e)},dt=function(t){var e=v(t,!0),n=X.call(this,e);return!(this===q&&d(Y,e)&&!d(Z,e))&&(!(n||!d(this,e)||!d(Y,e)||d(this,U)&&this[U][e])||n)},pt=function(t,e){var n=b(t),i=v(e,!0);if(n!==q||!d(Y,i)||d(Z,i)){var r=K(n,i);return!r||!d(Y,i)||d(n,U)&&n[U][i]||(r.enumerable=!0),r}},ft=function(t){var e=V(b(t)),n=[];return B(e,(function(t){d(Y,t)||d(x,t)||n.push(t)})),n},mt=function(t){var e=t===q,n=V(e?Z:b(t)),i=[];return B(n,(function(t){!d(Y,t)||e&&!d(q,t)||i.push(Y[t])})),i};if(u||(z=function(){if(this instanceof z)throw TypeError("Symbol is not a constructor");var t=arguments.length&&void 0!==arguments[0]?String(arguments[0]):void 0,e=W(t),n=function(t){this===q&&n.call(Z,t),d(this,U)&&d(this[U],e)&&(this[U][e]=!1),ot(this,e,P(1,t))};return l&&rt&&ot(q,e,{configurable:!0,set:n}),at(e,t)},j(z[J],"toString",(function(){return Q(this).tag})),j(z,"withoutSetter",(function(t){return at(W(t),t)})),C.f=dt,M.f=ut,A.f=pt,S.f=w.f=ft,y.f=mt,N.f=function(t){return at($(t),t)},l&&(L(z[J],"description",{configurable:!0,get:function(){return Q(this).description}}),a||j(q,"propertyIsEnumerable",dt,{unsafe:!0}))),i({global:!0,wrap:!0,forced:!u,sham:!u},{Symbol:z}),B(_(nt),(function(t){E(t)})),i({target:D,stat:!0,forced:!u},{for:function(t){var e=String(t);if(d(tt,e))return tt[e];var n=z(e);return tt[e]=n,et[n]=e,n},keyFor:function(t){if(!lt(t))throw TypeError(t+" is not a symbol");if(d(et,t))return et[t]},useSetter:function(){rt=!0},useSimple:function(){rt=!1}}),i({target:"Object",stat:!0,forced:!u,sham:!l},{create:st,defineProperty:ut,defineProperties:ct,getOwnPropertyDescriptor:pt}),i({target:"Object",stat:!0,forced:!u},{getOwnPropertyNames:ft,getOwnPropertySymbols:mt}),i({target:"Object",stat:!0,forced:s((function(){y.f(1)}))},{getOwnPropertySymbols:function(t){return y.f(h(t))}}),G){var ht=!u||s((function(){var t=z();return"[null]"!=G([t])||"{}"!=G({a:t})||"{}"!=G(Object(t))}));i({target:"JSON",stat:!0,forced:ht},{stringify:function(t,e,n){var i,r=[t],o=1;while(arguments.length>o)r.push(arguments[o++]);if(i=e,(f(e)||void 0!==t)&&!lt(t))return p(e)||(e=function(t,e){if("function"==typeof i&&(e=i.call(this,t,e)),!lt(e))return e}),r[1]=e,G.apply(null,r)}})}z[J][H]||O(z[J],H,z[J].valueOf),R(z,D),x[U]=!0},a640:function(t,e,n){"use strict";var i=n("d039");t.exports=function(t,e){var n=[][t];return!!n&&i((function(){n.call(null,e||function(){throw 1},1)}))}},b64b:function(t,e,n){var i=n("23e7"),r=n("7b0b"),o=n("df75"),a=n("d039"),l=a((function(){o(1)}));i({target:"Object",stat:!0,forced:l},{keys:function(t){return o(r(t))}})},dbb4:function(t,e,n){var i=n("23e7"),r=n("83ab"),o=n("56ef"),a=n("fc6a"),l=n("06cf"),u=n("8418");i({target:"Object",stat:!0,sham:!r},{getOwnPropertyDescriptors:function(t){var e,n,i=a(t),r=l.f,c=o(i),s={},d=0;while(c.length>d)n=r(i,e=c[d++]),void 0!==n&&u(s,e,n);return s}})},e439:function(t,e,n){var i=n("23e7"),r=n("d039"),o=n("fc6a"),a=n("06cf").f,l=n("83ab"),u=r((function(){a(1)})),c=!l||u;i({target:"Object",stat:!0,forced:c,sham:!l},{getOwnPropertyDescriptor:function(t,e){return a(o(t),e)}})},e538:function(t,e,n){var i=n("b622");e.f=i},e68e:function(t,e,n){},e71c:function(t,e,n){"use strict";n.r(e);var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"random"}},[n("div",{attrs:{id:"countBar"}}),n("div",[n("p",[t._v("自动组卷")]),t._l(t.tabs,(function(e){return n("button",{key:e.title,class:["tab-button",{active:t.currentTab===e.title}],on:{click:function(n){t.currentTab=e.title}}},[t._v(" "+t._s(e.displayName)+" ")])}))],2),n("div",{attrs:{id:"randomMain"}},[n(this.currentTabComponent,{tag:"component",staticClass:"RandomTab"})],1)])},r=[],o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("p",[t._v("单选")]),n("div",{attrs:{id:"SingleHelpBar"}},[n("form",{directives:[{name:"show",rawName:"v-show",value:t.Paper.WholePointSingle>0&&t.Paper.SingleChoiceAmountFull>0,expression:"(Paper.WholePointSingle>0 && Paper.SingleChoiceAmountFull>0)"}]},[n("ul",[n("li",[t._v("辅助栏："+t._s(t.SingleChoiceAmount)+"/"+t._s(t.Paper.SingleChoiceAmountFull))])])])]),n("div",{attrs:{id:"SingleBar"}},[n("table",[n("tr",[n("td",[t._v("输入总分：")]),n("td",[n("input",{directives:[{name:"model",rawName:"v-model.number",value:t.Paper.WholePointSingle,expression:"Paper.WholePointSingle",modifiers:{number:!0}}],attrs:{type:"text"},domProps:{value:t.Paper.WholePointSingle},on:{input:function(e){e.target.composing||t.$set(t.Paper,"WholePointSingle",t._n(e.target.value))},blur:function(e){return t.$forceUpdate()}}})])]),n("tr",[n("td",[t._v("输入题目数量：")]),n("td",[n("input",{directives:[{name:"model",rawName:"v-model.number",value:t.Paper.SingleChoiceAmountFull,expression:"Paper.SingleChoiceAmountFull",modifiers:{number:!0}}],attrs:{type:"text"},domProps:{value:t.Paper.SingleChoiceAmountFull},on:{input:function(e){e.target.composing||t.$set(t.Paper,"SingleChoiceAmountFull",t._n(e.target.value))},blur:function(e){return t.$forceUpdate()}}})])]),n("tr",[n("td",[t._v("单个题目分值：")]),n("td",[t._v(t._s(t.SingleChoicePoint))])])])]),n("div",{attrs:{id:"doubletest"}},[t._l(t.Paper.options,(function(e,i){return n("div",{key:i},[n("tr",[n("th",[t._v(t._s(e.value))]),n("td",[t._v(t._s(e.single))])]),t._l(e.optionsubs,(function(i,r){return n("tr",{key:r},[n("td",[t._v(t._s(i.value))]),n("td",[n("button",{attrs:{disabled:0==i.single},on:{click:function(n){return t.handleSubstract(e.id,i.id,0)}}},[t._v("-")])]),n("td",[t._v(t._s(i.single))]),n("td",[n("button",{attrs:{disabled:t.Paper.SingleChoiceAmount>=t.Paper.SingleChoiceAmountFull},on:{click:function(n){return t.handleAdd(e.id,i.id,0)}}},[t._v("+")])])])}))],2)})),n("p",[n("button",{attrs:{type:"submit",disabled:!(t.Paper.SingleChoiceAmount==t.Paper.SingleChoiceAmountFull&&0!=t.Paper.SingleChoiceAmountFull)},on:{click:function(e){return t.handleSubmitAndPreview(0)}}},[t._v("提交并预览 ")])])],2)])},a=[],l=n("5530"),u=n("2f62"),c={name:"PaperMakeRandomSingle",computed:Object(l["a"])(Object(l["a"])({},Object(u["d"])("papermakerandom",{Paper:"Paper"})),Object(u["b"])("papermakerandom",["SingleChoiceAmount","SingleChoicePoint"])),methods:Object(l["a"])(Object(l["a"])({},Object(u["c"])("papermakerandom",["add","substract","handleSubmitAndPreview"])),{},{handleAdd:function(t,e,n){this.add({id1:t,id2:e,sign:n})},handleSubstract:function(t,e,n){this.substract({id1:t,id2:e,sign:n})}})},s=c,d=(n("96b1"),n("2877")),p=Object(d["a"])(s,o,a,!1,null,"201bce14",null),f=p.exports,m=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("p",[t._v("多选")]),n("div",{attrs:{id:"MultipleHelpBar"}},[n("form",{directives:[{name:"show",rawName:"v-show",value:t.Paper.WholePointMultiple>0&&t.Paper.MultipleChoiceAmountFull>0,expression:"(Paper.WholePointMultiple>0 && Paper.MultipleChoiceAmountFull>0)"}]},[n("ul",[n("li",[t._v("辅助栏："+t._s(t.MultipleChoiceAmount)+"/"+t._s(t.Paper.MultipleChoiceAmountFull))])])])]),n("div",{attrs:{id:"MultipleBar"}},[n("table",[n("tr",[n("td",[t._v("输入总分：")]),n("td",[n("input",{directives:[{name:"model",rawName:"v-model.number",value:t.Paper.WholePointMultiple,expression:"Paper.WholePointMultiple",modifiers:{number:!0}}],attrs:{type:"text"},domProps:{value:t.Paper.WholePointMultiple},on:{input:function(e){e.target.composing||t.$set(t.Paper,"WholePointMultiple",t._n(e.target.value))},blur:function(e){return t.$forceUpdate()}}})])]),n("tr",[n("td",[t._v("输入题目数量：")]),n("td",[n("input",{directives:[{name:"model",rawName:"v-model.number",value:t.Paper.MultipleChoiceAmountFull,expression:"Paper.MultipleChoiceAmountFull",modifiers:{number:!0}}],attrs:{type:"text"},domProps:{value:t.Paper.MultipleChoiceAmountFull},on:{input:function(e){e.target.composing||t.$set(t.Paper,"MultipleChoiceAmountFull",t._n(e.target.value))},blur:function(e){return t.$forceUpdate()}}})])]),n("tr",[n("td",[t._v("单个题目分值：")]),n("td",[t._v(t._s(t.MultipleChoicePoint))])])])]),n("div",{attrs:{id:"MultipleMain"}},[t._l(t.Paper.options,(function(e,i){return n("div",{key:i},[n("tr",[n("th",[t._v(t._s(e.value))]),n("td",[t._v(t._s(e.multiple))])]),t._l(e.optionsubs,(function(i,r){return n("tr",{key:r},[n("td",[t._v(t._s(i.value))]),n("td",[n("button",{attrs:{disabled:0==i.multiple},on:{click:function(n){return t.handleSubstract(e.id,i.id,1)}}},[t._v("-")])]),n("td",[t._v(t._s(i.multiple))]),n("td",[n("button",{attrs:{disabled:t.Paper.MultipleChoiceAmount>=t.Paper.MultipleChoiceAmountFull},on:{click:function(n){return t.handleAdd(e.id,i.id,1)}}},[t._v("+")])])])}))],2)})),n("p",[n("button",{attrs:{type:"submit",disabled:!(t.Paper.MultipleChoiceAmount==t.Paper.MultipleChoiceAmountFull&&0!=t.Paper.MultipleChoiceAmountFull)},on:{click:function(e){return t.handleSubmitAndPreview(1)}}},[t._v("提交并预览 ")])])],2)])},h=[],b={name:"PaperMakeRandomMultiple",computed:Object(l["a"])(Object(l["a"])({},Object(u["d"])("papermakerandom",{Paper:"Paper"})),Object(u["b"])("papermakerandom",["MultipleChoiceAmount","MultipleChoicePoint"])),methods:Object(l["a"])(Object(l["a"])({},Object(u["c"])("papermakerandom",["add","substract","handleSubmitAndPreview"])),{},{handleAdd:function(t,e,n){this.add({id1:t,id2:e,sign:n})},handleSubstract:function(t,e,n){this.substract({id1:t,id2:e,sign:n})}})},v=b,P=Object(d["a"])(v,m,h,!1,null,null,null),g=P.exports,_=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"MixMain"}},[n("p",[t._v("单选+多选")]),n("div",{attrs:{id:"MixHelpBar"}},[n("form",{directives:[{name:"show",rawName:"v-show",value:t.Paper.WholePointMultiple>0&&t.Paper.MultipleChoiceAmountFull>0&&t.Paper.WholePointSingle>0&&t.Paper.SingleChoiceAmountFull>0,expression:"(Paper.WholePointMultiple>0 && Paper.MultipleChoiceAmountFull>0 && Paper.WholePointSingle>0 && Paper.SingleChoiceAmountFull>0)"}]},[n("ul",[n("li",[t._v("单选辅助栏："+t._s(t.SingleChoiceAmount)+"/"+t._s(t.Paper.SingleChoiceAmountFull))]),n("li",[t._v("多选辅助栏："+t._s(t.MultipleChoiceAmount)+"/"+t._s(t.Paper.MultipleChoiceAmountFull))])])])]),n("div",{attrs:{id:"MixBar"}},[n("table",[n("tr",[n("td",[t._v("输入单选总分：")]),n("td",[n("input",{directives:[{name:"model",rawName:"v-model.number",value:t.Paper.WholePointSingle,expression:"Paper.WholePointSingle",modifiers:{number:!0}}],attrs:{type:"text"},domProps:{value:t.Paper.WholePointSingle},on:{input:function(e){e.target.composing||t.$set(t.Paper,"WholePointSingle",t._n(e.target.value))},blur:function(e){return t.$forceUpdate()}}})]),n("td",[t._v("输入多选总分：")]),n("td",[n("input",{directives:[{name:"model",rawName:"v-model.number",value:t.Paper.WholePointMultiple,expression:"Paper.WholePointMultiple",modifiers:{number:!0}}],attrs:{type:"text"},domProps:{value:t.Paper.WholePointMultiple},on:{input:function(e){e.target.composing||t.$set(t.Paper,"WholePointMultiple",t._n(e.target.value))},blur:function(e){return t.$forceUpdate()}}})])]),n("tr",[n("td",[t._v("输入单选题目数量：")]),n("td",[n("input",{directives:[{name:"model",rawName:"v-model.number",value:t.Paper.SingleChoiceAmountFull,expression:"Paper.SingleChoiceAmountFull",modifiers:{number:!0}}],attrs:{type:"text"},domProps:{value:t.Paper.SingleChoiceAmountFull},on:{input:function(e){e.target.composing||t.$set(t.Paper,"SingleChoiceAmountFull",t._n(e.target.value))},blur:function(e){return t.$forceUpdate()}}})]),n("td",[t._v("输入多选题目数量：")]),n("td",[n("input",{directives:[{name:"model",rawName:"v-model.number",value:t.Paper.MultipleChoiceAmountFull,expression:"Paper.MultipleChoiceAmountFull",modifiers:{number:!0}}],attrs:{type:"text"},domProps:{value:t.Paper.MultipleChoiceAmountFull},on:{input:function(e){e.target.composing||t.$set(t.Paper,"MultipleChoiceAmountFull",t._n(e.target.value))},blur:function(e){return t.$forceUpdate()}}})])]),n("tr",[n("td",[t._v("单选分值：")]),n("td",[t._v(t._s(t.SingleChoicePoint))]),n("td",[t._v("多选分值：")]),n("td",[t._v(t._s(t.MultipleChoicePoint))])])])]),n("div",{attrs:{id:"MixMain"}},[t._m(0),t._m(1),t._l(t.Paper.options,(function(e,i){return n("table",{key:i,staticStyle:{"table-layout":"fixed"},attrs:{border:"1",width:"100%",cellpadding:"0",cellspacing:"0"}},[n("thead",[n("tr",[n("th",{attrs:{width:"100"}},[t._v(t._s(e.value))]),n("th",{attrs:{width:"30"}}),n("th",{attrs:{width:"40"}},[t._v(t._s(e.single))]),n("th",{attrs:{width:"30"}}),n("th",{attrs:{width:"30"}}),n("th",{attrs:{width:"40"}},[t._v(t._s(e.multiple))]),n("th",{attrs:{width:"30"}})])]),n("tbody",t._l(e.optionsubs,(function(i,r){return n("tr",{key:r},[n("td",[t._v(t._s(i.value))]),n("td",[n("button",{attrs:{disabled:0==i.single},on:{click:function(n){return t.handleSubstract(e.id,i.id,0)}}},[t._v("-")])]),n("td",[t._v(t._s(i.single))]),n("td",[n("button",{attrs:{disabled:t.Paper.SingleChoiceAmount>=t.Paper.SingleChoiceAmountFull},on:{click:function(n){return t.handleAdd(e.id,i.id,0)}}},[t._v("+")])]),n("td",[n("button",{attrs:{disabled:0==i.multiple},on:{click:function(n){return t.handleSubstract(e.id,i.id,1)}}},[t._v("-")])]),n("td",[t._v(t._s(i.multiple))]),n("td",[n("button",{attrs:{disabled:t.Paper.MultipleChoiceAmount>=t.Paper.MultipleChoiceAmountFull},on:{click:function(n){return t.handleAdd(e.id,i.id,1)}}},[t._v("+")])])])})),0)])})),n("p",[n("button",{attrs:{type:"submit",disabled:!(t.Paper.SingleChoiceAmount==t.Paper.SingleChoiceAmountFull&&0!=t.Paper.SingleChoiceAmountFull&&t.Paper.MultipleChoiceAmount==t.Paper.MultipleChoiceAmountFull&&0!=t.Paper.MultipleChoiceAmountFull)},on:{click:function(e){return t.handleSubmitAndPreview(2)}}},[t._v("提交并预览 ")])])],2)])},S=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("table",{staticStyle:{"table-layout":"fixed"},attrs:{border:"1",width:"100%",cellpadding:"0",cellspacing:"0"}},[n("tr",[n("th",{attrs:{width:"100"}}),n("th",{attrs:{width:"30"}}),n("td",{attrs:{width:"40",colspan:"3"}},[t._v("单选数量")]),n("th",{attrs:{width:"30"}}),n("th",{attrs:{width:"30"}}),n("th",{attrs:{width:"40"}},[t._v("多选数量")]),n("th",{attrs:{width:"30"}})])])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("table",{staticStyle:{"table-layout":"fixed"},attrs:{border:"1",width:"100%",cellpadding:"0",cellspacing:"0"}},[n("tr",[n("th",{attrs:{width:"100"}},[t._v("标题")]),n("th",{attrs:{width:"30"}}),n("th",{attrs:{width:"40",colspan:"3"}},[t._v("单选数量")]),n("th",{attrs:{width:"30"}}),n("th",{attrs:{width:"30"}}),n("th",{attrs:{width:"40"}},[t._v("多选数量")]),n("th",{attrs:{width:"30"}})])])}],w={name:"PaperMakeRandomMix",computed:Object(l["a"])(Object(l["a"])({},Object(u["d"])("papermakerandom",{Paper:"Paper"})),Object(u["b"])("papermakerandom",["SingleChoiceAmount","SingleChoicePoint","MultipleChoiceAmount","MultipleChoicePoint"])),methods:Object(l["a"])(Object(l["a"])({},Object(u["c"])("papermakerandom",["add","substract","handleSubmitAndPreview"])),{},{handleAdd:function(t,e,n){this.add({id1:t,id2:e,sign:n})},handleSubstract:function(t,e,n){this.substract({id1:t,id2:e,sign:n})}})},y=w,A=Object(d["a"])(y,_,S,!1,null,"14e643fc",null),M=A.exports,C={name:"PaperMakeRandom",components:{PaperMakeRandomSingle:f,PaperMakeRandomMultiple:g,PaperMakeRandomMix:M},data:function(){return{currentTab:"Single",tabs:[{title:"Single",displayName:"单选"},{title:"Multiple",displayName:"多选"},{title:"Mix",displayName:"单选+多选"}]}},computed:{currentTabComponent:function(){return"PaperMakeRandom"+this.currentTab}}},O=C,j=(n("a421"),Object(d["a"])(O,i,r,!1,null,"441ca494",null));e["default"]=j.exports}}]);
//# sourceMappingURL=chunk-4a246317.61ef14ed.js.map