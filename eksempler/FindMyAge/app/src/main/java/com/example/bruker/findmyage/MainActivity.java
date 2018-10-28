package com.example.bruker.findmyage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etDOB;
    TextView tvShowAge;

    //These are for the video about sending info between activities
    EditText etUserName;
    EditText etPassword;
    String userName ="admin";
    String password= "1111";
    String name = "Rune";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //etDOB = findViewById(R.id.etDOB);
        //tvShowAge = findViewById(R.id.tvShowAge);

        //Video 14
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
    }

    public void buFindAge(View view) {
        int dob = Integer.parseInt(etDOB.getText().toString());
        // Get device current time
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int age = year -dob;
        tvShowAge.setText("Your age is: "+ age +"and in months: " + age*12 +", in days: "+age*365);
    }


    // Video 14
    public void buLogin(View view) {
        if (userName.equals(etUserName.getText().toString()) &&
                password.equals(etPassword.getText().toString())) {
            // go to second activity
            Intent intent = new Intent(this,Home.class);
            intent.putExtra("name",name);
            intent.putExtra("Username",userName);
            startActivity(intent);
        }

    }
}
