package ng.hotels.android.app.ui.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import ng.hotels.android.app.R;
import ng.hotels.android.app.ui.adapters.SingleHotelSlideAdapter;

public class SingleHotelPageActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] HotelImages = {R.drawable.hotel_img2, R.drawable.hotel_img3, R.drawable.hotel_img4, R.drawable.hotel_img5};
    private ArrayList<Integer> HotelImagesArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_hotel_page);

        ExpandableTextView expTxt = (ExpandableTextView) findViewById(R.id.expand_text_view);
        expTxt.setText(getString(R.string.dummy_hotel_desc));
        init();
    }

    private void init() {
        for (int i = 0; i < HotelImages.length; i++)
            HotelImagesArray.add(HotelImages[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SingleHotelSlideAdapter(SingleHotelPageActivity.this, HotelImagesArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == HotelImages.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }
}
