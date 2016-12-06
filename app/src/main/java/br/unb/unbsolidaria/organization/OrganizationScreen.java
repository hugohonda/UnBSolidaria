package br.unb.unbsolidaria.organization;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.unb.unbsolidaria.LoginActivity;
import br.unb.unbsolidaria.R;
import br.unb.unbsolidaria.entities.Organization;
import br.unb.unbsolidaria.entities.User;
import br.unb.unbsolidaria.persistency.Database;

public class OrganizationScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    private int lastSelectedItem;
    private Toolbar mActivityToolbar;

    private User mLoggedUser;
    private Organization mUserProfile;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_screen);
        mActivityToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActivityToolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mActivityToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        lastSelectedItem = -1;
        MenuItem newsItem = mNavigationView.getMenu().getItem(0);
        newsItem.setChecked(true);
        onNavigationItemSelected(newsItem);

        setUpUserProfile();
    }

    private void setUpUserProfile() {
        Intent thisIntent = getIntent();
        TextView nav_UserName;

        mLoggedUser = (User)thisIntent.getSerializableExtra(LoginActivity.LOGIN_MESSAGE);
        if (mLoggedUser == null)
            return;

        try{
            mUserProfile = Database.getInstance().getOrganizacoes().get(mLoggedUser.getId());
        } catch (IndexOutOfBoundsException e){
            setUpUserProfileDialogError();
            return;
        }

        nav_UserName = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.ov_navTitle);
        nav_UserName.setText(mUserProfile.getCommercialName());
        //TODO: set-up also picture (maybe it is in User class)
    }

    private void setUpUserProfileDialogError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Erro ao carregar informações de Perfil. Opções de Menu serão desativadas até Logout.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mLoggedUser = null;
                    }
                });
        builder.show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            // Avoid going accidently to the Login Screen
            //super.onBackPressed();
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (mLoggedUser == null)
            return true;

        if (lastSelectedItem == id){
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        ft = fragmentManager.beginTransaction();
        userFragment = fragmentManager.findFragmentById(R.id.co_frameLayout);
        if (userFragment != null){
            ft.remove(userFragment);
        }
        lastSelectedItem = id;

        if (id == R.id.orgv_sbNewsItem) {
            mActivityToolbar.setTitle("Novidades");
            ft.commit();
        } else if (id == R.id.orgv_sbCreateOpportunityItem) {
            userFragment = new CreateOpportunity();
            ft.add(R.id.co_frameLayout, userFragment).commit();
            mActivityToolbar.setTitle("Criar Oportunidade");

        } else if (id == R.id.orgv_sbViewOpportunityItem) {
            userFragment = new ViewOpportunities();
            ft.add(R.id.co_frameLayout, userFragment).commit();
            mActivityToolbar.setTitle("Ver Oportunidades");

        } else if (id == R.id.orgv_sbEditProfileItem) {
            userFragment = new EditProfile();
            ft.add(R.id.co_frameLayout, userFragment).commit();
            mActivityToolbar.setTitle("Editar Perfil");
        } else if (id == R.id.orgv_sbExitItem) {
            exitHandler();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void exitHandler() {
        Database.getInstance().saveLocalState(getApplicationContext());
        finish();
    }

    public Organization getUserProfile(){
        return mUserProfile;
    }

    public void restart() {
        int homeFragmentID = 0;

        if (homeFragmentID == lastSelectedItem)
            lastSelectedItem = -1;

        MenuItem newsItem = mNavigationView.getMenu().getItem(homeFragmentID);
        newsItem.setChecked(true);
        onNavigationItemSelected(newsItem);
    }

}
