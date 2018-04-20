package com.campuz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.campuz.R;
import com.campuz.model.ExamsModel;

import java.util.List;

/**
 * Created by manikantad on 18-04-2018.
 */

public class ExamsAdapter extends ArrayAdapter<ExamsModel> {
    List<ExamsModel> list;

    public ExamsAdapter(Context context, int resouceId, List<ExamsModel> list) {
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


        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.fragment_exam_list_item, parent, false);
        ExamsModel subs = list.get(position);
        TextView label = (TextView) row.findViewById(R.id.tv_test_titles);
        TextView label1 = (TextView) row.findViewById(R.id.tv_tests_status);
        label.setText(subs.getTests());
        label1.setText(subs.getTest_status());

           /* if (position % 2 == 1) {
                row.setBackgroundColor(getResources().getColor(R.color.appblue));

            } else {
                row.setBackgroundColor(getResources().getColor(R.color.homebuttoncolors));

            }
*/
        return row;
    }

}