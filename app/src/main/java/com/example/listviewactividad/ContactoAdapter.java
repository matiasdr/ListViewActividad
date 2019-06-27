package com.example.listviewactividad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ContactoAdapter extends BaseAdapter {
    List<Contacto> contactoList;

    public ContactoAdapter(List<Contacto> contactoList){
        this.contactoList=contactoList;
    }

    @Override
    public int getCount() {
        return contactoList.size();
    }

    @Override
    public Contacto getItem(int position) {
        return contactoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;

        // Optimizar recursos
        if(convertView==null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_contacto, null);
        }else{
            view = convertView;
        }

        final Contacto item = getItem(position);

        TextView textViewNombre = view.findViewById(R.id.textViewNombre);
        TextView textViewMail = view.findViewById(R.id.textViewMail);
        TextView textViewTelefono = view.findViewById(R.id.textViewTelefono);
        ImageView imageViewFoto = view.findViewById(R.id.imageViewFoto);
        ImageButton btnLlamar = view.findViewById(R.id.btnLlamar);

        textViewNombre.setText(item.getNombre()+" "+ item.getApellido());
        textViewMail.setText(item.getEmail());
        textViewTelefono.setText(item.getTelefono());

        imageViewFoto.setImageResource(item.getFoto());

        btnLlamar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), "Llamando "+item.getTelefono(), Toast.LENGTH_SHORT).show();

            }

        });

        return view;
    }
}
