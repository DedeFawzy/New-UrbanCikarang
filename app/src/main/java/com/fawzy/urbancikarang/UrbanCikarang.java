package com.fawzy.urbancikarang;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class UrbanCikarang extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (isNetworkStatusAvialable(getApplicationContext())) {
            Toast.makeText(getApplicationContext(), (getString(R.string.tunggu)), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), (getString(R.string.putus)), Toast.LENGTH_SHORT).show();
            finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urban_cikarang);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Fragment urbanFragment = null;
        switch (position) {
            case 0:
                urbanFragment = new HomeFragment();
                break;
            case 1:
                urbanFragment = new TwitFragment();
                break;
            case 2:
                urbanFragment = new AboutFragment();
                break;
        }
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, urbanFragment)
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff00aafa")));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.urban_cikarang, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_iklan) {

            Toast.makeText(getApplicationContext(), "Beriklan di UrbanCikarang mulai dari Rp. 50.000", Toast.LENGTH_SHORT).show();
            Intent iklanIntent = new Intent(android.content.Intent.ACTION_SEND);
            String iklanEmailList[] = {"urbancikarang@gmail.com"};
            iklanIntent.putExtra(android.content.Intent.EXTRA_EMAIL, iklanEmailList);
            iklanIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Beriklan di UrbanCikarang");
            iklanIntent.setType("plain/text");
            iklanIntent.putExtra(android.content.Intent.EXTRA_TEXT, (getString(R.string.isi_iklan)));
            startActivity(Intent.createChooser(iklanIntent, (getString(R.string.aksi))));

            return true;
        }
        if (id == R.id.action_partner) {
            Intent partnerIntent = new Intent(android.content.Intent.ACTION_SEND);
            String partnerEmailList[] = {"urbancikarang@gmail.com"};
            partnerIntent.putExtra(android.content.Intent.EXTRA_EMAIL, partnerEmailList);
            partnerIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Media Partner UrbanCikarang");
            partnerIntent.setType("plain/text");
            partnerIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Rincian event :");
            startActivity(Intent.createChooser(partnerIntent, (getString(R.string.aksi))));
        }
        if (id == R.id.action_feedback) {
            Intent fawzyIntent = new Intent(android.content.Intent.ACTION_SEND);
            String DedeFawzyEmailList[] = {"dede.fawzy@gmail.com"};
            fawzyIntent.putExtra(android.content.Intent.EXTRA_EMAIL, DedeFawzyEmailList);
            fawzyIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Feedback for UrbanCikarang app");
            fawzyIntent.setType("plain/text");
            startActivity(Intent.createChooser(fawzyIntent, (getString(R.string.aksi))));
        }
        if (id == R.id.action_exit) {

            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.action_exit))
                    .setPositiveButton(getString(R.string.yoik), new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton(getString(R.string.mbung), null)
                    .show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_urban_cikarang, container, false);
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((UrbanCikarang) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(getString(R.string.action_exit));
        builder.setPositiveButton((getString(R.string.yoik)), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton((getString(R.string.mbung)),new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }

    public boolean isNetworkStatusAvialable (Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if(netInfos != null)
                if(netInfos.isConnected())
                    return true;
        }
        return false;
    }
}