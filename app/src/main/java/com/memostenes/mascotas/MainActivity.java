package com.memostenes.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.memostenes.mascotas.adapter.MascotaAdaptador;
import com.memostenes.mascotas.adapter.PageAdapter;
import com.memostenes.mascotas.fragment.PerfilFragment;
import com.memostenes.mascotas.fragment.ReciclerViewFragment;
import com.memostenes.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Toolbar miActionBar;// = (Toolbar) findViewById(R.id.miActionBar);
    private TabLayout tabLayout;
    private ViewPager viewPager;
//    Mascota m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout)  findViewById(R.id.tabLayout);
        viewPager = (ViewPager)  findViewById(R.id.viewPager);
        setUpViewPager();


        if (miActionBar!=null){
            setSupportActionBar(miActionBar);
        }


        /*
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        */
  //      m = new Mascota("Rosco", 0, R.drawable.perro1);

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ReciclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
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
            case R.id.mContacto:
                //Toast.makeText(getApplicationContext(), "se presiono", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Contacto.class);
                startActivity(intent);
                return true;
            case R.id.mAcerca:
                Intent intent2 = new Intent(this, Acerca.class);
                startActivity(intent2);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    public void favoritos(View v){
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
        for (int vu=1; vu<=5; vu++){
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
    }

}
