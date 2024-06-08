package com.example.ventapasajes;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ventapasajes.dataPasaje.DataAllVentaPasaje;

import java.util.ArrayList;
import java.util.List;

public class ActivitySeleccionAsientos extends AppCompatActivity {

    private TextView countSelectAsientos;
    private boolean[] selectedSeats = new boolean[9];
    private List<Integer> selectedSeatNumbers = new ArrayList<>();
    private DataAllVentaPasaje dataAllVentaPasaje = new DataAllVentaPasaje();

    private int[] buttonIds = {
            R.id.asientoOne, R.id.asientoDos, R.id.asientoTres,
            R.id.asientoCuatro, R.id.asientoCinco, R.id.asientoSeis,
            R.id.asientoSiete, R.id.asientoOcho, R.id.asientoNueve
    };
    private int[] drawableWhiteIds = {
            R.drawable.onewhite, R.drawable.twowhite, R.drawable.threewhite,
            R.drawable.fourwhite, R.drawable.fivewhite, R.drawable.sixwhite,
            R.drawable.sevenwhite, R.drawable.eightwhite, R.drawable.ninewhite
    };
    private int[] drawableSelectedIds = {
            R.drawable.onegreen, R.drawable.twogreen, R.drawable.threegreen,
            R.drawable.fourgreen, R.drawable.fivegreen, R.drawable.sixgreen,
            R.drawable.sevengreen, R.drawable.eightgreen, R.drawable.ninegreen
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_asientos);

        countSelectAsientos = findViewById(R.id.countSelectAsientos);

        for (int i = 0; i < buttonIds.length; i++) {
            ImageButton seatButton = findViewById(buttonIds[i]);
            int finalI = i;
            seatButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedSeats[finalI]) {
                        seatButton.setBackgroundResource(drawableWhiteIds[finalI]);
                        selectedSeatNumbers.remove(Integer.valueOf(finalI + 1));
                    } else {
                        seatButton.setBackgroundResource(drawableSelectedIds[finalI]);
                        selectedSeatNumbers.add(finalI + 1);
                    }
                    selectedSeats[finalI] = !selectedSeats[finalI];
                    int countAsientos = selectedSeatNumbers.size();
                    countSelectAsientos.setText(String.valueOf(countAsientos));

                    // Update the DataAllVentaPasaje instance
                    dataAllVentaPasaje.setAsientosSeleccionados(new ArrayList<>(selectedSeatNumbers));
                }
            });
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
