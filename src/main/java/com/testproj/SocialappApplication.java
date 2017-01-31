package com.testproj;

import com.testproj.controller.SearchController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.elasticrepo")
@ComponentScan(basePackageClasses = {SearchController.class, MovieService.class})
public class SocialappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialappApplication.class, args);
	}

}
