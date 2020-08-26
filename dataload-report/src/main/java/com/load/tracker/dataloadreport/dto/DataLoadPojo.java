package com.load.tracker.dataloadreport.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataLoadPojo {
	
	@JsonProperty("uri")
	private String trackerId;
	
	@JsonProperty("createdBy")
	private String loadedBy;
	
	@JsonProperty("attributes") 
	private Attributes attributes;

}
