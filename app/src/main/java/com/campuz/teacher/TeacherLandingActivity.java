package com.campuz.teacher;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.campuz.parentfragments.ParentSubjectsSyllabusFragment;
import com.campuz.teacherfragments.TeacherAttendanceFragment;
import com.campuz.teacherfragments.TeacherHomeFragment;
import com.campuz.teacherfragments.TeacherTakeAttendanceFragment;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TeacherLandingActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,TeacherHomeFragment.OnFragmentInteractionListener,
        TeacherAttendanceFragment.OnFragmentInteractionListener,TeacherTakeAttendanceFragment.OnFragmentInteractionListener{

    private View header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_teacher);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_teacher);
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
        TeacherHomeFragment homeFragment = new TeacherHomeFragment();
        replaceFragment(homeFragment, false);
    }
    // pass context to Calligraphy
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_teacher);
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
              int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container_layout);
        removeAllFragments();
        if (id == R.id.nav_attendance&&!(currentFragment instanceof ParentSubjectsSyllabusFragment)) {
            TeacherAttendanceFragment teacherAttendanceFragment = new TeacherAttendanceFragment();
            replaceFragment(teacherAttendanceFragment, true);
        }else if (id == R.id.nav_syllubus&& !(currentFragment instanceof ParentSubjectsSyllabusFragment)) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_teacher);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
