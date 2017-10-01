package ng.hotels.android.app;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import ng.hotels.android.app.di.ActivityBindingModule;

/**
 * Created by idee on 9/28/17.
 */

@Component(modules = {AndroidSupportInjectionModule.class, ActivityBindingModule.class})
public interface AppComponent extends AndroidInjector<AppController> {

    @Override
    void inject(AppController instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);
        AppComponent build();
    }

}