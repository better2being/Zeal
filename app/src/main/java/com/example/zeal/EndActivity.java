package com.example.zeal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class EndActivity extends BaseActivity {
	
	private Button again;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.end_activity);
		
		again = (Button) this.findViewById(R.id.again);
		again.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent to_main = new Intent(EndActivity.this, MainActivity.class);
				startActivity(to_main);
				EndActivity.this.finish();
			}
		});
	}
}
