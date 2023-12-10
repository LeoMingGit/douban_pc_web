import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)

export default new Router({
	mode:'history',
	routes: [
		// {
		// 	path: '/f',
		// 	name: 'Films',
		// 	component: Films
		// },
		// {
		// 	path: '/describe',
		// 	name: 'Describe',
		// 	component: Describe
		// },
    {
      path: '/film/home',
      component: () => import('@/views/film/home'),
      hidden: true
    },
	]
})
