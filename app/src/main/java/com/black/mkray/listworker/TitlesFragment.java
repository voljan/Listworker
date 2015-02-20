package com.black.mkray.listworker;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by black on 2/7/15.
 */
public class TitlesFragment extends ListFragment {

    private MainActivity mActivity = null;
    int mCurCheckPosition = 0;

    @Override
    public void onAttach(Activity mActivity) {
        Log.v(MainActivity.TAG, " in TitlesFragment onAttach activity is " + mActivity);
        super.onAttach(mActivity);
        this.mActivity = (MainActivity) mActivity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.v(MainActivity.TAG, " in TitlesFragment onActivity savedState contains");
        if (savedInstanceState != null) {
            for (String key : savedInstanceState.keySet()) {
                Log.v(MainActivity.TAG, " key " + key);
            }
        } else {
            Log.v(MainActivity.TAG, "saved Bundle is null");
        }

        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                Shakespeare.TITLES));
        if (savedInstanceState != null) {
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }
        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setSelection(mCurCheckPosition);
//        mActivity.showDetails(mCurCheckPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.v(MainActivity.TAG, "in TitlesGFragment outState");
        super.onSaveInstanceState(outState);
        outState.putInt("ourChoice", mCurCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.v(MainActivity.TAG, " in TitlesFragment.oListItemClick.pos= " + position);
        super.onListItemClick(l, v, position, id);
        mActivity.showDetails(position);
        mCurCheckPosition= position;
    }

    @Override
    public void onDetach() {
        Log.v(MainActivity.TAG, "onDetach() TitlesFragment");
        super.onDetach();
        mActivity = null;
    }
}

