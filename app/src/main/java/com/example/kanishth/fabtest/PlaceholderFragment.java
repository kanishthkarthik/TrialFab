package com.example.kanishth.fabtest;

/**
 * Created by kanishth on 27/7/14.
 */

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    View rootView;
    Fab mFab;

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mFab = (Fab)rootView.findViewById(R.id.fabbutton);
        int holoBlue = getResources().getColor(android.R.color.holo_blue_light);
        mFab.setFabColor(holoBlue);
        mFab.setFabDrawable(getResources().getDrawable(R.drawable.ic_content_edit));

        String data[] = new String[15];
        for (int i = 0; i < 15; i++)
            data[i] = "Text Entry " + i;

        ArrayAdapter<String> mForecastAdapter;
        List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));

        mForecastAdapter = new ArrayAdapter<String>(
                getActivity(), // The current context (this activity)
                R.layout.list_item_display, // The name of the layout ID.
                R.id.list_item_textview, // The ID of the textview to populate.
                weekForecast);

        final ListView listview = (ListView) rootView.findViewById(R.id.listview_display);

        listview.setAdapter(mForecastAdapter);
        listview.setOnScrollListener(new AbsListView.OnScrollListener(){
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // TODO Auto-generated method stub
                if(scrollState == SCROLL_STATE_TOUCH_SCROLL)
                {
                    Log.i("a", "scrolling touch...");
                    mFab.hideFab();
                }
                else if(scrollState ==  SCROLL_STATE_IDLE)
                mFab.showFab();
            }
        });

        return rootView;
    }

}
