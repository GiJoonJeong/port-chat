<template>
  <div class="container">
      <div class="backbox">
        <LoginMsg :isCheck="isCheck" @checkKey="checkKey"></LoginMsg>
      </div>
      <div class="frontbox" :class="{'moving' : !isCheck}">
        <LoginPage v-show="isCheck" ></LoginPage>
        <JoinPage v-show="!isCheck"></JoinPage>
      </div>
  </div>

</template>

<script>
import LoginPage from './loginPage.vue'
import JoinPage from './joinPage.vue'
import LoginMsg from '../user/loginmsg/LoginMsg.vue'
export default {
  components: {
    LoginMsg,
    LoginPage,
    JoinPage
  },
  data () {
    return {
      isCheck: true
    }
  },
  methods: {
    checkKey (asd) {
      this.isCheck = asd
    }
  }
}
</script>

<style lang="scss">
 @import "@/assets/scss/loginjoin.scss"
</style>
<style scoped>
.container{
    /*border:1px solid white;*/
    width: 600px;
    height: 350px;
    position: absolute;
    top:50%;
    left:50%;
    transform: translate(-50%, -50%);
    display: inline-flex !important;
  }
  .backbox{
    background-color: #404040;
    width: 100%;
    height: 80%;
    position: absolute;
    transform: translate(0,-50%);
    top:50%;
    display: inline-flex !important;
  }
  .frontbox{
    background-color: white;
    border-radius: 20px;
    height: 100%;
    width: 50%;
    z-index: 10;
    position: absolute;
    right:0;
    margin-right: 3%;
    margin-left: 3%;
    transition: right .8s ease-in-out;
  }
  .moving{
    right:45%;
  }
</style>
