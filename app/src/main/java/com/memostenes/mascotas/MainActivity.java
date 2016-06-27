package com.memostenes.mascotas;

import android.content.Intent;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
//    Mascota m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
  //      m = new Mascota("Rosco", 0, R.drawable.perro1);

    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Rosco", 0, R.drawable.perro1));
        mascotas.add(new Mascota("Tracy", 0, R.drawable.perro2));
        mascotas.add(new Mascota("Juancho", 0, R.drawable.perro4));
        mascotas.add(new Mascota("Lula", 0, R.drawable.perro5));
        mascotas.add(new Mascota("Chenta", 0, R.drawable.perro3));
        mascotas.add(new Mascota("Tayson", 0, R.drawable.perro6));
        mascotas.add(new Mascota("Fido", 0, R.drawable.perro7));
        mascotas.add(new Mascota("Lasy", 0, R.drawable.perro8));
        mascotas.add(new Mascota("Wero", 0, R.drawable.perro9));
        mascotas.add(new Mascota("Greñas", 0, R.drawable.perro10));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        //return true;
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.estrella:
                //Toast.makeText(getApplicationContext(), "se presiono", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Favoritas.class);
               // intent.putExtra("mascotass", (Parcelable) mascotas.get(0));

                //intent.putExtra("te", m);

                //ORDENAR LOS LIKES PARA EN LA SIGUIENTE VENTANA SOLO MOSTRAR LOS 5 MAS LIKEADOS
                int likes[]= new int[10];
                for (int i=0; i<mascotas.size(); i++){
                    likes[i] = mascotas.get(i).getLikes();
                   // Log.i("likes", String.valueOf(likes[i]));
                   // System.out.println(likes[i]);
                }
                int actual=0;
                int may;
                int mayores[] = new int[5];
                for (int v=1; v<=5; v++){
                    may = actual;
                    for(int i=0; i<10; i++ ){
                        if(likes[may]<likes[i]){
                            may=i;
                        }
                    }
                    mayores[actual]=may;
                    System.out.println(mayores[actual]);
                    likes[may]=-1;
                    //int t=likes[actual];

                    //likes[actual] = likes[may];
                    //likes[may] = t;
                    actual++;
                }
                /*intent.putExtra("uno", mascotas.get(9));
                intent.putExtra("dos", mascotas.get(8));
                intent.putExtra("tres", mascotas.get(7));
                intent.putExtra("cuatro", mascotas.get(6));
                intent.putExtra("cinco", mascotas.get(5));*/
                intent.putExtra("uno", mascotas.get(mayores[0]));
                intent.putExtra("dos", mascotas.get(mayores[1]));
                intent.putExtra("tres", mascotas.get(mayores[2]));
                intent.putExtra("cuatro", mascotas.get(mayores[3]));
                intent.putExtra("cinco", mascotas.get(mayores[4]));

                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
