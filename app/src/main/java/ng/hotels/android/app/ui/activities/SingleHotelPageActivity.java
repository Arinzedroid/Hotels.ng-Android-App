package ng.hotels.android.app.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import ng.hotels.android.app.R;

public class SingleHotelPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_hotel_page);

        ExpandableTextView expTxt = (ExpandableTextView) findViewById(R.id.expand_text_view);
    }
}
