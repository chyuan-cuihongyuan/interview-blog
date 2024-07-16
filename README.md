1. 技术选型
   语言和框架: 使用Java 17和Spring Boot 3.x来构建项目。
   数据库: 使用MySQL作为关系型数据库。
   ORM框架: 使用MyBatis来进行数据库操作。
   认证机制: 自行实现基于JWT的身份认证，而不使用Spring Security。
2. 数据库设计
   设计两个主要的表：用户表（users）和文章表（posts）。

用户表（users）
user_id: 主键，用户ID
username: 用户名
password: 密码（加密存储）
email: 邮箱
created: 创建时间
last_modified: 最后修改时间
文章表（posts）
post_id: 主键，文章ID
title: 标题
content: 内容
user_id: 作者ID，关联到用户表
created: 创建时间
last_modified: 最后修改时间
3. 服务设计
   3.1 用户管理
   提供用户注册、登录、获取当前用户信息的API。

用户注册
接收用户名、密码、邮箱等信息。
对密码进行加密存储。
返回注册成功的信息。
用户登录
接收用户名和密码。
验证用户信息，生成JWT token。
返回JWT token。
获取当前用户信息
根据JWT token解析出用户名。
返回用户的详细信息。
3.2 文章管理
提供创建、读取、更新和删除文章的API。

创建文章
接收文章标题和内容。
根据JWT token解析出作者信息，关联文章和用户。
返回创建成功的文章信息。
获取文章列表
支持分页和按创建时间排序。
返回文章列表。
获取单篇文章详情
根据文章ID获取文章的详细信息。
返回文章详情。
更新文章
验证JWT token，确保是作者本人操作。
更新文章内容。
返回更新后的文章信息。
删除文章
验证JWT token，确保是作者本人操作。
删除文章。
返回删除成功的信息。
4. 认证机制
   JWT Token
   用户登录成功后，生成JWT token，返回给客户端。
   客户端每次请求需要认证的接口时，需在请求头中携带JWT token。
   服务器通过拦截器或过滤器验证JWT token的有效性。
   JWT工具类
   generateToken(String username): 生成JWT token。
   getUsernameFromToken(String token): 从JWT token中解析出用户名。
5. 权限控制
   只有文章的作者才能修改或删除自己的文章。
   在更新和删除文章的API中，通过JWT token解析出用户名，确保操作的是文章的作者。
6. 错误处理和日志记录
   统一的异常处理机制，返回规范的错误信息。
   使用Log4j2进行日志记录。
7. Docker部署
   使用Dockerfile构建项目镜像。
   使用Docker Compose配置应用和MySQL数据库。
   编写启动脚本，确保应用和数据库能够正常启动和交互。
8. 详细实现
   8.1 数据模型
   User类和Post类分别对应users和posts表。
   8.2 MyBatis配置
   UserMapper.xml和PostMapper.xml文件配置SQL语句。
   UserMapper和PostMapper接口与数据库操作对应。
   8.3 服务层
   UserService和PostService接口定义业务逻辑。
   UserServiceImpl和PostServiceImpl实现业务逻辑。
   8.4 控制器层
   AuthController处理用户注册、登录、获取当前用户信息的请求。
   PostController处理文章的创建、读取、更新和删除的请求。
   8.5 工具类
   PasswordUtil进行密码加密和验证。
   JwtUtil生成和解析JWT token。
   8.6 配置文件
   application.properties配置数据库连接信息和MyBatis的相关配置。
   8.7 Dockerfile和Docker Compose
   Dockerfile定义应用镜像构建。
   docker-compose.yml配置应用和MySQL数据库的服务。
9. 项目启动
   使用Maven构建项目。
   使用Docker启动MySQL数据库。
   使用Docker启动Spring Boot应用。
   访问API进行测试。