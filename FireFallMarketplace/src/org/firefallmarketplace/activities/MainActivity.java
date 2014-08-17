package org.firefallmarketplace.activities;

import java.util.ArrayList;
import java.util.List;

import org.firefallmarketplace.R;
import org.firefallmarketplace.resources.ResourceObject;
import org.firefallmarketplace.resources.ResourcesListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * @author horodysk
 */
public class MainActivity extends Activity {

    private ListView resourcesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        List<ResourceObject> resourceObjectList = new ArrayList<ResourceObject>();
        resourceObjectList.add(new ResourceObject(R.drawable.resource_default, "Resource 1"));

        ResourcesListAdapter adapter = new ResourcesListAdapter(this, R.layout.activity_resource_item, resourceObjectList);

        resourcesList = (ListView) findViewById(R.id.resources_list);
        resourcesList.setAdapter(adapter);
    }
}
