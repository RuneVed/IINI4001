package no.hist.itfag.flagsapplication;

//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;


public class NorwayActivity extends Activity {
    private int request_Code = 1;
    private int flagValue = R.drawable.norway;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_norway);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_norway, menu);
        return true;
    }

    public void onClick(View v) {
     //   startActivity(new Intent("no.hist.itfag.UKActivity"));
     //   finish();
     //   startActivityForResult(new Intent("no.hist.itfag.UKActivity"), request_Code);
        Intent intent = new Intent("no.hist.itfag.UKActivity");
        intent.putExtra("flag", flagValue);
        startActivityForResult(intent, request_Code);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==request_Code && resultCode==RESULT_OK) {
            flagValue = data.getIntExtra("flag", R.drawable.uk);
            ImageView flag = (ImageView)findViewById(R.id.imageView);
            flag.setImageResource(flagValue);
        }
    }

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
}
