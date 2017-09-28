package ng.hotels.android.app;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Nsikak on 9/27/17.
 */

public class AppController  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        //initialized default font
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Lato-Bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }
}
