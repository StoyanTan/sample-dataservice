package com.kaggle.traffic.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Interface definition of the REST API
 * @author STOYAN
 *
 */
@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public interface ITrafficService {

	/**
	 * Returns the clustering as a JSON array with the structure expected by d3.js
	 * @return
	 * @throws JsonProcessingException
	 */
	@GET
    @Path("/")
    public Response getClusteringByCity() throws JsonProcessingException;
	
	/**
	 * Returns the incidents filtered by city and paginated
	 * @param city
	 * @param page
	 * @return
	 * @throws JsonProcessingException
	 */
	@GET
	@Path("/city/{city}")
	public Response getIncidentsByCity(@PathParam("city") String city, @QueryParam("page") Integer page)throws JsonProcessingException;
	
	/**
	 * Returns a single entry by its unique identifier
	 * @param id
	 * @return
	 * @throws JsonProcessingException
	 */
	@GET
	@Path("/city/incidents/{id}")
	public Response getIncidentsById(@PathParam("id") String id)throws JsonProcessingException;
}
