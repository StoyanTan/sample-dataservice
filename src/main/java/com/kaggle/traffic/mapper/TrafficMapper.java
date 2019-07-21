package com.kaggle.traffic.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.kaggle.traffic.model.TrafficIncidentREST;
import com.kaggle.traffic.model.TrafficIncident;

/**
 * A MapStruct mapping class, transforming the DB result to the REST structure
 * @author STOYAN
 *
 */
@Mapper
public interface TrafficMapper {

	@Mappings({
		  @Mapping(target="uniqueId", source="id"),
		  @Mapping(target="date", source="date"),
	      @Mapping(target="time", source="time"),
	      @Mapping(target="city", source="city"),
	      @Mapping(target="location", source="location"),
	      @Mapping(target="lat", source="latitude"),
	      @Mapping(target="longitude", source="longitude"),
	      @Mapping(target="direction", source="direction"),
	      @Mapping(target="lanes", source="lanesBlocked"),
	      @Mapping(target="vehiclesInvolved", source="involved"),
	      @Mapping(target="twitterLink", source="tweet"),
	      @Mapping(target="source", source="source"),
	    })
	public abstract TrafficIncidentREST mapTraffic(TrafficIncident traffic);
	
	public abstract List<TrafficIncidentREST> mapTraffic(List<TrafficIncident> trafficList);
}
