package com.suhang.rxbus;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by 苏杭 on 2017/5/25 20:07.
 */

public class App extends Application{
	@Override
	public void onCreate() {
		super.onCreate();
		if (LeakCanary.isInAnalyzerProcess(this)) {
			// This process is dedicated to LeakCanary for heap analysis.
			// You should not init your app in this process.
			return;
		}
		LeakCanary.install(this);
	}
}
