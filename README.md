# SpringCloud-V1

## 此仓库用于个人学习springcloud第一代

1.第一代
SpringCloud.第一代实际上都是用的Netflix开源的组件整合微服务解决方案。
最开始 SpringCloud 的第一代版本时，它的每个分布式组件都不是自己研发，而是在 GitHub 上找 Netflix 公司（制作视频网站），该公司研发了许多开源的微服务框架。
SpringCloud 就将所有的组件核心进行了整合。
但并不是 SpringCloud 写出的，因为 SpringCloud 目的是为了解决程序员在微服务架构中遇到的问题，因而其中的Eureka、Hystrix、Ribbon、Feign 和 Zuul 网关其实都并非 SpringCloud 写的，而使用的都是 Netflix 公司的。
Spring Cloud 第一代:
Spring Cloud Config 分布式配置中心
Spring Cloud Netflix 核心组件.
Eureka:服务治理
Hystrix:服务保护框架
Ribbon:客户端负载均衡器
Feign:基于 ribbon 和 hystrix 的声明式服务调用组件。
Zuul:网关组件,提供智能路由、访问过滤等功能。

2.第二代
SpringCloud 第二代实际就是自己研发和 SpringCloudAalibaba 国内的优秀的微服务解决框架实现整合。
而闭源其实并不是真正的原因，其中最大的变化在网关上就有体现，在第一代中使用的是 zuul 网关，而第二代使用的则是自己研发的 Spring Cloud Gateway 网关。
在官网表述中可以得知 Gateway 网关性能远远好于 zuul 网关，同时客户端负载均衡器也从 Ribbon 换成Loadbalancer。服务保护框架也使用了 SpringCloud 自己孵化的 r4j。
Spring Cloud Alibaba Sentinel 服务保护框架也十分重要，能够替代我们之前学习的服务饱和框架。同时阿里迭代的框架相比原来也是更胜一筹。
阿里的 SpringCloud Alibaba Seata 分布式事务解决框架也能够很好的解决程序员在工作中遇到的许多分布式事务问题。
SpringCloud 第二代（自己研发）和优秀的组件组合:
Spring Cloud Gateway 网关
Spring Cloud Loadbalancer 客户端负载均衡器
Spring Cloud r4j(Resilience4J)服务保护
Spring Cloud Alibaba Nacos 服务注册
Spring Cloud Alibaba Nacos 分布式配置中心
Spring Cloud Alibaba Sentinel 服务保护
（可以替代我们所学过的所有保护式框架）
SpringCloud Alibaba Seata 分布式事务解决框架
（用于解决我们在微服务器中遇到的所有分布式问题）
Alibaba Cloud 0SS 阿里云存储
Alibaba Cloud SchedulerX分 布式任务调度平台
Alibaba Cloud SMS 分布式短信系统


三、SpringCloudalibaba与SpringCloud有哪些区别？
1.区别
SpringCloudalibaba 就是为了推广阿里云的产品对我们目前的 SpringCloud2.x 版本实现扩展功能。
Nacos 服务注册与发现、分布式配置中心就等同于 SpringCloud 第一代中的 Eureka 和 Spring Cloud Config
Rocketmq 买阿里云的 ons
同时在之后遇到的分布式云存储问题，Spring Cloud 0SS 也支持阿里的 oss。
阿里的 SpringCloud 还含有 Alibaba Cloud SchedulerX 分布式任务调度平台框架但稍逊。但如 Alibaba Cloud SMS分布式短信系统其实都是为阿里做推广。
SpringCloudalibaba 就是为了推广阿里云的产品对我们目前的 SpringCloud2.x 版本实现扩展功能。
因而在使用 SpringCloudAlibaba 其中消息中间件选型应和 Rocket 联动一起使用，但单机版本中搭建 Rocket 联动性能并不理想，所以要配套购买阿里云的 ons。而阿里云的 ons 其实就是性能更加强大的 Rocketmq 联动。
2. SpringCloudalibaba
在官网中展示的功能，可以发现 SpringCloudalibaba 就是为了对我们目前的 SpringCloud2.x 版本实现扩展功能，其中含有许多组件，优势在于能够将组合的组件与 SpringCloud 的 rpc 远程调度整合在一起。
