package com.campuz.parentfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.campuz.R;
import com.campuz.adapter.ExamsAdapter;
import com.campuz.base.BaseActivity;
import com.campuz.base.BaseFragment;
import com.campuz.model.ExamsModel;

import java.util.ArrayList;

public class ParentExamsFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    ArrayList<ExamsModel> tests_list = new ArrayList<>();
    ListView lv_test;
    String[] test = {"Unit Test - 1", "Unit Test - 2", "Quarterly", "Half Yearly", "Annual"};
    String[] test_status = {"Results", "Syllabus", "Syllabus", "Syllabus", "Syllabus"};

    private ParentExamsFragment.OnFragmentInteractionListener mListener;

    public ParentExamsFragment() {
        // Required empty public constructor
    }

    public static ParentExamsFragment newInstance(String param1, String param2) {
        ParentExamsFragment fragment = new ParentExamsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < test.length; i++) {
            ExamsModel items = new ExamsModel(test[i], test_status[i]);
            tests_list.add(items);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exams, container, false);

        lv_test = (ListView) view.findViewById(R.id.listview_exams);
        lv_test.setAdapter(new ExamsAdapter(getActivity(), R.layout.fragment_exam_list_item, tests_list));

        lv_test.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ParentExamDetailedFragment examDetailFragment = new ParentExamDetailedFragment();
                ((BaseActivity) getActivity()).replaceFragment(examDetailFragment, true);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ParentExamsFragment.OnFragmentInteractionListener) {
            mListener = (ParentExamsFragment.OnFragmentInteractionListener) context;
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
