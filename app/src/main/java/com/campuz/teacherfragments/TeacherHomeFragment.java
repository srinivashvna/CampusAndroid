package com.campuz.teacherfragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.campuz.R;
import com.campuz.base.BaseActivity;

public class TeacherHomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;

    private TeacherHomeFragment.OnFragmentInteractionListener mListener;

    public TeacherHomeFragment() {
        // Required empty public constructor
    }

    public static TeacherHomeFragment newInstance(String param1, String param2) {
        TeacherHomeFragment fragment = new TeacherHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    public void init(View view){
        TextView txtName = (TextView) view.findViewById(R.id.textName);
        txtName.setText(R.string.alekhya);
        ImageView imgProfile = (ImageView) view.findViewById(R.id.imgProfile);
        TextDrawable drawable = TextDrawable.builder().beginConfig()
                .withBorder(10)
                .bold()
                .useFont(Typeface.DEFAULT)
                .endConfig()
                .buildRound("AK", getResources().getColor(R.color.appblue));


        imgProfile.setImageDrawable(drawable);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.teacher_home_fragment, container, false);
        init(view);
        // Inflate the layout for this fragment
        return view;
    }
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TeacherHomeFragment.OnFragmentInteractionListener) {
            mListener = (TeacherHomeFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void onBackPressed() {
        ((BaseActivity) getActivity()).removeFragment();
    }
}
