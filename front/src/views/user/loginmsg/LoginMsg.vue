<template>

    <div class="loginMsg" :class="{'visibility' : !isCheck}">
        <div class="textcontent">
            <p class="title">Don't have an account?</p>
            <p>Sign up to save all your graph.</p>
        </div>
            <button id="switch1" @click="toJoin">Sign Up</button>
    </div>

    <div class="signupMsg" :class="{'visibility' : isCheck}">
        <div class="textcontent">
            <p class="title">Have an account?</p>
            <p>Log in to see all your collection.</p>
            <button id="switch2" @click="toLogin">LOG IN</button>
        </div>
    </div>
</template>

<script>
export default {
  name: 'LoginMsg',
  props: {
    isCheck: Boolean
  },
  methods: {
    toJoin () {
      console.log('toJoin()')
      this.$emit('checkKey', false)
    },
    toLogin () {
      console.log('toLogin()')
      this.$emit('checkKey', true)
    }
  }
}
</script>
<style scoped>
    #switch1:hover{
        cursor: pointer;
        background-color: red;
    }
    button:hover{
        cursor: pointer;
        background-color: red;
    }
    .loginMsg, .signupMsg{
    width: 50%;
    height: 100%;
    font-size: 15px;
    box-sizing: border-box;
    }
    .loginMsg .title,
    .signupMsg .title{
    font-weight: 300;
    font-size: 23px;
    }
    .loginMsg p,
    .signupMsg p {
    font-weight: 100;
    }
    .textcontent{
    color:white;
    margin-top:65px;
    margin-left: 12%;
    }
    .loginMsg button,
    .signupMsg button {
    background-color: #404040;
    border: 2px solid white;
    border-radius: 10px;
    color:white;
    font-size: 12px;
    box-sizing: content-box;
    font-weight: 300;
    padding:10px;
    margin-top: 20px;
    }
    .loginMsg, .signupMsg{
    /*opacity: 1;*/
    transition: opacity .8s ease-in-out;
    }
    </style>
