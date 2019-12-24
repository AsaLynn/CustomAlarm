package com.zxn.customalarm.receiver;

import com.zxn.customalarm.RingActivity;
import com.zxn.customalarm.core.Alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

	public AlarmReceiver() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		Alarm alarm=new Alarm(context, intent.getExtras());
		Intent intent2=new Intent();
		intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent2.setClass(context, RingActivity.class);
		intent2.putExtras(Alarm.alarm2Bundle(alarm));
		context.startActivity(intent2);
	}
	
	

}
