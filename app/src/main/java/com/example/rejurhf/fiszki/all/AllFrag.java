package com.example.rejurhf.fiszki.all;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rejurhf.fiszki.R;

/**
 * Created by Rejurhf on 06.12.2017.
 */

public class AllFrag extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.frag_all, container, false);

        return myView;
    }

//    private void displayFiles(View myView){
//        textViewDirs = (TextView) myView.findViewById(R.id.testDir);
//        List<File> files = getFiles();
//        String textToDsply = "List of files:";
//
//        for (File file:files){
//            textToDsply = textToDsply + "\n" + file.getName();
//        }
//
//        textViewDirs.setText(textToDsply);
//    }
//

}
