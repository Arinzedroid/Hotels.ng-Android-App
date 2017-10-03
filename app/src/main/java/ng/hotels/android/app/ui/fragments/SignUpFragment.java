package ng.hotels.android.app.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.hotels.android.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.email_address)
    EditText emailView;

    @BindView(R.id.password)
    EditText passwordView;

    @BindView(R.id.confirm_password)
    EditText confirmPasswordView;

    @BindView(R.id.sign_up_button)
    Button signUpButton;

    @BindView(R.id.text_login)
    TextView loginView;

    private OnFragmentInteractionListener mListener;

    public static SignUpFragment newInstance(){
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        ButterKnife.bind(this, view);
        setUpViews();

        emailView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                    emailView.setError("Invalid Email address");
                } else if (TextUtils.isEmpty(s)) {
                    emailView.setError("This field is required");
                } else {
                    emailView.setError(null);
                }
                showSignUpButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        passwordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().matches("^(?=.*\\d).{6}$")) {
                    passwordView.setError("Must have at least 1digit, and must be up to 6 characters");
                } else if (TextUtils.isEmpty(s)) {
                    passwordView.setError("This field cannot be empty");
                } else {
                    passwordView.setError(null);
                }
                showSignUpButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        confirmPasswordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().equals(passwordView.getText().toString())){
                    confirmPasswordView.setError("Passwords do not match");
                } else if (TextUtils.isEmpty(s)){
                    confirmPasswordView.setError("This field cannot be empty");
                } else {
                    confirmPasswordView.setError(null);
                }
                showSignUpButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        signUpButton.setOnClickListener(this);
        loginView.setOnClickListener(this);
        showSignUpButton();
        return view;
    }

    private void setUpViews() {
        emailView.setText("");
        passwordView.setText("");
        confirmPasswordView.setText("");
    }

    private void showSignUpButton(){
        if (Patterns.EMAIL_ADDRESS.matcher(emailView.getText().toString()).matches() &&
                passwordView.getText().toString().matches("^(?=.*\\d).{6}$") &&
                confirmPasswordView.getText().toString().equals(passwordView.getText().toString())) {

            signUpButton.setVisibility(View.VISIBLE);
        } else {
            signUpButton.setVisibility(View.GONE);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_up_button:
                String email = emailView.getText().toString();
                String password = passwordView.getText().toString();
                String confirm_password = confirmPasswordView.getText().toString();
                mListener.onSignUpClicked(email, password, confirm_password);
                break;
            case R.id.text_login:
                mListener.onSignInClicked();
                break;
        }
    }

    public interface OnFragmentInteractionListener{
        void onSignInClicked();
        void onSignUpClicked(String email, String password, String confirm_password);
        void onBackPressed();
    }

}