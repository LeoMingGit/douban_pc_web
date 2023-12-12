import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)

export default new Router({
	mode:'history',
	routes: [
    {
      path: '/film/detail',
      name: "filmDetail",
      component: () => import('@/views/film/detail'),
      hidden: true
    },
    {
      path: '/film/home',
      component: () => import('@/views/film/home'),
      hidden: true
    },
	]
})
