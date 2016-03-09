package com.wanquanlong.weatherwidget.Bean;

import java.util.Arrays;

public class InfoInWeatherBean {
	private String[] dawn;
	private String[] night;
	private String[] day;
	public String[] getDawn() {
		return dawn;
	}
	public void setDawn(String[] dawn) {
		this.dawn = dawn;
	}
	public String[] getNight() {
		return night;
	}
	public void setNight(String[] night) {
		this.night = night;
	}
	public String[] getDay() {
		return day;
	}
	public void setDay(String[] day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "InfoInWeatherBean [dawn=" + Arrays.toString(dawn) + ", night="
				+ Arrays.toString(night) + ", day=" + Arrays.toString(day)
				+ "]";
	}
	
}
