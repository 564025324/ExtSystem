@[toc]
---
## 添加热部署
### 热部署定义

    项目开发过程中经常会改动页面数据或者修改代码逻辑，为了显示改动效果往往需要重启服务来检查更改是否成功，其实就是重新编译的过程。
    例如修改了.java文件，就会在重新编译时生成新的.class文件，然后被虚拟机的ClassLoader加载。
    而热部署正是利用了这一特点，他监听到了又class文件改动了，就会重新创建一个新的ClassLoader进行加载该文件，最终将新的结果展现给我们。

        - (类加载机制)
        java中的类经过编译器可以吧代码编译为存储字节码的class文件，该class文件存储了各种信息，最终要加载到虚拟机中运行使用。
        虚拟机吧描述类的数据从class文件中加载到内存中，并对数据进行校验、转换解析和初始化，最终形成可以被虚拟机直接使用的java类型。

---

### 热部署的两种类型
#### Spring Loaded
这种方式是通过Maven插件的形式去加载，所以启动时必须通过Maven命令mvn spring-boot:run启动，而通过Application.run的方式启动无效，因为通过应用程序启动时已经绕开了Maven插件机制。
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <dependencies>
                <dependency>
                    <groupId>org.springframework</groupId>
                    <artifactId>springloaded</artifactId>
                    <version>1.2.5.RELEASE</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
 ```

#### spring-boot-devtools
这种方式无论怎么启动应用，都可以达到修改文件后重启应用的效果。
```xml
<!-- 热部署模块 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional> <!-- 这个需要为 true 热部署才有效 -->
</dependency>
```

### 注意
1. 如果发现没有热部署效果、检查IDE配置中是否打开自动编译。
2. 如果使用Thymeleaf模板引擎，需要把模板默认缓存设置为false
```properties
# 禁止thymeleaf缓存(建议开发环境false、生产环境设置为true)
spring.thymeleaf.cache=false
```
3. 针对devtools的可以指定目录或者排除了目录来进行热部署
```properties
# 添加那个目录的文件需要restart
spring.devtools.restart.additional-paths=src/main/java
# 排除那个目录不需要restart
spring.devtools.restart.exclude=static/**,public/**
```
4. 默认情况下，/META-INF/maven,/META-INF/resources/,/resources,/static,/public,/templates这些文件夹的文件我徐该不会使用重启，但是会重新加载(devtools内嵌了一个LiveReload Server，当资源发生变化时，浏览器刷新)
5. 在application.properties中配置spring.devtools.restart.enabled=false，此时restart类加载器还会初始化，但是不会监听文件更新，在springApplication.run之前调用System.setProperty("spring.devtools.restart.enable","false")，可以完全关闭重启支持。
