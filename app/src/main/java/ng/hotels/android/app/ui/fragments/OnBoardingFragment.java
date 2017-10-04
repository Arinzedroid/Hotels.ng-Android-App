package ng.hotels.android.app.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;

public class OnBoardingFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    @BindView(R.id.image_on_boarding)
    ImageView imageOnBoarding;

    @BindView(R.id.text_detail_on_boarding)
    TextView onBoardingTextDetail;

    int[] bgs = new int[]{R.drawable.hotel_booking_onboarding, R.drawable.flight_on_boarding, R.drawable.better_prices_on_boarding};

    public OnBoardingFragment() {
        // Required empty public constructor
    }

    public static OnBoardingFragment newInstance(int sectionNumber) {
        OnBoardingFragment fragment = new OnBoardingFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_onboarding, container, false);
        ButterKnife.bind(this,view);

        int page = getArguments().getInt(ARG_SECTION_NUMBER);

        if (page==1){
            onBoardingTextDetail.setText(R.string.hotel_booking);
        } else if (page==2){
            onBoardingTextDetail.setText(R.string.flight_booking);
        } else if (page==3){
            onBoardingTextDetail.setText(R.string.better_prices);
        }

        imageOnBoarding.setBackgroundResource(bgs[getArguments().getInt(ARG_SECTION_NUMBER) - 1]);

        return view;
    }


}
