package com.limecreativelabs.actionbarrefresh;

import com.example.actionbarrefresh.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button abButton = (Button) findViewById(R.id.ab_example);
		Button absButton = (Button) findViewById(R.id.abs_example);
		
		abButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(MainActivity.this, ActionBarActivity.class));	
			}
		});
		
		absButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(MainActivity.this, ActionBarSherlockActivity.class));	
			}
		});
	}
}
