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
 import com.campuz.adapter.NotificationAdapter;
 import com.campuz.base.BaseActivity;
 import com.campuz.base.BaseFragment;
 import com.campuz.model.NotificationModel;

 import java.util.ArrayList;

public class ParentNotificationsFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    ArrayList<NotificationModel> notification_list = new ArrayList<>();
    ListView listview_notifications;
    String[] noti_names = {"Notifications - One","Notifications - One","Notifications - One","Notifications - One","Notifications - One"};


    private ParentNotificationsFragment.OnFragmentInteractionListener mListener;

    public ParentNotificationsFragment() {
        // Required empty public constructor
    }
    public static ParentNotificationsFragment newInstance(String param1, String param2) {
        ParentNotificationsFragment fragment = new ParentNotificationsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < noti_names.length; i++) {
            NotificationModel items = new NotificationModel(noti_names[i]);
            notification_list.add(items);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragments_notification,container,false);

        listview_notifications = (ListView) view.findViewById(R.id.listview_notifications);
        listview_notifications.setAdapter(new NotificationAdapter(getActivity(), R.layout.fragment_notification_list_item, notification_list));

        listview_notifications.setOnItemClickListener(new AdapterView.OnItemClickListener(){
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
        if (context instanceof ParentNotificationsFragment.OnFragmentInteractionListener) {
            mListener = (ParentNotificationsFragment.OnFragmentInteractionListener) context;
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

