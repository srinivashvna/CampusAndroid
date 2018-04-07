package com.campuz.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.campuz.R;
import com.campuz.parent.HomeActivity;
import com.campuz.parent.LoginActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by manikantad on 06-04-2018.
 */

public class SplashActivity extends BaseActivity {

    // Splash screen timer
    private int SPLASH_TIME_OUT = 3000;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        //No title bar is set for the activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Full screen is set for the Window
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

        /*Showing splash screen with a timer.*/

            @Override
            public void run() {

                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();

            }
        }, SPLASH_TIME_OUT);

    }

    // pass context to Calligraphy
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

}
