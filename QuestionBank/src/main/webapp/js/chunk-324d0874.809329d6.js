(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-324d0874"],{"057f":function(t,e,n){var r=n("fc6a"),o=n("241c").f,i={}.toString,c="object"==typeof window&&window&&Object.getOwnPropertyNames?Object.getOwnPropertyNames(window):[],u=function(t){try{return o(t)}catch(e){return c.slice()}};t.exports.f=function(t){return c&&"[object Window]"==i.call(t)?u(t):o(r(t))}},"159b":function(t,e,n){var r=n("da84"),o=n("fdbc"),i=n("17c2"),c=n("9112");for(var u in o){var f=r[u],s=f&&f.prototype;if(s&&s.forEach!==i)try{c(s,"forEach",i)}catch(a){s.forEach=i}}},"17c2":function(t,e,n){"use strict";var r=n("b727").forEach,o=n("a640"),i=o("forEach");t.exports=i?[].forEach:function(t){return r(this,t,arguments.length>1?arguments[1]:void 0)}},"1dde":function(t,e,n){var r=n("d039"),o=n("b622"),i=n("2d00"),c=o("species");t.exports=function(t){return i>=51||!r((function(){var e=[],n=e.constructor={};return n[c]=function(){return{foo:1}},1!==e[t](Boolean).foo}))}},"4de4":function(t,e,n){"use strict";var r=n("23e7"),o=n("b727").filter,i=n("1dde"),c=i("filter");r({target:"Array",proto:!0,forced:!c},{filter:function(t){return o(this,t,arguments.length>1?arguments[1]:void 0)}})},"50c1":function(t,e,n){"use strict";var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",t._l(t.questionItems,(function(t,e){return n("div",{key:e},[n("QuestionItem",{attrs:{questionItem:t}})],1)})),0)},o=[],i=n("5530"),c=(n("6e63"),function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("p",[t._v(t._s(t.questionItem.mainTitle))]),n("p",[t._v(t._s(t.questionItem.subTitle))]),n("p",[t._v("题干："+t._s(t.questionItem.content))]),n("p",[t._v("A:"+t._s(t.questionItem.options[0])+" B:"+t._s(t.questionItem.options[1]))]),n("p",[t._v("C:"+t._s(t.questionItem.options[2])+" D:"+t._s(t.questionItem.options[3]))]),n("p",[t._v("答案："+t._s(t.answer))])])}),u=[],f={name:"QuestionItem",props:["questionItem"],data:function(){return{}},computed:{answer:function(){var t=[0,0,0,0],e=[],n=this.questionItem.answer,r=0;for(r=3;r>=0;r--)n%2!=0&&(t[r]=1),n=parseInt(n/2);return 1==t[0]&&e.push("A"),1==t[1]&&e.push("B"),1==t[2]&&e.push("C"),1==t[3]&&e.push("D"),e}}},s=f,a=n("2877"),l=Object(a["a"])(s,c,u,!1,null,null,null),p=l.exports,b=n("2f62"),d={name:"QuestionList",computed:Object(i["a"])({},Object(b["d"])("testdata",{questionItems:"questionItems"})),components:{QuestionItem:p}},h=d,v=Object(a["a"])(h,r,o,!1,null,null,null);e["a"]=v.exports},5530:function(t,e,n){"use strict";n.d(e,"a",(function(){return i}));n("b64b"),n("a4d3"),n("4de4"),n("e439"),n("159b"),n("dbb4");function r(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}function o(t,e){var n=Object.keys(t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(t);e&&(r=r.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),n.push.apply(n,r)}return n}function i(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?o(Object(n),!0).forEach((function(e){r(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):o(Object(n)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}},"5b0b":function(t,e,n){"use strict";n.r(e);var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("p",[t._v("预览界面"),n("button",{on:{click:function(e){return t.handleHome()}}},[t._v("回到主界面")])]),n("p",[n("button",{on:{click:function(e){return t.handleFresh()}}},[t._v("以目前要求重新生成")])]),n("p",[n("button",{on:{click:function(e){return t.handleDownload()}}},[t._v("下载")])]),n("QuestionList")],1)},o=[],i=n("5530"),c=n("bc3a"),u=n.n(c),f=n("a18c"),s=n("50c1"),a=n("2f62"),l={name:"Preview",computed:Object(i["a"])({},Object(a["d"])("papermakerandom",{Trans:"Trans"})),methods:Object(i["a"])(Object(i["a"])({},Object(a["c"])("papermakerandom",["replaceQuestionItems"])),{},{handleHome:function(){f["a"].push({path:"/home"})},handleFresh:function(){u.a.post("/#",{WholeBlockAmount:this.Trans.WholeBlockAmount,Blocks:this.Trans.Blocks}).then((function(t){this.replaceQuestionItems(t.data)})).catch((function(t){}))},handleDownload:function(){}}),components:{QuestionList:s["a"]}},p=l,b=n("2877"),d=Object(b["a"])(p,r,o,!1,null,null,null);e["default"]=d.exports},"746f":function(t,e,n){var r=n("428f"),o=n("5135"),i=n("e538"),c=n("9bf2").f;t.exports=function(t){var e=r.Symbol||(r.Symbol={});o(e,t)||c(e,t,{value:i.f(t)})}},8418:function(t,e,n){"use strict";var r=n("c04e"),o=n("9bf2"),i=n("5c6c");t.exports=function(t,e,n){var c=r(e);c in t?o.f(t,c,i(0,n)):t[c]=n}},a4d3:function(t,e,n){"use strict";var r=n("23e7"),o=n("da84"),i=n("d066"),c=n("c430"),u=n("83ab"),f=n("4930"),s=n("fdbf"),a=n("d039"),l=n("5135"),p=n("e8b5"),b=n("861d"),d=n("825a"),h=n("7b0b"),v=n("fc6a"),m=n("c04e"),y=n("5c6c"),O=n("7c73"),g=n("df75"),w=n("241c"),j=n("057f"),_=n("7418"),P=n("06cf"),I=n("9bf2"),S=n("d1e7"),k=n("9112"),E=n("6eeb"),q=n("5692"),D=n("f772"),x=n("d012"),Q=n("90e3"),T=n("b622"),B=n("e538"),A=n("746f"),N=n("d44e"),F=n("69f3"),J=n("b727").forEach,C=D("hidden"),L="Symbol",W="prototype",$=T("toPrimitive"),H=F.set,z=F.getterFor(L),G=Object[W],K=o.Symbol,M=i("JSON","stringify"),R=P.f,U=I.f,V=j.f,X=S.f,Y=q("symbols"),Z=q("op-symbols"),tt=q("string-to-symbol-registry"),et=q("symbol-to-string-registry"),nt=q("wks"),rt=o.QObject,ot=!rt||!rt[W]||!rt[W].findChild,it=u&&a((function(){return 7!=O(U({},"a",{get:function(){return U(this,"a",{value:7}).a}})).a}))?function(t,e,n){var r=R(G,e);r&&delete G[e],U(t,e,n),r&&t!==G&&U(G,e,r)}:U,ct=function(t,e){var n=Y[t]=O(K[W]);return H(n,{type:L,tag:t,description:e}),u||(n.description=e),n},ut=s?function(t){return"symbol"==typeof t}:function(t){return Object(t)instanceof K},ft=function(t,e,n){t===G&&ft(Z,e,n),d(t);var r=m(e,!0);return d(n),l(Y,r)?(n.enumerable?(l(t,C)&&t[C][r]&&(t[C][r]=!1),n=O(n,{enumerable:y(0,!1)})):(l(t,C)||U(t,C,y(1,{})),t[C][r]=!0),it(t,r,n)):U(t,r,n)},st=function(t,e){d(t);var n=v(e),r=g(n).concat(dt(n));return J(r,(function(e){u&&!lt.call(n,e)||ft(t,e,n[e])})),t},at=function(t,e){return void 0===e?O(t):st(O(t),e)},lt=function(t){var e=m(t,!0),n=X.call(this,e);return!(this===G&&l(Y,e)&&!l(Z,e))&&(!(n||!l(this,e)||!l(Y,e)||l(this,C)&&this[C][e])||n)},pt=function(t,e){var n=v(t),r=m(e,!0);if(n!==G||!l(Y,r)||l(Z,r)){var o=R(n,r);return!o||!l(Y,r)||l(n,C)&&n[C][r]||(o.enumerable=!0),o}},bt=function(t){var e=V(v(t)),n=[];return J(e,(function(t){l(Y,t)||l(x,t)||n.push(t)})),n},dt=function(t){var e=t===G,n=V(e?Z:v(t)),r=[];return J(n,(function(t){!l(Y,t)||e&&!l(G,t)||r.push(Y[t])})),r};if(f||(K=function(){if(this instanceof K)throw TypeError("Symbol is not a constructor");var t=arguments.length&&void 0!==arguments[0]?String(arguments[0]):void 0,e=Q(t),n=function(t){this===G&&n.call(Z,t),l(this,C)&&l(this[C],e)&&(this[C][e]=!1),it(this,e,y(1,t))};return u&&ot&&it(G,e,{configurable:!0,set:n}),ct(e,t)},E(K[W],"toString",(function(){return z(this).tag})),E(K,"withoutSetter",(function(t){return ct(Q(t),t)})),S.f=lt,I.f=ft,P.f=pt,w.f=j.f=bt,_.f=dt,B.f=function(t){return ct(T(t),t)},u&&(U(K[W],"description",{configurable:!0,get:function(){return z(this).description}}),c||E(G,"propertyIsEnumerable",lt,{unsafe:!0}))),r({global:!0,wrap:!0,forced:!f,sham:!f},{Symbol:K}),J(g(nt),(function(t){A(t)})),r({target:L,stat:!0,forced:!f},{for:function(t){var e=String(t);if(l(tt,e))return tt[e];var n=K(e);return tt[e]=n,et[n]=e,n},keyFor:function(t){if(!ut(t))throw TypeError(t+" is not a symbol");if(l(et,t))return et[t]},useSetter:function(){ot=!0},useSimple:function(){ot=!1}}),r({target:"Object",stat:!0,forced:!f,sham:!u},{create:at,defineProperty:ft,defineProperties:st,getOwnPropertyDescriptor:pt}),r({target:"Object",stat:!0,forced:!f},{getOwnPropertyNames:bt,getOwnPropertySymbols:dt}),r({target:"Object",stat:!0,forced:a((function(){_.f(1)}))},{getOwnPropertySymbols:function(t){return _.f(h(t))}}),M){var ht=!f||a((function(){var t=K();return"[null]"!=M([t])||"{}"!=M({a:t})||"{}"!=M(Object(t))}));r({target:"JSON",stat:!0,forced:ht},{stringify:function(t,e,n){var r,o=[t],i=1;while(arguments.length>i)o.push(arguments[i++]);if(r=e,(b(e)||void 0!==t)&&!ut(t))return p(e)||(e=function(t,e){if("function"==typeof r&&(e=r.call(this,t,e)),!ut(e))return e}),o[1]=e,M.apply(null,o)}})}K[W][$]||k(K[W],$,K[W].valueOf),N(K,L),x[C]=!0},a640:function(t,e,n){"use strict";var r=n("d039");t.exports=function(t,e){var n=[][t];return!!n&&r((function(){n.call(null,e||function(){throw 1},1)}))}},b64b:function(t,e,n){var r=n("23e7"),o=n("7b0b"),i=n("df75"),c=n("d039"),u=c((function(){i(1)}));r({target:"Object",stat:!0,forced:u},{keys:function(t){return i(o(t))}})},dbb4:function(t,e,n){var r=n("23e7"),o=n("83ab"),i=n("56ef"),c=n("fc6a"),u=n("06cf"),f=n("8418");r({target:"Object",stat:!0,sham:!o},{getOwnPropertyDescriptors:function(t){var e,n,r=c(t),o=u.f,s=i(r),a={},l=0;while(s.length>l)n=o(r,e=s[l++]),void 0!==n&&f(a,e,n);return a}})},e439:function(t,e,n){var r=n("23e7"),o=n("d039"),i=n("fc6a"),c=n("06cf").f,u=n("83ab"),f=o((function(){c(1)})),s=!u||f;r({target:"Object",stat:!0,forced:s,sham:!u},{getOwnPropertyDescriptor:function(t,e){return c(i(t),e)}})},e538:function(t,e,n){var r=n("b622");e.f=r}}]);
//# sourceMappingURL=chunk-324d0874.809329d6.js.map