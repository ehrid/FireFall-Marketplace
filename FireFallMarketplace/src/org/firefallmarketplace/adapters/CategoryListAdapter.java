package org.firefallmarketplace.adapters;

import java.util.List;

import org.firefallmarketplace.R;
import org.firefallmarketplace.database.objects.CategoryObject;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategoryListAdapter extends ArrayAdapter<CategoryObject> {

    private int resource;

    // Initialize adapter
    public CategoryListAdapter(Context context, int resource, List<CategoryObject> items) {
        super(context, resource, items);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout alertView;
        // Get the current alert object
        CategoryObject res = getItem(position);

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

        // initialize embedded views
        TextView name = (TextView) alertView.findViewById(R.id.category_item_name);

        // Assign the appropriate data from our alert objects above
        name.setText(res.getName());
        setTypeFont(name);

        // return view
        return alertView;
    }

    private void setTypeFont(TextView name) {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/YouRookMarbelous.ttf");
        name.setTypeface(font);
    }
}