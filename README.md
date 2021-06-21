# tourism
旅游项目，有web端，app端，微信小程序端。

分登录，旅游团信息，旅图，旅游动态这几个板块（微服务）；

权限分管理员和普通用户。

因为主要是面向c端的项目所以没有提供管理员的注册及相关账号功能



## 技术栈：

前端：

- vue
- element ui
- 飞冰
- uniapp
- 还有很多前端插件,就不一一说了，大家可以看package.json

后端：

 - springboot
 - springCloud(openfeign+gateway)
 - springCloudAlibaba(nacos+setinel+seata)
 - mysql+redis(消息队列及时效性数据使用redis)
 - easyexcel
 - mail
 - fastDfs
 - 等等

## 概览：

<img src="screenshots/all.png" alt="image" style="zoom:60%;" />

## 界面图

#### pc

主页

<img src="screenshots/index.png" alt="image" style="zoom:60%;" />

登录

<img src="screenshots/login.png" alt="image" style="zoom:60%;" />

注册：

<img src="screenshots/registry.png" alt="image" style="zoom:60%;" />

忘记密码：

<img src="screenshots/forgetPass.png" alt="image" style="zoom:60%;" />

修改信息：

<img src="screenshots/updateInfor.png" alt="image" style="zoom:60%;" />

旅游团

<img src="screenshots/team.png" alt="image" style="zoom:60%;" />

旅游团详细信息

<img src="screenshots/teamInfor.png" alt="image" style="zoom:60%;" />

旅图

<img src="screenshots/myPhoto.png" alt="image" style="zoom:60%;" />

照片墙：

<img src="screenshots/photowall.png" alt="image" style="zoom:60%;" />

动态：

<img src="screenshots/dong_tai.png" alt="image" style="zoom:60%;" />

发布动态：

<img src="screenshots/publishDong.png" alt="image" style="zoom:60%;" />

 后台-旅游团信息发布

<img src="screenshots/backEnd_team.png" alt="image" style="zoom:60%;" />

后台：动态信息管理

<img src="screenshots/backEnd_dong.png" alt="image" style="zoom:60%;" />

后台：旅游团信息管理

<img src="screenshots/backEnd_teaminfor.png" alt="image" style="zoom:60%;" />

后台：预定用户手机号查看

<img src="screenshots/backEnd_phone.png" alt="image" style="zoom:60%;" />

后台：首页展示信息管理

<img src="screenshots/backEnd_index.png" alt="image" style="zoom:60%;" />

后台：通知管理

![backEnd_email](screenshots/backEnd_email.png)

#### 手机端

微信小程序测试平台为 “微信开发者工具”

app测试平台为：“逍遥模拟器”

![app_test](screenshots/app_test.png)

展示：

具体页面的名称我就我介绍了，大家可以自行观看

![wx_dong](screenshots/wx_dong.png)

![wx_dong2](screenshots/wx_dong2.png)

![wx_forget](screenshots/wx_forget.png)

![wx_login](screenshots/wx_login.png)

![wx_phone](screenshots/wx_phone.png)

![wx_registry](screenshots/wx_registry.png)

![wx_team](screenshots/wx_team.png)

![wx_team_infor](screenshots/wx_team_infor.png)

![wx_tu](screenshots/wx_tu.png)

![wx_xiu](screenshots/wx_xiu.png)

app端页面样式和小程序端相同，我就不截图展示了，大家可以自行下载源码查看

![app_index](screenshots/app_index.png)

