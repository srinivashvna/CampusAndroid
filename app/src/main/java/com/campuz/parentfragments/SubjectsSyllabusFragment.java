package com.campuz.parentfragments;

import android.graphics.Color;
import android.net.LinkAddress;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.campuz.R;
import com.campuz.modal.Subjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubjectsSyllabusFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    ArrayList<Subjects> sub_list = new ArrayList<>();
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

    private SubjectsSyllabusFragment.OnFragmentInteractionListener mListener;

    public SubjectsSyllabusFragment() {
        // Required empty public constructor
    }
    public static SubjectsSyllabusFragment newInstance(ListView listview_subjects) {
        SubjectsSyllabusFragment fragment = new SubjectsSyllabusFragment();
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

        View view = inflater.inflate(R.layout.fragment_subjects_syllabus,container,false);
        for (int i = 0; i < subject_names.length; i++) {
            Subjects items = new Subjects(subject_img[i], subject_names[i]);
            sub_list.add(items);
        }

        listview_subjects = (ListView) view.findViewById(R.id.listview_subjects);
        listview_subjects.setAdapter(new SubjectsAdapter(getActivity(), R.layout.fragments_subjects_list_items, sub_list));

        listview_subjects.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Subjects subjects = (Subjects) parent.getItemAtPosition(position);
                String selectedItem = subjects.getSubject();
                Toast.makeText(getActivity(),"Selected Subject :"+selectedItem,Toast.LENGTH_SHORT).show();


            }

        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SubjectsSyllabusFragment.OnFragmentInteractionListener) {
            mListener = (SubjectsSyllabusFragment.OnFragmentInteractionListener) context;
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


    public class SubjectsAdapter extends ArrayAdapter<Subjects> {
        List<Subjects> list;
        public SubjectsAdapter(Context context, int resouceId, List<Subjects> list) {
            super(context, resouceId, list);
            this.list = list;
            // TODO Auto-generated constructor stub
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            //return super.getView(position, convertView, parent);

            Subjects subs = list.get(position);

            LayoutInflater inflater = getActivity().getLayoutInflater();
            View row = inflater.inflate(R.layout.fragments_subjects_list_items, parent, false);
            TextView label = (TextView) row.findViewById(R.id.tv_subjects);
            ImageView ims_subject = (ImageView) row.findViewById(R.id.img_subject);
            ims_subject.setImageResource(subs.getSubject_id());
            label.setText(subs.getSubject());

            if (position % 2 == 1) {
                row.setBackgroundColor(getResources().getColor(R.color.appblue));

            } else {
                row.setBackgroundColor(getResources().getColor(R.color.homebuttoncolors));

            }

            return row;
        }

    }
}
