package com.campuz.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.campuz.R;
import com.campuz.parentfragments.ParentHomeFragment;
import com.campuz.util.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BaseActivity extends AppCompatActivity {

    public ProgressDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public ProgressDialog showProgressDialog(Context context, String text) {
        myDialog = new ProgressDialog(context);
        myDialog.setMessage(text);
        myDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        myDialog.setCancelable(false);
        myDialog.show();
        return myDialog;
    }

    // pass context to Calligraphy
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }


    public void hideKeyboard() {
        try {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(
                    INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);

        } catch (Exception e) {
            System.out.println("Exception in savenotes" + e.toString());
        }
    }

    public String getCurrentTimeStamp() {
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_LOCATION);
            String currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    /**
     * This method to replace a fragment in through out the app
     */
    public void replaceFragment(Fragment frag, boolean addToBackStack) {
        try {

            String backStateName = frag.getClass().getName();
            FragmentManager manager = getSupportFragmentManager();
            boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

            if (!fragmentPopped && manager.findFragmentByTag(frag.getClass().getSimpleName()) == null) { //fragment not in back stack, create it.
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container_layout, frag, frag.getClass().getSimpleName());
                if (addToBackStack)
                    transaction.addToBackStack(frag.getClass().getSimpleName());
                transaction.commitAllowingStateLoss();
            } else {
                getSupportFragmentManager().popBackStack();
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onBackPressed() {
        removeFragment();
    }

    /**
     * This method removes the Fragment from backstack
     */

    public void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }

    }

    public void removeAllFragments() {
        try {
            FragmentManager fm = getSupportFragmentManager();
            for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container_layout);
                if(!(currentFragment instanceof ParentHomeFragment)){
                    fm.popBackStack();
                }
            }
        } catch (Exception e) {
            Log.e("replace error", e.getMessage() + "replace fragment error");
        }

    }

}
