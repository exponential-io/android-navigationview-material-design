package io.exponential.mdnavigationview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity implements MainFragment.Callbacks {

    private final String CHECKED_MENU_ITEM_ID = "MainActivity.CHECKED_MENU_ITEM_ID";
    private int checkedMenuItemId = 0;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.container) != null) {

            if (savedInstanceState != null) {
                // Restore the previously checked NavigationView drawer MenuItem.
                checkedMenuItemId = savedInstanceState.getInt(CHECKED_MENU_ITEM_ID);
            } else {
                // Guard against creating overlapping fragment instances if the activity is being
                // restored from a previous state.
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
            Menu navigationViewMenu = navigationView.getMenu();

            if (checkedMenuItemId == 0) {
                // Default: check the Home menu item.
                MenuItem homeMenuItem = navigationViewMenu.findItem(R.id.nav_home);
                homeMenuItem.setChecked(true);
                checkedMenuItemId = homeMenuItem.getItemId();
            } else {
                // Check the previously checked menu item (i.e. the checked menu item from saved
                // instance state).
                MenuItem checkedMenuItem = navigationViewMenu.findItem(checkedMenuItemId);
                checkedMenuItem.setChecked(true);
            }

            navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Set the selected menu item in the drawer to checked
                        menuItem.setChecked(true);
                        checkedMenuItemId = menuItem.getItemId();
                        // Close the NavigationView drawer
                        drawerLayout.closeDrawers();
                        // Inform Android that we have handled the event
                        return true;
                    }
                }
            );
        }

        ImageView avatarImageView = (ImageView) findViewById(R.id.avatar);

        Picasso
            .with(this)
            .load(R.drawable.avatar)
            .into(avatarImageView);
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
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CHECKED_MENU_ITEM_ID, checkedMenuItemId);

        // Call the super class so that it can save the view hierarchy state
        super.onSaveInstanceState(outState);
    }

    @Override
    public void passDataToActivity(String data) {
        // Do nothing yet...
    }
}
