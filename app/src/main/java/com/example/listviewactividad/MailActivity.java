package com.example.listviewactividad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MailActivity extends AppCompatActivity {
    List<Mensaje> mensajeList;
    MensajeAdapter mensajeAdapter;
    ListView listViewMensajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_activity);

        mensajeList= new ArrayList<>();

        cargarListaMensajes(mensajeList);

        mensajeAdapter = new MensajeAdapter(mensajeList);

        listViewMensajes = findViewById(R.id.listMail);

        listViewMensajes.setAdapter(mensajeAdapter);

        listViewMensajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mensaje mensaje = mensajeList.get(position);

                Intent intent = new Intent(MailActivity.this, MensajeActivity.class );

                intent.putExtra("KEY_REMITENTE", mensaje.getContacto().toString());
                intent.putExtra("KEY_MAIL", mensaje.getContacto().getEmail());
                intent.putExtra("KEY_ASUNTO", mensaje.getAsunto());
                intent.putExtra("KEY_CUERPO", mensaje.getCuerpo());

                startActivity(intent);


            }
        });



    }


    private void cargarListaMensajes(List<Mensaje> mensajeList) {
        Contacto contacto = new Contacto("mat",
                "drae",
                "152",
                "mam",
                "algo@gmail",
                R.drawable.administrator);
        mensajeList.add(new Mensaje(
                contacto, "holaaa", "mmmmmmmmmm", "#123hhg"
        ));

    }

}
