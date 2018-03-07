package com.example.rejurhf.fiszki.classic;

/**
 * Created by Rejurhf on 07.03.2018.
 */

public class Word {
    private String word, info;
    private int knowlage = 0;                       //level of knowlage of the word 0 - min, 3- max

    public Word(String word, String info){
        this.word = word;
        this.info = info;
    }

    public String getWord(){
        return word;
    }

    public String getInformation(){
        return info;
    }

    public int getKnowlageLevel(){
        return knowlage;
    }

    public void setWord(String word){
        this.word = word;
    }

    public void setInformation(String info){
        this.info = info;
    }

    public void incrKnowlage(){
        if(knowlage < 3)
            knowlage++;
    }

    private void decrKnowlage(){
        if (knowlage > 0)
            knowlage--;
    }
}
