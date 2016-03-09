package com.wanquanlong.weatherwidget.api;

import com.lidroid.xutils.exception.HttpException;

/**
 * Created by sxxjava on 2015/10/27.
 */
public interface OnHttpRequestCallBack<T> {
	void onSuccess(T result);

	void onFailure(HttpException exception, String errorString);
}
