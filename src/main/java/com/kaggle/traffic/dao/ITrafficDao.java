package com.kaggle.traffic.dao;

import java.util.List;

import com.kaggle.traffic.model.Filter;
import com.kaggle.traffic.model.ParameterValueObject;
import com.kaggle.traffic.model.TrafficIncident;

public interface ITrafficDao {

	public List<TrafficIncident> getTraffic(Filter filter, int offset, int pageSize);
	
	 public List<ParameterValueObject> getClustering(Filter filter);
	 
	 public TrafficIncident getIncidentById(Filter filter);
}
