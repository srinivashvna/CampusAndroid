package com.campuz.teacherfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.campuz.R;
import com.campuz.base.BaseActivity;
import com.campuz.base.BaseFragment;

public class TeacherAttendanceFragment extends BaseFragment {

    RelativeLayout rl_history, rl_take_attendance, rl_edit_attendance;

    private TeacherAttendanceFragment.OnFragmentInteractionListener mListener;

    public TeacherAttendanceFragment() {
        // Required empty public constructor
    }

    public static TeacherAttendanceFragment newInstance(String param1, String param2) {
        TeacherAttendanceFragment fragment = new TeacherAttendanceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.teacher_attendance, container, false);

        rl_history = (RelativeLayout) view.findViewById(R.id.rl_history);
        rl_take_attendance = (RelativeLayout) view.findViewById(R.id.rl_take_attendance);
        rl_edit_attendance = (RelativeLayout) view.findViewById(R.id.rl_edit_attendance);

        rl_edit_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeacherTakeAttendanceFragment teacherTakeAttendanceFragment = new TeacherTakeAttendanceFragment();
                ((BaseActivity)getActivity()).replaceFragment(teacherTakeAttendanceFragment, true);
            }
        });

        rl_take_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeacherTakeAttendanceFragment teacherTakeAttendanceFragment = new TeacherTakeAttendanceFragment();
                ((BaseActivity)getActivity()).replaceFragment(teacherTakeAttendanceFragment, true);
            }
        });

        rl_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeacherAttendanceHistoryFragment teacherAttendanceHistoryFragment = new TeacherAttendanceHistoryFragment();
                ((BaseActivity)getActivity()).replaceFragment(teacherAttendanceHistoryFragment, true);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TeacherAttendanceFragment.OnFragmentInteractionListener) {
            mListener = (TeacherAttendanceFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);

    }

    public void onBackPressed() {
        ((BaseActivity) getActivity()).removeFragment();
    }
}
