package com.example.pankaj.app9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.SecureRandom;
import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    private boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editNum1 = findViewById(R.id.editNum1);
        final EditText editNum2 = findViewById(R.id.editNum2);
        final EditText editNum3 = findViewById(R.id.editNum3);
        final TextView txtResult = findViewById(R.id.txtResult);
        final TextView txtSecureRandomNubers = findViewById(R.id.txtSecureRandomNumbers);
        Button btnGetMax = findViewById(R.id.btnMaxValue);
        final Button btnSecureRandonNumbers = findViewById(R.id.btnSecureRandomNumbers);

        btnGetMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(editNum1.getText().toString());
                double num2= Double.parseDouble(editNum2.getText().toString());
                double num3 = Double.parseDouble(editNum3.getText().toString());

                double result = getTheMax(num1,num2,num3);
                txtResult.setText(result + "");
            }
        });

        btnSecureRandonNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstTime){
                   txtSecureRandomNubers.setText("");
                   firstTime = false;
                }
                SecureRandom secureRandomNumber = new SecureRandom();
                String oldTxtSecureRandomNumbersValue = txtSecureRandomNubers.getText().toString();
                if(txtSecureRandomNubers.getText().toString().length() >= 9){
                    btnSecureRandonNumbers.setVisibility(View.GONE);
                }

                int randomSecureNumber = 1 + secureRandomNumber.nextInt(5);
                Log.i("LOG",randomSecureNumber + "");
                txtSecureRandomNubers.setText(  oldTxtSecureRandomNumbersValue    + randomSecureNumber + "");
            }
        });

    }
    public double getTheMax(double num1, double num2, double num3){
        double theMaxValue = 0;
        if (num1> theMaxValue){
            theMaxValue = num1;
        }
        if (num2 > theMaxValue){
            theMaxValue = num2;
        }
        if (num3 > theMaxValue){
            theMaxValue = num3;
        }
        return  theMaxValue;
    }
}
