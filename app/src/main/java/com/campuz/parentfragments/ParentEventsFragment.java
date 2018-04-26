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
import com.campuz.base.BaseActivity;
import com.campuz.base.BaseFragment;
import com.campuz.model.EventsModel;

import java.util.ArrayList;

public class ParentEventsFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    ArrayList<EventsModel> event_list = new ArrayList<>();
    ListView listview_events;
    String[] events_names = {"Event - One","Event - One","Event - One","Event - One","Event - One"};


    private ParentEventsFragment.OnFragmentInteractionListener mListener;

    public ParentEventsFragment() {
        // Required empty public constructor
    }
    public static ParentEventsFragment newInstance(String param1, String param2) {
        ParentEventsFragment fragment = new ParentEventsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < events_names.length; i++) {
            EventsModel items = new EventsModel(events_names[i]);
            event_list.add(items);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_events,container,false);

        listview_events = (ListView) view.findViewById(R.id.listview_events);
        listview_events.setAdapter(new EventsAdapter(getActivity(), R.layout.fragment_event_list_item, event_list));

        listview_events.setOnItemClickListener(new AdapterView.OnItemClickListener(){
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
        if (context instanceof ParentEventsFragment.OnFragmentInteractionListener) {
            mListener = (ParentEventsFragment.OnFragmentInteractionListener) context;
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
