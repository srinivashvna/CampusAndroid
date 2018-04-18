package com.campuz.parentfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.campuz.R;
import com.campuz.adapter.ExamsAdapter;
import com.campuz.base.BaseActivity;
import com.campuz.base.BaseFragment;
import com.campuz.model.ExamsModel;

import java.util.ArrayList;

public class ExamsFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    ArrayList<ExamsModel> test_list = new ArrayList<>();
    ListView listview_tests;
    String[] test = {"Unit Test - 1", "Unit Test - 2", "Quarterly", "Half Yearly", "Annual"};
    String[] test_status = {"Results", "Syllabus", "Syllabus", "Syllabus", "Syllabus"};

    private ExamsFragment.OnFragmentInteractionListener mListener;

    public ExamsFragment() {
        // Required empty public constructor
    }

    public static ExamsFragment newInstance(String param1, String param2) {
        ExamsFragment fragment = new ExamsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < test.length; i++) {
            ExamsModel items = new ExamsModel(test[i], test_status[i]);
            test_list.add(items);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exams, container, false);

        listview_tests = (ListView) view.findViewById(R.id.listview_exams);
        listview_tests.setAdapter(new ExamsAdapter(getActivity(), R.layout.fragment_exam_list_item, test_list));

        listview_tests.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /* SyllabusDetailsFragment syllabusFragment = new SyllabusDetailsFragment();
                ((BaseActivity) getActivity()).replaceFragment(syllabusFragment, true);*/
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ExamsFragment.OnFragmentInteractionListener) {
            mListener = (ExamsFragment.OnFragmentInteractionListener) context;
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
