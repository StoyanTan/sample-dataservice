package com.airbnb.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="METROTRAFFIC")
public class Traffic {

	@Column(name="HOLIDAY")
	private String holiday;
	
	@Column(name="TEMP")
	private String temp;
	
	@Column(name="RAIN_1H")
	private String rain1H;
	
	@Column(name="SNOW_1H")
	private String snow1H;
	
	@Column(name="CLOUDS_ALL")
	private String cloudsAll;
	
	@Column(name="WEATHER_MAIN")
	private String weatherMain;
	
	@Column(name="WEATHER_DESCRIPTION")
	private String weatherDescription;
	
	@Column(name="DATE_TIME")
	private String dateTime;
	
	@Column(name="TRAFFIC_VOLUME")
	private String trafficVolume;

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getRain1H() {
		return rain1H;
	}

	public void setRain1H(String rain1h) {
		rain1H = rain1h;
	}

	public String getSnow1H() {
		return snow1H;
	}

	public void setSnow1H(String snow1h) {
		snow1H = snow1h;
	}

	public String getCloudsAll() {
		return cloudsAll;
	}

	public void setCloudsAll(String cloudsAll) {
		this.cloudsAll = cloudsAll;
	}

	public String getWeatherMain() {
		return weatherMain;
	}

	public void setWeatherMain(String weatherMain) {
		this.weatherMain = weatherMain;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getTrafficVolume() {
		return trafficVolume;
	}

	public void setTrafficVolume(String trafficVolume) {
		this.trafficVolume = trafficVolume;
	}
	
}
