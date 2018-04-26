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
import com.campuz.adapter.SubjectsAdapter;
import com.campuz.base.BaseActivity;
import com.campuz.base.BaseFragment;
import com.campuz.model.SubjectsModel;

import java.util.ArrayList;

public class ParentSubjectsSyllabusFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    ArrayList<SubjectsModel> sub_list = new ArrayList<>();
    ListView listview_subjects;
    String[] subject_names = {"Telugu", "Hindi", "English", "Maths", "Science", "Social", "GK", "Computers"};
    Integer[] subject_img = {
            R.drawable.ic_telugu,
            R.drawable.ic_hindi,
            R.drawable.ic_english,
            R.drawable.ic_maths,
            R.drawable.ic_science,
            R.drawable.ic_social,
            R.drawable.ic_gk,
            R.drawable.ic_computers
    };

    private ParentSubjectsSyllabusFragment.OnFragmentInteractionListener mListener;

    public ParentSubjectsSyllabusFragment() {
        // Required empty public constructor
    }
    public static ParentSubjectsSyllabusFragment newInstance(String param1, String param2) {
        ParentSubjectsSyllabusFragment fragment = new ParentSubjectsSyllabusFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < subject_names.length; i++) {
            SubjectsModel items = new SubjectsModel(subject_img[i], subject_names[i]);
            sub_list.add(items);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_subjects_syllabus,container,false);

        listview_subjects = (ListView) view.findViewById(R.id.listview_subjects);
        listview_subjects.setAdapter(new SubjectsAdapter(getActivity(), R.layout.fragments_subjects_list_items, sub_list));

        listview_subjects.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ParentSyllabusDetailsFragment syllabusFragment = new ParentSyllabusDetailsFragment();
                ((BaseActivity)getActivity()).replaceFragment(syllabusFragment, true);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ParentSubjectsSyllabusFragment.OnFragmentInteractionListener) {
            mListener = (ParentSubjectsSyllabusFragment.OnFragmentInteractionListener) context;
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
