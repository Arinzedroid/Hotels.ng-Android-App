package ng.hotels.android.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ng.hotels.android.app.R;
import ng.hotels.android.app.model.Places;

/**
 * Created by Nsikak on 10/1/17.
 */

public class FeaturedPlaceAdapter extends RecyclerView.Adapter<FeaturedPlaceAdapter.ViewHolder> {

    private List<Places> modelArrayList;

    public FeaturedPlaceAdapter(List<Places> models) {
        this.modelArrayList = models;
    }

    @Override
    public FeaturedPlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int idForListItem = R.layout.featured_places_layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attach = false;

        View view = inflater.inflate(idForListItem, parent, attach);
        ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;

    }

    @Override
    public void onBindViewHolder(final FeaturedPlaceAdapter.ViewHolder holder, final int position) {

        Places item = modelArrayList.get(position);


        holder.placeImage.setImageResource(item.getPlace_image());
        holder.placeName.setText(item.getPlace_name());
        holder.placeDescr.setText(item.getPlace_descriptions());


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
        public ImageView placeImage;
        public TextView placeName,placeDescr;



        public ViewHolder(View itemView) {
            super(itemView);
            placeImage = (ImageView) itemView.findViewById(R.id.place_image);
            placeName = (TextView) itemView.findViewById(R.id.place_name);
            placeDescr= (TextView) itemView.findViewById(R.id.place_descr);


        }

       /* void bind(int index) {
            picture.setImageResource(index);
            name.setText(String.valueOf(index));
        }*/
    }
}
