package com.kaggle.traffic.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaggle.traffic.dao.impl.TrafficDao;
import com.kaggle.traffic.mapper.TrafficMapper;
import com.kaggle.traffic.model.Filter;
import com.kaggle.traffic.model.TrafficIncidentREST;
import com.kaggle.traffic.service.ITrafficService;

public class TrafficService implements ITrafficService {
	
	@Inject
	private TrafficMapper mapper;
	
	public Response getAll() throws JsonProcessingException {
		TrafficDao dao = new TrafficDao();
		List<TrafficIncidentREST> result = mapper.mapTraffic(dao.getTraffic(new Filter()));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writerWithDefaultPrettyPrinter();
		String jsonResult = objectMapper.writeValueAsString(result);
        return Response.ok(jsonResult)
        		.header("Access-Control-Allow-Origin", "*")
        	      .header("Access-Control-Allow-Credentials", "true")
        	      .header("Access-Control-Allow-Headers",
        	        "origin, content-type, accept, authorization")
        	      .header("Access-Control-Allow-Methods", 
        	        "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}

	public Response getByCity(String city) throws JsonProcessingException {
		TrafficDao dao = new TrafficDao();
		Filter filter = new Filter();
		filter.setFilterCriteria("city");
		filter.setValue(city);
		List<TrafficIncidentREST> result = mapper.mapTraffic(dao.getTraffic(filter));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writerWithDefaultPrettyPrinter();
		String jsonResult = objectMapper.writeValueAsString(result);
        return Response.ok(jsonResult)
        		.header("Access-Control-Allow-Origin", "*")
        	      .header("Access-Control-Allow-Credentials", "true")
        	      .header("Access-Control-Allow-Headers",
        	        "origin, content-type, accept, authorization")
        	      .header("Access-Control-Allow-Methods", 
        	        "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}

}
