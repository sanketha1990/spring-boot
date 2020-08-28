package com.load.tracker.dataloadreport.dto;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.load.tracker.dataloadreport.DataloadReportApplication;

public class TerminateBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataloadReportApplication.class);

	@PreDestroy
	public void onDestroy() throws Exception {
		LOGGER.info("Process tracker:Finished process ..!!!");
	}

}
