package com.bigball.girl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GirlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GirlApplication.class, args);

//		三种启动方式：
//		1。直接使用程序启动
//		2。进入源码目录使用命令 mvn spring-boot:run启动
//		3。源码目录使用mvn install命令生成，进入target目录使用java -jar *-SNAPSHOT.jar启动，次方法么还可定制使用哪个配置文件启动。

	}
}
