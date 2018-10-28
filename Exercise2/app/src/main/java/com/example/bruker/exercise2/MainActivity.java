package com.example.bruker.exercise2;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 * Exercise 2 INI4014 at NTNU
 * Created fall 2018 by Rune Vedøy
 */

public class MainActivity extends Activity {
    private int request_Code = 1;
    private int result;
    private int result2;
    private int max;

    EditText et1;
    EditText et2;
    TextView tvadd1;
    TextView tvadd2;
    TextView tvresult;
    TextView tvupper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tvadd1 = findViewById(R.id.tvadd1);
        tvadd2 = findViewById(R.id.tvadd2);
        tvresult = findViewById(R.id.tvresult);
        tvupper = findViewById(R.id.tvupper);
    }

    public void buGenerateRandom(View view) {
        //Starting an intent to get results from RandomNumber activity
        // Task 1
        Intent intent = new Intent(this, RandomNumber.class);
        startActivityForResult(intent,request_Code);
    }

    //This method is called when the result is set in RandomNumber
    // task 1 and 2
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == request_Code && resultCode== RESULT_OK){
            result = data.getIntExtra("Number",1);
            result2 = data.getIntExtra("Number2",1);
            max = data.getIntExtra("Max",1);
            //String res = String.valueOf(result);
            //Toast.makeText(this,res,Toast.LENGTH_LONG).show();
            tvadd1.setText(String.valueOf(result));
            tvadd2.setText(String.valueOf(result2));
            tvupper.setText(String.valueOf(max));
        }
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tvadd1 = findViewById(R.id.tvadd1);
        tvadd2 = findViewById(R.id.tvadd2);

    }


    public void buAdd(View view) {
        //String
        int userEnteredNumber = Integer.parseInt(et1.getText().toString());
        int tvNumber1 = Integer.parseInt(tvadd1.getText().toString());
        int tvNumber2 = Integer.parseInt(tvadd2.getText().toString());
        int upperLimit =max;

        int sum =tvNumber1+tvNumber2;
        String stringSum = " " + String.valueOf(sum);

        // Checking if correct:
        if (sum == userEnteredNumber){
            Toast.makeText(this,getString(R.string.correct),Toast.LENGTH_LONG).show();
            tvresult.setText(String.valueOf(sum));
            tvupper.setText(String.valueOf(upperLimit));
        }else Toast.makeText(this,getString(R.string.wrong)+stringSum,Toast.LENGTH_LONG).show();

        // Getting new random numbers and setting the max limit for the random numbers
        Intent intent = new Intent(this, RandomNumber.class);
        intent.putExtra("upper",et2.getText().toString());
        setResult(RESULT_OK,intent);
        startActivityForResult(intent,request_Code);

    }

    public void buMultiply(View view) {
        int userEnteredNumber = Integer.parseInt(et1.getText().toString());
        int tvNumber1 = Integer.parseInt(tvadd1.getText().toString());
        int tvNumber2 = Integer.parseInt(tvadd2.getText().toString());

        int sum =tvNumber1*tvNumber2;
        String stringSum = " " + String.valueOf(sum);

        // Checking if correct:
        if (sum == userEnteredNumber){
            Toast.makeText(this,getString(R.string.correct),Toast.LENGTH_LONG).show();
            tvresult.setText(String.valueOf(sum));
        }else Toast.makeText(this,getString(R.string.wrong)+stringSum,Toast.LENGTH_LONG).show();

        // Getting a new random number
        Intent intent = new Intent(this, RandomNumber.class);
        intent.putExtra("upper",et2.getText().toString());
        setResult(RESULT_OK,intent);
        startActivityForResult(intent,request_Code);
    }

}
