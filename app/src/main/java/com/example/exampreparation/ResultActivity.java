package com.example.exampreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    final String TAG = "MID TERM DEMO - ResultActivity";
    TextView txtViewConvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        try{
            int numInput = 0;
            Bundle bundle = getIntent().getExtras();  // extract the bundle from the previous view intent
            double costR = bundle.getDouble("COST",0);  // extract the "COST" from bundle
            numInput = getIntent().getExtras().getInt("NUMINPUT");  // extract the "NUMINPUT"
            String optionChosen = bundle.getString("OPTION_CHOSEN","NOTHING");  // extract the  "OPTION_CHOSEN"
            DecimalFormat df = new DecimalFormat("#.##");   // format the decimal
            String outputString = "Number of Input: " + numInput + "\n" +
                                    "Option Chosen: " + optionChosen + "\n"+
                                    "Total Cost: " + df.format(costR);
            TextView txtViewResults = findViewById(R.id.txtViewResults);    // get the textView id
            txtViewResults.setText(outputString);   // set the textView display content
            //txtViewResults.setGravity(Gravity.CENTER); // set the text display in horizontal and vertical center
            txtViewResults.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL); // Display in TOP CENTER
        } catch(Exception e){
            e.printStackTrace();
            Log.d(TAG, e.getMessage());
            Toast.makeText(ResultActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        txtViewConvResults = findViewById(R.id.txtViewConvResults);
        RadioGroup radGroupConv = findViewById(R.id.radGroupConv);
        try{
            radGroupConv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                Bundle bundle = getIntent().getExtras();  // extract the bundle from the previous view intent
                double costR = bundle.getDouble("COST",0);
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (i == R.id.radBtnCadToHkd) {
                        Toast.makeText(ResultActivity.this, "Let us convert CAD to HKD", Toast.LENGTH_SHORT).show();
                        DecimalFormat df = new DecimalFormat("HKD $#.##");   // format the decimal
                        txtViewConvResults.setText(df.format(costR*6));
                    } else if (i == R.id.radBtnHkdToCad) {
                        Toast.makeText(ResultActivity.this, "Let us convert HKD to CAD", Toast.LENGTH_SHORT).show();
                        DecimalFormat df = new DecimalFormat("CAD $#.##");   // format the decimal
                        txtViewConvResults.setText(df.format(costR));
                    }
                    //radGroupConv.getcheckedRadioButtionId() --> -1 nothing is onContextItemSelected()
                }
            });
        } catch(Exception e) {
            e.printStackTrace();
            Log.d(TAG, e.getMessage());
            Toast.makeText(ResultActivity.this, "Covert Error", Toast.LENGTH_SHORT).show();
        }

    }
}