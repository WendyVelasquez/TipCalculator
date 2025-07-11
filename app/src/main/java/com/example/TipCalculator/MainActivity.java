package com.example.TipCalculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textViewPercent, textViewTipAmount, textViewTotal;
    private SeekBar seekBarTip;

    private EditText editTextBillAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.TipCalculator.R.layout.activity_main);

        textViewPercent = findViewById(R.id.txtViewPercent);
        seekBarTip = findViewById(R.id.seekBarTip);
        editTextBillAmount = findViewById(R.id.txtInputBillAmount);
        textViewTipAmount = findViewById(R.id.txtTipAmount);
        textViewTotal = findViewById(R.id.txtValueTotal);

        seekBarTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewPercent.setText(progress + "%");
                String valueInput = editTextBillAmount.getText().toString();
                if((valueInput.equals("")) || valueInput == null){
                    Toast.makeText(
                            getApplicationContext(),
                            "Enter an amount for calculation",
                            Toast.LENGTH_LONG
                    ).show();
                }else{
                    double amountEntered = Double.parseDouble(valueInput);
                    double percent = progress;
                    double tip = amountEntered *(percent/100);
                    double totalAmount = amountEntered + tip;
                    textViewTipAmount.setText(String.format("%.2f", tip) + "€");
                    textViewTotal.setText(String.format("%.2f",totalAmount) + "€");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}