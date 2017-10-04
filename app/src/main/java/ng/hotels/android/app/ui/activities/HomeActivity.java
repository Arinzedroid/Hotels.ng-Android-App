package ng.hotels.android.app.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import ng.hotels.android.app.R;
import ng.hotels.android.app.adapters.BottomBarAdapter;
import ng.hotels.android.app.adapters.NoSwipePager;
import ng.hotels.android.app.ui.fragments.HotelsFragments;
import ng.hotels.android.app.ui.fragments.SearchFlightFragment;
import ng.hotels.android.app.ui.fragments.WishListFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private NoSwipePager viewPager;
    private  BottomBarAdapter pagerAdapter;
    private BottomNavigationView navigation;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_hotel:
                    selectedFragment = new HotelsFragments();
                    break;
                case R.id.navigation_flight:
                    selectedFragment = new SearchFlightFragment();
                    break;
                case R.id.navigation_wishlist:
                    selectedFragment = new WishListFragment();


                break;

                default:
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();
            return true;
        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextMessage = (TextView) findViewById(R.id.message);
         navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new HotelsFragments());
        transaction.commit();

       // setupViewPager();
    }

    private void setupViewPager() {
        viewPager = (NoSwipePager) findViewById(R.id.viewPager);
        viewPager.setPagingEnabled(false);
        pagerAdapter = new BottomBarAdapter(getSupportFragmentManager());

        HotelsFragments hotelsFragments = new HotelsFragments();
        SearchFlightFragment searchFlightFragment = new SearchFlightFragment();
        pagerAdapter.addFragments(hotelsFragments);
        pagerAdapter.addFragments(searchFlightFragment);


        viewPager.setAdapter(pagerAdapter);
    }




}
