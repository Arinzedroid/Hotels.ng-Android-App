package ng.hotels.android.app.ui.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ng.hotels.android.app.R;
import ng.hotels.android.app.ui.activities.MainActivity;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    @BindView(R.id.email_address)
    EditText emailView;
    @BindView(R.id.password)
    EditText passwordView;
    @BindView(R.id.sign_in_button)
    Button signIn;
    @BindView(R.id.text_sign_up)
    TextView signUpView;
    @BindView(R.id.google_sign_in_button)
    SignInButton mSignInButton;

    private GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 1000;
    private static final String TAG = "LoginFragment";



    LoginButton loginButton;
    CallbackManager callbackManager;
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
        callbackManager = CallbackManager.Factory.create();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(getActivity());

        mSignInButton.setOnClickListener(this);

        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));

        //SignInButton signInButton = (SignInButton) findViewById(R.id.google_sign_in_button);
        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleApiClient with access to the Google Sign-In API and the
// options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .enableAutoManage((getActivity()) /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();




        loginButton = (LoginButton) view.findViewById(R.id.button_facebook_login);
        loginButton.setReadPermissions("email");
        // If using in a fragment
        loginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                startActivity(new Intent( getActivity(), MainActivity.class));

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

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
                if (!s.toString().matches("^(?=.*\\d).{6}$")) {
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
                passwordView.getText().toString().matches("^(?=.*\\d).{6}$")) {
            signIn.setVisibility(View.VISIBLE);
        } else {
            signIn.setVisibility(View.GONE);
        }
    }


    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            startActivity(new Intent( getActivity(), MainActivity.class));
            //mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
            //updateUI(true);
        } else {
            // Signed out, show unauthenticated UI.
            //updateUI(false);
        }
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
            case R.id.google_sign_in_button:
                signIn();
                break;
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

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public interface OnFragmentInteractionListener{
        void onLoginClicked(String email, String password);
        void onSignUpClicked();
    }


}
