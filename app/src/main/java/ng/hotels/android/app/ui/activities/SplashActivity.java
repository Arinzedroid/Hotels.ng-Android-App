package ng.hotels.android.app.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ng.hotels.android.app.utils.PreferenceUtils;

/**
 * Created by tody on 9/28/17.
 */

public class SplashActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (PreferenceUtils.isThisUserFirstTime(this))
            intent = new Intent(this, OnBoardingActivity.class);
        else
            intent = new Intent(this, HomeActivity.class);

        startActivity(intent);
        finish();

    }

}
