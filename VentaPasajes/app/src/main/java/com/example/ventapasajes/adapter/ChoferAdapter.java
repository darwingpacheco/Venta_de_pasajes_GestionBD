package com.example.ventapasajes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ventapasajes.R;

import java.util.List;

public class ChoferAdapter extends RecyclerView.Adapter<ChoferAdapter.DriverViewHolder>{

    private List<Chofer> listaChoferes;

    public ChoferAdapter(List<Chofer> listaChoferes) {
        this.listaChoferes = listaChoferes;
    }

    public static class DriverViewHolder extends RecyclerView.ViewHolder {
        ImageView iconoChofer;
        TextView nombreChofer;
        TextView numeroPlaca;
        TextView numeroBuseta;

        public DriverViewHolder(@NonNull View itemView) {
            super(itemView);
            iconoChofer = itemView.findViewById(R.id.icon_driver);
            nombreChofer = itemView.findViewById(R.id.driver_name);
            numeroPlaca = itemView.findViewById(R.id.driver_plate_number);
            numeroBuseta = itemView.findViewById(R.id.bus_number);
        }
    }

    @NonNull
    @Override
    public DriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_driver, parent, false);
        return new DriverViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverViewHolder holder, int position) {
        Chofer chofer = listaChoferes.get(position);
        holder.nombreChofer.setText(chofer.getNombre());
        holder.numeroPlaca.setText(chofer.getNumeroPlaca());
        holder.numeroBuseta.setText(chofer.getNumeroBuseta());
        // También puedes establecer el ícono del chofer si es necesario
        // holder.iconoChofer.setImageResource(R.drawable.tu_icono);
    }

    @Override
    public int getItemCount() {
        return listaChoferes.size();
    }
}
