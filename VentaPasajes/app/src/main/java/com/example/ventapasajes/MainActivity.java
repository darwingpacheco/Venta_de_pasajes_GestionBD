package com.example.ventapasajes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button venta_de_pasajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        venta_de_pasajes = findViewById(R.id.ventaPsajes);

        venta_de_pasajes.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ActivityVentaPasaje.class);
            startActivity(intent);
        });
    }
}