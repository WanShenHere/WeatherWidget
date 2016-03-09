package com.wanquanlong.weatherwidget.Bean;

public class Pm25Bean {
	private String key;
	private String show_desc;
	private Pm25InfoBean pm25;
	private String dateTime;
	private String cityName;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getShow_desc() {
		return show_desc;
	}
	public void setShow_desc(String show_desc) {
		this.show_desc = show_desc;
	}
	public Pm25InfoBean getPm25() {
		return pm25;
	}
	public void setPm25(Pm25InfoBean pm25) {
		this.pm25 = pm25;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "Pm25Bean [key=" + key + ", show_desc=" + show_desc + ", pm25="
				+ pm25 + ", dateTime=" + dateTime + ", cityName=" + cityName
				+ "]";
	}
	
	
}
