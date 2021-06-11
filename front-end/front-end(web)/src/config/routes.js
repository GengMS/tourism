import HeaderAsideLayout from '@/layouts/HeaderAsideLayout';
import NotFound from '@/pages/NotFound';
const Login =()=> import("@/components/Login/UserLogin");
const registy =()=> import("@/components/Registy/UserLogin")
const ForgetPasswd =()=> import("@/components/ForgetPasswd/UserLogin")
const Index =()=> import("@/pages/index/index");
const Tours =()=> import("@/pages/Tours/page");
const LvTu =()=> import("@/pages/LvTu/page");
const DongTai =()=> import("@/pages/dongtai/page")
const LvYouTuanInfor =()=> import("@/pages/LvYouTuanInfor/page")
const ArticleManagement =()=> import("@/pages/ArticleManagement/page")
const wen =()=> import("@/pages/wen/page")
const Show =()=> import("@/pages/show/page")
const dongTaiPage =()=> import("@/pages/dongtai/dongTai")
const TeamInforManage =()=> import("@/pages/teamInforManage/page")
const TeamInforPage =()=> import("@/pages/TeamInforPage/page")
const phoneNum =()=> import("@/pages/phoneNum/phoneNum")
const HomePageInforManage =()=> import("@/pages/homePageInforManage/page")
const NoticeManage =()=> import("@/pages/notice/index")
const routerConfig = [
  {
    path:"",
    component: Index
  },
  {
    path:"/registy",
    component:registy
  },
  {
    path:"/forgetPasswd",
    component: ForgetPasswd
  },
  {
    path:"/login",
    component: Login
  },
  {
    path:"/TeamInforPage",
    component: TeamInforPage
  },
  {
    path:"/tours",
    component: Tours
  },
  {
    path:"/lvtu",
    component:LvTu
  },
  {
    path:"/dongtai",
    component:DongTai
  },
  {
    path:"/dongtaiPage",
    component: dongTaiPage
  },
  {
    path:"/show/:id",
    component:Show
  },
  {
    path: '/dashboard',
    component: HeaderAsideLayout,
    children: [
      { path: 'analysis', component: LvYouTuanInfor },
      { path: 'monitor', component: ArticleManagement },
      { path:'teamInforManage', component: TeamInforManage},
      {path:"phoneNum",component:phoneNum},
      {path:"homePageInforManage",component:HomePageInforManage},
      {path:"notic", component: NoticeManage}
    ],
  },
  {
    path:"/wen",
    component:wen
  },
  { path: '*', component: NotFound },
];

export default routerConfig;
