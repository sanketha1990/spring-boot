package com.load.tracker.dataloadreport.dto;

import org.springframework.context.annotation.Bean;

public class ShutdownConfig {

	@Bean
	public TerminateBean getTerminateBean() {
		return new TerminateBean();
	}

}
