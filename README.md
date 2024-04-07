# kintong3000

[我的博客](https://kintong3000-me.vercel.app/)

一个简单的个人博客

前端博客展示+后台管理系统

博客前端使用nuxt构建，实现ISR（Incremental Static Regeneration）动态更新无需重新部署，且相比CSR(Client-Side Rendering)有良好的SEO,同时减短加载时间，使得用户有更好的体验。相比SSR(Server-Side Rendering),减少了服务器的实时计算需求，帮助降低服务器成本。

文章自动同步于github仓库

### 技术栈
- Springboot
- Spring Security
- Redis
- Mysql
- Mybatis-Plus
- Vue3
- Nuxt3
- Unocss

### 部分界面
![CleanShot 2024-03-13 at 14.55.04@2x](https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/CleanShot%202024-03-13%20at%2014.55.04@2x.png)
![CleanShot 2024-03-13 at 14.56.03@2x](https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/CleanShot%202024-03-13%20at%2014.56.03@2x.png)
![CleanShot 2024-03-13 at 14.56.47@2x](https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/CleanShot%202024-03-13%20at%2014.56.47@2x.png)
![CleanShot 2024-03-13 at 14.57.29@2x](https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/CleanShot%202024-03-13%20at%2014.57.29@2x.png)
![CleanShot 2024-03-13 at 14.58.28@2x](https://cdn.jsdelivr.net/gh/kintong3000/Kintong-Image-Hosting@main/img/CleanShot%202024-03-13%20at%2014.58.28@2x.png)


### 本地开发
#### 配置修改
进入服务端文件夹cd blog-server,修改spring-boot配置文件application-dev.yml
```yml
spring:
    datasource:
      driverClassName: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/kintong-blog
      username: root
      password: 
```
将数据库的用户名和密码修改成对应你数据库的用户名密码

#### 项目启动
##### 后端
进入blog-server文件夹，找到BlogServerApplication,直接在IDE中运行BlogServerApplication启动类的main方法就可以看到项目启动了。
##### 前端
进入文件夹cd blog-fronted，安装依赖并启动服务：
```shell
pnpm install
pnpm run dev
```
进入文件夹cd blog-admin，安装依赖和启动服务：
```shell
pnpm install
pnpm dev
```
