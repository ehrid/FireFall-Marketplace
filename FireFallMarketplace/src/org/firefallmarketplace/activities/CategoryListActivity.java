package org.firefallmarketplace.activities;

import org.firefallmarketplace.R;
import org.firefallmarketplace.adapters.CategoryListAdapter;
import org.firefallmarketplace.database.DataBaseHandler;

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
public class CategoryListActivity extends Activity implements OnItemClickListener {

    private ListView categoryList;

    private DataBaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        categoryList = (ListView) findViewById(R.id.category_list);
        db = new DataBaseHandler(this);

        setAdpterOnResourceList();
        categoryList.setOnItemClickListener(this);
    }

    private void setAdpterOnResourceList() {
        CategoryListAdapter adapter = new CategoryListAdapter(this, R.layout.activity_resource_item, db.getCategories());
        categoryList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(CategoryListActivity.this, ResourceListActivity.class);

        CategoryListAdapter adapter = (CategoryListAdapter) categoryList.getAdapter();
        intent.putExtra(ResourceListActivity.EXTRA_ITEM_CATEGORY_ID, adapter.getItem(position).getId());

        startActivity(intent);
    }

}
