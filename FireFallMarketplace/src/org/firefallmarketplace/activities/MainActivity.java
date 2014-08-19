package org.firefallmarketplace.activities;

import java.util.ArrayList;
import java.util.List;

import org.firefallmarketplace.R;
import org.firefallmarketplace.activities.dialog.ResourceItemDialog;
import org.firefallmarketplace.resources.RarityType;
import org.firefallmarketplace.resources.ResourceObject;
import org.firefallmarketplace.resources.ResourcesListAdapter;

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
public class MainActivity extends Activity implements OnItemClickListener {

    private ListView resourcesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        resourcesList = (ListView) findViewById(R.id.resources_list);

        setAdpterOnResourceList();

        resourcesList.setOnItemClickListener(this);
    }

    private void setAdpterOnResourceList() {
        ResourcesListAdapter adapter = new ResourcesListAdapter(this, R.layout.activity_resource_item, getResourceList());
        resourcesList.setAdapter(adapter);
    }

    private List<ResourceObject> getResourceList() {
        List<ResourceObject> resourceObjectList = new ArrayList<ResourceObject>();
        // green
        resourceObjectList.add(new ResourceObject(R.drawable.resource_synthetic_ligatures, "Synthetic Ligatures", RarityType.UNCOMMON));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_biosteel_frame, "Biosteel Frame", RarityType.UNCOMMON));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_artificial_sinews, "Artificial Sinews", RarityType.UNCOMMON));

        // blue
        resourceObjectList.add(new ResourceObject(R.drawable.resource_entropic_nanotubes, "Entropic Nanotubes", RarityType.RARE));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_adaptive_fibers, "Adaptive Fibers", RarityType.RARE));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_twinned_muscle_fibers, "Twinned Muscle Fibers", RarityType.RARE));

        // purple
        resourceObjectList.add(new ResourceObject(R.drawable.resource_thermionic_transformer, "Thermionic Transformer", RarityType.EPIC));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_polyphasic_fabric, "Polyphasic Fabric", RarityType.EPIC));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_transnucleic_battery, "Transnucleic Battery", RarityType.EPIC));

        // gold
        resourceObjectList.add(new ResourceObject(R.drawable.resource_fusion_motor, "Fusion Motor", RarityType.PRTOTYPE));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_superconductive_fuel_cells, "Superconductive Fuel Cells", RarityType.PRTOTYPE));
        resourceObjectList.add(new ResourceObject(R.drawable.resource_hyper_keg, "Hyper Keg", RarityType.PRTOTYPE));
        return resourceObjectList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, ResourceItemDialog.class);
        startActivity(intent);
    }
}
