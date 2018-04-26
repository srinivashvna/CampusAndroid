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
import com.campuz.adapter.HolidayAdapter;
import com.campuz.base.BaseActivity;
import com.campuz.base.BaseFragment;
import com.campuz.model.HolidayModel;

import java.util.ArrayList;

public class ParentHolidayFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    ArrayList<HolidayModel> holidays_list = new ArrayList<>();
    ListView listview_holidays;
    String[] holidays_ = {"Festival Holiday","Summer Holidays","Festival Holiday","Summer Holidays"};


    private ParentHolidayFragment.OnFragmentInteractionListener mListener;

    public ParentHolidayFragment() {
        // Required empty public constructor
    }
    public static ParentHolidayFragment newInstance(String param1, String param2) {
        ParentHolidayFragment fragment = new ParentHolidayFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < holidays_.length; i++) {
            HolidayModel items = new HolidayModel(holidays_[i]);
            holidays_list.add(items);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_holidays,container,false);

        listview_holidays = (ListView) view.findViewById(R.id.listview_holidays);
        listview_holidays.setAdapter(new HolidayAdapter(getActivity(), R.layout.fragment_holidays_list_item, holidays_list));

        listview_holidays.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*ParentSyllabusDetailsFragment syllabusFragment = new ParentSyllabusDetailsFragment();
                ((BaseActivity)getActivity()).replaceFragment(syllabusFragment, true);*/
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ParentHolidayFragment.OnFragmentInteractionListener) {
            mListener = (ParentHolidayFragment.OnFragmentInteractionListener) context;
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
