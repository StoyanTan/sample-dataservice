package com.kaggle.traffic.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kaggle.traffic.dao.ITrafficDao;
import com.kaggle.traffic.mapper.TrafficMapper;
import com.kaggle.traffic.model.Filter;
import com.kaggle.traffic.model.ParameterValueObject;
import com.kaggle.traffic.model.TrafficIncidentREST;
import com.kaggle.traffic.service.ITrafficService;

public class TrafficService implements ITrafficService {
	
	@Inject
	private TrafficMapper mapper;
	
	@Inject
	private ITrafficDao dao;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public Response getClusteringByCity() throws JsonProcessingException {
		List<ParameterValueObject> result = dao.getClustering(new Filter("city", null));
		ArrayNode arrayNode = objectMapper.createArrayNode();
		objectMapper.writerWithDefaultPrettyPrinter();
		ObjectNode objNode = objectMapper.createObjectNode();
		objNode.putPOJO("children", result);
		arrayNode.add(objNode);
		String jsonResult = objectMapper.writeValueAsString(objNode);
        return Response.ok(jsonResult)
        		.header("Access-Control-Allow-Origin", "*").build();
	}

	public Response getIncidentsByCity(String city, Integer page) throws JsonProcessingException {
		Filter filter = new Filter("city", city);
		Integer pageSize = 50;
		Long count = dao.getCount(filter);;
		List<TrafficIncidentREST> result = new ArrayList<>();
		if (page == null){
			result = mapper.mapTraffic(dao.getTraffic(filter, 0, pageSize));
		} else {
			Integer offset = (page - 1) * pageSize;
			
			result = mapper.mapTraffic(dao.getTraffic(filter, offset, pageSize));
		}
		objectMapper.writerWithDefaultPrettyPrinter();
		ObjectNode objNode = objectMapper.createObjectNode();
		objNode.putPOJO("items", result);
		objNode.put("count", count);
		String jsonResult = objectMapper.writeValueAsString(objNode);
        return Response.ok(jsonResult)
        		.header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	public Response getIncidentsById(String id) throws JsonProcessingException {
		Filter filter = new Filter("id", id);
		TrafficIncidentREST result = mapper.mapTraffic(dao.getIncidentById(filter));
		objectMapper.writerWithDefaultPrettyPrinter();
		String jsonResult = objectMapper.writeValueAsString(result);
		return Response.ok(jsonResult)
        		.header("Access-Control-Allow-Origin", "*").build();
	}
}
