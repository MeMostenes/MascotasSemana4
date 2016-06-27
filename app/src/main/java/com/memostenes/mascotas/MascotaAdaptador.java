package com.memostenes.mascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by memo on 24/06/16.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota>mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewholder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewholder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewholder.tvNombre.setText(mascota.getNombre());
        mascotaViewholder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        mascotaViewholder.imgHB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(activity, "un hueso para "+mascota.getNombre(), Toast.LENGTH_SHORT).show();
                int x = mascota.getLikes();
                x++;
                mascota.setLikes(x);
                mascotaViewholder.tvLikes.setText(String.valueOf(x));

            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private ImageButton imgHB;
        private ImageView imgHA;
        private TextView tvNombre;
        private TextView tvLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            imgHB = (ImageButton) itemView.findViewById(R.id.imgHB);
            imgHA = (ImageView) itemView.findViewById(R.id.imgHA);
            tvNombre = (TextView ) itemView.findViewById(R.id.tvNombre);
            tvLikes = (TextView ) itemView.findViewById(R.id.tvLikes);
        }
    }
}
