package com.iniciosaga.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editValue;
    private TextView percentText;
    private SeekBar seekBarTip;
    private TextView tipResult;
    private TextView total;
    private float percent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValue = findViewById(R.id.editValue);
        percentText = findViewById(R.id.percentText);
        seekBarTip = findViewById(R.id.seekBarTip);
        tipResult = findViewById(R.id.tipResult);
        total = findViewById(R.id.total);

        seekBarTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                percent = i;
                percentText.setText(Math.round(percent)+"%");
                calculate();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void calculate() {
        String recoveredValue = editValue.getText().toString();
        if(recoveredValue == null || recoveredValue.equals("")) {
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor para prosseguir!",
                    Toast.LENGTH_LONG
            ).show();
        } else {
            double typedValue = Double.parseDouble(recoveredValue);
            double tip = typedValue * (percent/100);
            tipResult.setText("R$ " + Math.round(tip));
            double result = typedValue + tip;
            total.setText("R$ " + Math.round(result));
        }
    }
}