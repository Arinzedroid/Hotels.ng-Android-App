package ng.hotels.android.app.ui.activities;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import ng.hotels.android.app.R;

public class SettingsActivity extends PreferenceActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.activity_settings);
    }
}
