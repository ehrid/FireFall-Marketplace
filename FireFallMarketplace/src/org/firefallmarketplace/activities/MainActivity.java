package org.firefallmarketplace.activities;

import java.util.ArrayList;
import java.util.List;

import org.firefallmarketplace.R;
import org.firefallmarketplace.resources.ResourceObject;
import org.firefallmarketplace.resources.ResourcesListAdapter;

import android.app.Activity;
import android.graphics.Color;
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

        resourcesList = (ListView) findViewById(R.id.resources_list);

        setAdpterOnResourceList();
    }

    private void setAdpterOnResourceList() {
        ResourcesListAdapter adapter = new ResourcesListAdapter(this, R.layout.activity_resource_item, getResourceList());
        resourcesList.setAdapter(adapter);
    }

    private List<ResourceObject> getResourceList() {
        List<ResourceObject> resourceObjectList = new ArrayList<ResourceObject>();
        // green
        resourceObjectList.add(new ResourceObject(R.drawable.resource_synthetic_ligatures, "Synthetic Ligatures", Color.GREEN));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_biosteel_frame, "Biosteel Frame", Color.GREEN));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_artificial_sinews, "Artificial Sinews", Color.GREEN));

        // blue
        resourceObjectList.add(new ResourceObject(R.drawable.resource_entropic_nanotubes, "Entropic Nanotubes", Color.BLUE));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_adaptive_fibers, "Adaptive Fibers", Color.BLUE));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_twinned_muscle_fibers, "Twinned Muscle Fibers", Color.BLUE));

        // purple
        resourceObjectList.add(new ResourceObject(R.drawable.resource_thermionic_transformer, "Thermionic Transformer", Color.MAGENTA));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_polyphasic_fabric, "Polyphasic Fabric", Color.MAGENTA));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_transnucleic_battery, "Transnucleic Battery", Color.MAGENTA));

        // gold
        resourceObjectList.add(new ResourceObject(R.drawable.resource_fusion_motor, "Fusion Motor", Color.YELLOW));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_superconductive_fuel_cells, "Superconductive Fuel Cells", Color.YELLOW));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_hyper_keg, "Hyper Keg", Color.YELLOW));
        return resourceObjectList;
    }
}
