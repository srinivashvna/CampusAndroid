package com.campuz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.campuz.R;
import com.campuz.model.EventsModel;
import com.campuz.model.ExamsModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class EventsAdapter extends ArrayAdapter<EventsModel> {
    List<EventsModel> list;
    public EventsAdapter(Context context, int resouceId, List<EventsModel> list) {
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
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.fragment_event_list_item, parent, false);
        EventsModel subs = list.get(position);


        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        SimpleDateFormat month_date = new SimpleDateFormat("MMM");
        String month_name = month_date.format(calendar.getTime());
        String date = day+" " +month_name+", " + year;

        TextView label = (TextView) row.findViewById(R.id.tv_event_desc);
        TextView tv_date = (TextView) row.findViewById(R.id.tv_date);
        label.setText(subs.getEvent_Name());
        tv_date.setText(date);
        return row;
    }

}