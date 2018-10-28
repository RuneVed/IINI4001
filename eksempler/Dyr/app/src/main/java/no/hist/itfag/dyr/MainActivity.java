package no.hist.itfag.dyr;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.TypedArray;
import android.content.res.Resources;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.BaseAdapter;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private String[] dyrenavn;
    private String[] dyrebeskrivelse;
    private TypedArray ikoner;
    private TypedArray bilder;
    private int[] imageIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        dyrenavn = res.getStringArray(R.array.dyrenavn);
        dyrebeskrivelse = res.getStringArray(R.array.dyrebeskrivelse);
        ikoner = res.obtainTypedArray(R.array.ikoner);
        bilder = res.obtainTypedArray(R.array.bilder);
        initierSpinner();
        initierKnapper();
        initierList();
        initierGrid();
        initerAvsluttknapp();
    }

    private void initerAvsluttknapp() {
        Button avslutt = (Button)findViewById(R.id.buttonAvslutt);
        avslutt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
    }
    private void initierKnapper() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout1);
        LayoutParams params =
                new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        for (int i=0; i < ikoner.length(); i++) {
            ImageButton knapp = new ImageButton(this);
            knapp.setImageDrawable(ikoner.getDrawable(i));
            knapp.setLayoutParams(params);
            layout.addView(knapp);
            final int nr = i; // Må være final for å brukes i indre klasse
            knapp.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    visStortBilde(nr);
                }
            });
        }
    }
    private void visStortBilde(int nr) {
        Intent i = new Intent("no.hist.itfag.dyr.VisBilde");
        i.putExtra("nr", nr);
        startActivity(i);
    }

    private void initierList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, dyrenavn);
        ListView listView = (ListView)(findViewById(R.id.listView1));
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View valgt, int posisjon, long id) {
                //       TextView tv = (TextView) findViewById(R.id.beskrivelse);
                //       tv.setText(dyrebeskrivelse[posisjon]);
                Spinner spinner = (Spinner) findViewById(R.id.spinnerDyr);
                spinner.setSelection(posisjon);
            }
        });
    }
    private void initierSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, dyrenavn);
        Spinner spinner = (Spinner)findViewById(R.id.spinnerDyr);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View valgt, int posisjon, long id) {
                TextView tv = (TextView) findViewById(R.id.beskrivelse);
                tv.setText(dyrebeskrivelse[posisjon]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
    private void initierGrid() {
        imageIDs=new int[bilder.length()];
        for (int i=0; i < bilder.length(); i++) {
            imageIDs[i]=bilder.peekValue(i).resourceId;
        }
        GridView g = (GridView)findViewById(R.id.gridView1);
        g.setAdapter(new MinAdapter(this));
        g.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View valgt, int posisjon, long id) {
                visStortBilde(posisjon);
            }
        });
    }

    public class MinAdapter extends BaseAdapter {
        private Context context;

        public MinAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return imageIDs.length;
        }

        @Override
        public Object getItem(int position) {
            return imageIDs[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setImageResource(imageIDs[position]);
                imageView.setLayoutParams(new GridView.LayoutParams(50,50));
            } else {
                imageView = (ImageView)convertView;
            }
            return imageView;
        }

    }
}
