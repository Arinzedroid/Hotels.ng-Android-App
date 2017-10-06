package ng.hotels.android.app.di.modules;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import ng.hotels.android.app.ui.activities.CustomerServiceChatActivity;

/**
 * Created by idee on 10/6/17.
 */

@Module
public class CustomerServiceChatModule {

    @Provides
    public Context provideContext(CustomerServiceChatActivity customerServiceChatActivity){
        return customerServiceChatActivity;
    }

}
