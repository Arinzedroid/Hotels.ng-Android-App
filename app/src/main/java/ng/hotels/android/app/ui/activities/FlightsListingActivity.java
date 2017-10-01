package ng.hotels.android.app.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;

/**
 * Created by idee on 9/28/17.
 */

public class FlightsListingActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view_flights_listing)
    RecyclerView recyclerViewFlightsListing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_flights_listing);
        recyclerViewFlightsListing.setLayoutManager(new LinearLayoutManager(this));
        // TODO: Initialize a custom adapter and assign to the recycler view. Custom adapter should use R.layout.custom_flight_listing_row
    }
}
