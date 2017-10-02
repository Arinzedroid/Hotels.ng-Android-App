package ng.hotels.android.app.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ng.hotels.android.app.R;
import ng.hotels.android.app.adapters.FeaturedPlaceAdapter;
import ng.hotels.android.app.adapters.HotelsForYouAdapter;
import ng.hotels.android.app.model.Hotels;
import ng.hotels.android.app.model.Places;

/**
 * Created by Nsikak on 9/27/17.
 */

public class HotelsFragments extends Fragment {

    private List<Hotels> hotelsList = new ArrayList<>();
    private List<Places> placesList = new ArrayList<>();
    private RecyclerView recyclerView2 , recyclerView3;
    private HotelsForYouAdapter mAdapter;
    private FeaturedPlaceAdapter featuredPlaceAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
      View rootView = inflater.inflate( R.layout.hotels_fragments, container,false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        //for crate home button
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

      //Hotels near you
        recyclerView2 = (RecyclerView) rootView.findViewById(R.id.hotels_list);
        mAdapter = new HotelsForYouAdapter(hotelsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(mAdapter);
        prepareData();

        //Featured places
        recyclerView3 = (RecyclerView) rootView.findViewById(R.id.places_list);
       featuredPlaceAdapter = new FeaturedPlaceAdapter(placesList);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager1);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setAdapter(featuredPlaceAdapter);
        preparePlaceData();


      return rootView;
    }

    private void prepareData() {


        Hotels item = new Hotels("Esuites","Asokoro, Lagos", "₦20,000",3, R.drawable.top);
        hotelsList.add(item);
        item = new Hotels("Esuites","Asokoro, Lagos", "₦20,000",3, R.drawable.top);
        hotelsList.add(item);
        item = new Hotels("Esuites","Asokoro, Lagos", "₦20,000",3, R.drawable.top);
        hotelsList.add(item);
        item = new Hotels("Esuites","Asokoro, Lagos", "₦20,000",3, R.drawable.top);
        hotelsList.add(item);



        mAdapter.notifyDataSetChanged();
    }

    private void preparePlaceData() {


        Places item = new Places(R.drawable.place, "Ibom Tropicana", "Best entertainment Center  in Uyo");
        placesList.add(item);
        item = new Places(R.drawable.place, "Ibom Tropicana", "Best entertainment Center  in Uyo");
        placesList.add(item);
        item = new Places(R.drawable.place, "Ibom Tropicana", "Best entertainment Center  in Uyo");
        placesList.add(item);
        item = new Places(R.drawable.place, "Ibom Tropicana", "Best entertainment Center  in Uyo");
        placesList.add(item);




        featuredPlaceAdapter.notifyDataSetChanged();
    }






}
