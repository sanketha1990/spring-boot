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
public class Attributes {

	@JsonProperty("Metrics")
	private Metrics[] metrics;

	@JsonProperty("DataloadType")
	private List<Value> dataloadType;

	@JsonProperty("TypeOfData")
	private List<Value> typeOfData;
	
	@JsonProperty("StartTime")
	private List<Value> startTime;
	
	@JsonProperty("EndTime")
	private List<Value> endTime;
	
	@JsonProperty("Status")
	private List<Value> status;
	
	@JsonProperty("UserComment")
	private List<Value> userComment;
}
