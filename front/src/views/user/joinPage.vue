<template>
  <div>
    <h1>회원가입 페이지</h1>
    <hr />
    <form @submit.prevent="onSubmit()">
      <input type="email" v-model.trim="signup.email" placeholder="이메일 입력" minlength="1" required/><br />
      <input type="text" v-model.trim="signup.username" placeholder="닉네임 입력" minlength="1" maxlength="20" /><br />
      <input type="password" v-model.trim="signup.password" placeholder="비밀번호 입력" minlength="4" maxlength="16" @blur="passwordValid()" autocomplete="new-password"/>
         <span class="green" v-if="passwordValidFlag == 2">
          사용가능
        </span>
        <br />
        <div class="red" v-if="!passwordValidFlag">
          영어 소문자+숫자 조합 4~16자리 입력해주세요
        </div>
      <input type="password" v-model.trim="passwordCheck" placeholder="비밀번호 확인" minlength="4" maxlength="16" @blur="passwordCheckValid()" autocomplete="new-password"/>
        <span class="green" v-if="passwordCheckFlag == 2">
          일치
        </span>
        <br />
        <div class="red" v-if="!passwordCheckFlag">
          비밀번호가 동일하지않습니다.
        </div>
      <button type="submit">회원가입</button>
    </form>
    <router-link to="/loginForm">로그인 하러가기</router-link>
  </div>
</template>
<script>
import $axios from 'axios'
export default {
  name: 'JoinPage',
  data: () => ({
    signup: {
      email: '',
      username: '',
      password: ''
    },
    passwordCheck: '',
    passwordValidFlag: 1,
    passwordCheckFlag: 1
  }),
  methods: {
    onSubmit: function () {
      console.log(this.signup)
      if (this.signup.email == null || this.signup.username == null || this.signup.password == null) {
        alert('필수값 누락')
        return
      }
      if (!this.passwordValidFlag || !this.passwordCheckFlag) {
        alert('유효성 확인')
        return
      }
      const data = this.signup
      const vm = this
      $axios
        .post('/user', data)
        .then(function (response) {
          console.log('data : ', response.data)
          console.log('data type : ', typeof response.data)
          alert(response.data)
          vm.$router.push('/joinDone')
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    passwordValid () {
      if (/^(?=.*[a-z])(?=.*[0-9]).{4,16}$/.test(this.signup.password)) {
        this.passwordValidFlag = 2
      } else {
        this.passwordValidFlag = 0
      }
    },
    passwordCheckValid () {
      if (this.signup.password === this.passwordCheck) {
        this.passwordCheckFlag = 2
      } else {
        this.passwordCheckFlag = 0
      }
    }
  }
}
</script>
<style>
.red {
  color: #d25050;
}
.green {
  color: #42b983;
}
</style>
