# 购物商城服务端
![](https://img.shields.io/badge/JDK-1.8-brightgreen.svg)
![](https://img.shields.io/badge/License-Apache%202.0-orange.svg)

##### Rqeuired 
* JDK 1.8  
* Springboot
* Alibaba FastJson

>基于Springboot + Mybatis框架，Maven构建。使用swagger来显示Restful风格的接口。
>项目打包: mvn clean install

## 项目部署
* 因为商品表中包含有base64编码后的缩略图，所以使用Navicat等工具可能会出现导入失败的错误。这里推荐使用官方的MySQL Workbench导入  
* 编译后默认输出jar包，需要放到Tomcat中部署则需要先修改pom文件内的打包格式，改成war

## 2019年7月5日16:19:20
#### 更新
* 精简服务端接口回传数据，不返回base64编码的图片

## 2019年6月11日14:40:03
#### 更新
* 项目升级至Springboot 2
* 加入Eureka依赖，可通过Spring Cloud Eureka管理

## 2019年6月10日15:20:31
#### 更新
* 新增参数校验器、反射工具类、责任链和执行器等
* 加依赖项更新，将常用工具类代码依赖移步到jar包内
* 添加Swagger开关，在生产环境中将swagger.enable=false，即可关闭Swagger服务