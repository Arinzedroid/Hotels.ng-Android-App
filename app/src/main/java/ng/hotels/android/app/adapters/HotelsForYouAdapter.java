package ng.hotels.android.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import ng.hotels.android.app.R;
import ng.hotels.android.app.model.Hotels;

/**
 * Created by Nsikak on 10/1/17.
 */

public class HotelsForYouAdapter extends RecyclerView.Adapter<HotelsForYouAdapter.ViewHolder> {

    private ArrayList<Hotels> modelArrayList;

    public HotelsForYouAdapter(ArrayList<Hotels> models) {
        this.modelArrayList = models;
    }

    @Override
    public HotelsForYouAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int idForListItem = R.layout.hotels_for_you_layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attach = false;

        View view = inflater.inflate(idForListItem, parent, attach);
        ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;

    }

    @Override
    public void onBindViewHolder(final HotelsForYouAdapter.ViewHolder holder, final int position) {

        Hotels item = modelArrayList.get(position);


        holder.hotelImage.setImageResource(item.getHotel_image());
        holder.hotelName.setText(item.getHotel_name());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = holder.itemView.getContext();


            }
        });


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView hotelImage;
        public TextView hotelName,hotelPrice, hotelLocation;
        public RatingBar hotelRating;


        public ViewHolder(View itemView) {
            super(itemView);
            hotelImage = (ImageView) itemView.findViewById(R.id.hotel_thumbnail);
            hotelName = (TextView) itemView.findViewById(R.id.hotel_name);
            hotelPrice = (TextView) itemView.findViewById(R.id.hotel_prize);
            hotelLocation= (TextView) itemView.findViewById(R.id.hotel_location);
            hotelRating = itemView.findViewById(R.id.hotel_rating);


        }

       /* void bind(int index) {
            picture.setImageResource(index);
            name.setText(String.valueOf(index));
        }*/
    }
}
