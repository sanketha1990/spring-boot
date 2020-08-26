package com.load.tracker.dataloadreport.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetrixValue {
	
	@JsonProperty("NumberofThreads") 
	private List<Value> numberofThreads;
	
	@JsonProperty("RecordsPerPost") 
	private List<Value> recordsPerPost;
	
	@JsonProperty("TotalRecordsCount") 
	private List<Value> totalRecordsCount;
	
	@JsonProperty("SuccessRecordsCount") 
	private List<Value> successRecordsCount;
	
	@JsonProperty("FailedRecordsCount")
	private List<Value> failedRecordsCount;
	
	@JsonProperty("TotalTimeTaken")
	private List<Value> totalTimeTaken;
	
	@JsonProperty("TotalOPS") 
	private List<Value> totalOPS;

}
