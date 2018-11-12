package com.example.myassist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Float;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private float holdPrice_t;
    private float holdShare_t;
    private float currPrice_t;
    private float changePercent_t;
    private float targetPrice_t;
    private float result_t;
    Button startCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startCal = (Button) findViewById(R.id.start_cal);

        startCal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_cal:
                EditText holdPrice = (EditText) findViewById(R.id.show_hold_price);
                EditText holdShare = (EditText) findViewById(R.id.show_hold_share);
                EditText currPrice = (EditText) findViewById(R.id.show_curr_price);
                EditText changePercent = (EditText) findViewById(R.id.show_change_percent);
                EditText targetPrice = (EditText) findViewById(R.id.show_target_price);
                TextView result = (TextView) findViewById(R.id.show_result);

                holdPrice_t = Float.parseFloat(holdPrice.getText().toString());
                holdShare_t = Float.parseFloat(holdShare.getText().toString());
                currPrice_t = Float.parseFloat(currPrice.getText().toString());
                changePercent_t = Float.parseFloat(changePercent.getText().toString());
                currPrice_t = currPrice_t * (1 + changePercent_t/100);
                targetPrice_t = Float.parseFloat(targetPrice.getText().toString());

                result_t = ((holdPrice_t - targetPrice_t) * holdShare_t * currPrice_t)/(targetPrice_t - currPrice_t);
                result.setText(Float.toString(result_t));
                //result_t = holdPrice_t;
                //result.setText(Float.toString(result_t));
                //Toast.makeText(this, Float.toString(changePercent_t), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, Float.toString(currPrice_t), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
