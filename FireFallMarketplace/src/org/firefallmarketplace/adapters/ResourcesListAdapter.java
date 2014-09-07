package org.firefallmarketplace.adapters;

import java.lang.reflect.Field;
import java.util.List;

import org.firefallmarketplace.R;
import org.firefallmarketplace.database.objects.ResourceObject;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResourcesListAdapter extends ArrayAdapter<ResourceObject> {

    private int resource;

    // Initialize adapter
    public ResourcesListAdapter(Context context, int resource, List<ResourceObject> items) {
        super(context, resource, items);
        this.resource = resource;
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

        // initialize embedded views
        TextView name = (TextView) alertView.findViewById(R.id.resorces_item_name);
        ImageView icon = (ImageView) alertView.findViewById(R.id.resorces_item_icon);
        LinearLayout container = (LinearLayout) alertView.findViewById(R.id.resources_item_container);

        // Assign the appropriate data from our alert objects above
        name.setText(res.getResourceName());

        int imageId = getResId(res.getImageResource(), R.drawable.class);
        Log.d("AAAAA", imageId + ""); // TODO load image
        icon.setImageResource(imageId);
        container.setBackgroundResource(res.getBackground());

        setTypeFont(name);

        // return view
        return alertView;
    }

    private void setTypeFont(TextView name) {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/YouRookMarbelous.ttf");
        name.setTypeface(font);
    }

    /**
     * @author Lonkly
     * @param variableName
     *            - name of drawable, e.g R.drawable.<b>image</b>
     * @param с
     *            - class of resource, e.g R.drawable, of R.raw
     * @return integer id of resource
     */
    public int getResId(String variableName, Class<?> с) {
        Field field = null;
        int resId = 0;
        try {
            field = с.getField(variableName);
            try {
                resId = field.getInt(null);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return resId;

    }
}