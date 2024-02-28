package com.example.exampreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;


public class AnotherActivity extends AppCompatActivity {
    final String TAG = "MID TERM DEMO - AnotherActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        // findViewById must only after setContentView
        EditText editTxtUserInput = findViewById(R.id.editTxtUserInput);
        Spinner spinnerOptions = findViewById(R.id.spinnerOptions);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        spinnerOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            // adapterView is the spinner, view is the particular item in the list, i is the position of item, l is id of the item
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Toast.makeText(AnotherActivity.this, "Clicked on A", Toast.LENGTH_SHORT).show();
                } else if (i == 1){
                    Toast.makeText(AnotherActivity.this, "Clicked on B", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {// only trigger when java set the position to "-1"
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check the editText contain empty string or not
                if (editTxtUserInput.getText().toString().isEmpty()){
                    Toast.makeText(AnotherActivity.this, "message", Toast.LENGTH_SHORT).show();
                } else {
                    try { //if not empty and able to convert to integer
                        int numInput = Integer.parseInt(editTxtUserInput.getText().toString());
                        int selectedInd = spinnerOptions.getSelectedItemPosition();
                        double cost = 0;
                        switch(selectedInd){    // calculate the $ according to the selected spinner
                            case 0: cost = numInput*69.99; break;
                            case 1: cost = numInput*39.99; break;}
                        DecimalFormat df = new DecimalFormat("$#.##"); // set the display format
                        String outputTxt = df.format(cost); // set the output and display to user
                        Toast.makeText(AnotherActivity.this, "Total cost:" + outputTxt, Toast.LENGTH_SHORT).show();

                        // Create a bundle
                        Bundle bundle = new Bundle();
                        // Put data in the bundle
                        bundle.putInt("NUMINPUT", numInput);
                        bundle.putString("OPTION_CHOSEN", spinnerOptions.getSelectedItem().toString());
                        bundle.putDouble("COST", cost);
                        // Create an intent and put the bundle
                        Intent intent = new Intent(AnotherActivity.this, ResultActivity.class);
                        intent.putExtras(bundle);
                        // Start activity with this intent
                        startActivity(intent);
                    } catch (Exception e){
                        e.printStackTrace(); //print stack trace
                        Log.d(TAG, "Error occurred in " + editTxtUserInput.getText().toString());
                        Toast.makeText(AnotherActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}