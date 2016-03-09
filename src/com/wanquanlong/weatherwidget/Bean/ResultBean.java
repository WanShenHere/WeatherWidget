package com.wanquanlong.weatherwidget.Bean;

public class ResultBean {
	private DataBean data;

	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultBean [data=" + data + "]";
	}
	
}
