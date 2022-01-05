package com.example.car;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Information> InfoList;

    @Override
    public void onCreate() {
        super.onCreate();
        InfoList = new ArrayList<>();
        InfoList.add(new Information("Peter Azelerat","9825346346","Benz-S","Mercedes"));
        InfoList.add(new Information("Thomas Rivera","6547478446","Polo","Volkswagen"));
        InfoList.add(new Information("Angel Crook","8825543343","Sunny","Nissan"));
        InfoList.add(new Information("Jeremy Hemsworth","35472785449","Vento","Volkswagen"));
        InfoList.add(new Information("Timmy Louis","9805340346","Benz-C","Mercedes"));
        InfoList.add(new Information("Alexa Trump","7547478990","Terrano","Nissan"));
    }
}
