<template>
  <div class="login">
    <h1>로그인 페이지</h1>
    <hr />
    <form @submit.prevent="onSubmit()">
      <input type="email" v-model.trim="login.username" placeholder="이메일 입력" minlength="1" required/><br />
      <input type="password" v-model.trim="login.password" placeholder="비밀번호 입력" minlength="4" maxlength="16" autocomplete="new-password" required/>
      <button type="submit">로그인</button>
    </form>
    <a href="/oauth2/authorization/google">구글 로그인</a> |
    <router-link to="/joinForm">가입하기</router-link> |
  </div>
</template>
<script>
import $axios from 'axios'
export default {
  name: 'LoginPage',
  data: () => ({
    login: {
      username: '',
      password: ''
    }
  }),
  methods: {
    onSubmit: function () {
      console.log(this.login)
      if (this.login.username == null || this.login.password == null) {
        alert('필수값 누락')
        return
      }
      const vm = this
      $axios
        .post('/login', vm.login)
        .then(function (response) {
          console.log('data : ', response.data)
          console.log('data type : ', typeof response.data)
          alert('로그인 성공')
        })
        .catch(function (error) {
          alert('로그인 실패')
          console.log(error)
        })
    }
  }
}
</script>
