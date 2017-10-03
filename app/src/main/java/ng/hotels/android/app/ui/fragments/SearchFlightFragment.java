package ng.hotels.android.app.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ng.hotels.android.app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFlightFragment extends Fragment {

    public SearchFlightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_flight, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
