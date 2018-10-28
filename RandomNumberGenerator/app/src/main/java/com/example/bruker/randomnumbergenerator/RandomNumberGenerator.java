package com.example.bruker.randomnumbergenerator;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

public class RandomNumberGenerator extends Activity{
    private int request_Code = 1;
    //private int randomNumber = randomNumber();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void randomNumber(){
        int max = 100;
        int min = 0;
        double number = (Math.random()*(max-min)+1)+min;
    }


}
