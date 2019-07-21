package com.kaggle.traffic.model;

/**
 * A generic filter structure to be integrated in the Hibernate query
 * @author STOYAN
 *
 */
public class Filter {

	private String filterCriteria;
	
	private String value;
	
	public Filter(String filterCriteria, String value){
		this.filterCriteria = filterCriteria;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFilterCriteria() {
		return filterCriteria;
	}

	public void setFilterCriteria(String filterCriteria) {
		this.filterCriteria = filterCriteria;
	}
	
	
	
}
