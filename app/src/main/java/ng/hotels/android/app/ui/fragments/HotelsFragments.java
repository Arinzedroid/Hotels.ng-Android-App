package ng.hotels.android.app.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ng.hotels.android.app.R;

/**
 * Created by Nsikak on 9/27/17.
 */

public class HotelsFragments extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
      View rootView = inflater.inflate( R.layout.hotels_fragments, container,false);

      return rootView;
    }
}
