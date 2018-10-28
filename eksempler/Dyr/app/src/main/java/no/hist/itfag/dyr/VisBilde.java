package no.hist.itfag.dyr;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;

public class VisBilde extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vis_dyr);
        settLytter();
        Intent i = getIntent();
        int nr=i.getIntExtra("nr", 0);
        visValgtDyr(nr);
    }
    private void visValgtDyr(int nr) {
        if (nr >= 0) {
            ImageView bildeView = (ImageView)findViewById( R.id.stortBilde);
            TypedArray bilder = getResources().obtainTypedArray(
                    R.array.bilder);
            Drawable bilde = bilder.getDrawable(nr);
            bildeView.setImageDrawable(bilde);
        }
    }
    private void settLytter() {
        ImageView bildeView = (ImageView)findViewById(R.id.stortBilde);
        bildeView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VisBilde.this.finish();
            }
        });
    }
}
