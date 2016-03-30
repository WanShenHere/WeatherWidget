package com.wanquanlong.weatherwidget;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.lidroid.xutils.exception.HttpException;
import com.wanquanlong.weatherwidget.Bean.RealtimeBean;
import com.wanquanlong.weatherwidget.Bean.StatusBean;
import com.wanquanlong.weatherwidget.api.HttpApi;
import com.wanquanlong.weatherwidget.api.OnHttpRequestCallBack;

import android.R.integer;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

public class WeatherService extends Service {
	Timer timer;
	StatusBean statusBean;
	String cityname = null;

	public LocationClient mLocationClient = null;
	public BDLocationListener myListener = new MyLocationListener();
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

	@Override
	public IBinder onBind(Intent arg0) {

		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		mLocationClient = new LocationClient(getApplicationContext()); // ����LocationClient��
		mLocationClient.registerLocationListener(myListener);
		initLocation();
		mLocationClient.start();

		timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				updateTime();
			}
		}, 0, 1000);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

	}

	private void updateTime() {
		String time = sdf.format(new Date());
		RemoteViews rv = new RemoteViews(getPackageName(), R.layout.widget);
		rv.setTextViewText(R.id.tv_time, time);
		AppWidgetManager manager = AppWidgetManager
				.getInstance(getApplicationContext());
		ComponentName cn = new ComponentName(getApplicationContext(),
				WidgetProvider.class);
		manager.updateAppWidget(cn, rv);
	}

	public class MyLocationListener implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation bdLocation) {
			String cityname = bdLocation.getCity();
			if (cityname == null) {
				Log.e("cityname", "��λʧ��");
				return;
			}
			initData(cityname);

		}
	}

	private void initData(String cityname) {
		HttpApi.getJsonData(cityname, new OnHttpRequestCallBack<StatusBean>() {

			@Override
			public void onSuccess(StatusBean result) {
				statusBean = result;
				Log.e("statusBean", statusBean.toString());
				if (statusBean != null) {
					RealtimeBean realtime = statusBean.getResult().getData()
							.getRealtime();

					RemoteViews rv = new RemoteViews(getPackageName(),
							R.layout.widget);
					String date = realtime.getDate();
					String[] arr = date.split("-");
					String dayString = arr[1] + "/" + arr[2];
					Log.e("dayString", dayString);

					rv.setTextViewText(R.id.tv_day, dayString);
					String weekString = getWeek(realtime.getWeek());
					Log.e("weekString", weekString);

					rv.setTextViewText(R.id.tv_week, weekString);
					String weatherString = realtime.getWeather().getInfo()
							+ "  " + realtime.getWeather().getTemperature()
							+ "��";
					Log.e("weatherString", weatherString);

					rv.setTextViewText(R.id.tv_weather, weatherString);
					// String imageName = "pic" +
					// realtime.getWeather().getImg();

					int[] picId = { R.drawable.pic00, R.drawable.pic01,
							R.drawable.pic02, R.drawable.pic03,
							R.drawable.pic04, R.drawable.pic05,
							R.drawable.pic06, R.drawable.pic07,
							R.drawable.pic08, R.drawable.pic09,
							R.drawable.pic10, R.drawable.pic11,
							R.drawable.pic12, R.drawable.pic13,
							R.drawable.pic14, R.drawable.pic15,
							R.drawable.pic16, R.drawable.pic17,
							R.drawable.pic18, R.drawable.pic19,
							R.drawable.pic20, R.drawable.pic21,
							R.drawable.pic22, R.drawable.pic23,
							R.drawable.pic24, R.drawable.pic25,
							R.drawable.pic26, R.drawable.pic27,
							R.drawable.pic28, R.drawable.pic29,
							R.drawable.pic30, R.drawable.pic31,
							R.drawable.pic53, R.drawable.undefined };
					int imgInfo = Integer.parseInt(realtime.getWeather()
							.getImg());

					Log.e("imgInfo", "" + imgInfo);

					int imgId = picId[imgInfo];
					if (imgInfo == 53) {
						imgId = picId[picId.length - 2];
					}
					if (imgInfo < 0 || imgInfo > 53) {
						imgId = picId[picId.length - 1];
					}

					rv.setImageViewResource(R.id.iv_pic, imgId);
					AppWidgetManager manager = AppWidgetManager
							.getInstance(getApplicationContext());
					ComponentName cn = new ComponentName(
							getApplicationContext(), WidgetProvider.class);
					manager.updateAppWidget(cn, rv);
				}

			}

			@Override
			public void onFailure(HttpException exception, String errorString) {

			}
		});
	}

	public int getResource(String imageName) {
		Context ctx = getBaseContext();
		int resId = getResources().getIdentifier(imageName, "drawable",
				ctx.getPackageName());
		return resId;
	}

	private String getWeek(int weekNum) {
		String weekString = "";

		switch (weekNum) {
		case 1:
			weekString = "��һ";
			break;
		case 2:
			weekString = "�ܶ�";
			break;
		case 3:
			weekString = "����";
			break;
		case 4:
			weekString = "����";
			break;
		case 5:
			weekString = "����";
			break;
		case 6:
			weekString = "����";
			break;
		case 7:
			weekString = "����";
			break;
		default:
			break;
		}
		return weekString;
	}

	private void initLocation() {
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Battery_Saving);// ��ѡ��Ĭ�ϸ߾��ȣ����ö�λģʽ���߾��ȣ��͹��ģ����豸
		option.setCoorType("bd09ll");// ��ѡ��Ĭ��gcj02�����÷��صĶ�λ�������ϵ
		int span = 1000 * 3600;
		option.setScanSpan(span);// ��ѡ��Ĭ��0��������λһ�Σ����÷���λ����ļ����Ҫ���ڵ���1000ms������Ч��
		option.setIsNeedAddress(true);// ��ѡ�������Ƿ���Ҫ��ַ��Ϣ��Ĭ�ϲ���Ҫ
		option.setOpenGps(true);// ��ѡ��Ĭ��false,�����Ƿ�ʹ��gps
		option.setLocationNotify(false);// ��ѡ��Ĭ��false�������Ƿ�gps��Чʱ����1S1��Ƶ�����GPS���
		option.setIsNeedLocationDescribe(false);// ��ѡ��Ĭ��false�������Ƿ���Ҫλ�����廯�����������BDLocation.getLocationDescribe��õ�����������ڡ��ڱ����찲�Ÿ�����
		option.setIsNeedLocationPoiList(false);// ��ѡ��Ĭ��false�������Ƿ���ҪPOI�����������BDLocation.getPoiList��õ�
		option.setIgnoreKillProcess(false);// ��ѡ��Ĭ��true����λSDK�ڲ���һ��SERVICE�����ŵ��˶������̣������Ƿ���stop��ʱ��ɱ��������̣�Ĭ�ϲ�ɱ��
		option.SetIgnoreCacheException(false);// ��ѡ��Ĭ��false�������Ƿ��ռ�CRASH��Ϣ��Ĭ���ռ�
		option.setEnableSimulateGps(false);// ��ѡ��Ĭ��false�������Ƿ���Ҫ����gps��������Ĭ����Ҫ
		mLocationClient.setLocOption(option);
	}

}
