package com.campuz.adapter;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.campuz.R;

import java.util.ArrayList;

/**
 * Created by manikantad on 26-04-2018.
 */

public class TeacherTakeAttendanceAdapter  extends BaseAdapter {
    private Context context;
    private ArrayList<String> arrayList;
    private LayoutInflater inflater;
    private SparseBooleanArray mSelectedItemsIds;
    private ViewHolder viewHolder;

    public TeacherTakeAttendanceAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = LayoutInflater.from(context);
        mSelectedItemsIds = new SparseBooleanArray();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            viewHolder = new ViewHolder();

            //inflate the layout on basis of boolean
            view = inflater.inflate(R.layout.grid_custom_row_layout, viewGroup, false);
            viewHolder.checkBox = (CheckedTextView) view.findViewById(R.id.checkbox);

            view.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) view.getTag();


        viewHolder.checkBox.setText(arrayList.get(i));
        viewHolder.checkBox.setChecked(mSelectedItemsIds.get(i));
        if(mSelectedItemsIds.get(i)) {
            viewHolder.checkBox.setBackgroundColor(context.getResources().getColor(R.color.appcolor));
        }
        else {
            viewHolder.checkBox.setBackgroundColor(context.getResources().getColor(R.color.absent));
        }
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCheckBox(i, !mSelectedItemsIds.get(i));
            }
        });

        return view;
    }

    private class ViewHolder {
        //private TextView label;
        private CheckedTextView checkBox;
    }


    /**
     * Remove all checkbox Selection
     **/
    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    /**
     * Check the Checkbox if not checked
     **/
    public void checkCheckBox(int position, boolean value) {
        if (value) {
            mSelectedItemsIds.put(position, true);
        }
        else {
            mSelectedItemsIds.delete(position);
        }
        notifyDataSetChanged();
    }

    /**
     * Return the selected Checkbox IDs
     **/
    public SparseBooleanArray getSelectedIds() {
        return mSelectedItemsIds;
    }

}