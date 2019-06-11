# 购物商城服务端
##### Rqeuired 
* JDK 1.8  
* Springboot
* Alibaba FastJson

>基于Springboot + Mybatis框架，Maven构建。使用swagger来显示Restful风格的接口。
>项目打包: mvn clean install

## 2019年6月11日14:40:03
#### 更新
* 项目升级至Springboot 2
* 加入Eureka依赖，可通过Spring Cloud Eureka管理

## 2019年6月10日15:20:31
#### 更新
* 新增参数校验器、反射工具类、责任链和执行器等
* 加依赖项更新，将常用工具类代码依赖移步到jar包内
* 添加Swagger开关，在生产环境中将swagger.enable=false，即可关闭Swagger服务