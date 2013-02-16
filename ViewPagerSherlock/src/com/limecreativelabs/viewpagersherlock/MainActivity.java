package com.limecreativelabs.viewpagersherlock;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

public class MainActivity extends SherlockFragmentActivity {

	private FragmentAdapter mAdapter;
	private ViewPager mPager;
	private PageIndicator mIndicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);

		mAdapter = new FragmentAdapter(getSupportFragmentManager());

		mPager = (ViewPager)findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		mIndicator = (TitlePageIndicator)findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
