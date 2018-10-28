package com.example.bruker.findmyage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    EditText etShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        etShow = findViewById(R.id.etShow);

        //Read from intent
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String uname = bundle.getString("Username");
        etShow.setText(name);
    }

    public void buClose(View view) {
        finish();
    }
}
