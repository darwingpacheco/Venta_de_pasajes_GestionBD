package com.example.ventapasajes;

import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.jakewharton.threetenabp.AndroidThreeTen;

public class MainActivity extends AppCompatActivity {
    private Button venta_de_pasajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        venta_de_pasajes = findViewById(R.id.ventaPsajes);

        AndroidThreeTen.init(this);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        venta_de_pasajes.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ActivityVentaPasaje.class);
            startActivity(intent);
        });
    }
}