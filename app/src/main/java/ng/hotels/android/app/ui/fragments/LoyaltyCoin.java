package ng.hotels.android.app.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ng.hotels.android.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoyaltyCoin extends Fragment {


    public LoyaltyCoin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loyalty_coin, container, false);
    }

}
