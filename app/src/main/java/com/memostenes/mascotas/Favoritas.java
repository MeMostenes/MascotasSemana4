package com.memostenes.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.memostenes.mascotas.adapter.MascotaAdaptador;
import com.memostenes.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button btnEstrella = (Button) findViewById(R.id.btEstrella);
        btnEstrella.setVisibility(View.GONE);
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        //ArrayList<Mascota> mascotas = getIntent().getParcelableExtra("mascotas");
        //Bundle p = getIntent().getExtras();
        //Mascota m = getIntent().getParcelableExtra("uno");
        //TextView tvPrueba = (TextView)findViewById(R.id.tvPrueba);
        //tvPrueba.setText(m.getNombre());
        //tvPrueba.setText(mascotas.get(0).getNombre());
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        //getIntent().getParcelableExtra("uno");
        Mascota m = getIntent().getParcelableExtra("uno");;
        mascotas.add(m);
        m = getIntent().getParcelableExtra("dos");
        mascotas.add(m);
        m = getIntent().getParcelableExtra("tres");
        mascotas.add(m);
        m = getIntent().getParcelableExtra("cuatro");
        mascotas.add(m);
        m = getIntent().getParcelableExtra("cinco");
        mascotas.add(m);
        /*mascotas.add(new Mascota("Rosco", 0, R.drawable.perro1));
        mascotas.add(new Mascota("Tracy", 0, R.drawable.perro2));
        mascotas.add(new Mascota("Juancho", 0, R.drawable.perro4));
        mascotas.add(new Mascota("Lula", 0, R.drawable.perro5));
        mascotas.add(new Mascota("Chenta", 0, R.drawable.perro3));
        mascotas.add(new Mascota("Tayson", 0, R.drawable.perro6));
        mascotas.add(new Mascota("Fido", 0, R.drawable.perro7));
        mascotas.add(new Mascota("Lasy", 0, R.drawable.perro8));
        mascotas.add(new Mascota("Wero", 0, R.drawable.perro9));
        mascotas.add(new Mascota("Greñas", 0, R.drawable.perro10));
        */
    }
}
