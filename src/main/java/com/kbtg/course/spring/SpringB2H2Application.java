package com.kbtg.course.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringB2H2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringB2H2Application.class, args);

		String[] beans = context.getBeanDefinitionNames();
//		for (String bean: beans) {
//			System.out.println(bean);
//		}
		System.out.printf("Size: %d", beans.length);
		SpringApplication.run(SpringB2H2Application.class, args);
	}

}
