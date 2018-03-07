package com.example.rejurhf.fiszki.all;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import static com.example.rejurhf.fiszki.io.FileHand.getArrayOfDirs;

/**
 * Created by Rejurhf on 04.03.2018.
 */

public class DirsFragment extends ListFragment {
    int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> connectArrayToListView = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_activated_1, getArrayOfDirs());
        setListAdapter(connectArrayToListView);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        showDetails(position);
    }

    private void showDetails(int index) {
        mCurCheckPosition = index;
        Bundle extras = new Bundle();
        extras.putInt("index", index);
        extras.putString("name", getArrayOfDirs().get(index));

        Intent intent = new Intent();
        intent.setClass(getActivity(), AllActivity.class);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
