package com.suhang.rxbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class ThreeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three);
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(view -> RxBusHelper.post("这是发送的消息"));
	}
}
