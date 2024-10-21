import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import fangwuleixing from '@/views/modules/fangwuleixing/list'
    import discussfangwuxinxi from '@/views/modules/discussfangwuxinxi/list'
    import news from '@/views/modules/news/list'
    import weixiuchuli from '@/views/modules/weixiuchuli/list'
    import storeup from '@/views/modules/storeup/list'
    import fangwupingjia from '@/views/modules/fangwupingjia/list'
    import fangwuxinxi from '@/views/modules/fangwuxinxi/list'
    import yuyuekanfang from '@/views/modules/yuyuekanfang/list'
    import woyaodangfangzhu from '@/views/modules/woyaodangfangzhu/list'
    import fangzhu from '@/views/modules/fangzhu/list'
    import yonghu from '@/views/modules/yonghu/list'
    import discusswoyaodangfangzhu from '@/views/modules/discusswoyaodangfangzhu/list'
    import fangwubaoxiu from '@/views/modules/fangwubaoxiu/list'
    import hetongxinxi from '@/views/modules/hetongxinxi/list'
    import messages from '@/views/modules/messages/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
          ,{
	path: '/fangwuleixing',
        name: '房屋类型',
        component: fangwuleixing
      }
          ,{
	path: '/discussfangwuxinxi',
        name: '房屋信息评论',
        component: discussfangwuxinxi
      }
          ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
          ,{
	path: '/weixiuchuli',
        name: '维修处理',
        component: weixiuchuli
      }
          ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
          ,{
	path: '/fangwupingjia',
        name: '房屋评价',
        component: fangwupingjia
      }
          ,{
	path: '/fangwuxinxi',
        name: '房屋信息',
        component: fangwuxinxi
      }
          ,{
	path: '/yuyuekanfang',
        name: '预约看房',
        component: yuyuekanfang
      }
          ,{
	path: '/woyaodangfangzhu',
        name: '我要当房主',
        component: woyaodangfangzhu
      }
          ,{
	path: '/fangzhu',
        name: '房主',
        component: fangzhu
      }
          ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
          ,{
	path: '/discusswoyaodangfangzhu',
        name: '我要当房主评论',
        component: discusswoyaodangfangzhu
      }
          ,{
	path: '/fangwubaoxiu',
        name: '房屋报修',
        component: fangwubaoxiu
      }
          ,{
	path: '/hetongxinxi',
        name: '合同信息',
        component: hetongxinxi
      }
          ,{
	path: '/messages',
        name: '留言板管理',
        component: messages
      }
          ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
        ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
