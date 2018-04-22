package com.campuz.parent;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.campuz.R;
import com.campuz.base.BaseActivity;
import com.campuz.parentfragments.AttendanceReportFragment;
import com.campuz.parentfragments.DairyReportFragment;
import com.campuz.parentfragments.ExamDetailedFragment;
import com.campuz.parentfragments.ExamsFragment;
import com.campuz.parentfragments.HomeFragment;
import com.campuz.parentfragments.LeaveFragment;
import com.campuz.parentfragments.ProgressReportDetailedFragment;
import com.campuz.parentfragments.ProgressReportFragment;
import com.campuz.parentfragments.SubjectsSyllabusFragment;
import com.campuz.parentfragments.SyllabusDetailsFragment;
import com.campuz.parentfragments.TimeTableFragment;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by manikantad on 06-04-2018.
 */

public class LandingActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, LeaveFragment.OnFragmentInteractionListener,HomeFragment.OnFragmentInteractionListener,DairyReportFragment.OnFragmentInteractionListener,
        AttendanceReportFragment.OnFragmentInteractionListener, SubjectsSyllabusFragment.OnFragmentInteractionListener, SyllabusDetailsFragment.OnFragmentInteractionListener, ExamsFragment.OnFragmentInteractionListener
        ,ExamDetailedFragment.OnFragmentInteractionListener,TimeTableFragment.OnFragmentInteractionListener,ProgressReportFragment.OnFragmentInteractionListener,ProgressReportDetailedFragment.OnFragmentInteractionListener{

    private View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        header = navigationView.getHeaderView(0);

        TextView txtName = (TextView)header. findViewById(R.id.txtName);
        txtName.setText(R.string.anil);
        ImageView imgProfilenav = (ImageView)header. findViewById(R.id.imgProfilenav);
        TextDrawable drawable = TextDrawable.builder().beginConfig()
                .withBorder(10)
                .bold()
                .useFont(Typeface.DEFAULT)
                .endConfig()
                .buildRound("AK", getResources().getColor(R.color.appblue));


        imgProfilenav.setImageDrawable(drawable);

        init();

    }

    public void init() {
        HomeFragment homeFragment = new HomeFragment();
        replaceFragment(homeFragment, false);
    }

    // pass context to Calligraphy
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container_layout);
        removeAllFragments();
        if (id == R.id.nav_location) {

        }else if (id == R.id.nav_syllubus&& !(currentFragment instanceof SubjectsSyllabusFragment)) {
            SubjectsSyllabusFragment subjectsSyllabusFragment = new SubjectsSyllabusFragment();
            replaceFragment(subjectsSyllabusFragment, true);
        }else if (id == R.id.nav_attendance&& !(currentFragment instanceof AttendanceReportFragment)) {
            AttendanceReportFragment attendanceReportFragment = new AttendanceReportFragment();
            replaceFragment(attendanceReportFragment, true);
        }else if (id == R.id.nav_leaves&& !(currentFragment instanceof LeaveFragment)) {
            LeaveFragment leaveFragment = new LeaveFragment();
            replaceFragment(leaveFragment, true);
        }else if (id == R.id.nav_dairy&& !(currentFragment instanceof DairyReportFragment)) {
            DairyReportFragment dairyReportFragment = new DairyReportFragment();
            replaceFragment(dairyReportFragment, true);
        }else if (id == R.id.nav_exams&& !(currentFragment instanceof ExamsFragment)) {
            ExamsFragment examsFragment = new ExamsFragment();
            replaceFragment(examsFragment, true);
        }else if (id == R.id.nav_timetable&& !(currentFragment instanceof TimeTableFragment)) {
            TimeTableFragment timeTableFragment = new TimeTableFragment();
            replaceFragment(timeTableFragment, true);
        }else if (id == R.id.nav_progressReport&& !(currentFragment instanceof ProgressReportFragment)) {
            ProgressReportFragment progressReportFragment = new ProgressReportFragment();
            replaceFragment(progressReportFragment, true);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
