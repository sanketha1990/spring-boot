package com.load.tracker.dataloadreport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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
		ConfigurableApplicationContext context = SpringApplication.run(DataloadReportApplication.class, args);
		DataLoadService service = (DataLoadService) context.getBean("dataLoadService");
		service.getDataload();
		LOGGER.info(
				"****** Process Tracker:Dataload reported generated.....! Please check the generated report in database table..! *********");
		LOGGER.info("See you in the next run. Thank you..!!");

		int exitCode = SpringApplication.exit(context, new ExitCodeGenerator() {

			@Override
			public int getExitCode() {
				LOGGER.info("Exit from the program !!");
				return 0;
			}
		});
		System.exit(exitCode);
	}
}
