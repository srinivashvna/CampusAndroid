package com.campuz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.campuz.R;
import com.campuz.model.SubjectsModel;

import java.util.List;

/**
 * Created by manikantad on 18-04-2018.
 */

public class SubjectsAdapter extends ArrayAdapter<SubjectsModel> {
    List<SubjectsModel> list;
    Context mContext;
    public SubjectsAdapter(Context context, int resouceId, List<SubjectsModel> list) {
        super(context, resouceId, list);
        this.list = list;
        this.mContext = context;
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

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.fragments_subjects_list_items, parent, false);
        SubjectsModel subs = list.get(position);
        TextView label = (TextView) row.findViewById(R.id.tv_subjects);
        ImageView ims_subject = (ImageView) row.findViewById(R.id.img_subject);
        ims_subject.setImageResource(subs.getSubject_id());
        label.setText(subs.getSubject());

        if (position % 2 == 1) {
            row.setBackgroundColor(mContext.getResources().getColor(R.color.appblue));

        } else {
            row.setBackgroundColor(mContext.getResources().getColor(R.color.homebuttoncolors));

        }

        return row;
    }

}
