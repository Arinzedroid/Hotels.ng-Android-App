package ng.hotels.android.app.ui.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import ng.hotels.android.app.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PaymentOptionsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PaymentOptionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaymentOptionsFragment extends DialogFragment {

    private OnFragmentInteractionListener mListener;

    public PaymentOptionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment PaymentOptionsFragment.
     */
    public static PaymentOptionsFragment newInstance() {
        PaymentOptionsFragment fragment = new PaymentOptionsFragment();
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

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View root = inflater.inflate(R.layout.fragment_payment_options, null);

        final Button atmButton = root.findViewById(R.id.atm);
        final Button bankDeposit = root.findViewById(R.id.bank_deposit);
        final Button payHotel = root.findViewById(R.id.pay_at_hotel);

        builder.setView(root);
        final AlertDialog dialog = builder.create();

        atmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String option = atmButton.getText().toString();
                mListener.onOptionSelected(option);
                dialog.dismiss();
            }
        });

        bankDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String option = bankDeposit.getText().toString();
                mListener.onOptionSelected(option);
                dialog.dismiss();
            }
        });

        payHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String option = payHotel.getText().toString();
                mListener.onOptionSelected(option);
                dialog.dismiss();
            }
        });

        return dialog;
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

        void onOptionSelected(String option);
    }
}
