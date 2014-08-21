package org.firefallmarketplace.dialog;

import org.firefallmarketplace.R;
import org.firefallmarketplace.resources.ResourceObject;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author horodysk
 */
public class ResourceItemDialog extends DialogActivity {
    public static final String EXTRA_ITEM_TYPE_ID = "org.firefallmarketplace.dialog.EXTRA_ITEM_TYPE_ID";

    private Button showChartButton;

    private Button addButton;

    private EditText addValue;

    private ResourceObject item;

    private TextView addLabel;

    private TextView andLabel;

    @Override
    protected void onCreateDialog(Bundle savedInstanceState) {
        View inflated = initializeDialogBody();

        initializeItem();
        initializeVariables(inflated);
        setOnClicListeners();
        setTypeFont();
    }

    private void initializeItem() {
        Bundle b = getIntent().getExtras();

        if (b != null) {
            item = (ResourceObject) b.get(EXTRA_ITEM_TYPE_ID);
        }
        else {
            String toastMessage = getResources().getString(R.string.activity_resourceitem_unspecified_object);
            toastMessage(toastMessage);
            finish();
        }
    }

    private void toastMessage(String toastMessage) {
        Toast unspecifiedResource = Toast.makeText(this, toastMessage, 2 * Time.SECOND);
        unspecifiedResource.show();
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
        addLabel = (TextView) inflated.findViewById(R.id.dialog_resource_item_label_add);
        andLabel = (TextView) inflated.findViewById(R.id.dialog_resource_item_label_and);

        showChartButton.setEnabled(false);
    }

    private void setOnClicListeners() {
        showChartButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
    }

    private void setTypeFont() {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/YouRookMarbelous.ttf");
        showChartButton.setTypeface(font);
        addButton.setTypeface(font);
        addLabel.setTypeface(font);
        andLabel.setTypeface(font);
    }

    @Override
    protected void onClickAction(View v) {
        switch (v.getId()) {
            case R.id.dialog_resource_item_show_chart_button:
                // do nothing
                break;
            case R.id.dialog_resource_item_add_button:
                String newStringValue = addValue.getText().toString().trim();
                int newIntValue = verifyNewMarketplaceValue(newStringValue);

                if (newIntValue != 0) {
                    String toastMessage = getResources().getString(R.string.activity_resourceitem_value_added);
                    toastMessage(toastMessage);

                    showChartButton.setEnabled(true);
                }

                break;
        }

    }

    private int verifyNewMarketplaceValue(String newMarketplaceValue) {
        int newValue = 0;

        try {
            newValue = Integer.parseInt(newMarketplaceValue);
        }
        catch (NumberFormatException e) {
            String toastMessage = getResources().getString(R.string.activity_resourceitem_wrong_value);
            toastMessage(toastMessage);
        }

        return newValue;
    }
}
