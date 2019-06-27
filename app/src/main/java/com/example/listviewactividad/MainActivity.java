package com.example.listviewactividad;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout swipe;
    List<Contacto> contactoList;
    ContactoAdapter contactoAdapter;
    ListView listViewContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactoList = new ArrayList<>();

        CargarLista();

        swipe =findViewById(R.id.Swipe);



        listViewContactos = findViewById(R.id.ListViewContactos);
        contactoAdapter= new ContactoAdapter(contactoList);
        listViewContactos.setAdapter(contactoAdapter);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                CargarLista2();

                contactoAdapter.notifyDataSetChanged();
                
                swipe.setRefreshing(false);
            }
        });

        listViewContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacto contacto= contactoList.get(position);

                Toast.makeText(parent.getContext(), "El usuario selecciono "+ contacto.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void CargarLista(){
        //contactoList = new ArrayList<>();

        contactoList.clear();
        contactoList.add(new Contacto("Matias", "Draeger", "1521211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.officer));
        contactoList.add(new Contacto("Matias", "Draeger", "15217211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.officer));
        contactoList.add(new Contacto("Matias", "Draeger", "15211211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.administrator));
        contactoList.add(new Contacto("Matias", "Draeger", "15231211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.logo));
        contactoList.add(new Contacto("Matias", "Draeger", "15221211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.administrator));
        contactoList.add(new Contacto("Matias", "Draeger", "15251211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.officer));
        contactoList.add(new Contacto("Matias", "Draeger", "15241211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.administrator));
        contactoList.add(new Contacto("Matias", "Draeger", "15216211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.officer));
        contactoList.add(new Contacto("Matias", "Draeger", "152.1211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.administrator));
    }

    void CargarLista2(){
       // contactoList = new ArrayList<>();
        contactoList.clear();
        contactoList.add(new Contacto("Matias", "Draeger", "15211211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.administrator));
        contactoList.add(new Contacto("Matias", "Draeger", "15231211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.logo));
        contactoList.add(new Contacto("Matias", "Draeger", "15221211", "su casa", "sumaill@hotamilkk.com.ar", R.drawable.administrator));

    }
}
