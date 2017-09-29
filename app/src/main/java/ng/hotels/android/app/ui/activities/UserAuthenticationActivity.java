package ng.hotels.android.app.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ng.hotels.android.app.R;
import ng.hotels.android.app.ui.fragments.LoginFragment;

public class UserAuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_authentication);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_user_authentication,new LoginFragment())
                .commit();
    }
}
