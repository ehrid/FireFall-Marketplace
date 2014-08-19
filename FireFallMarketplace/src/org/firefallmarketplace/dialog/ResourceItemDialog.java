package org.firefallmarketplace.dialog;

import org.firefallmarketplace.R;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author horodysk
 */
public class ResourceItemDialog extends DialogActivity {

    private Button showChartButton;

    private Button addButton;

    private EditText addValue;

    @Override
    protected void onCreateDialog(Bundle savedInstanceState) {
        View inflated = initializeDialogBody();

        initializeVariables(inflated);
        setOnClicListeners();
        setTypeFont();
    }

    private View initializeDialogBody() {
        ViewStub stub = (ViewStub) findViewById(R.id.dialog_stub);
        stub.setLayoutResource(R.layout.dialog_resource_item);
        View inflated = stub.inflate();

        return inflated;
    }

    private void initializeVariables(View inflated) {
        showChartButton = (Button) inflated.findViewById(R.id.dialog_resource_item_show_chart_button);
        addButton = (Button) inflated.findViewById(R.id.dialog_resource_item_add_button);
        addValue = (EditText) inflated.findViewById(R.id.dialog_resource_item_add_value);
    }

    private void setOnClicListeners() {
        showChartButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
    }

    private void setTypeFont() {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/YouRookMarbelous.ttf");
        showChartButton.setTypeface(font);
        addButton.setTypeface(font);
    }

    @Override
    protected void onClickAction(View v) {
        switch (v.getId()) {
            case R.id.dialog_resource_item_show_chart_button:
                // do nothing
                break;
            case R.id.dialog_resource_item_add_button:
                // do nothing
                break;
        }

    }

}
