package com.limecreativelabs.actionbarsearch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnQueryTextListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    private SearchView mSearchView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        
        MenuItem searchItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) searchItem.getActionView();
        mSearchView.setQueryHint("Search…");
        mSearchView.setOnQueryTextListener(this);
        
        return true;
    }

	@Override
	public boolean onQueryTextChange(String newText) {
		
		Toast.makeText(this, newText, Toast.LENGTH_SHORT).show();
		
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String text) {
		
		Toast.makeText(this, "Searching for " + text, Toast.LENGTH_LONG).show();
		
		return false;
	}
}
