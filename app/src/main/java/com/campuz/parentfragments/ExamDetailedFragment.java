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
import com.campuz.adapter.ExamDetailsAdapter;
import com.campuz.adapter.SyllabusAdapter;
import com.campuz.base.BaseActivity;
import com.campuz.base.BaseFragment;
import com.campuz.model.ExamDetailsModel;
import com.campuz.model.SyllabusModel;

import java.util.ArrayList;

public class ExamDetailedFragment extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";

    ArrayList<ExamDetailsModel> exam_list = new ArrayList<>();
    ListView listview_exam_details;
    String[] subject_names = {"Telugu", "Hindi", "English", "Maths", "Science", "Social", "GK", "Computers"};
    String[] chapter_titles = {"This is Chapter One", "This is Chapter Two", "This is Chapter Three", "This is Chapter Four", "This is Chapter Five", "This is Chapter Six"};

    private ExamDetailedFragment.OnFragmentInteractionListener mListener;

    public ExamDetailedFragment() {
        // Required empty public constructor
    }
    public static ExamDetailedFragment newInstance(String param1, String param2) {
        ExamDetailedFragment fragment = new ExamDetailedFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < subject_names.length; i++) {
            ExamDetailsModel items = new ExamDetailsModel(subject_names[i], chapter_titles[i]);
            exam_list.add(items);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exam_details, container, false);

        listview_exam_details = (ListView) view.findViewById(R.id.listview_exam_details);
        listview_exam_details.setAdapter(new ExamDetailsAdapter(getActivity(), R.layout.fragment_exam_details_list_item, exam_list));

        listview_exam_details.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

             /*   SyllabusModel syllabus = (SyllabusModel) parent.getItemAtPosition(position);
                String selectedItem = syllabus.getChapter();
                Toast.makeText(getActivity(),"Selected Subject :"+selectedItem,Toast.LENGTH_SHORT).show();
*/


                //commented
               /* SyllabusDetailsFragment syllabusFragment = new SyllabusDetailsFragment();
                ((BaseActivity)getActivity()).replaceFragment(syllabusFragment, true);*/
            }

        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SyllabusDetailsFragment.OnFragmentInteractionListener) {
            mListener = (ExamDetailedFragment.OnFragmentInteractionListener) context;
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
