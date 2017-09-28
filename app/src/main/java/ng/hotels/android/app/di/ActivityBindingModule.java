package ng.hotels.android.app.di;

import dagger.Module;
import ng.hotels.android.app.MainActivity;

/**
 * Created by idee on 9/28/17.
 */

@Module
public abstract class ActivityBindingModule {

    //@ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();

}
