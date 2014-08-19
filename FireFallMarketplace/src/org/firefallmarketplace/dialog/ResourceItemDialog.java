package org.firefallmarketplace.dialog;

import org.firefallmarketplace.R;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

/**
 * @author horodysk
 */
public class ResourceItemDialog extends DialogActivity {

    @Override
    protected void onCreateDialog(Bundle savedInstanceState) {
        View inflated = initializeDialogBody();

        Button showChart = (Button) inflated.findViewById(R.id.dialog_resource_item_show_chart);
        setTypeFont(showChart);
        showChart.setOnClickListener(this);
    }

    private View initializeDialogBody() {
        ViewStub stub = (ViewStub) findViewById(R.id.dialog_stub);
        stub.setLayoutResource(R.layout.dialog_resource_item);
        View inflated = stub.inflate();

        return inflated;
    }

    private void setTypeFont(Button item) {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/YouRookMarbelous.ttf");
        item.setTypeface(font);
    }

    @Override
    protected void onClickAction(View v) {
        switch (v.getId()) {
            case R.id.dialog_resource_item_show_chart:
                // do nothing
                break;
        }

    }

}
