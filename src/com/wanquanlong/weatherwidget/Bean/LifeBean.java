package com.wanquanlong.weatherwidget.Bean;

public class LifeBean {
	private String date;
	private InfoInLifeBean info;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public InfoInLifeBean getInfo() {
		return info;
	}
	public void setInfo(InfoInLifeBean info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "LifeBean [date=" + date + ", info=" + info + "]";
	}
	
}
