package com.jikexueyuan.game2048;

import com.jikexueyuan.service.RWService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class ClassLoadView extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ConFig.mb.bindMyService();
				Intent intent = new Intent(ClassLoadView.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		}, 3000);
		ConFig.mb = new MainBase(getApplicationContext());
		Intent service = new Intent(ClassLoadView.this, RWService.class);
		startService(service);
	}
}
