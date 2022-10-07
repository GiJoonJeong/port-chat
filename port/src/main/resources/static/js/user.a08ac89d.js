"use strict";(self["webpackChunkfront"]=self["webpackChunkfront"]||[]).push([[378],{9751:function(n,a,t){t.r(a),t.d(a,{default:function(){return p}});var o=t(6252);const s=(0,o._)("h1",null,"회원 가입 완료",-1),e=(0,o._)("hr",null,null,-1);function l(n,a){const t=(0,o.up)("router-link");return(0,o.wg)(),(0,o.iD)("div",null,[s,e,(0,o.Wm)(t,{to:"/loginForm"},{default:(0,o.w5)((()=>[(0,o.Uk)("로그인 하러가기")])),_:1})])}var r=t(3744);const i={},u=(0,r.Z)(i,[["render",l]]);var p=u},5548:function(n,a,t){t.r(a),t.d(a,{default:function(){return T}});var o=t(6252),s=t(9963);const e={class:"signup"},l=(0,o._)("h2",null,"회원가입 페이지",-1),r=(0,o._)("hr",null,null,-1),i=(0,o._)("br",null,null,-1),u=(0,o._)("br",null,null,-1),p={key:0,class:"green"},d=(0,o._)("br",null,null,-1),h={key:1,class:"red"},g={key:2,class:"green"},c=(0,o._)("br",null,null,-1),m={key:3,class:"red"},w=(0,o._)("button",{type:"submit"},"회원가입",-1);function k(n,a,t,k,v,b){return(0,o.wg)(),(0,o.iD)("div",e,[l,r,(0,o._)("form",{onSubmit:a[6]||(a[6]=(0,s.iM)((n=>b.onSubmit()),["prevent"]))},[(0,o.wy)((0,o._)("input",{type:"email","onUpdate:modelValue":a[0]||(a[0]=a=>n.signup.email=a),placeholder:"이메일 입력",minlength:"1",required:""},null,512),[[s.nr,n.signup.email,void 0,{trim:!0}]]),i,(0,o.wy)((0,o._)("input",{type:"text","onUpdate:modelValue":a[1]||(a[1]=a=>n.signup.username=a),placeholder:"닉네임 입력",minlength:"1",maxlength:"20"},null,512),[[s.nr,n.signup.username,void 0,{trim:!0}]]),u,(0,o.wy)((0,o._)("input",{type:"password","onUpdate:modelValue":a[2]||(a[2]=a=>n.signup.password=a),placeholder:"비밀번호 입력",minlength:"4",maxlength:"16",onBlur:a[3]||(a[3]=n=>b.passwordValid()),autocomplete:"new-password"},null,544),[[s.nr,n.signup.password,void 0,{trim:!0}]]),2==n.passwordValidFlag?((0,o.wg)(),(0,o.iD)("span",p,[(0,o.Uk)(" 사용가능 "),d])):(0,o.kq)("",!0),n.passwordValidFlag?(0,o.kq)("",!0):((0,o.wg)(),(0,o.iD)("div",h," 영어 소문자+숫자 조합 4~16자리 입력해주세요 ")),(0,o.wy)((0,o._)("input",{type:"password","onUpdate:modelValue":a[4]||(a[4]=a=>n.passwordCheck=a),placeholder:"비밀번호 확인",minlength:"4",maxlength:"16",onBlur:a[5]||(a[5]=n=>b.passwordCheckValid()),autocomplete:"new-password"},null,544),[[s.nr,n.passwordCheck,void 0,{trim:!0}]]),2==n.passwordCheckFlag?((0,o.wg)(),(0,o.iD)("span",g,[(0,o.Uk)(" 일치 "),c])):(0,o.kq)("",!0),n.passwordCheckFlag?(0,o.kq)("",!0):((0,o.wg)(),(0,o.iD)("div",m," 비밀번호가 동일하지않습니다. ")),w],32)])}t(7658);var v=t(4206),b=t.n(v),f={name:"JoinPage",props:{},data:()=>({signup:{email:"",username:"",password:""},passwordCheck:"",passwordValidFlag:1,passwordCheckFlag:1}),methods:{onSubmit:function(){if(console.log(this.signup),null==this.signup.email||null==this.signup.username||null==this.signup.password)return void alert("필수값 누락");if(!this.passwordValidFlag||!this.passwordCheckFlag)return void alert("유효성 확인");const n=this.signup,a=this;b().post("/user",n).then((function(n){console.log("data : ",n.data),console.log("data type : ",typeof n.data),alert(n.data),a.$router.push("/joinDone")})).catch((function(n){console.log(n)}))},passwordValid(){/^(?=.*[a-z])(?=.*[0-9]).{4,16}$/.test(this.signup.password)?this.passwordValidFlag=2:this.passwordValidFlag=0},passwordCheckValid(){this.signup.password===this.passwordCheck?this.passwordCheckFlag=2:this.passwordCheckFlag=0}}},D=t(3744);const U=(0,D.Z)(f,[["render",k]]);var T=U},5402:function(n,a,t){t.r(a),t.d(a,{default:function(){return T}});var o=t(6252),s=t(9963);const e=n=>((0,o.dD)("data-v-0418572e"),n=n(),(0,o.Cn)(),n),l={class:"login"},r=e((()=>(0,o._)("h1",null,"로그인 페이지",-1))),i=e((()=>(0,o._)("hr",null,null,-1))),u=e((()=>(0,o._)("br",null,null,-1))),p=e((()=>(0,o._)("br",null,null,-1))),d=e((()=>(0,o._)("br",null,null,-1))),h=e((()=>(0,o._)("button",{type:"submit"},"로그인",-1))),g=e((()=>(0,o._)("a",{href:"/oauth2/authorization/google?redirect_uri=http://localhost:8080/PortChat"},[(0,o._)("img",{class:"google login-Logo",src:"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAABXFBMVEX////qQzU0qFNChfT7vAUwffTT4/M4gPSdu/ixyPrqQDH7ugD/vQD7uAAvp1D86+oopUvpOirpLxvqPS3pNCLpLRgYokIRoT/8wgAipEf74N48gvTi8eX509H2uLTyl5HsWE3M5tJgt3VDg/uRy570qaTznpn3wb7tYVfwgnv+9vX4zcrubWT74+HpNjf914f94qn93p5QsWis17YzqkJ4wInrTkHveXHoJgzyhTL2nSr+89v5rx/vbDj+78/95rb80G9DiO//+e391oJ6p+8uq1/w9vm+38XS6dfo9Ovxi4XsXFLucmrxkYvqQ0D3pQD7wSn8xkPtWznwczf1li1ime+/1PT8zF+zy/RUk+vU4fnm15SPsD1brE3SuCWJx5extDV5r0bmuhtSq0/NuCqptDqSskRzo+8/jNk8lbU4n4g+kcY6m5w2o3A7mKo3oX1Ai949lLs5nZA+kMuE9FnFAAAKrUlEQVR4nO2c+3fbRBaAFcVpWsVRZVmSI8evGMtOnISCHTuBFtpAE+dBS8tuobAL4bG7ZZ/s4/8/ZyVLiW1ZM74z0szIPv5+As5S6ePeufeOZryStGTJkiVLlixZkhDtYrlVcZxm1aPpOJVWufhQ9EslQ7HlXO32DVM3XHK3eH+jm0b/4MppHYp+RWraZWevf6IbubyirESjKK6sbtauKkXRb0tKe796behGHqUWEs27/9sDpyz6rcEUnV3TyMHkRuRzun5cmYO1Wa6u6MR2d5aGfu2kWvKwGUPPRzHM3UpbtEg07UrNjKl3J7mXwjVZvDKMJPR88nq/Itpokv0DM5eY3hDFMJrpWZGtmp5P1m9ITr9Kh2Orn2B6hhxP9sQ77td0Vn4eefNKbGEt7jL188jpTXF+7T2TxfoLY6y0BAk6esL1E4WiH4hYjsWawcfPI2/yT9WmyXoBTmL0+W6wDvscA+ijnPAMo8M5gD5GjddqbO9yD6CPYvIZVss5Hi0iGnOPg6BzIiJDb8n1mWfqsS7Qb8Xbc+wz9WvXODV5DCcOQ8HDvLglOEK/YiZYZj5mg1B0VmuxZYp2G6LkWQlWTkS7DVFyrASdRY9gWgSXEaSlkhJBZhFspaTIMItgOSURZCZ4KHgUDWCXom3gOSdj2EVQqqVhFmUYQelY/G5ihWkEnVQsQoYRLKeiTzCMYDuRQ93gNZV8PrhOkycrXgwjKB0kU2Xy3q2Zlesv9qrVZrNZfbF3UMub3k0b4YJO/M+G3l0Z5dhpHYYPydrFVvMgpxszLVkKHsadZZScuXLVwr3gYeXYwB/wsBSU+vEWYU7vO5DDhvJVHh1JpoLNODmqGLkX8LOU/S8QNx2YChZj5Kii1wg/wD+sGhH/QRm2CZcadY4q5i7NZ1snF3ZkGkH6Oqrou7Q3mhxjIlfZRrBNKxjr1L39YuxUhG0EpT26gVuJexx9eH37n5axIGWZMa7j32kOjl8ZC0q7NONa7AD6PPTuQLBdg25/otkz5VeSukxQNVlHkKpTGAfJPb9lMBZsUYTQrLJ9p2R5SR7Ck5TdeMXz9Ms+cQTZnj0nzatM5qv3SfwUPYX3sjF8upnJbH1EomjO2U9eXm9kXMWPX8IF5yuC0mM3hJ7iJjRTT+ZrDUrSs42MDzBTOV3FSpDNzC1bHwMUjbnqgx4fjAwzW0++miWYT3CS4cSrjcwYW7/Dh1FRRL8vMY83MxNs/R6rOG99wuXRRiak+AQz4BgCfylASyZs6PIJKoxKTfTrkvPp5rQgum2Yc/gr5c8jQuhl6sLkaGSSojJ1DuvodCXFZqou6sc6cfgQaTg9iivXot+WhteoJM1Mj+LztqPwQYdwKlOVXdEvS8NTvOHEKK7P255pyNRAM6X45DZT57HZS+GpO9oxGMWNudsVenw2I0l9RX8UN0S/LBWRI1tEprqCuReiX5YKTDec5JP39fnbNXl8M3sZBmH86KXod6UDOZRO8yH1Q87vseUc93BokmYym4+pDR+sseUN5tnosXsaakHpwfoqU7Yxz5410YzYeJZewzVMmj4CG24+TbHh1+hnPwMXms3P0mu4fh/9bNzWKQS9IPt1+A79bLDfxjcpNlw9RT8bvgzpuyEHwzXko0Fzt28Yo9BwMLyHejS8Hcbo9zwMkcUUtrMYGsYQZG+4/hb1aHjDj1NKORgi28UHUMON1+k2fI56NHh3mHJDdEOEGz5Lt+G3qEfP/NB2Z/h5qg3RLR9u+GhODaMP1ubQcHVpuLiGi78OF7+WLko/TMIw5TMNsuMvylyKNlyUvQV6Ll2U/eE2cm+xKHt89O5pUb7TYD6YLsi3NvRXjEX5Xor5rL8Y37xX175DPnsxzi0w30sX5OwJ8817Qc4P0ZunhTkDRg5tEq9zfNaGyIYvkdzFyP4htYbrDzAPhxbTbPaPZ/SGa+s0bEMNcafc0B1iNvO9bJVoDb+7T8VzqCKmWUB3F9kfZFnWbmgNKfl6DWqI+1NAs3f2z2euoWzzUgu4D40h5pBbgtwv9TJ0iN3lpBZwChTEllLA57bsz3KA2uGk5nMOTVLMzsJj1lST/fHs1lC2djjJDXkL7THYQiPN6PnZzE/yCL5BfANdhusz/iDcBir78y/yODyDCE5S7MzmgemI2R/lSXgGEZykuDtfQ5DDdzb7FzVkKFsDLnYe0EqK2/4GIEbT7Ktfwn5eFHnIedyDJim+3w+J7hfZP0X4uYNNg4OdxztonZm5DKMHN2/QjjSUC9TTKRHwEGI3FgHTaXo3xkSkKZ9iA566Z3ZDj6k0HQ7aKGweeQoP4Yyh1CdcTYNBG0XhgrkgvNuvbs/qFUMmpu/JMSYqT9nXU/C+CdIrPMaPEUeDNhKtztoQ7If/JcIYI8PxQRu9FBnvheFlBpiko6812exPAEF3tGG6UyTIUVAl9QhqTXjQRlNgOIKfk3yZg1TSIcMNBmKMiY4iu4J6Cs9RULv3cecad9AGZShrRXijWMX/HijEq+hBm7/ic5Icxf2UJMxT3BiDUGSxFu8TVBloMww4m9oLzqSQfEUlE4TXGY+BTWwoW0mPqM/JBNfwH9nCdMiDKNvJTjdvSE9wyP74HYvcUNbU5OrN+SmhILxVBNQpgiirhaQy9e0aSZvwAI6kI0oFCkM3UztJ7PrP35EtQZoQSlJPo1JUEyg4g9P3SAXJQ+hCUU6HaGq8j4ylekH+lVSRsJD6dGkVZatD3/4ve5Yqq0d/JVQk6oV30HQMH5XW8fKm4C+Oo79tE02kuJNtNJTF5taRfMa56Fl3i98++xYeRsBX0mga1HnqOdr2DUldvezK1njSqEd/BytCd77TUIyn42jWWQMmWWp0LC38sKN/ABVnnsZgHkwz2YyjapbcG1ziH9LtqdN6Q8V/Ave/1IJx6ukIzbbUXncQEczSTvemY1s2svNqKqRtUJaZgDpd3w+jupqW3Kn3Gj43vXpHtVy3yNiN/XuAtkGy8Y0i3koMva+q3aKqwD/46LeZbSOeoHQRo2UkgjajbRDt7CPpxq02ccG3jRh19A7KETxBjv77HipTt+nGtRD001tS2Mi2sQ7/gIgDWhXYoan/i8zU+IvQp5RAV4zL0b8iFNfIt70IhBdUT/G31XCmon/gRM4gBYra2b8nw0i9o4ikmwJF9eg/44rJlNF0KU62je1kymjKFO3O3WfUdeo9YboVVS1oG/Sb3rQrBm2DiWA6KuqwbawzEnT7oi18unHR5F9ZCbrTjfgBzl2LMtP7gh3hOw2N9W3BnuD9YsKnlFGILakFHr9GulCFZarK62p5XVCmamxrzDhdS0RNtXq8/FxKHe67YpXtDcFpGgW+YbQ7+MMBBnANI/cA+nTRJw4JY9W5BzCgxyVV494MiEWpzryqaolfJyNkp8N0w6FaPVEJOmJwxiyOaqHOrcdjGXSYOGqFXjr8PHbqhaTraqr8PC5v7AQXpGqrgutLJN2ICxVUeppVF9gfsJQaclxJV6/TFV8+MVzEkVThV3CEUurWLZvY0ruvUU939CbYaXTsmZdJRnKaZXcaXP9PGhLhots7K+AvzbhutlWQe905SE0UpUGjV5dty7K9mN7h/p37j+T6TeRtqXnksnQx6Ha7wZ0o968GF6X5WXNLlixZsmTJktTzf4AGplzbL0a4AAAAAElFTkSuQmCC"})],-1))),c=e((()=>(0,o._)("a",{href:"/oauth2/authorization/github?redirect_uri=http://localhost:8080/PortChat"},[(0,o._)("img",{class:"github login-Logo",src:"https://w7.pngwing.com/pngs/490/316/png-transparent-computer-icons-github-github-icon-cat-like-mammal-carnivoran-black.png"})],-1))),m=e((()=>(0,o._)("a",{href:"/oauth2/authorization/naver?redirect_uri=http://localhost:8080/PortChat"},[(0,o._)("img",{class:"naver login-Logo",src:"https://t1.daumcdn.net/cfile/tistory/994331335F52047D05"})],-1))),w=e((()=>(0,o._)("a",{href:"/oauth2/authorization/kakao?redirect_uri=http://localhost:8080/PortChat"},[(0,o._)("img",{class:"kakao login-Logo",src:"https://www.gotchawashmall.com/design/gotcha82/gotcha/img/kakao.png"})],-1)));function k(n,a,t,e,k,v){return(0,o.wg)(),(0,o.iD)("div",l,[r,i,(0,o._)("form",{onSubmit:a[2]||(a[2]=(0,s.iM)((n=>v.onSubmit()),["prevent"]))},[(0,o.wy)((0,o._)("input",{type:"email",name:"username","onUpdate:modelValue":a[0]||(a[0]=a=>n.username=a),placeholder:"이메일 입력",minlength:"1",required:""},null,512),[[s.nr,n.username,void 0,{trim:!0}]]),u,(0,o.wy)((0,o._)("input",{type:"password",name:"password","onUpdate:modelValue":a[1]||(a[1]=a=>n.password=a),placeholder:"비밀번호 입력",minlength:"4",maxlength:"16",autocomplete:"new-password",required:""},null,512),[[s.nr,n.password,void 0,{trim:!0}]]),p,d,h],32),g,(0,o.Uk)("   "),c,(0,o.Uk)("   "),m,(0,o.Uk)("   "),w])}var v=t(4206),b=t.n(v),f={name:"LoginPage",props:{},data:()=>({username:"",password:""}),methods:{onSubmit:function(){if(console.log(this.login),null==this.username||null==this.password)return void alert("필수값 누락");const n={username:this.username,password:this.password};console.log(n),b().post("/login",n).then((function(n){alert("data",n.data),console.log("data : ",n.data),console.log("data type : ",typeof n.data)})).catch((function(n){console.log(n);const a=decodeURIComponent(n.request.responseURL),t=a.split("="),o=t[1].replaceAll("+"," ");alert(o)}))}}},D=t(3744);const U=(0,D.Z)(f,[["render",k],["__scopeId","data-v-0418572e"]]);var T=U}}]);
//# sourceMappingURL=user.a08ac89d.js.map