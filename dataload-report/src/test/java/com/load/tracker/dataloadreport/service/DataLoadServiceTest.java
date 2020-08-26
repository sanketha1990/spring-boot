package com.load.tracker.dataloadreport.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.load.tracker.dataloadreport.dto.DataLoadPojo;

@SpringBootTest
class DataLoadServiceTest {

	@Autowired
	DataLoadService service;

	final ObjectMapper mapper = new ObjectMapper();

	//@Test
	void testGetDataload() {
		//String json = "[{\"uri\":\"entities/FlPHGZa\",\"type\":\"configuration/entityTypes/ProcessTracker\",\"createdBy\":\"Paramjeet.s\",\"createdTime\":1598012608548,\"updatedBy\":\"Paramjeet.s\",\"updatedTime\":1598012615810}]";
		service.getDataload();
	}

	//@Test
	void test() throws Exception {
		String json = "[{\"uri\":\"entities/FlPHGZa\",\"type\":\"configuration/entityTypes/ProcessTracker\",\"createdBy\":\"Paramjeet.s\",\"createdTime\":1598012608548,\"updatedBy\":\"Paramjeet.s\",\"updatedTime\":1598012615810}]";

		DataLoadPojo[] dataLoad = mapper.readValue(json, DataLoadPojo[].class);
		System.out.println("Dataload = "+dataLoad);
	}
	
	@Test
	void testString() {
		String str="Initial EntityType:Individual Dataload[IDL] from SDR";
		String[] comment=str.split(" ");
		System.out.println(comment[comment.length-1]);
	}

}
