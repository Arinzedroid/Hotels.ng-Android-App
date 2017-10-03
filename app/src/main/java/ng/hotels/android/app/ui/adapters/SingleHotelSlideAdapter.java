package ng.hotels.android.app.ui.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import ng.hotels.android.app.R;

/**
 * Created by tody on 10/3/17.
 */

public class SingleHotelSlideAdapter extends PagerAdapter {

    private ArrayList<Integer> IMAGES;
    private LayoutInflater inflater;
    private Context context;

    public SingleHotelSlideAdapter(Context context, ArrayList<Integer> Images) {
        this.context = context;
        this.IMAGES = Images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View imageLayout = inflater.inflate(R.layout.slide, container, false);

        ImageView myImage = (ImageView) imageLayout.findViewById(R.id.image);

        myImage.setImageResource(IMAGES.get(position));

        container.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return IMAGES.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
