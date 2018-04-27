package com.campuz.teacher;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.campuz.R;
import com.campuz.base.SelectModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeacherHomeActivity extends AppCompatActivity {

    String[] classes = new String[]{
            "Select Class...",
            "Class 1",
            "Class 3",
            "Class 5",
            "Class 9"
    };

    String[] classesSections = new String[]{
            "Select Section...",
            "Section A",
            "Section B",
            "Section C"
    };

    String[] subjects = new String[]{
            "Select Subject...",
            "English",
            "Maths"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Spinner classSpinner = (Spinner) findViewById(R.id.classSpinner);
        final Spinner subjectSpinner = (Spinner) findViewById(R.id.subjectSpinner);
        final Spinner sectionSpinner = (Spinner) findViewById(R.id.sectionSpinner);

        final Button btnSubmit = (Button) findViewById(R.id.submit);

        final List<String> classList = new ArrayList<>(Arrays.asList(classes));
        final List<String> sectionsList = new ArrayList<>(Arrays.asList(classesSections));
        final List<String> subList = new ArrayList<>(Arrays.asList(subjects));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TeacherHomeActivity.this, TeacherLandingActivity.class);
                startActivity(i);
            }
        });

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerclassAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,classList){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnersubAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,sectionsList){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnersectAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,subList){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };


        spinnerclassAdapter.setDropDownViewResource(R.layout.spinner_item);
        classSpinner.setAdapter(spinnerclassAdapter);

        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnersubAdapter.setDropDownViewResource(R.layout.spinner_item);
        subjectSpinner.setAdapter(spinnersubAdapter);

        subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnersectAdapter.setDropDownViewResource(R.layout.spinner_item);
        sectionSpinner.setAdapter(spinnersectAdapter);

        sectionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
