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
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ng.hotels.android.app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.email_address)
    EditText emailView;
    @BindView(R.id.password)
    EditText passwordView;
    @BindView(R.id.sign_in_button)
    Button signIn;
    @BindView(R.id.text_sign_up)
    TextView signUpView;

    private OnFragmentInteractionListener mListener;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public LoginFragment() {

    }

    //TODO: Implement the logic for social media logins

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        setupViews();

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
                showSignInButton();
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
                if (!s.toString().matches("^(?=.*\\d).{6,32}$")) {
                    passwordView.setError("Must have at least 1digit, and must be up to 6 characters");
                } else if (TextUtils.isEmpty(s)) {
                    passwordView.setError("This field cannot be empty");
                } else {
                    passwordView.setError(null);
                }
                showSignInButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        signIn.setOnClickListener(this);
        signUpView.setOnClickListener(this);
        showSignInButton();
        return view;
    }

    private void setupViews() {
        emailView.setText("");
        passwordView.setText("");
    }

    private void showSignInButton() {
        if (Patterns.EMAIL_ADDRESS.matcher(emailView.getText().toString()).matches() &&
                passwordView.getText().toString().matches("^(?=.*\\d).{6,32}$")) {
            signIn.setVisibility(View.VISIBLE);
        } else {
            signIn.setVisibility(View.GONE);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");
        }*/
    }


    @OnClick(R.id.text_forgot_password)
    public void clickForgotPassword() {
        Toast.makeText(getActivity(), "Yet to be implemented", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.text_sign_up)
    public void openSignUpFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_user_authentication, new SignUpFragment())
                .commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in_button:
                String email = emailView.getText().toString();
                String password = passwordView.getText().toString();
                mListener.onLoginClicked(email, password);
                break;
            case R.id.text_sign_up:
                mListener.onSignUpClicked();
                break;
        }
    }

    public interface OnFragmentInteractionListener{
        void onLoginClicked(String email, String password);
        void onSignUpClicked();
    }
}

