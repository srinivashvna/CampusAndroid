package com.campuz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.campuz.R;
import com.campuz.model.ProgressReportModel;

import java.util.List;

/**
 * Created by manikantad on 22-04-2018.
 */

public class ProgressReportAdapter   extends ArrayAdapter<ProgressReportModel> {
    List<ProgressReportModel> list;
    public ProgressReportAdapter(Context context, int resouceId, List<ProgressReportModel> list) {
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

        ProgressReportModel subs = list.get(position);

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.progress_report_item, parent, false);
        TextView label = (TextView) row.findViewById(R.id.subject);
        TextView label1 = (TextView) row.findViewById(R.id.marks);
        label.setText(subs.getSubjects());
        label1.setText(subs.getMarks());

           /* if (position % 2 == 1) {
                row.setBackgroundColor(getResources().getColor(R.color.appblue));

            } else {
                row.setBackgroundColor(getResources().getColor(R.color.homebuttoncolors));

            }
*/
        return row;
    }

}