package com.example.rejurhf.fiszki.io;

import android.os.Environment;
import com.example.rejurhf.fiszki.classic.Word;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rejurhf on 06.03.2018.
 */

public class FileHand {
    private static String path = Environment.getExternalStorageDirectory().getAbsolutePath() +
            "/FiszkiApp";

    public static ArrayList<String> getArrayOfDirs() {
        ArrayList<String> dirs = new ArrayList<String>();
        File[] files = new File(path).listFiles();
        for (File file:files){
            if (!file.isDirectory()){
                if (file.getName().endsWith(".txt")){
                    dirs.add(file.getName());
                }
            }
        }
        return dirs;
    }

    public static ArrayList<String> getArrayOfCombined(String fileName){           //read in file and gives Array of Strings WOrds and clues combined
        ArrayList<String> arrayList = new ArrayList<String>();
        File file = new File(path + "/" + fileName);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String lineW, lineI;
        try {
            while ((lineW = br.readLine()) != null && (lineI = br.readLine()) != null){
                arrayList.add(lineW + "\n" + lineI);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    public static List<Word> getListOfWords(String fileName){
        List<Word> wordsList = new ArrayList<Word>(){};
        File file = new File(path + "/" + fileName);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String lineW, lineI;
        try {
            while ((lineW = br.readLine()) != null && (lineI = br.readLine()) != null){
                wordsList.add(new Word(lineW, lineI));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordsList;
    }

    public static void addNewFile(String fileName){
        addNewWord("Testowy plik o nazwie:", fileName, fileName);
    }

    public static void addNewWord(String word, String info, String fileName) {
        word = word.replaceAll("\n", ", ");
        info = info.replaceAll("\n", ", ");

        if(!fileName.endsWith(".txt")){
            fileName += ".txt";
        }
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(path + "/" + fileName , true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.append(word + "\n" + info + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            out.close();
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
