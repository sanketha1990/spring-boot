package com.load.tracker.dataloadreport.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.load.tracker.dataloadreport.dto.ProcessTracker;
import com.load.tracker.dataloadreport.service.DataLoadService;

@RestController
public class ProcessTrackerController {

	@Autowired
	DataLoadService service;

	@GetMapping("/")
	public ProcessTracker getLoadedDataDetails() {
		ProcessTracker response = service.getDataload();
		return response;
	}

}
