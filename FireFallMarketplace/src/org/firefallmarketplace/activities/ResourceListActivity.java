package org.firefallmarketplace.activities;

import org.firefallmarketplace.R;
import org.firefallmarketplace.adapters.ResourcesListAdapter;
import org.firefallmarketplace.database.DataBaseHandler;
import org.firefallmarketplace.dialog.ResourceItemDialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * @author horodysk
 */
public class ResourceListActivity extends Activity implements OnItemClickListener {

    public static final String EXTRA_ITEM_CATEGORY_ID = "org.firefallmarketplace.activities.EXTRA_ITEM_CATEGORY_ID";

    private DataBaseHandler db;

    private ListView resourcesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        resourcesList = (ListView) findViewById(R.id.resources_list);
        db = new DataBaseHandler(this);

        setAdpterOnResourceList();

        resourcesList.setOnItemClickListener(this);
    }

    private void setAdpterOnResourceList() {
        ResourcesListAdapter adapter = new ResourcesListAdapter(this, R.layout.activity_resource_item,
            db.getResourcesInCategory(getCategoryId()));
        resourcesList.setAdapter(adapter);
    }

    private int getCategoryId() {
        Bundle b = getIntent().getExtras();

        if (b != null) {
            return b.getInt(EXTRA_ITEM_CATEGORY_ID);
        }
        return 0;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ResourceListActivity.this, ResourceItemDialog.class);

        ResourcesListAdapter adapter = (ResourcesListAdapter) resourcesList.getAdapter();
        intent.putExtra(ResourceItemDialog.EXTRA_ITEM_TYPE_ID, adapter.getItem(position));

        startActivity(intent);
    }

}
