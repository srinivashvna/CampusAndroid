package com.campuz.parent;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
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
import com.campuz.parentfragments.ParentAttendanceReportFragment;
import com.campuz.parentfragments.ParentBusLocationFragment;
import com.campuz.parentfragments.ParentDairyReportFragment;
import com.campuz.parentfragments.ParentEventsFragment;
import com.campuz.parentfragments.ParentExamDetailedFragment;
import com.campuz.parentfragments.ParentExamsFragment;
import com.campuz.parentfragments.ParentHolidayFragment;
import com.campuz.parentfragments.ParentHomeFragment;
import com.campuz.parentfragments.ParentLeaveFragment;
import com.campuz.parentfragments.ParentProgressReportDetailedFragment;
import com.campuz.parentfragments.ParentProgressReportFragment;
import com.campuz.parentfragments.ParentSubjectsSyllabusFragment;
import com.campuz.parentfragments.ParentSyllabusDetailsFragment;
import com.campuz.parentfragments.ParentTimeTableFragment;


import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import com.campuz.parentfragments.ParentNotificationsFragment;

/**
 * Created by manikantad on 06-04-2018.
 */

public class ParentLandingActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, ParentLeaveFragment.OnFragmentInteractionListener,ParentHomeFragment.OnFragmentInteractionListener,ParentDairyReportFragment.OnFragmentInteractionListener,
        ParentAttendanceReportFragment.OnFragmentInteractionListener, ParentSubjectsSyllabusFragment.OnFragmentInteractionListener, ParentSyllabusDetailsFragment.OnFragmentInteractionListener, ParentExamsFragment.OnFragmentInteractionListener
        ,ParentExamDetailedFragment.OnFragmentInteractionListener,ParentTimeTableFragment.OnFragmentInteractionListener,ParentProgressReportFragment.OnFragmentInteractionListener,ParentProgressReportDetailedFragment.OnFragmentInteractionListener
        ,ParentEventsFragment.OnFragmentInteractionListener,ParentNotificationsFragment.OnFragmentInteractionListener,ParentHolidayFragment.OnFragmentInteractionListener,ParentBusLocationFragment.OnFragmentInteractionListener{

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
        ParentHomeFragment parentHomeFragment = new ParentHomeFragment();
        replaceFragment(parentHomeFragment, false);
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

        }else if (id == R.id.nav_syllubus&& !(currentFragment instanceof ParentSubjectsSyllabusFragment)) {
            ParentSubjectsSyllabusFragment parentSubjectsSyllabusFragment = new ParentSubjectsSyllabusFragment();
            replaceFragment(parentSubjectsSyllabusFragment, true);
        }else if (id == R.id.nav_attendance&& !(currentFragment instanceof ParentAttendanceReportFragment)) {
            ParentAttendanceReportFragment parentAttendanceReportFragment = new ParentAttendanceReportFragment();
            replaceFragment(parentAttendanceReportFragment, true);
        }else if (id == R.id.nav_dairy&& !(currentFragment instanceof ParentDairyReportFragment)) {
            ParentDairyReportFragment parentDairyReportFragment = new ParentDairyReportFragment();
            replaceFragment(parentDairyReportFragment, true);
        }else if (id == R.id.nav_exams&& !(currentFragment instanceof ParentExamsFragment)) {
            ParentExamsFragment parentExamsFragment = new ParentExamsFragment();
            replaceFragment(parentExamsFragment, true);
        }else if (id == R.id.nav_timetable&& !(currentFragment instanceof ParentTimeTableFragment)) {
            ParentTimeTableFragment parentTimeTableFragment = new ParentTimeTableFragment();
            replaceFragment(parentTimeTableFragment, true);
        }else if (id == R.id.nav_events&& !(currentFragment instanceof ParentEventsFragment)) {
            ParentEventsFragment parentEventsFragment = new ParentEventsFragment();
            replaceFragment(parentEventsFragment, true);
        }else if (id == R.id.nav_notifications&& !(currentFragment instanceof ParentNotificationsFragment)) {
            ParentNotificationsFragment parentNotificationsFragment = new ParentNotificationsFragment();
            replaceFragment(parentNotificationsFragment, true);
        }else if (id == R.id.nav_holidays&& !(currentFragment instanceof ParentHolidayFragment)) {
            ParentHolidayFragment parentHolidayFragment = new ParentHolidayFragment();
            replaceFragment(parentHolidayFragment, true);
        }else if (id == R.id.nav_loc && !(currentFragment instanceof ParentBusLocationFragment)) {
            ParentBusLocationFragment parentBusLocationFragment = new ParentBusLocationFragment();
            replaceFragment(parentBusLocationFragment, true);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
