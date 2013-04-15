package com.limecreativelabs.actionbarrefresh;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.example.actionbarrefresh.R;

public class ActionBarSherlockActivity extends SherlockActivity implements IRefresh{

	private MockRefreshTask mTask;
	
	private MenuItem mRefreshMenuItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.action_bar, menu);
		
		mRefreshMenuItem = menu.findItem(R.id.action_refresh);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		case R.id.action_refresh:
			mTask = new MockRefreshTask(this);
			mTask.execute();
		}
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void setRefresh(boolean refresh) {

		if (refresh){
			mRefreshMenuItem.setActionView(R.layout.actionbar_indeterminate_progress);
		}else{
			mRefreshMenuItem.setActionView(null);
			mTask = null;
		}
	}
	
	@Override
	protected void onDestroy() {
		
		super.onDestroy();
		
		if (mTask != null){
			mTask.cancel(true);
		}
	}
}
