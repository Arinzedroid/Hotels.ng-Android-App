package ng.hotels.android.app.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import ng.hotels.android.app.R;
import ng.hotels.android.app.ui.fragments.LoginFragment;
import ng.hotels.android.app.ui.fragments.SignUpFragment;


public class UserAuthenticationActivity extends AppCompatActivity implements
        LoginFragment.OnFragmentInteractionListener,
        SignUpFragment.OnFragmentInteractionListener{

    private LoginFragment loginFragment;
    private SignUpFragment signUpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_authentication);
        showSignInFragment();
    }

    private void showSignInFragment(){
        if (loginFragment == null)
            loginFragment = LoginFragment.newInstance();
        loadFragment(loginFragment);
    }

    private void showSignUpFragment() {
        if (signUpFragment == null)
            signUpFragment = SignUpFragment.newInstance();
        loadFragment(signUpFragment);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_user_authentication, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

    private void showHomePage() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (signUpFragment.isAdded()) {
            loginFragment = null;
            showSignInFragment();
        } else {
            showHomePage();
        }
    }

    @Override
    public void onLoginClicked(String email, String password) {
        //TODO: Make API call to authenticate the user on the server
        Toast.makeText(this, "API call for login yet to be implemented", Toast.LENGTH_LONG).show();
        showHomePage();
    }


    @Override
    public void onSignUpClicked() {
        signUpFragment = null;
        showSignUpFragment();
    }

    @Override
    public void onSignInClicked() {
        loginFragment = null;
        showSignInFragment();
    }

    @Override
    public void onSignUpClicked(String email, String password, String confirm_password) {
        //TODO: Make API call to pass the user details to the server
        Toast.makeText(this, "API call for sign up yet to be implemented", Toast.LENGTH_LONG).show();
        showHomePage();
    }
}

