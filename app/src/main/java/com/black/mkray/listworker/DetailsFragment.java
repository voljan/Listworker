package com.black.mkray.listworker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by black on 2/6/15.
 */
public class DetailsFragment extends Fragment {

    private int mIndex = 0;

    public static DetailsFragment newInstance(int index) {
        Log.v(MainActivity.TAG, " in DetailsFragment newInstance index " + index + " )");
        DetailsFragment df = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        df.setArguments(args);
        return df;
    }

    public static DetailsFragment newInstance(Bundle bundle) {

        int index = bundle.getInt("index", 0);

        return newInstance(index);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v(MainActivity.TAG, " in DetailsFragment onCreate Bundle now");
        if (savedInstanceState != null) {
            for (String key : savedInstanceState.keySet()) {
                Log.v(MainActivity.TAG, "  " + key);
            }
        } else {
            Log.v(MainActivity.TAG, " savedInstancestate is null");
        }
        super.onCreate(savedInstanceState);

        mIndex = getArguments().getInt("index", 0);

    }

    public int getShownIndex() {
        return mIndex;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(MainActivity.TAG, " onCreateView DetailsFragment");

    View v = inflater.inflate(R.layout.details, container, false);

        TextView textView = (TextView) v.findViewById(R.id.text1);
        textView.setText(Shakespeare.DIALOGUE[mIndex]);
        return v;
    }

}
