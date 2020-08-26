package com.load.tracker.dataloadreport.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.core.annotation.Order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class ProcessTracker {


	/*
	 * @GeneratedValue private int ProcessTrackerId;
	 */
	
	@Id
	@Order(1)
	private String uri;
	@Order(2)
	private String createdBy;
	
	//Simple attribute
	@Order(3)
	private String SourceSystem;
	@Order(4)
	private String DataloadType;
	@Order(5)
	private String TypeOfData;
	@Order(6)
	private String StartTime;
	@Order(7)
	private String EndTime;
	@Order(8)
	private String Status;
	
	
	//Nested matrix attribute
	@Order(9)
	private String NumberofThreads;
	@Order(10)
	private String RecordsPerPost;
	@Order(11)
	private String TotalRecordsCount;
	@Order(12)
	private String SuccessRecordsCount;
	@Order(13)
	private String FailedRecordsCount;
	@Order(14)
	private String TotalTimeTaken;
	@Order(15)
	private String TotalOPS;
	@Order(16)
	private float timeInMins;
	
}