package com.wanquanlong.weatherwidget.Bean;

import java.util.List;

public class DataBean {
	private RealtimeBean realtime;
	private LifeBean life;
	private List<WeatherBean> weather;
	private Pm25Bean pm25;
	private String date;
	private int isForeign;

	public RealtimeBean getRealtime() {
		return realtime;
	}

	public void setRealtime(RealtimeBean realtime) {
		this.realtime = realtime;
	}

	public LifeBean getLife() {
		return life;
	}

	public void setLife(LifeBean life) {
		this.life = life;
	}

	public List<WeatherBean> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherBean> weather) {
		this.weather = weather;
	}

	public Pm25Bean getPm25() {
		return pm25;
	}

	public void setPm25(Pm25Bean pm25) {
		this.pm25 = pm25;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIsForeign() {
		return isForeign;
	}

	public void setIsForeign(int isForeign) {
		this.isForeign = isForeign;
	}

	@Override
	public String toString() {
		return "DataBean [realtime=" + realtime + ", life=" + life
				+ ", weather=" + weather + ", pm25=" + pm25 + ", date=" + date
				+ ", isForeign=" + isForeign + "]";
	}

}
