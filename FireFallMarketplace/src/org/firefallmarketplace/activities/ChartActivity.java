package org.firefallmarketplace.activities;

import java.util.List;

import org.firefallmarketplace.R;
import org.firefallmarketplace.database.DataBaseHandler;
import org.firefallmarketplace.database.objects.PriceObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

public class ChartActivity extends Activity {

    public static final String EXTRA_RESOURCE_ID = "org.firefallmarketplace.activities.EXTRA_RESOURCE_ID";

    private LinearLayout chartContainer;

    private List<PriceObject> resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        initializeContainer();
        initializeResourcesFromDB();
        addChartToView(createChart());
    }

    private void initializeContainer() {
        chartContainer = (LinearLayout) findViewById(R.id.chart_container);

    }

    private void initializeResourcesFromDB() {
        DataBaseHandler db = new DataBaseHandler(this);
        resources = db.getPricesForResource(getResourceId());
    }

    private int getResourceId() {
        Bundle b = getIntent().getExtras();

        if (b != null) {
            return b.getInt(EXTRA_RESOURCE_ID);
        }
        return 0;
    }

    private GraphView createChart() {
        // init example series data
        GraphViewData[] graphViewDatas = new GraphViewData[resources.size()];

        for (int i = 0; i < graphViewDatas.length; i++) {
            PriceObject price = resources.get(i);
            double x = price.getDate();
            int y = price.getPrice();
            graphViewDatas[i] = new GraphViewData(x, y);
        }

        GraphViewSeries exampleSeries = new GraphViewSeries(graphViewDatas);

        GraphView graphView = new LineGraphView(
            this // context
            , "Resource prices chart" // heading
        );
        graphView.addSeries(exampleSeries); // data

        return graphView;
    }

    private void addChartToView(GraphView graphView) {
        chartContainer.addView(graphView);
    }
}
