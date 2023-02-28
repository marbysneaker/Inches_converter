package com.example.inchesconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inchesText;
    Button calculateButton;
    TextView messageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        inchesText = findViewById(R.id.edit_inches);
        calculateButton = findViewById(R.id.calculate_button);
        messageResult = findViewById(R.id.result_message);
        messageResult.setText("i am starting");
    }

    private void setButtonClicker() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double inchesResult = calculateInches();
                displayResult(inchesResult);
                messageResult.setText("i am working");
            }
        });
    }
    private double calculateInches() {
        String inchesToCalculate = inchesText.getText().toString();
        int inches = Integer.parseInt(inchesToCalculate);

        return inches * .0254;
    }
    private void displayResult(double inchesResult) {
        DecimalFormat myDecimal = new DecimalFormat("0.00");
        String result = myDecimal.format(inchesResult);
        messageResult.setText(result);
    }



}