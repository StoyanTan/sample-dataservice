package com.airbnb.service;

import java.util.List;

import com.airbnb.model.BusinessModel;

/**
 * Hello world!
 *
 */
public interface TrafficService {
	
	public List<BusinessModel> getAllOnHoliday(String holiday);
	
}
