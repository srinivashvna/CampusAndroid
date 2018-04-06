package com.campuz.base;

import android.app.Application;
import android.content.Context;

import com.campuz.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by manikantad on 28-02-2017.
 */

public class CampuzApplication extends Application {

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

//For Custom font. By default Lato-Regular will be the default font for through out the app
        CalligraphyConfig calligraphyConfig = new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Lato-Bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();

        CalligraphyConfig.initDefault(calligraphyConfig);


    }


    public static Context getContext() {
        return instance.getApplicationContext();
    }


}