package org.firefallmarketplace.resources;

import java.util.List;

import org.firefallmarketplace.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResourcesListAdapter extends ArrayAdapter<ResourceObject> {

    int resource;

    String response;

    Context appContext;

    // Initialize adapter
    public ResourcesListAdapter(Context context, int resource, List<ResourceObject> items) {
        super(context, resource, items);
        this.resource = resource;

    }

    public ResourceObject getResource(int position) {
        return getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout alertView;
        // Get the current alert object
        ResourceObject res = getItem(position);

        // Inflate the view
        if (convertView == null) {
            alertView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(resource, alertView, true);
        }
        else {
            alertView = (LinearLayout) convertView;
        }

        // Get the text boxes from the listitem.xml file
        TextView name = (TextView) alertView.findViewById(R.id.resorces_item_name);
        ImageView icon = (ImageView) alertView.findViewById(R.id.resorces_item_icon);

        // Assign the appropriate data from our alert object above
        name.setText(res.getResourceName());
        icon.setBackgroundResource(res.getImageResourceId());

        return alertView;
    }
}