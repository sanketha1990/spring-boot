package com.load.tracker.dataloadreport.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.load.tracker.dataloadreport.dto.Attributes;
import com.load.tracker.dataloadreport.dto.DataLoadPojo;
import com.load.tracker.dataloadreport.dto.Metrics;
import com.load.tracker.dataloadreport.dto.ProcessTracker;
import com.load.tracker.dataloadreport.repository.DataloadRepository;

@Service("dataLoadService")
public class DataLoadService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DataloadRepository dataloadRepo;

	@Value("${environment.url}")
	private String environmentURL;

	@Value("${tenant.id}")
	private String tenantID;

	@Value("${created.from}")
	private String createdDateFrom;

	@Value("${created.to}")
	private String createdDateTo;

	@Value("${access.token}")
	private String accessToken;

	final ObjectMapper mapper = new ObjectMapper();

	private static final Logger LOGGER = LoggerFactory.getLogger(DataLoadService.class);

	public ProcessTracker getDataload() {

		DataLoadPojo[] dataLoad = null;
		String url = "https://" + environmentURL + "/reltio/api/" + tenantID + "/entities?";
		String filter = "filter=equals(type,'configuration/entityTypes/ProcessTracker') and range(createdTime,"
				+ createdDateFrom + "," + createdDateTo + ")";

		String finalUrl = url + filter;
		HttpEntity<String> entity = getHeader();
		LOGGER.info("Final request URL = " + finalUrl);
		ResponseEntity<String> response = restTemplate.exchange(finalUrl, HttpMethod.GET, entity, String.class);
		try {
			dataLoad = mapper.readValue(response.getBody().toString(), DataLoadPojo[].class);
			LOGGER.info("dataLoad = " + dataLoad);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ProcessTracker res = persistData(dataLoad);
		return res;
	}

	private HttpEntity<String> getHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(accessToken);

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		return entity;
	}

	private ProcessTracker persistData(DataLoadPojo[] dataload) {

		ProcessTracker pt = null;
		ProcessTracker res = new ProcessTracker();
		List<ProcessTracker> list = new ArrayList<ProcessTracker>();
		for (int i = 0; i < dataload.length; i++) {
			pt = new ProcessTracker();
			pt.setUri(dataload[i].getTrackerId());
			pt.setCreatedBy(dataload[i].getLoadedBy());

			// Simple attribute
			Attributes attr = dataload[i].getAttributes();
			pt.setDataloadType(attr.getDataloadType().get(0).getValue());
			pt.setTypeOfData((attr.getTypeOfData()).get(0).getValue());
			
			String userComment=attr.getUserComment().get(0).getValue();
			String[] comment=userComment.split(" ");
			//System.out.println(comment[comment.length-1]);
			
			pt.setSourceSystem(comment[comment.length-1]);
			
			pt.setStartTime(attr.getStartTime().get(0).getValue().toString());
			pt.setEndTime(attr.getEndTime().get(0).getValue().toString());
			//String startDate=attr.getStartTime().get(0).getValue();
			//Date sdate=Date.valueOf(startDate);
			//pt.setStartTime(sdate);
			
			//String endDate=attr.getEndTime().get(0).getValue();
			//Date edate=Date.valueOf(endDate);
			//pt.setEndTime(edate);
			pt.setStatus(attr.getStatus().get(0).getValue());

			// Matrix attribute
			Metrics[] matrics = dataload[i].getAttributes().getMetrics();
			pt.setNumberofThreads(matrics[0].getValue().getNumberofThreads().get(0).getValue());
			pt.setRecordsPerPost(matrics[0].getValue().getRecordsPerPost().get(0).getValue());
			pt.setTotalRecordsCount(matrics[0].getValue().getTotalRecordsCount().get(0).getValue());
			pt.setSuccessRecordsCount(matrics[0].getValue().getSuccessRecordsCount().get(0).getValue());
			pt.setFailedRecordsCount(matrics[0].getValue().getFailedRecordsCount().get(0).getValue());
			pt.setTotalTimeTaken(matrics[0].getValue().getTotalTimeTaken().get(0).getValue());
			pt.setTotalOPS(matrics[0].getValue().getTotalOPS().get(0).getValue());
			
			float timeTaken=Integer.parseInt((matrics[0].getValue().getTotalTimeTaken().get(0).getValue()));
			float timeInMins=timeTaken/60;
			
			pt.setTimeInMins(timeInMins);

			list.add(pt);
		}
		
		LOGGER.info("**********Number Of Generated Row is = "+list.size() +" ***********");
		
		for (ProcessTracker proctra : list) {
			res = dataloadRepo.save(proctra);
		}
		LOGGER.info("Response ="+res);
		return res;
	}

	/*
	 * public List<ProcessTracker> fetchResponseObject(String response) {
	 * ProcessTracker pt = null; List<ProcessTracker> procesList = new
	 * ArrayList<ProcessTracker>(); Map<String, String> map = new HashMap<String,
	 * String>(); JSONParser parser = new JSONParser(); try { JSONArray json =
	 * (JSONArray) parser.parse(response);
	 * 
	 * for (int i = 0; i < json.size(); i++) { JSONObject obj = (JSONObject)
	 * json.get(i); JSONObject attributes = (JSONObject) obj.get("attributes"); for
	 * (int j = 0; j < attributes.size(); i++) { for (int index = 0; index <
	 * attributeList.size(); index++) { String[] str = (String[])
	 * attributeList.get(index).split("\\."); if (str.length == 2) { JSONArray
	 * typeArr = (JSONArray) attributes.get(str[1]); JSONObject Obj = (JSONObject)
	 * typeArr.get(0); String value = (String) Obj.get("value"); map.put(str[1],
	 * value); continue; } if (str.length == 3) { JSONArray nestedAr = (JSONArray)
	 * attributes.get(str[1]); for (int k = 0; k < nestedAr.size(); k++) {
	 * JSONObject dltObj = (JSONObject) nestedAr.get(k); JSONObject valObj =
	 * (JSONObject) dltObj.get("value"); // JSONObject jsonObj = (JSONObject)
	 * valObj.get(str[3]); for (int l = 0; l < valObj.size(); l++) {
	 * 
	 * // JSONObject jsonObj=(JSONObject)valObj.get(l); JSONArray jsonAr =
	 * (JSONArray) valObj.get(str[2]); for (int m = 0; m < jsonAr.size(); m++) {
	 * JSONObject Obj = (JSONObject) jsonAr.get(0); String nestVal = (String)
	 * Obj.get("value"); map.put(str[2], nestVal); continue; } //
	 * System.out.println("Map = " + map); // pt = mapper.convertValue(map,
	 * ProcessTracker.class); // procesList.add(pt); } } } // if } // for } }
	 * System.out.println("Map = " + map); } catch (ParseException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return procesList; }
	 */

}
