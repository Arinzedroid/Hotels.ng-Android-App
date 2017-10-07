package ng.hotels.android.app.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ng.hotels.android.app.R;
import ng.hotels.android.app.adapters.BookingHistoryListRecyclerViewAdapter;
import ng.hotels.android.app.model.BookingHistory;

;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class BookingHistoryListFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    private List<BookingHistory> historyList = null;
    private RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BookingHistoryListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BookingHistoryListFragment newInstance(int columnCount) {
        BookingHistoryListFragment fragment = new BookingHistoryListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking_history_list, container, false);
        setHistory();
        // Set the adapter

        recyclerView = view.findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new BookingHistoryListRecyclerViewAdapter(historyList, mListener));
        return view;
    }

    private void setHistory() {
        if (historyList == null || historyList.size() == 0) {
            historyList = new ArrayList<>();
            BookingHistory booking1 = new BookingHistory(0, "Arik Airline",
                    "12:00PM", "13:00PM", "Sep. Monday", 1,
                    "Uyo - Lagos", "N25,000");
            BookingHistory booking3 = new BookingHistory(0, "Air Peace",
                    "14:00PM", "14:47PM", "Sep. Tuesday", 3,
                    "Lagos - Abuja", "N25,040");

            BookingHistory booking2 = new BookingHistory(1, "2 Adults",
                    "1st Sep. 2017", "2nd Sep. 2017",
                    "Sep. Monday", 2, "Le Meridien Resort", "N34,800");

            BookingHistory booking4 = new BookingHistory(1, "2 Adults",
                    "3rd Sep. 2017", "4th Sep. 2017",
                    "Sep. Monday", 4, "Sheraton Hotels and Suites", "N17,290");
            historyList.add(booking1);
            historyList.add(booking2);
            historyList.add(booking3);
            historyList.add(booking4);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction();
    }
}
