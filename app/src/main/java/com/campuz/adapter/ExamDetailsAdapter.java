package com.campuz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.campuz.R;
import com.campuz.model.ExamDetailsModel;

import java.util.List;

public class ExamDetailsAdapter  extends ArrayAdapter<ExamDetailsModel> {
        List<ExamDetailsModel> list;
        Context mContext;

    public ExamDetailsAdapter(Context context, int resouceId, List<ExamDetailsModel> list) {
            super(context, resouceId, list);
            this.list = list;
            this.mContext =context;
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

            ExamDetailsModel subs = list.get(position);

            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.fragment_exam_details_list_item, parent, false);
            RelativeLayout rl_mainLayout = (RelativeLayout) row.findViewById(R.id.rl_mainLayout);
            RelativeLayout bg_date = (RelativeLayout) row.findViewById(R.id.bg_date);
            ImageView iv_triangle = (ImageView) row.findViewById(R.id.iv_triangle);
            TextView label = (TextView) row.findViewById(R.id.tv_chapter);
            TextView label1 = (TextView) row.findViewById(R.id.tv_chapter_title);
            label.setText(subs.getSubject_name());
            label1.setText(subs.getChapter_title());

            if (position % 2 == 1) {
                rl_mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.appblue));
                iv_triangle.setBackgroundColor(mContext.getResources().getColor(R.color.appblue));
                bg_date.setBackgroundColor(mContext.getResources().getColor(R.color.appblue));

            } else {
                row.setBackgroundColor(mContext.getResources().getColor(R.color.track));
                iv_triangle.setBackgroundColor(mContext.getResources().getColor(R.color.homebuttoncolors));
                bg_date .setBackgroundColor(mContext.getResources().getColor(R.color.homebuttoncolors));

            }

            return row;
        }

    }
