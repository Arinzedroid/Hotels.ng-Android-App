package ng.hotels.android.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by idee on 9/29/17.
 */

public class PreferenceUtils {

    private static SharedPreferences prefUserFirstTime;
    private static SharedPreferences.Editor editorUserFirstTime;
    private static final String USER_FIRST_TIME = "user_first_time";
    private static final String PREF_USER_FIRST_TIME = "pref_user_first_time";
    private static final String LOG_USER_IN = "login_user";

    public static boolean isThisUserFirstTime(Context context){
        prefUserFirstTime = context.getSharedPreferences(PREF_USER_FIRST_TIME, Context.MODE_PRIVATE);
        return prefUserFirstTime.getBoolean(USER_FIRST_TIME, true);
    }

    public static void storeUserFirstTime(Context context){
        prefUserFirstTime = context.getSharedPreferences(PREF_USER_FIRST_TIME, Context.MODE_PRIVATE);
        editorUserFirstTime = prefUserFirstTime.edit();
        editorUserFirstTime.putBoolean(USER_FIRST_TIME, false);
        editorUserFirstTime.apply();
    }

    public static boolean isUserLoggedIn(Context context) {
        prefUserFirstTime = context.getSharedPreferences(PREF_USER_FIRST_TIME, Context.MODE_PRIVATE);
        return prefUserFirstTime.getBoolean(LOG_USER_IN, false);
    }

    public static void logInUser(Context context) {
        prefUserFirstTime = context.getSharedPreferences(PREF_USER_FIRST_TIME, Context.MODE_PRIVATE);
        editorUserFirstTime = prefUserFirstTime.edit();
        editorUserFirstTime.putBoolean(LOG_USER_IN, true);
        editorUserFirstTime.apply();
    }

    public static void louUserOut(Context context) {
        prefUserFirstTime = context.getSharedPreferences(PREF_USER_FIRST_TIME, Context.MODE_PRIVATE);
        editorUserFirstTime = prefUserFirstTime.edit();
        editorUserFirstTime.putBoolean(LOG_USER_IN, false);
        editorUserFirstTime.apply();
    }
}