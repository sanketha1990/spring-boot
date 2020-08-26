package com.load.tracker.dataloadreport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.load.tracker.dataloadreport.service.DataLoadService;

@SpringBootApplication
public class DataloadReportApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataloadReportApplication.class);

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		// SpringApplication.run(DataloadReportApplication.class, args);
		ApplicationContext context = SpringApplication.run(DataloadReportApplication.class, args);
		DataLoadService service = (DataLoadService) context.getBean("dataLoadService");
		service.getDataload();
		LOGGER.info("Spring boot application started...!");
	}
}
