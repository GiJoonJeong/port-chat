import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/loginForm',
    name: 'login',
    component: () =>
      import(/* webpackChunkName: "user" */ '../views/user/loginPage.vue')
  },
  {
    path: '/joinForm',
    name: 'join',
    component: () =>
      import(/* webpackChunkName: "user" */ '../views/user/joinPage.vue')
  },
  {
    path: '/joinDone',
    name: 'joinDone',
    component: () =>
      import(/* webpackChunkName: "user" */ '../views/user/joinDone.vue')
  },
  {
    path: '/test',
    name: 'storeTest',
    component: () =>
      import(/* webpackChunkName: "user" */ '../views/test/StoreTest.vue')
  },
  {
    path: '/loginJoin',
    name: 'LoginJoin',
    component: () =>
      import(/* webpackChunkName: "user" */ '../views/user/LoginJoin.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
