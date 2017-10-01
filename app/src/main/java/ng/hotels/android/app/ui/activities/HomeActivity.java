package ng.hotels.android.app.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import ng.hotels.android.app.R;
import ng.hotels.android.app.adapters.BottomBarAdapter;
import ng.hotels.android.app.adapters.NoSwipePager;
import ng.hotels.android.app.ui.fragments.HotelsFragments;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private NoSwipePager viewPager;
    private  BottomBarAdapter pagerAdapter;
    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_hotel:
                    mTextMessage.setText("Hotel");
                    return true;
                case R.id.navigation_flight:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_wishlist:
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
         navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        setupViewPager();
    }

    private void setupViewPager() {
        viewPager = (NoSwipePager) findViewById(R.id.viewPager);
        viewPager.setPagingEnabled(false);
        pagerAdapter = new BottomBarAdapter(getSupportFragmentManager());

        HotelsFragments hotelsFragments = new HotelsFragments();
        pagerAdapter.addFragments(hotelsFragments);


        viewPager.setAdapter(pagerAdapter);
    }




}
