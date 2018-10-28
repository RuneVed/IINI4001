package com.example.bruker.exercise2;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;

public class RandomNumber extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);

        //Calling the randomNumber method upon creation
        randomNumber();
    }


    public void randomNumber(){
        int m=0;

        // Getting Upper limit from MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String someVariable = extras.getString("upper");
            m = Integer.parseInt(someVariable);
        }
        int min = 1;
        int number = (int)(Math.random()*(m-min)+1)+min;
        int number2=(int)(Math.random()*(m-min)+1)+min;

        //Creating a new intent to send to the MainActivity, closing the activity afterwards
        Intent intent = new Intent();
        intent.putExtra("Number", number);
        intent.putExtra("Number2",number2);
        intent.putExtra("Max",m); // Task b
        setResult(RESULT_OK, intent);
        finish();
    }


}
