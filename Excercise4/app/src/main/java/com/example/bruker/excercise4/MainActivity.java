package com.example.bruker.excercise4;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/*
* Exercise 4 of the course IINI4001 at NTNU
* Rune Vedøy, fall 2018
*/
public class MainActivity extends Activity implements NamesFragmentList.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().setDisplayHomeAsUpEnabled(true); App vil ikke åpne seg med denne her
    }

  @Override
  public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
  }


    @Override
    public void onItemSelected(String value){
        Bundle arguments = new Bundle();
        arguments.putString("name", value);
        if (value.equals("Monkey")){
            arguments.putInt("imageId",R.drawable.monkey);
        }else if (value.equals("Lion")){
            arguments.putInt("imageId",R.drawable.lion);
        }else if (value.equals("Squirrel")){
            arguments.putInt("imageId",R.drawable.squirrel);
        }else if (value.equals("Tiger")){
            arguments.putInt("imageId",R.drawable.tiger);
        }

        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(arguments);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.details_container,fragment);
        fragmentTransaction.commit();
    }

}
