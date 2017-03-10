package com.example.zeal;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	
	private MediaPlayer mp;
	
	private ImageButton play_or_pause;
	
	private ImageView author;
	private ImageView title;
	
	private TextView text_1;
	private TextView text_2;
	private TextView text_3;
	private TextView text_4;
	
	private SeekBar seekBar;
	
	private Integer music_length;
	
	private List<String> poem_str = new ArrayList<>();
	
	private InputStream inputStream;
	
	private Runnable runnable;

	private PowerManager pm;

	private PowerManager.WakeLock wakeLock;
	
	private Handler handler = new Handler() {
		
		public void handleMessage(Message msg) {
			// 更新进度条
			seekBar.setProgress(msg.arg1);
			// 更改ImageButton图标
			switch(msg.arg2) {
				case 1:
					play_or_pause.setImageResource(R.drawable.play);
					break;
				case 2:
					play_or_pause.setImageResource(R.drawable.pause);
					break;
			}
			// 更新TextView
			switch (msg.arg1) {
				case 18:
					title.setImageResource(R.drawable.title);
					break;
				case 22:
					author.setImageResource(R.drawable.author);
					break;
				case 33:
					text_1.setText(poem_str.get(0));
					break;
				case 40:
					text_1.setText(poem_str.get(0));
					text_2.setText(poem_str.get(1));
					break;
				case 49:
					text_1.setText(poem_str.get(0));
					text_2.setText(poem_str.get(1));
					text_3.setText(poem_str.get(2));
					break;
				case 54:
					text_1.setText(poem_str.get(0));
					text_2.setText(poem_str.get(1));
					text_3.setText(poem_str.get(2));
					text_4.setText(poem_str.get(3));
					break;
				case 61:	
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 65:	
					text_1.setText(poem_str.get(4));
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 68:
					text_1.setText(poem_str.get(4));
					text_2.setText(poem_str.get(5));
					text_3.setText("");
					text_4.setText("");
					break;
				case 72:
					text_1.setText(poem_str.get(4));
					text_2.setText(poem_str.get(5));
					text_3.setText(poem_str.get(6));
					text_4.setText("");
					break;
				case 75:
					text_1.setText(poem_str.get(4));
					text_2.setText(poem_str.get(5));
					text_3.setText(poem_str.get(6));
					text_4.setText(poem_str.get(7));
					break;
				case 83:	
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 87:	
					text_1.setText(poem_str.get(8));
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 91:
					text_1.setText(poem_str.get(8));
					text_2.setText(poem_str.get(9));
					text_3.setText("");
					text_4.setText("");
					break;
				case 95:
					text_1.setText(poem_str.get(8));
					text_2.setText(poem_str.get(9));
					text_3.setText(poem_str.get(10));
					text_4.setText("");
					break;
				case 97:
					text_1.setText(poem_str.get(8));
					text_2.setText(poem_str.get(9));
					text_3.setText(poem_str.get(10));
					text_4.setText(poem_str.get(11));
					break;
				case 100:	
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 103:	
					text_1.setText(poem_str.get(12));
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 107:
					text_1.setText(poem_str.get(12));
					text_2.setText(poem_str.get(13));
					text_3.setText("");
					text_4.setText("");
					break;
				case 111:
					text_1.setText(poem_str.get(12));
					text_2.setText(poem_str.get(13));
					text_3.setText(poem_str.get(14));
					text_4.setText("");
					break;
				case 114:
					text_1.setText(poem_str.get(12));
					text_2.setText(poem_str.get(13));
					text_3.setText(poem_str.get(14));
					text_4.setText(poem_str.get(15));
					break;
				case 121:	
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 124:	
					text_1.setText(poem_str.get(16));
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 128:
					text_1.setText(poem_str.get(16));
					text_2.setText(poem_str.get(17));
					text_3.setText("");
					text_4.setText("");
					break;
				case 131:
					text_1.setText(poem_str.get(16));
					text_2.setText(poem_str.get(17));
					text_3.setText(poem_str.get(18));
					text_4.setText("");
					break;
				case 133:
					text_1.setText(poem_str.get(16));
					text_2.setText(poem_str.get(17));
					text_3.setText(poem_str.get(18));
					text_4.setText(poem_str.get(19));
					break;
				case 139:	
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 143:	
					text_1.setText(poem_str.get(20));
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 148:
					text_1.setText(poem_str.get(20));
					text_2.setText(poem_str.get(21));
					text_3.setText("");
					text_4.setText("");
					break;
				case 152:
					text_1.setText(poem_str.get(20));
					text_2.setText(poem_str.get(21));
					text_3.setText(poem_str.get(22));
					text_4.setText("");
					break;
				case 156:
					text_1.setText(poem_str.get(20));
					text_2.setText(poem_str.get(21));
					text_3.setText(poem_str.get(22));
					text_4.setText(poem_str.get(23));
					break;
				case 164:	
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 167:	
					text_1.setText(poem_str.get(24));
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
				case 171:
					text_1.setText(poem_str.get(24));
					text_2.setText(poem_str.get(25));
					text_3.setText("");
					text_4.setText("");
					break;
				case 173:
					text_1.setText(poem_str.get(24));
					text_2.setText(poem_str.get(25));
					text_3.setText(poem_str.get(26));
					text_4.setText("");
					break;
				case 179:
					text_1.setText(poem_str.get(24));
					text_2.setText(poem_str.get(25));
					text_3.setText(poem_str.get(26));
					text_4.setText(poem_str.get(27));
					break;
				case 240:	
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		inputStream = getResources().openRawResource(R.raw.answer);
		mp = MediaPlayer.create(this, R.raw.huida);
		music_length = mp.getDuration();
		poem_str = TextReader.getString(inputStream);
		pm = (PowerManager) getSystemService(Context.POWER_SERVICE);

		wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "TAG");
		wakeLock.acquire();
		
		mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				// 播放完成结束当前Activity
				Intent to_end = new Intent(MainActivity.this, EndActivity.class);
				startActivity(to_end);
				MainActivity.this.finish();
			}
		});
	    
		author = (ImageView) this.findViewById(R.id.author);
		title = (ImageView) this.findViewById(R.id.title);
		text_1 = (TextView) this.findViewById(R.id.text_1);
		text_2 = (TextView) this.findViewById(R.id.text_2);
		text_3 = (TextView) this.findViewById(R.id.text_3);
		text_4 = (TextView) this.findViewById(R.id.text_4);
		seekBar = (SeekBar) this.findViewById(R.id.seek_bar);
		seekBar.setMax(music_length / 1000);
		seekBar.setOnTouchListener(new ProgressBar.OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent event) {
				Message message = new Message();
				message.arg1 = (int) (music_length / 1000 * event.getX() / view.getWidth());
				mp.seekTo(1000 * message.arg1);
				handler.sendMessage(message);
				return true;
			}
		});
		
		runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					Message message = new Message();
					message.arg1 = mp.getCurrentPosition()/1000;
					if(mp.isPlaying()) {
						message.arg2 = 1;
					} else {
						message.arg2 = 2;
					}
					handler.sendMessage(message);
					// 每次延迟200毫秒再启动线程
					handler.postDelayed(this, 200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runnable).start();
		
		play_or_pause = (ImageButton) findViewById(R.id.play_or_pause);
		play_or_pause.setImageResource(R.drawable.pause);
		play_or_pause.setOnClickListener(new ImageButton.OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	if(mp.isPlaying()) {
            		mp.pause();
            	} else {
            		mp.start();
            	}
            }
        });
    }
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mp.release();
		wakeLock.release();
		handler.removeCallbacks(runnable);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
