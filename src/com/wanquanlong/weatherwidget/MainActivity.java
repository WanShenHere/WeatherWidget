package com.wanquanlong.weatherwidget;

import com.lidroid.xutils.exception.HttpException;
import com.wanquanlong.weatherwidget.Bean.StatusBean;
import com.wanquanlong.weatherwidget.api.HttpApi;
import com.wanquanlong.weatherwidget.api.OnHttpRequestCallBack;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tView;
	StatusBean statusBean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tView = (TextView) findViewById(R.id.tv_ss);
		HttpApi.getJsonData("…Ó€⁄", new OnHttpRequestCallBack<StatusBean>() {

			@Override
			public void onSuccess(StatusBean result) {
				statusBean = result;
				Log.e("statusBean", statusBean.toString());
				if (statusBean != null) {
					String[] yundong = statusBean.getResult().getData()
							.getLife().getInfo().getYundong();
					tView.setText(yundong[1]);
				}

			}

			@Override
			public void onFailure(HttpException exception, String errorString) {

			}
		});
	}
}
