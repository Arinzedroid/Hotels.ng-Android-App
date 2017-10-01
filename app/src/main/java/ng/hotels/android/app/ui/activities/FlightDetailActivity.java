package ng.hotels.android.app.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import ng.hotels.android.app.R;

/**
 * Created by idee on 9/28/17.
 */

public class FlightDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_detail);
        ButterKnife.bind(this);
    }
}
