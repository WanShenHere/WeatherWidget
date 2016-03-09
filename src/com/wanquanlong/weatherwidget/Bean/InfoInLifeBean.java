package com.wanquanlong.weatherwidget.Bean;

import java.util.Arrays;

public class InfoInLifeBean {
	private String[] kongtiao;
	private String[] yundong;
	private String[] ziwaixian;
	private String[] ganmao;
	private String[] xiche;
	private String[] wuran;
	private String[] chuanyi;

	public String[] getKongtiao() {
		return kongtiao;
	}

	public void setKongtiao(String[] kongtiao) {
		this.kongtiao = kongtiao;
	}

	public String[] getYundong() {
		return yundong;
	}

	public void setYundong(String[] yundong) {
		this.yundong = yundong;
	}

	public String[] getZiwaixian() {
		return ziwaixian;
	}

	public void setZiwaixian(String[] ziwaixian) {
		this.ziwaixian = ziwaixian;
	}

	public String[] getGanmao() {
		return ganmao;
	}

	public void setGanmao(String[] ganmao) {
		this.ganmao = ganmao;
	}

	public String[] getXiche() {
		return xiche;
	}

	public void setXiche(String[] xiche) {
		this.xiche = xiche;
	}

	public String[] getWuran() {
		return wuran;
	}

	public void setWuran(String[] wuran) {
		this.wuran = wuran;
	}

	public String[] getChuanyi() {
		return chuanyi;
	}

	public void setChuanyi(String[] chuanyi) {
		this.chuanyi = chuanyi;
	}

	@Override
	public String toString() {
		return "InfoInLifeBean [kongtiao=" + Arrays.toString(kongtiao)
				+ ", yundong=" + Arrays.toString(yundong) + ", ziwaixian="
				+ Arrays.toString(ziwaixian) + ", ganmao="
				+ Arrays.toString(ganmao) + ", xiche=" + Arrays.toString(xiche)
				+ ", wuran=" + Arrays.toString(wuran) + ", chuanyi="
				+ Arrays.toString(chuanyi) + "]";
	}

}
