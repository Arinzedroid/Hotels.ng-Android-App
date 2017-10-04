package ng.hotels.android.app;

import android.app.Activity;
import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.facebook.FacebookSdk;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Nsikak on 9/27/17.
 */

public class AppController extends MultiDexApplication implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.setApplicationId("hejfbdgfbpudfbhgdbpfuygdBIUFgbp");
        FacebookSdk.sdkInitialize(this);

        //initialized default font
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Lato-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        DaggerAppComponent.builder().application(this)
                .build().inject(this);

    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

}
