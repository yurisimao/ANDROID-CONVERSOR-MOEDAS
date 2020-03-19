package com.yurisimao.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    private static final Double DOLAR_VALUE = 5.08;
    private static final Double EURO_VALUE = 5.43;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);
        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.clearValues();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_calculate) {

            final String value = this.mViewHolder.editValue.getText().toString();

            if (!value.isEmpty()) {

                final double real = Double.valueOf(value);

                this.mViewHolder.textDolar.setText(String.format("%.2f", (real / DOLAR_VALUE)));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (real / EURO_VALUE)));


            } else {
                Toast.makeText(this, this.getString(R.string.informe_value), Toast.LENGTH_LONG).show();
            }

        }

    }

    private void clearValues() {
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.textDolar.setText("");
    }

    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}
