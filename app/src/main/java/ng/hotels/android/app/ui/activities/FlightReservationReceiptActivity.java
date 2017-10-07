package ng.hotels.android.app.ui.activities;

import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;

import ng.hotels.android.app.R;

public class FlightReservationReceiptActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_reservation_receipt);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
