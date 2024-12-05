package com.example.prep3so;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = findViewById(R.id.etNumero);
        tvResultado = findViewById(R.id.tvResultado);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularSerie();
            }
        });
    }

    private void calcularSerie() {
        String input = etNumero.getText().toString().trim();
        if (input.isEmpty()) {
            etNumero.setError("Por favor, insira um número!");
            return;
        }

        int n = Integer.parseInt(input);
        if (n <= 0 || n >= 20) {
            Toast.makeText(this, "O número deve estar entre 1 e 19", Toast.LENGTH_LONG).show();
            return;
        }

        double resultado = 0.0;
        for (int i = 1; i <= n; i++) {
            resultado += 1.0 / i;
        }

        tvResultado.setText(String.format("Resultado: %.4f", resultado));
    } }
