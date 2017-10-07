package ng.hotels.android.app.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import ng.hotels.android.app.R;
import ng.hotels.android.app.ui.fragments.BookingHistoryDetailsFragment;
import ng.hotels.android.app.ui.fragments.BookingHistoryListFragment;

public class BookingHistoryActivity extends AppCompatActivity implements
        BookingHistoryDetailsFragment.OnFragmentInteractionListener,
        BookingHistoryListFragment.OnListFragmentInteractionListener{

    private BookingHistoryDetailsFragment bookingHistoryDetailsFragment;
    private BookingHistoryListFragment bookingHistoryListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_history);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent.hasExtra("page")) {
            int page = intent.getIntExtra("page",0);
            if (page == 0) {
                showBookingHistoryDetailsFragment();
            } else if (page == 1) {
                showBookingHistoryListFragment();
            }
        }
    }

    private void showBookingHistoryDetailsFragment() {
        if (bookingHistoryDetailsFragment == null)
            bookingHistoryDetailsFragment = BookingHistoryDetailsFragment.newInstance();
        loadFragment(bookingHistoryDetailsFragment);
    }

    private void showBookingHistoryListFragment() {
        if (bookingHistoryListFragment == null)
            bookingHistoryListFragment = BookingHistoryListFragment.newInstance(1);
        loadFragment(bookingHistoryListFragment);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.booking_container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

    @Override
    public void onFragmentInteraction() {

    }

    @Override
    public void onListFragmentInteraction() {
        showBookingHistoryDetailsFragment();
    }
}
