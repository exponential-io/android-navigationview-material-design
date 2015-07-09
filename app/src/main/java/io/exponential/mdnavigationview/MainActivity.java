package io.exponential.mdnavigationview;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements MainFragment.Callbacks {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.container) != null) {

            // Guard against creating overlapping fragment instances if the activity is being
            // restored from a previous state.
            if (savedInstanceState == null) {
                getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, MainFragment.newInstance("Placeholder"))
                    .commit();
            }
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        // Define an event listener via an anonymous class
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Set the selected menu item in the drawer to checked
                        menuItem.setChecked(true);
                        // Close the NavigationView drawer
                        drawerLayout.closeDrawers();
                        // Inform Android that we have handled the event
                        return true;
                    }
                }
            );
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id) {
            case android.R.id.home:
                // Open the NavigationView drawer when the home icon is clicked
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                // TODO: Implement settings
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void passDataToActivity(String data) {
        // Do nothing yet...
    }
}
