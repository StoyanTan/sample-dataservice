package com.kaggle.traffic;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Sets the application root, needed to expose the component as a RESTful service
 * @author STOYAN
 *
 */
@ApplicationPath("/")
public class TrafficApplication extends Application{

	   public TrafficApplication() {
		   
	   }	
}
