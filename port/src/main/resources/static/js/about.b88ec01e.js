"use strict";(self["webpackChunkfront"]=self["webpackChunkfront"]||[]).push([[443],{6389:function(e,t,o){o.r(t),o.d(t,{default:function(){return g}});var n=o(6252),s=o(3577);const r={class:"about"};function u(e,t,o,u,a,c){return(0,n.wg)(),(0,n.iD)("div",r,[(0,n._)("h1",null,"로그인회원 정보 : "+(0,s.zw)(a.userInfo),1),(0,n._)("button",{onClick:t[0]||(t[0]=e=>c.getUser())},"get username!!"),(0,n._)("h1",null,"회원명 : "+(0,s.zw)(a.userName),1),(0,n._)("button",{onClick:t[1]||(t[1]=e=>c.getUserList())},"getUserList"),(0,n._)("h1",null,"회원리스트 : "+(0,s.zw)(a.userList),1)])}var a=o(4206),c=o.n(a),l={data(){return{userInfo:[],userList:[],userName:""}},created(){console.log("created ===========");const e=this;c().get("/user/userInfo").then((function(t){console.log("/userInfo",t),console.log("헤더 : ",t.headers),console.log("data : ",t.data),console.log("data type : ",typeof t.data),e.userInfo=t.data})).catch((function(t){e.userInfo="로그인 하세요",console.log(t)}))},methods:{getUserList:function(){const e=this;c().get("/user").then((function(t){console.log("get('/user')",t),console.log("data : ",t.data),console.log("data type : ",typeof t.data),e.userList=t.data})).catch((function(e){console.log(e)}))},getUser:function(){this.userName=this.userInfo.username}}},i=o(3744);const f=(0,i.Z)(l,[["render",u]]);var g=f}}]);
//# sourceMappingURL=about.b88ec01e.js.map