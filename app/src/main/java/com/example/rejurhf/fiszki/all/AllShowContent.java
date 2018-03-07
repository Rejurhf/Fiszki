package com.example.rejurhf.fiszki.all;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.rejurhf.fiszki.R;
import static com.example.rejurhf.fiszki.io.FileHand.getArrayOfCombined;

/**
 * Created by Rejurhf on 06.03.2018.
 */

@SuppressLint("ValidFragment")
public class AllShowContent extends Fragment {
    private String fileName;
    private ListView list ;
    private ArrayAdapter<String> adapter ;

    @SuppressLint("ValidFragment")
    public AllShowContent(String name){
        fileName = name;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.all_words, container, false);
        list = (ListView) myView.findViewById(R.id.listViewOfWords);

        adapter = new ArrayAdapter<String>(getActivity(), R.layout.all_word,
                getArrayOfCombined(fileName));
        list.setAdapter(adapter);
        return myView;
    }
}
