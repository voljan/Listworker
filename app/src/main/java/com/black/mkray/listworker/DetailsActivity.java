package com.black.mkray.listworker;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by black on 2/8/15.
 */
public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(MainActivity.TAG, " in DetailsActivity onCreate    ");
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        if (getIntent() != null) {
            DetailsFragment details = DetailsFragment
                    .newInstance(getIntent().getExtras());
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content, details)
                    .commit();

        }
    }
}
