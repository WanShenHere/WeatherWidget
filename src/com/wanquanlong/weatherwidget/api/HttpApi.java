package com.wanquanlong.weatherwidget.api;

import android.util.Log;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.wanquanlong.weatherwidget.Constant;
import com.wanquanlong.weatherwidget.Bean.StatusBean;

public class HttpApi {

	private static HttpUtils httpUtils = new HttpUtils();

	public static void getJsonData(String cityName,
			final OnHttpRequestCallBack<StatusBean> callBack) {

		String url = Constant.URL;
		url = url + "?cityname=" + cityName + "&key=" + Constant.APIKEY;
		httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				Log.e("API", "œ¬‘ÿ ß∞‹");
			}

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				String result = responseInfo.result;
				StatusBean statusBean = null;
				try {
					statusBean = new Gson().fromJson(result, StatusBean.class);
					callBack.onSuccess(statusBean);
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});

	}
}
