package com.wanquanlong.weatherwidget.Bean;

public class WindBean {
	private String windspeed;
	private String direct;
	private String power;
	private String offset;

	public String getWindspeed() {
		return windspeed;
	}

	public void setWindspeed(String windspeed) {
		this.windspeed = windspeed;
	}

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "WindBean [windspeed=" + windspeed + ", direct=" + direct
				+ ", power=" + power + ", offset=" + offset + "]";
	}

}
