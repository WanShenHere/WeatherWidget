package com.wanquanlong.weatherwidget.Bean;

public class StatusBean {
	private String reason;
	private ResultBean result;
	private int error_code;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ResultBean getResult() {
		return result;
	}

	public void setResult(ResultBean result) {
		this.result = result;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	@Override
	public String toString() {
		return "StatusBean [reason=" + reason + ", result=" + result
				+ ", error_code=" + error_code + "]";
	}

}
