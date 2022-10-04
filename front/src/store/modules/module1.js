// store/modules/module1.js
import $axios from 'axios'
export const module1 = {
  namespaced: true,
  state: {
    counter: 10,
    server: [],
    currentServer: '',
    userInfo: [],
    userName: '원래이름'
  },
  mutations: {
    SET_USER_NAME (state, value) {
      state.userName = value
    }
  },
  actions: {
    test () {
      console.log(4)
    },
    changeUserName ({ commit }, value) {
      console.log(value)
      commit('SET_USER_NAME', value + '변경')
    },
    loadUserName ({ commit }) {
      $axios
        .get('/user/userInfo')
        .then(function (response) {
          console.log('/userInfo', response)
          console.log('헤더 : ', response.headers)
          console.log('data : ', response.data)
          console.log('data type : ', typeof response.data)
          commit('SET_USER_NAME', response.data.username)
        })
        .catch(function (error) {
          console.log(error)
          commit('SET_USER_NAME', '로그인인함')
        })
    }
  },
  getters: {
    getUserName (state) {
      console.log(state.userName)
      return state.userName
    }
  }
}
