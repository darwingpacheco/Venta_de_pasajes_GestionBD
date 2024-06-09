package com.example.ventapasajes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ventapasajes.dataPasaje.DataAllVentaPasaje;
import com.example.ventapasajes.dataPasaje.SingletonData;

public class ActivityDetalleVenta extends AppCompatActivity {

    private TextView detail_positionAsientos, detail_numAsientos, detail_numBus, detail_placaBus,
            detail_nameChofer, detail_destino, detail_origen, detail_nunPhone, detail_nunDocument, detail_nameUser;

    private DataAllVentaPasaje dataAllVentaPasaje = SingletonData.getInstance().getDataAllVentaPasaje();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_venta);

        detail_positionAsientos = findViewById(R.id.detail_positionAsientos);
        detail_numAsientos = findViewById(R.id.detail_numAsientos);
        detail_numBus = findViewById(R.id.detail_numBus);
        detail_placaBus = findViewById(R.id.detail_placaBus);
        detail_nameChofer = findViewById(R.id.detail_nameChofer);
        detail_destino = findViewById(R.id.detail_destino);
        detail_origen = findViewById(R.id.detail_origen);
        detail_nunPhone = findViewById(R.id.detail_nunPhone);
        detail_nunDocument = findViewById(R.id.detail_nunDocument);
        detail_nameUser = findViewById(R.id.detail_nameUser);

        // Obtener los datos del Singleton
        dataAllVentaPasaje = SingletonData.getInstance().getDataAllVentaPasaje();

        // Llenar los campos con los datos obtenidos
        if (dataAllVentaPasaje != null) {
            detail_positionAsientos.setText(dataAllVentaPasaje.getAsientosSeleccionados().toString());
            detail_numAsientos.setText(String.valueOf(dataAllVentaPasaje.getCantidadPuestos()));
            detail_numBus.setText(dataAllVentaPasaje.getNumeroBusRecogida());
            detail_placaBus.setText(dataAllVentaPasaje.getPlacaBusRecogida());
            detail_nameChofer.setText(dataAllVentaPasaje.getNombreChoferRecogida());
            detail_destino.setText(dataAllVentaPasaje.getUbicacionDestino());
            detail_origen.setText(dataAllVentaPasaje.getUbicacionOrigen());
            detail_nunPhone.setText(dataAllVentaPasaje.getNumTelefonoPasajero());
            detail_nunDocument.setText(dataAllVentaPasaje.getNumDocumentoPasajero());
            detail_nameUser.setText(dataAllVentaPasaje.getNombrePasajero());
        }
    }
}
