package com.kaggle.traffic.dao;

import java.util.List;

import com.kaggle.traffic.model.Filter;
import com.kaggle.traffic.model.TrafficIncident;

public interface ITrafficDao {

	public List<TrafficIncident> getTraffic(Filter filter);
}
