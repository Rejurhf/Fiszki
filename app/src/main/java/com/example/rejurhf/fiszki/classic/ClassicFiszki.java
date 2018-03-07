package com.example.rejurhf.fiszki.classic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.rejurhf.fiszki.R;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static com.example.rejurhf.fiszki.io.FileHand.getListOfWords;

/**
 * Created by Rejurhf on 07.03.2018.
 */

@SuppressLint("ValidFragment")
class ClassicFiszki extends Fragment {
    private String fileName = "initFile.txt";
    private static String hidenInfoText = "Naciśnij żeby zobaczyć zawartość";
    private static TextView textViewWord, textViewInfo;
    private List<Word> listOfWords;

    public ClassicFiszki(String fileName) {
        this.fileName = fileName;
    }                                               //fileName save

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.classic_fiszki, container, false);

        textViewInfo = (TextView) myView.findViewById(R.id.textViewClasicInfo);
        textViewInfo = (TextView) myView.findViewById(R.id.textViewClasicInfo);
        loadAndRandomiseList();

        return myView;
    }

    private void loadAndRandomiseList() {                                                //loads and shuffle loaded list of words
        listOfWords = getListOfWords(fileName);
        long seed = System.nanoTime();
        Collections.shuffle(listOfWords, new Random(seed));
    }

    public static void changeInfoText() {
        String infoText = textViewInfo.getText().toString();
        if(infoText.equals(hidenInfoText)){
            textViewInfo.setText("Info");
        }
    }
}
