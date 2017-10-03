package ng.hotels.android.app.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ng.hotels.android.app.R;

/**
 * Created by Nsikak on 10/3/17.
 */

public class WishListFragment extends Fragment {
    public WishListFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wishlist, container, false);
        return rootView;
    }
}
