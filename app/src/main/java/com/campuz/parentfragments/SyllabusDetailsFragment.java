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
import com.campuz.adapter.SyllabusAdapter;
import com.campuz.base.BaseActivity;
import com.campuz.base.BaseFragment;
import com.campuz.model.SyllabusModel;

import java.util.ArrayList;

public class SyllabusDetailsFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    ArrayList<SyllabusModel> chapter_list = new ArrayList<>();
    ListView listview_syllabus;
    String[] chapter_names = {"Chapter - 1", "Chapter - 2", "Chapter - 3", "Chapter - 4", "Chapter - 5", "Chapter - 6"};
    String[] chapter_titles = {"This is Chapter One", "This is Chapter Two", "This is Chapter Three", "This is Chapter Four", "This is Chapter Five", "This is Chapter Six"};

    private SyllabusDetailsFragment.OnFragmentInteractionListener mListener;

    public SyllabusDetailsFragment() {
        // Required empty public constructor
    }

    public static SyllabusDetailsFragment newInstance(String param1, String param2) {
        SyllabusDetailsFragment fragment = new SyllabusDetailsFragment();
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

        View view = inflater.inflate(R.layout.fragment_detailed_syllabus, container, false);

        for (int i = 0; i < chapter_names.length; i++) {
            SyllabusModel items = new SyllabusModel(chapter_names[i], chapter_titles[i]);
            chapter_list.add(items);
        }

        listview_syllabus = (ListView) view.findViewById(R.id.listview_syllabus);
        listview_syllabus.setAdapter(new SyllabusAdapter(getActivity(), R.layout.fragments_syllabus_list_items, chapter_list));

        listview_syllabus.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SyllabusModel syllabus = (SyllabusModel) parent.getItemAtPosition(position);
                String selectedItem = syllabus.getChapter();
                Toast.makeText(getActivity(),"Selected Subject :"+selectedItem,Toast.LENGTH_SHORT).show();

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
            mListener = (SyllabusDetailsFragment.OnFragmentInteractionListener) context;
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
