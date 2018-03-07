package com.example.rejurhf.fiszki.classic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    private int index = -1;

    public ClassicFiszki(String fileName) {
        this.fileName = fileName;
    }                                               //fileName save

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.classic_fiszki, container, false);

        textViewWord = (TextView) myView.findViewById(R.id.textViewClasicWord);
        textViewInfo = (TextView) myView.findViewById(R.id.textViewClasicInfo);
        loadAndRandomiseList();
        showNewWord();

        return myView;
    }

    protected void showNewWord() {
        index++;
        if(index < listOfWords.size()){
            textViewWord.setText(listOfWords.get(index).getWord());
            textViewInfo.setText(hidenInfoText);
        }else{
            Toast.makeText(getActivity(), "Koniec fiszek", Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }
    }

    private void loadAndRandomiseList() {                                                //loads and shuffle loaded list of words
        listOfWords = getListOfWords(fileName);
        long seed = System.nanoTime();
        Collections.shuffle(listOfWords, new Random(seed));
    }

    public void changeInfoText() {
        String infoText = textViewInfo.getText().toString();
        if(infoText.equals(hidenInfoText)){
            textViewInfo.setText(listOfWords.get(index).getInformation());
        }
    }
}
