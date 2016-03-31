package com.wanquanlong.weatherwidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.wanquanlong.weatherwidget.Bean.StatusBean;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

}
