
# SpringBoot2.0创建maven多模块项目(从构建到打包成jar包发布)

> 一直想自己搭建一个多模块的项目，于是研究了一下这个，网上关于这个的文章很多，虽然不是很好，但我从中收获了很多，在这集百家所长，写一份实战记录，大家跟着我一块做吧！

>> 声明：构建多模块不是最难的，难点是如果把多模块打包成一个执行jar。
>> SpringBoot官方推崇的是富jar，也就是jar文件启动项目，所以如果在这里打war包我不具体介绍，如果需要的朋友可以给我留言，我回复。

>>建议clone项目后，在看教程（有不足的地方希望大家保函，指出来，我们一起学习改进）

..搭建完成后，项目结构如下：

springboot2.0          --父工程，管理依赖版本，和聚合项目打包任务
  --domain             --实体类，不依赖任何项目
  --dao                --mybatis集成，包括与mysql交互的mapper文件和dao文件，依赖domain实体类
  --service            --业务实现类，依赖domain实体类和dao数据库交互
  --web                --controller和静态资源，负责开发中项目启动任务，依赖domain实体类和dao数据库交互以及service服务提供


## 构建工程（搭建过程中一直要注意包与包之间的关系和父与子子与子之间的依赖关系）

###自己搭建请从头开始，仅仅部署请移步第7步，打包成jar并发布请移步第8步，上传到码云请移步第10步

#### 新建父工程和模块工程
- 1.首先在本地maven构建建springboot2.0父工程，删除除pom外的所有文件，父工程用来打包和管理依赖版本，修改pom文件如下

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	
	<modelVersion>4.0.0</modelVersion>
	<groupId>blm.server</groupId>
	<artifactId>springboot2.0</artifactId>
	<packaging>pom</packaging>
	<version>1.0-SNAPSHOT</version>
	
	<modules>
		<module>web</module>
		<module>service</module>
		<module>dao</module>
		<module>domain</module>
	</modules>
	
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.0.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
	
	<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <skipTests>true</skipTests>    <!--默认关掉单元测试 -->
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

- 2.右键springboot2.0父项目，新建maven module实体项目domain，修改pom如下

	<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
         
    <parent>
        <groupId>blm.server</groupId>
        <artifactId>springboot2.0</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>
    
    <modelVersion>4.0.0</modelVersion>
    <artifactId>domain</artifactId>
    
</project>

- 3.右键springboot2.0父项目，新建maven module数据库交互项目dao，修改pom如下

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <groupId>blm.server</groupId>
        <artifactId>springboot2.0</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>dao</artifactId>

    <dependencies>
        <dependency>
            <groupId>blm.server</groupId>
            <artifactId>domain</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        
        <dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.3.2</version>
		</dependency>
		
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		
    </dependencies>
    
</project>

- 4.右键springboot2.0父项目，新建maven module服务项目service，修改pom如下
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <groupId>blm.server</groupId>
        <artifactId>springboot2.0</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>service</artifactId>
    
<dependencies>
    <dependency>
        <groupId>blm.server</groupId>
        <artifactId>domain</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    
    <dependency>
        <groupId>blm.server</groupId>
        <artifactId>dao</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
</dependencies>

</project>

- 5.右键springboot2.0父项目，新建maven module服务项目web，修改pom如下
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <groupId>blm.server</groupId>
        <artifactId>springboot2.0</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>web</artifactId>

    <dependencies>
        <dependency>
            <groupId>blm.server</groupId>
            <artifactId>service</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        
        <dependency>
            <groupId>blm.server</groupId>
            <artifactId>dao</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        
        <dependency>
            <groupId>blm.server</groupId>
            <artifactId>domain</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

    <build>
    
    <resources>
    <resource>
    <directory>src/main/java</directory>
    <includes>
        <include>**/*.xml</include>
    </includes>
</resource>
</resources>

        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <!-- 指定该Main Class为全局的唯一入口 -->
                   <mainClass>iflyer.IflyerApplication</mainClass>
                    <layout>ZIP</layout>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal><!--可以把依赖的包都打包到生成的Jar包中-->
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
    
</project>

- 6.分别编写domain，dao，service，web层代码，在web项目下新建src/main/resources资源文件，加入application.properties配置文件及html等静态资源

#### 启动项目
- 7.mysql新建user表（user.sql导入也可以），加入varchar的name和int的age字段，修改web的application.properties数据库连接语句，右击web下的主启动类，浏览器输入相应路径即可访问

#### 项目发布
- 8.项目如果正常启动，接下来可以打包成jar包部署了，首先右击springboot2.0运行maven clean-〉清理垃圾资源，然后运行maven build-〉输入package进行打包

- 9.去web项目的target目录下可以找到web.jar文件，命令行输入java -jar web.jar即可启动项目

- 10.上传项目到码云，在码云上新建springboot2.0项目，然后下载到本地，将写好的本地项目拷到下载的git里，修改gitgrnore文件（忽略classpath等文件），再运行git commit或者用eclipse提交即可
# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*

### STS ###
.apt_generated
.classpath
.factorypath
.project
.settings
.springBeans

### IntelliJ IDEA ###
.idea
*.iws
*.iml
*.ipr

### NetBeans ###
nbproject/private/
build/
nbbuild/
dist/
nbdist/
.nb-gradle/

#项目截图

    ![](https://gitee.com/zk66/springboot2.0/raw/master/springboot2.0/web/src/main/resources/static/public/image/springboot2.0.png)
     ![](https://gitee.com/zk66/springboot2.0/raw/master/springboot2.0/web/src/main/resources/static/public/image/domain.png)
    ![](https://gitee.com/zk66/springboot2.0/raw/master/springboot2.0/web/src/main/resources/static/public/image/dao.png)
      ![](https://gitee.com/zk66/springboot2.0/raw/master/springboot2.0/web/src/main/resources/static/public/image/service.png)
        ![](https://gitee.com/zk66/springboot2.0/raw/master/springboot2.0/web/src/main/resources/static/public/image/web.png)
        
          ![](https://gitee.com/zk66/springboot2.0/raw/master/springboot2.0/web/src/main/resources/static/public/image/拦截器.png)
            ![](https://gitee.com/zk66/springboot2.0/raw/master/springboot2.0/web/src/main/resources/static/public/image/运行jar.png)
            ![](https://gitee.com/zk66/springboot2.0/raw/master/springboot2.0/web/src/main/resources/static/public/image/测试1.png)
            ![](https://gitee.com/zk66/springboot2.0/raw/master/springboot2.0/web/src/main/resources/static/public/image/测试2.png)

  
# very Good！Just do it ！

==提醒：所有模块里面的父节点都是一样的哦，不然会报错 unknow.version==
