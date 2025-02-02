package com.example.ventapasajes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ActivityVentaPasaje extends AppCompatActivity {

    private Button search_button;
    private CheckBox check_no, check_si;
    private ConstraintLayout time_picker_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_pasaje);

        search_button = findViewById(R.id.search_button);
        check_si = findViewById(R.id.check_si);
        check_no = findViewById(R.id.check_no);
        time_picker_container = findViewById(R.id.time_picker_container);

        check_si.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                check_no.setChecked(false);
                time_picker_container.setVisibility(View.GONE); // Oculta el time_picker_container si se selecciona "SI"
            }
        });

        check_no.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                check_si.setChecked(false);
                time_picker_container.setVisibility(View.VISIBLE); // Muestra el time_picker_container si se selecciona "NO"
            }
        });

        search_button.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityVentaPasaje.this, chofer_buseta.class);
            startActivity(intent);
        });
    }
}