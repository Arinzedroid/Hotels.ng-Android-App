package ng.hotels.android.app.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCardFragment extends Fragment {

    @BindView(R.id.banner_slider_add_card)
    BannerSlider bannerSlider;

    public AddCardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_card, container, false);
        ButterKnife.bind(this,view);
        setupSlider();
        return view;
    }

    private void setupSlider() {
        List<Banner> banners=new ArrayList<>();
        banners.add(new DrawableBanner(R.drawable.aeroplane));
        banners.add(new DrawableBanner(R.drawable.arik_logo));
        bannerSlider.setBanners(banners);
    }

}
