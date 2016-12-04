package br.unb.unbsolidaria;

import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OrganizationScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CreateOpportunity.OnFragmentInteractionListener {

    FragmentManager fragmentManager;
    int lastSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        lastSelectedItem = -1;
        MenuItem newsItem = navigationView.getMenu().getItem(0);
        newsItem.setChecked(true);
        onNavigationItemSelected(newsItem);

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
        getMenuInflater().inflate(R.menu.organization_screen, menu);
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment userFragment;
        FragmentTransaction ft;

        if (lastSelectedItem == id)
            return true;

        lastSelectedItem = id;
        ft = fragmentManager.beginTransaction();

        if (id == R.id.orgv_sbNewsItem) {
            userFragment = fragmentManager.findFragmentById(R.id.co_frameLayout);
            if (userFragment == null){
                userFragment = new CreateOpportunity();
            }
            ft.replace(R.id.co_frameLayout, userFragment);
            ft.commit();
            Toast.makeText(this, "hello toast", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.orgv_sbCreateOpportunityItem) {

        } else if (id == R.id.orgv_sbViewOpportunityItem) {

        } else if (id == R.id.orgv_sbEditProfileItem) {

        } else if (id == R.id.orgv_sbExitItem) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //TODO: Still have to learn Fragment things
    }
}
