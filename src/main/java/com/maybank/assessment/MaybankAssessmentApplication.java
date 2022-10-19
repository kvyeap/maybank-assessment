package com.maybank.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MaybankAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaybankAssessmentApplication.class, args);
	}

}
