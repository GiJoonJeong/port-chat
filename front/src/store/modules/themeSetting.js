export const themeSetting = {
  namespaced: true,
  state: {
    theme: []
  },
  mutations: {
    SET_THEME_MODE (state, value) {
      state.theme = value
    }
  },
  actions: {
    changeThemeMode ({ commit }, value) {
      console.log('getThemeMode : ', value)
      commit('SET_THEME_MODE', value)
    }
  },
  getters: {
    getTheme (state) {
      console.log(state.theme)
      return state.theme
    }
  }
}
