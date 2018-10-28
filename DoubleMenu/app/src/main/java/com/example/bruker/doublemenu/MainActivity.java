package com.example.bruker.doublemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu); // Kaller metoden som vi arver, er dog ikke nødvendig

        // Adding options
        menu.add("Rune");
        menu.add("Vedoy");

        Log.i("OnCreateOptionsMenu()", "Menu made");// Writing to log, to be shown in LogCat

        return true;//true will make the menu to be showed.
    }


    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);// Did not work until I chose the super class
        if (item.getTitle().equals("Rune")){
            Log.i("OnOptionsItemSelected()", "Rune chosen");
        }
        if (item.getTitle().equals("Vedoy")){
            Log.i("OnOptionsItemSelected()", "Vedøy chosen");
        }

        return true;// will make the choice happen
    }

}
