package ng.hotels.android.app.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ng.hotels.android.app.R;
import ng.hotels.android.app.model.BookingHistory;
import ng.hotels.android.app.ui.fragments.BookingHistoryListFragment.OnListFragmentInteractionListener;


public class BookingHistoryListRecyclerViewAdapter extends RecyclerView.Adapter<BookingHistoryListRecyclerViewAdapter.ViewHolder> {

    private final OnListFragmentInteractionListener mListener;
    private List<BookingHistory> history;

    public BookingHistoryListRecyclerViewAdapter(List<BookingHistory> history, OnListFragmentInteractionListener listener) {
        mListener = listener;
        this.history = history;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_booking_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = history.get(position);
        holder.booking.setText(holder.mItem.getBooking());
        holder.arrivalTime.setText(holder.mItem.getArrivalTime());
        holder.departureTime.setText(holder.mItem.getDepartureTime());
        holder.partyName.setText(holder.mItem.getPartyName());
        holder.dayMonth.setText(holder.mItem.getDayMonth());
        holder.bookingCost.setText(holder.mItem.getPrice());
        holder.dateView.setText(String.valueOf(holder.mItem.getDate()));
        int date = holder.mItem.getDate();
        if (date == 1 || date == 21 || date == 31) {
            holder.dateIdentifier.setText("st");
        } else if (date == 2 || date == 22) {
            holder.dateIdentifier.setText("nd");
        } else if (date == 3 || date == 23) {
            holder.dateIdentifier.setText("rd");
        } else {
            holder.dateIdentifier.setText("th");
        }

        int type = holder.mItem.getBookingType();
        if (type == 0) {
            holder.bookingType.setImageResource(R.drawable.plane_logo);
            holder.place.setText("Airline");
            holder.departure.setText("Departure");
            holder.arrival.setText("Arrival");
        } else {
            holder.bookingType.setImageResource(R.drawable.hotel_logo);
            holder.arrival.setText("Checked-Out:");
            holder.departure.setText("Checked-In:");
            holder.place.setText("Executive Deluxe Room:");
        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView bookingType;
        final TextView dateView;
        final TextView dateIdentifier;
        final TextView dayMonth;
        final TextView bookingCost;
        final TextView booking;
        final TextView partyName;
        final TextView departureTime;
        final TextView arrivalTime;
        final TextView place;
        final TextView departure;
        final TextView arrival;
        View mView;
        TextView mIdView;
        TextView mContentView;
        BookingHistory mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.date_view);
            mContentView = (TextView) view.findViewById(R.id.date_identifier);

            bookingType = view.findViewById(R.id.booking_type);
            dateView = view.findViewById(R.id.date_view);
            dateIdentifier = view.findViewById(R.id.date_identifier);
            dayMonth = view.findViewById(R.id.day_month);
            booking = view.findViewById(R.id.booking);
            bookingCost = view.findViewById(R.id.booking_cost);
            partyName = view.findViewById(R.id.party_name);
            departureTime = view.findViewById(R.id.depature_time);
            arrivalTime = view.findViewById(R.id.arrival_time);
            place = view.findViewById(R.id.place);
            departure = view.findViewById(R.id.departure);
            arrival = view.findViewById(R.id.arrival);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + booking.getText() + "'";
        }
    }
}
