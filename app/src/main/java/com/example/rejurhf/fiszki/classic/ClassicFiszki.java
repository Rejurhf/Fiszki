package com.example.rejurhf.fiszki.classic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rejurhf.fiszki.R;

/**
 * Created by Rejurhf on 07.03.2018.
 */

@SuppressLint("ValidFragment")
class ClassicFiszki extends Fragment {
    private String fileName = "initFile.txt";

    public ClassicFiszki(String fileName) {
        this.fileName = fileName;
    }  //fileName save

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.classic_fiszki, container, false);
        return myView;
    }
}
