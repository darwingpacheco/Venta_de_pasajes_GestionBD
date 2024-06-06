package com.example.ventapasajes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ventapasajes.adapter.Chofer;
import com.example.ventapasajes.adapter.ChoferAdapter;

import java.util.ArrayList;
import java.util.List;

public class chofer_buseta extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChoferAdapter driverAdapter;
    private List<Chofer> listaChoferes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chofer_buseta);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Datos de ejemplo
        listaChoferes = new ArrayList<>();
        listaChoferes.add(new Chofer("Juan Pérez", "ABC-123", "Bus 101"));
        listaChoferes.add(new Chofer("Ana García", "XYZ-456", "Bus 202"));
        listaChoferes.add(new Chofer("Carlos López", "LMN-789", "Bus 303"));

        driverAdapter = new ChoferAdapter(listaChoferes);
        recyclerView.setAdapter(driverAdapter);


    }
}