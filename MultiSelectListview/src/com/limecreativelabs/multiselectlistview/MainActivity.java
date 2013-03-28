package com.limecreativelabs.multiselectlistview;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	/** MultiSelect list adapter */
	private SelectionAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		List<String> items = new ArrayList<String>();
		items.add("Item 1");
		items.add("Item 2");
		items.add("Item 3");
		items.add("Item 4");
		items.add("Item 5");
		items.add("Item 6");

		mAdapter = new SelectionAdapter(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, items);
		setListAdapter(mAdapter);

		setupActionBar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void setupActionBar() {
		ListView listView = getListView();
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {

			@Override
			public void onItemCheckedStateChanged(ActionMode mode,
					int position, long id, boolean checked) {

				// If element is checked, it is added to selection; if not, it's
				// deleted
				if (checked) {
					mAdapter.setNewSelection(position);
				} else {
					mAdapter.removeSelection(position);
				}

				mode.setTitle(mAdapter.getSelectionCount() + " items selected");
			}

			@Override
			public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
				// CAB menu options
				switch (item.getItemId()) {
				case R.id.delete:
					Toast.makeText(MainActivity.this,
							mAdapter.getSelectionCount() + " items deleted",
							Toast.LENGTH_LONG).show();
					mAdapter.clearSelection();
					mode.finish();
					return true;
				default:
					return false;
				}
			}

			@Override
			public boolean onCreateActionMode(ActionMode mode, Menu menu) {

				// CAB is initialized
				MenuInflater inflater = mode.getMenuInflater();
				inflater.inflate(R.menu.main_cab, menu);

				return true;
			}

			@Override
			public void onDestroyActionMode(ActionMode mode) {
				mAdapter.clearSelection();
			}

			@Override
			public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

				return false;
			}
		});
	}
}
