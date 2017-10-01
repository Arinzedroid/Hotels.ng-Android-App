package ng.hotels.android.app.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ng.hotels.android.app.di.modules.OnBoardingActivityModule;
import ng.hotels.android.app.ui.activities.MainActivity;
import ng.hotels.android.app.ui.activities.OnBoardingActivity;

/**
 * Created by idee on 9/28/17.
 */

@Module
public abstract class ActivityBindingModule {

    //@ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = OnBoardingActivityModule.class)
    abstract OnBoardingActivity onboardingActivity();

}
