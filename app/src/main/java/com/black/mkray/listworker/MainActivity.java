package com.black.mkray.listworker;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    public static final String TAG = "Listworker";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager.enableDebugLogging(true);
        setContentView(R.layout.activity_main);


    }

    public boolean isMultiPane() {

        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public void showDetails(int index) {
        Log.v(TAG, " in ShowDetails index = " + index);
        if (isMultiPane()) {
            DetailsFragment details =  (DetailsFragment)getFragmentManager().findFragmentById(R.id.details);
            if ((details == null)||(details.getShownIndex() != index)) {
                details = DetailsFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack("details");
                ft.replace(R.id.details, details);
            }

        } else {
            Intent intent = new Intent();
            intent.setClass(this, DetailsActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);

        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        Log.v(MainActivity.TAG, " in MainActivity onAttachFragment");
        super.onAttachFragment(fragment);
    }

    @Override
    protected void onStart() {
        Log.v(MainActivity.TAG, " in MainActivity onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v(MainActivity.TAG, " in MainActivity onResume");
        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.v(MainActivity.TAG, " in MainActivity onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v(MainActivity.TAG, " in MainActivity onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v(MainActivity.TAG, " in MainActivity onDestroy");
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.v(MainActivity.TAG, " in MainActivity onSaveInstanceState");
        super.onSaveInstanceState(outState, outPersistentState);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
