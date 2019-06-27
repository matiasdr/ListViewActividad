package com.example.listviewactividad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MensajeActivity extends AppCompatActivity {
    TextView txtRemitente;
    TextView txtAsunto;
    TextView txtMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        Bundle extras = getIntent().getExtras();

        txtRemitente = findViewById(R.id.txtRemitente);
        txtAsunto = findViewById(R.id.txtAsunto);
        txtMensaje = findViewById(R.id.txtMensaje);

        txtRemitente.setText(extras.getString("KEY_REMITENTE") + " - " + extras.getString("KEY_MAIL"));
        txtAsunto.setText(extras.getString("KEY_ASUNTO"));
        txtMensaje.setText(extras.getString("KEY_CUERPO"));

    }
}
