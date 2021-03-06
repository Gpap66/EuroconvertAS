package com.gpap.euroconvert;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.gpap.euroconvert.R;

public class Main extends Activity {

    TextView apot;
    TextView poun;
    EditText money;
    Calcula result;
    AdView adView;
    double aa;
    private View.OnClickListener ok = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (!poun.getText().toString().equals("") && !money.getText().toString().equals("")) {
                try {
                    aa = result.toEuroKg(
                            Double.parseDouble(money.getText().toString()),
                            Double.parseDouble(poun.getText().toString()));
                    apot.setText(String.valueOf(aa));
                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else {

                //finish();
                Toast.makeText(getApplicationContext(), "kena pedia", Toast.LENGTH_SHORT).show();
            }
            ;

            // TODO Auto-generated method stub

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdRequest adRequest = new AdRequest.Builder().build();
        Button koump = (Button) findViewById(R.id.koum);


        poun = (EditText) findViewById(R.id.poundsLabel);
        money = (EditText) findViewById(R.id.money);
        result = new Calcula();
        apot = (TextView) findViewById(R.id.apotelesmaeurokilo);

        koump.setOnClickListener(ok);


        // Look up the AdView as a resource and load a request.
        adView = (AdView) this.findViewById(R.id.adView);
        //layout = (RelativeLayout)findViewById(R.id.ad);
        adView.loadAd(adRequest);
        Toast.makeText(this, "telos re",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
