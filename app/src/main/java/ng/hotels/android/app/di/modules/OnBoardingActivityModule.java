package ng.hotels.android.app.di.modules;

import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import ng.hotels.android.app.ui.activities.OnBoardingActivity;

/**
 * Created by idee on 9/29/17.
 */

@Module
public class OnBoardingActivityModule {

    @Provides
    public FragmentManager providesFragmentManager(OnBoardingActivity onBoardingActivity){
        return onBoardingActivity.getSupportFragmentManager();
    }

}
