\# 数据库设计说明



本项目使用MySQL数据库，核心表包括`student1`（学生信息表）和`login`（用户登录表），结构如下：





\## 1. student1表（学生信息表）

| 字段名       | 数据类型         | 约束           | 说明                 |

|--------------|------------------|----------------|----------------------|

| id           | int              | PRIMARY KEY    | 自增主键（唯一标识） |

| student\_id   | varchar(20)      | NOT NULL, UNIQUE | 学号（如2023001）    |

| name         | varchar(50)      | NOT NULL       | 学生姓名             |

| age          | int              |                | 年龄（可为空）       |

| department   | varchar(100)     | NOT NULL       | 院系（如计算机学院） |

| create\_time  | datetime         | DEFAULT NOW()  | 记录创建时间         |





\## 2. login表（用户登录表）

| 字段名       | 数据类型         | 约束           | 说明                 |

|--------------|------------------|----------------|----------------------|

| id           | int              | PRIMARY KEY    | 自增主键             |

| username     | varchar(50)      | NOT NULL, UNIQUE | 登录用户名（如教师工号/学生学号） |

| password     | varchar(100)     | NOT NULL       | 密码（建议加密存储） |

| role         | varchar(20)      | NOT NULL       | 角色（student/teacher） |

| status       | tinyint          | DEFAULT 1      | 状态（1-正常，0-禁用） |

