package com.wanquanlong.weatherwidget.Bean;

public class WeatherBean {
	private String date;
	private InfoInWeatherBean info;
	private String week;
	private String nongli;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public InfoInWeatherBean getInfo() {
		return info;
	}
	public void setInfo(InfoInWeatherBean info) {
		this.info = info;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getNongli() {
		return nongli;
	}
	public void setNongli(String nongli) {
		this.nongli = nongli;
	}
	@Override
	public String toString() {
		return "WeatherBean [date=" + date + ", info=" + info + ", week="
				+ week + ", nongli=" + nongli + "]";
	}
	
}
