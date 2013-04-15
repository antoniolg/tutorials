package com.limecreativelabs.actionbarrefresh;

import android.os.AsyncTask;

public class MockRefreshTask extends AsyncTask<Void, Void, Void> {
	
	private IRefresh refreshImpl;
	
	public MockRefreshTask(IRefresh ref) {
		refreshImpl = ref;
	}
	
	@Override
	protected void onPreExecute() {
		refreshImpl.setRefresh(true);
	}

	@Override
	protected Void doInBackground(Void... arg0) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		refreshImpl.setRefresh(false);
	}
}
