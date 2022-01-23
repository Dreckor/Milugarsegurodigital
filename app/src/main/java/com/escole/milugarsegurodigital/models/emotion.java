package com.escole.milugarsegurodigital.models;

public class emotion {
    private int image;
    private  String emotion;
    public emotion(int image, String emotion){
        this.image = image;
        this.emotion = emotion;
    }

    public int getImage() {
        return image;
    }

    public String getEmotion() {
        return emotion;
    }
}