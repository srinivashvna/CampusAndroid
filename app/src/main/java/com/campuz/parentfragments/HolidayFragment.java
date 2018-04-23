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
import com.campuz.adapter.EventsAdapter;
import com.campuz.adapter.HolidayAdapter;
import com.campuz.base.BaseActivity;
import com.campuz.base.BaseFragment;
import com.campuz.model.HolidayModel;

import java.util.ArrayList;

public class HolidayFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    ArrayList<HolidayModel> holidays_list = new ArrayList<>();
    ListView listview_holidays;
    String[] holidays_ = {"Festival Holiday","Summer Holidays","Festival Holiday","Summer Holidays"};


    private HolidayFragment.OnFragmentInteractionListener mListener;

    public HolidayFragment() {
        // Required empty public constructor
    }
    public static HolidayFragment newInstance(String param1, String param2) {
        HolidayFragment fragment = new HolidayFragment();
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
                /*SyllabusDetailsFragment syllabusFragment = new SyllabusDetailsFragment();
                ((BaseActivity)getActivity()).replaceFragment(syllabusFragment, true);*/
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof HolidayFragment.OnFragmentInteractionListener) {
            mListener = (HolidayFragment.OnFragmentInteractionListener) context;
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
