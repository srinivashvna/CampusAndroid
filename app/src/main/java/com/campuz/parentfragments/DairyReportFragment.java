package com.campuz.parentfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.campuz.adapter.DiaryReportAdapter;

import com.campuz.R;
import com.campuz.base.BaseActivity;
import com.campuz.base.BaseFragment;
import com.campuz.model.DiaryModel;
import com.campuz.model.SyllabusModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DairyReportFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DairyReportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DairyReportFragment extends BaseFragment {

    ArrayList<DiaryModel> chapter_list = new ArrayList<>();
    ListView listview_diary;
    String[] subject_names = {"Telugu", "Hindi", "English", "Maths", "Science", "Social"};
    String[] home_work = {"Complete Poems", "Complete Poems", "Complete Poems", "Complete Poems", "Complete Poems", "Complete Poems"};


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DairyReportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DairyReportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DairyReportFragment newInstance(String param1, String param2) {
        DairyReportFragment fragment = new DairyReportFragment();
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
        for (int i = 0; i < subject_names.length; i++) {
            DiaryModel items = new DiaryModel(subject_names[i], home_work[i]);
            chapter_list.add(items);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dairy_report, container, false);

        listview_diary = (ListView) view.findViewById(R.id.diaryList);
        listview_diary.setAdapter(new DiaryReportAdapter(getActivity(), R.layout.fragments_diary_report_item, chapter_list));

        listview_diary.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }

        });

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void onBackPressed() {
        ((BaseActivity) getActivity()).removeFragment();
    }
}
