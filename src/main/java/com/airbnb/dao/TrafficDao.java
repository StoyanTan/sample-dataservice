package com.airbnb.dao;

import java.util.List;

import com.airbnb.model.Traffic;

public interface TrafficDao {

	public List<Traffic> getTrafficOnHoliday(String holiday);
	
}
