package no.hist.itfag.flagsapplication;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
//import android.widget.Toast;
import android.widget.ImageView;


public class UKActivity extends Activity {
    private int flagValue = R.drawable.uk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uk);
        flagValue = getIntent().getIntExtra("flag", flagValue);
        ImageView flag=(ImageView)findViewById(R.id.imageView);
        flag.setImageResource(flagValue);
    }

 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_norway, menu);
        return true;
    }*/
    public void onClick1(View v) {
 //       Toast.makeText( getBaseContext(), "I OnClick1", Toast.LENGTH_LONG).show();
  //      startActivity(new Intent("no.hist.itfag.NorwayActivity"));
        Intent intent = new Intent();
        intent.putExtra("flag", flagValue);
        setResult(RESULT_OK, intent);
        finish();
    }
    public void onClick2(View v) {
        if (flagValue == R.drawable.norway){
            flagValue = R.drawable.uk;
        }
        else {
            flagValue = R.drawable.norway;
        }
        ImageView flag=(ImageView)findViewById(R.id.imageView);
        flag.setImageResource(flagValue);
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
