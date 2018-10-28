package com.example.bruker.calculatordemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    //Connect the textfields to the javacode
    EditText editText1;
    EditText editText2;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Finding the textfields
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void buClick(View view){
        int nr1 = Integer.parseInt(editText1.getText().toString());
        int nr2 = Integer.parseInt(editText2.getText().toString());
        int sum = nr1+nr2;
        textViewResult.setText(String.valueOf(sum));
    }


}
