package com.kaggle.traffic.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public interface ITrafficService {

	@GET
    @Path("/incidents")
    public Response getAll() throws JsonProcessingException;
	
	@GET
	@Path("/incidents/{city}")
	public Response getByCity(@PathParam("city") String city)throws JsonProcessingException;
}
