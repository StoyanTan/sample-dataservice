package com.airbnb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.airbnb.model.BusinessModel;
import com.airbnb.model.Traffic;

@Mapper
public abstract class TrafficMapper {

	@Mappings({
	      @Mapping(target="snow1H", source="snow1H"),
	      @Mapping(target="holiday", source="holiday")
	    })
	public abstract BusinessModel mapTraffic(Traffic traffic);
	
	public abstract List<BusinessModel> mapTraffic(List<Traffic> trafficList);
}
