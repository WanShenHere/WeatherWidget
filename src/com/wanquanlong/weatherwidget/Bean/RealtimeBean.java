package com.wanquanlong.weatherwidget.Bean;

public class RealtimeBean {
	private WindBean wind;
	private String time;
	private WeatherInRealtimeBean weather;
	private long dataUptime;
	private String date;
	private String city_code;
	private String city_name;
	private int week;
	private String moon;

	public WindBean getWind() {
		return wind;
	}

	public void setWind(WindBean wind) {
		this.wind = wind;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public WeatherInRealtimeBean getWeather() {
		return weather;
	}

	public void setWeather(WeatherInRealtimeBean weather) {
		this.weather = weather;
	}

	public long getDataUptime() {
		return dataUptime;
	}

	public void setDataUptime(long dataUptime) {
		this.dataUptime = dataUptime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getMoon() {
		return moon;
	}

	public void setMoon(String moon) {
		this.moon = moon;
	}

	@Override
	public String toString() {
		return "RealtimeBean [wind=" + wind + ", time=" + time + ", weather="
				+ weather + ", dataUptime=" + dataUptime + ", date=" + date
				+ ", city_code=" + city_code + ", city_name=" + city_name
				+ ", week=" + week + ", moon=" + moon + "]";
	}

}
