package com.example.ventapasajes;

import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ventapasajes.adapter.Chofer;
import com.example.ventapasajes.adapter.ChoferAdapter;
import com.example.ventapasajes.dataPasaje.DataAllVentaPasaje;
import com.example.ventapasajes.dataPasaje.SingletonData;

import java.util.ArrayList;
import java.util.List;

public class chofer_buseta extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChoferAdapter driverAdapter;
    private List<Chofer> listaChoferes;
    private FrameLayout firstPassengerContainer;
    private CardView cardViewChoferes;
    private DataAllVentaPasaje dataAllVentaPasaje = SingletonData.getInstance().getDataAllVentaPasaje();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chofer_buseta);

        recyclerView = findViewById(R.id.recycler_view);
        firstPassengerContainer = findViewById(R.id.first_passenger_container);
        cardViewChoferes = findViewById(R.id.cardViewChoferes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Datos de ejemplo
        listaChoferes = new ArrayList<>();
        listaChoferes.add(new Chofer("Ana García", "XYZ-456", "Bus 202"));
        listaChoferes.add(new Chofer("Juan Pérez", "ABC-123", "Bus 101"));
        listaChoferes.add(new Chofer("Carlos López", "LMN-789", "Bus 303"));

        if (!listaChoferes.isEmpty()) {
            showFirstPassenger(listaChoferes.get(0));

            List<Chofer> remainingChoferes = listaChoferes.subList(1, listaChoferes.size());
            driverAdapter = new ChoferAdapter(remainingChoferes);
            recyclerView.setAdapter(driverAdapter);
        }
    }

    private void showFirstPassenger(final Chofer chofer) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View firstPassengerView = inflater.inflate(R.layout.item_driver, firstPassengerContainer, false);

        TextView driverName = firstPassengerView.findViewById(R.id.driver_name);
        TextView driverPlateNumber = firstPassengerView.findViewById(R.id.driver_plate_number);
        TextView busNumber = firstPassengerView.findViewById(R.id.bus_number);

        driverName.setText(chofer.getNombre());
        driverPlateNumber.setText(chofer.getNumeroPlaca());
        busNumber.setText(chofer.getNumeroBuseta());

        firstPassengerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataAllVentaPasaje.setNombreChoferRecogida(chofer.getNombre());
                dataAllVentaPasaje.setPlacaBusRecogida(chofer.getNumeroPlaca());
                dataAllVentaPasaje.setNumeroBusRecogida(chofer.getNumeroBuseta());
                Intent intent = new Intent(chofer_buseta.this, ActivitySeleccionAsientos.class);
                startActivity(intent);
            }
        });

        firstPassengerContainer.addView(firstPassengerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
