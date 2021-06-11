// 菜单配置
// headerMenuConfig：头部导航配置
// asideMenuConfig：侧边导航配置

const headerMenuConfig = [];
let registy = 60;
const asideMenuConfig = [
  {
    path: '/dashboard',
    name: '管理员功能(一)',
    icon: 'el-icon-menu',
    children: [
      {
        path: '/analysis',
        name: '旅游团信息发表',
      },
      {
        path: '/monitor',
        name: '动态信息管理',
      },{
        path:'/teamInforManage',
        name:"旅游团信息管理"
      },{
        path:"/phoneNum",
        name:"手机号"
      },{
        path:"/homePageInforManage",
        name:"首页显示信息管理"
      },{
        path:"/notic",
        name:"通知管理"
      }
    ],
  }
];

export { headerMenuConfig, asideMenuConfig, registy };
