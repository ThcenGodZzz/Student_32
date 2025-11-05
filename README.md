# Student_32：学生管理系统
基于Java Servlet+MySQL的轻量级学生管理系统，支持学生信息CRUD、分页查询、用户登录注册、作业上传等功能。

## 功能说明
- 学生信息管理：新增、查询、修改、删除学生信息（学号、姓名、年龄、院系）
- 用户管理：登录、注册、密码修改、账号注销
- 作业上传：验证学生信息后上传文件
- 分页查询：按页展示学生数据

## 技术栈
- 后端：Java、Servlet、JDBC
- 数据库：MySQL
- 服务器：Tomcat 8.5
- 工具类：Apache Commons（文件上传、数据库连接池）

## 安装部署
1. 克隆仓库：`git clone https://github.com/ThcenGodZzz/Student_32.git`
2. 配置数据库：修改`dbcpconfig.properties`中的数据库连接信息
3. 部署到Tomcat：将项目打包为WAR包，放入Tomcat的webapps目录
4. 启动Tomcat，访问`http://localhost:8080/webapp`

## 贡献指南
欢迎提交issue或PR，参与功能改进和bug修复。
