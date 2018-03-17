package com.example.zeal;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class EntryActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.entry_activity);
		
		final Intent to_main = new Intent(this, MainActivity.class);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				startActivity(to_main);	// 启动新的activity
				EntryActivity.this.finish();
			}
		};
		timer.schedule(task, 1000 * 3);	// 3秒后执行
	}
}
