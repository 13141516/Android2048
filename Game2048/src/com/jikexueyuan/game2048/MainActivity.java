package com.jikexueyuan.game2048;

import java.io.IOException;

import com.jikexueyuan.service.RWService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	public MainActivity() {
		mainActivity = this;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gameView = (GameView) findViewById(R.id.gameView);
		tvScore = (TextView) findViewById(R.id.tvScore);
		if (ConFig.MODE_SELECT == 1) {
			ConFig.mb.rwService.setMove(gameView);
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(ConFig.MODE_SELECT == 1) {
			ConFig.mb.unBindMyService();
			Intent service = new Intent(MainActivity.this, RWService.class);
			stopService(service);
			if (ConFig.mserverSocket != null) {
				try {
					ConFig.mserverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ConFig.socket != null) {
				try {
					ConFig.socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void clearScore() {
		score = 0;
		showScore();
	}

	public void showScore() {
		tvScore.setText(score + "");
	}

	public void addScore(int s) {
		score += s;
		showScore();
	}

	private int score = 0;
	private TextView tvScore;
	private GameView gameView;
	private static MainActivity mainActivity = null;

	public static MainActivity getMainActivity() {
		return mainActivity;
	}

}
