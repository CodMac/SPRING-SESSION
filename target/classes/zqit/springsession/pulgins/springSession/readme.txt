spring-session原理:
	1. SessionRepositoryFilter：
		Servlet规范中Filter的实现，用来切换HttpSession至Spring Session，包装HttpServletRequest和HttpServletResponse
	2. HttpServerletRequest/HttpServletResponse/HttpSessionWrapper包装器：
		包装原有的HttpServletRequest、HttpServletResponse和Spring Session，实现切换Session和透明继承HttpSession的关键之所在
	3. Session：
		Spring Session模块
	4. SessionRepository：
		管理Spring Session的模块
	5. HttpSessionStrategy：
		映射HttpRequst和HttpResponse到Session的策略
		

spring-boot集成spring-session
	1. 集成pom相关依赖
	2. 添加 @EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800, redisNamespace = "spring-session")
		spring自动添加使用拦截器 
			[characterEncodingFilter] 
			[sessionRepositoryFilter] 
			[hiddenHttpMethodFilter] 
			[httpPutFormContentFilter]
			[requestContextFilter]
		同时,让Spring根据配置文件中的配置连到Redis


测试方法:
	1.先以8080端口启动程序
	2.修改/src/main/resources/application.yml文件, 将端口改为8081
	3.同一个浏览器,分别访问 http://localhost:8080/test/a, http://localhost:8081/test/b.
		结果:返回打印的session-id相同
