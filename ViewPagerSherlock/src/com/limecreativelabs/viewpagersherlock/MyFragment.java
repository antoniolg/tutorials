package com.limecreativelabs.viewpagersherlock;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.limecreativelabs.viewpagersherlock.R;

public class MyFragment extends SherlockFragment {
	
	private static String KEY_CONTENT = "myfragment:content";	
	
	public static MyFragment newInstance(String content){
		
		MyFragment fragment = new MyFragment();
		fragment.mContent = content;		
		
		return fragment;
	}
	
	private String mContent;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View myView = inflater.inflate(R.layout.fragment_page, null);
		
		TextView tv = (TextView) myView.findViewById(R.id.text1);
		tv.setText(mContent);
		
		return myView;
	}
	
	@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
    }
}
