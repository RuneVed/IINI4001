package com.example.bruker.randomnumbergenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    private int request_Code = 1;
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private double randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNumber= getIntent().getDoubleExtra("RandomNumber",randomNumber);
    }

    public void onClick(View v){
        //startActivity(new Intent(".RandomNumberGenerator"));
        //finish();

        //startActivityForResult(new Intent("com.example.bruker.RandomNumberGenerator"),request_Code);

        Intent intent = new Intent();
        intent.putExtra("RandomNuumber",randomNumber);
        setResult(RESULT_OK,intent);
        finish();

    }

    public void OnActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==request_Code &&resultCode ==RESULT_OK){
            randomNumber = data.getDoubleExtra("RandomNumber",randomNumber);
        }
    }

}
