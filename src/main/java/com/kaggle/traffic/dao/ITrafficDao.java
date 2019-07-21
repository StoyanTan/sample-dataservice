package com.kaggle.traffic.dao;

import java.util.List;

import com.kaggle.traffic.model.Filter;
import com.kaggle.traffic.model.ParameterValueObject;
import com.kaggle.traffic.model.TrafficIncident;

/**
 * Interface definition of the persistence layer component
 * @author STOYAN
 *
 */
public interface ITrafficDao {

	/**
	 * Returns a paginated list of incidents according to some filter criteria
	 * @param filter
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<TrafficIncident> getTraffic(Filter filter, int offset, int pageSize);
	
	/**
	 * Returns the count of the filtered results (used for pagination)
	 * @param filter
	 * @return
	 */
	public Long getCount(Filter filter);
	
	/**
	 * Returns the initial clustering key-value pairs for the overview
	 * @param filter
	 * @return
	 */
	 public List<ParameterValueObject> getClustering(Filter filter);
	 
	 /**
	  * Returns detailed data for a specific entry with Twitter link
	  * @param filter
	  * @return
	  */
	 public TrafficIncident getIncidentById(Filter filter);
}
