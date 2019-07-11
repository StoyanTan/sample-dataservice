package com.airbnb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.airbnb.dao.TrafficDao;
import com.airbnb.mapper.TrafficMapper;
import com.airbnb.model.BusinessModel;
import com.airbnb.service.TrafficService;

public class TrafficServiceImpl implements TrafficService{

	@Inject
	private TrafficDao trafficDao;
	
	@Inject
	private TrafficMapper mapper;
	
	public List<BusinessModel> getAllOnHoliday(String holiday) {
		if(holiday == null){
			return null;
		} else {
			
		}
		return mapper.mapTraffic(trafficDao.getTrafficOnHoliday(holiday));
	}

}
