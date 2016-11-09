package com.suhang.rxbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {
	CompositeDisposable disposables = new CompositeDisposable();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) findViewById(R.id.button);
		RxBusHelper.doOnMainThread(String.class, disposables, new RxBusHelper.OnEventListener<String>() {
			@Override
			public void onEvent(String s) {
				button.setText(s);
			}

			@Override
			public void onError(ErrorBean errorBean) {

			}
		});
		button.setOnClickListener(v -> startActivity(new Intent(this, SecondActivity.class)));
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		disposables.dispose();
	}
}
