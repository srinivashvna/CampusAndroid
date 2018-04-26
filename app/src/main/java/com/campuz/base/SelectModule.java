package com.campuz.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.campuz.R;

import com.campuz.parent.ParentLandingActivity;
import com.campuz.teacher.TeacherLandingActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SelectModule extends BaseActivity {


    Button btn_Teacher,btn_Parent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_selection);

        btn_Teacher =(Button)findViewById(R.id.btn_Teacher);
        btn_Parent =(Button)findViewById(R.id.btn_Parent);

        btn_Teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectModule.this, TeacherLandingActivity.class);
                startActivity(i);
                finish();
            }
        });
        btn_Parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectModule.this, ParentLandingActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    // pass context to Calligraphy
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }
}

