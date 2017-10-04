package ng.hotels.android.app.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link YourInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link YourInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YourInfoFragment extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.editText_email)
    EditText emailView;
    @BindView(R.id.editText_name)
    EditText nameView;
    @BindView(R.id.editText_phone)
    EditText phoneView;
    @BindView(R.id.proceed_button)
    Button proceedButton;
    @BindView(R.id.spinner_country)
    Spinner countrySpinner;
    @BindView(R.id.spinner_title)
    Spinner titleSpinner;

    public YourInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment YourInfoFragment.
     */
    public static YourInfoFragment newInstance() {
        YourInfoFragment fragment = new YourInfoFragment();
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
        View view = inflater.inflate(R.layout.fragment_your_info, container, false);
        ButterKnife.bind(this, view);
        proceedButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.proceed_button:
                String name = nameView.getText().toString();
                String email = emailView.getText().toString();
                String phone = phoneView.getText().toString();
//                TextView countryView = (TextView) countrySpinner.getSelectedView();
//                String country = countryView.getText().toString();
//                TextView titleView = (TextView) titleSpinner.getSelectedView();
//                String title = titleView.getText().toString();
                mListener.onProceedClicked("", "", email, phone, name);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        void onProceedClicked(String title, String country, String email, String phone, String name);
    }
}
