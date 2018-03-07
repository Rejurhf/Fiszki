package com.example.rejurhf.fiszki.add;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rejurhf.fiszki.R;

/**
 * Created by Rejurhf on 06.03.2018.
 */

@SuppressLint("ValidFragment")
public class AddWords extends Fragment {
    private String fileName;
    private TextView textView;

    @SuppressLint("ValidFragment")
    public AddWords(String name){
        fileName = name;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.add_words, container, false);
        textView = (TextView) myView.findViewById(R.id.textViewAddWord);
        String text = "Dodaj nowe słowo do " + fileName;
        textView.setText(text);
        return myView;
    }
}
