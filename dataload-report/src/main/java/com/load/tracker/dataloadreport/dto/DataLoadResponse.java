package com.load.tracker.dataloadreport.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataLoadResponse {

	private String DataloadType;
	private String TypeOfData;
	private Date StartTime;
	private Date EndTime;
	private String InitiatedBy;
	private String Status;

	//private Metrics[] Metrics;

}
