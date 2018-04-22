package com.campuz.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.campuz.R;

/**
 * Created by hithap on 03-03-2017.
 */

public class BaseFragment extends Fragment {

    public ProgressDialog myDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((BaseActivity) getActivity()).hideKeyboard();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    public ProgressDialog showProgressDialog(Context context, String text) {
        myDialog = new ProgressDialog(context);
        myDialog.setMessage(text);
        myDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        myDialog.setCancelable(false);
        myDialog.show();
        return myDialog;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {

    }


    public void onBackclick() {

    }

    private SpannableString getSpannableETAString(String totalString, String orderNotes) {
        SpannableString spannableTimeString = new SpannableString(totalString);
        if(totalString.contains(orderNotes)) {
            int iStart = totalString.indexOf(orderNotes);
            int iEnd = iStart + orderNotes.length();/*10 characters = in-network. */
            spannableTimeString.setSpan(new ForegroundColorSpan(ResourcesCompat.getColor(getResources(), R.color.black, null)), iStart, iEnd, 0);
            return spannableTimeString;
        }else {
            return spannableTimeString;
        }

    }

}
