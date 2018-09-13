# AI_City_as_a_Beginner
课程设计项目
模拟一个类似于滴滴的车辆调度系统

工具：Intelij IDEA, maven
框架 Spring Boot
接口 REST风格
数据库 MySQL

fleet-schedule-demo 是我们的工程

已完成：basic-data-service 基础数据管理 （在data-cache文件夹。。。不知道怎么改）
        data-cache-service 数据缓存
		schedule0-service 车辆调度
未完成： 前端（重要）
         车辆模拟器
		 日志数据分析

		 
代码结构解释：核心代码在..\src\main\java\demo
              domain包含有该模块所需实体的模型和访问接口
              service包实现具体业务逻辑，如CRUD，车辆调度等
			  rest包实现模块对外REST风格接口
			  
  在..\main\resources内有配置文件，包括运行端口等
