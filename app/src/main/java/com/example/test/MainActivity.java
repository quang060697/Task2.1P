package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input1;
    TextView unit1, unit2, unit3, resultText1, resultText2, resultText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner unitSpinner = findViewById(R.id.unitSpinner);
        String[] items = new String[]{"Metre", "Celsius", "Kilograms"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        unitSpinner.setAdapter(adapter);

        input1 = findViewById(R.id.input1);

        unit1 = findViewById(R.id.unit1);
        unit2 = findViewById(R.id.unit2);
        unit3 = findViewById(R.id.unit3);

        resultText1 = findViewById(R.id.resultText1);
        resultText2 = findViewById(R.id.resultText2);
        resultText3 = findViewById(R.id.resultText3);

        ImageButton lengthButton = findViewById(R.id.lengthButton);
        ImageButton tempButton = findViewById(R.id.tempButton);
        ImageButton weightButton = findViewById(R.id.weightButton);


        lengthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit = unitSpinner.getSelectedItem().toString();

                if (unit != "Metre") {
                    showAlert();
                } else {

                    unit1.setVisibility(View.VISIBLE);
                    unit2.setVisibility(View.VISIBLE);
                    unit3.setVisibility(View.VISIBLE);

                    resultText1.setVisibility(View.VISIBLE);
                    resultText2.setVisibility(View.VISIBLE);
                    resultText3.setVisibility(View.VISIBLE);

                    unit1.setText("Centimetre");
                    unit2.setText("Foot");
                    unit3.setText("Inch");

                    Float inputResult = Float.parseFloat(input1.getText().toString());

                    Float result1 = inputResult * 100;
                    resultText1.setText(String.format("%.2f", result1));

                    Float result2 = inputResult * (float) 3.2808;
                    resultText2.setText(String.format("%.2f", result2));

                    Float result3 = inputResult * (float) 39.37007874;
                    resultText3.setText(String.format("%.2f", result3));


                }

            }
        });

        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit = unitSpinner.getSelectedItem().toString();

                if (unit != "Celsius") {
                    showAlert();
                } else {
                    unit1.setVisibility(View.VISIBLE);
                    unit2.setVisibility(View.VISIBLE);
                    unit3.setVisibility(View.INVISIBLE);

                    resultText1.setVisibility(View.VISIBLE);
                    resultText2.setVisibility(View.VISIBLE);
                    resultText3.setVisibility(View.INVISIBLE);

                    unit1.setText("Fahrenheit");
                    unit2.setText("Kelvin");

                    Float inputResult = Float.parseFloat(input1.getText().toString());

                    Float result1 = inputResult * 9 / 5 + 32;
                    resultText1.setText(String.format("%.2f", result1));

                    Float result2 = inputResult + (float) 273.15;
                    resultText2.setText(String.format("%.2f", result2));


                }
            }
        });
        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit = unitSpinner.getSelectedItem().toString();

                if (unit != "Kilograms") {
                    showAlert();
                } else {
                    unit1.setVisibility(View.VISIBLE);
                    unit2.setVisibility(View.VISIBLE);
                    unit3.setVisibility(View.VISIBLE);

                    resultText1.setVisibility(View.VISIBLE);
                    resultText2.setVisibility(View.VISIBLE);
                    resultText3.setVisibility(View.VISIBLE);

                    unit1.setText("Gram");
                    unit2.setText("Ounce(Oz)");
                    unit3.setText("Pound(lb)");

                    Float inputResult = Float.parseFloat(input1.getText().toString());

                    Float result1 = inputResult * 100;
                    resultText1.setText(String.format("%.2f", result1));

                    Float result2 = inputResult * (float) 35.274;
                    resultText2.setText(String.format("%.2f", result2));

                    Float result3 = inputResult * (float) 2.20462;
                    resultText3.setText(String.format("%.2f", result3));
                }
            }
        });

    }

    public void showAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Please select the correct conversion icon");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }

}