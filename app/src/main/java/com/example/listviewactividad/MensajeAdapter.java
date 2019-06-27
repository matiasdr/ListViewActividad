package com.example.listviewactividad;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.listviewactividad.Mensaje;
import java.util.List;

public class MensajeAdapter extends BaseAdapter {

    List<Mensaje> mensajeList;

    public MensajeAdapter(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    @Override
    public int getCount() {
        return mensajeList.size();
    }

    @Override
    public Mensaje getItem(int position) {
        return mensajeList.get(position);
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
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_mail, null);
        }else{
            view = convertView;
        }

        final Mensaje item = getItem(position);

        TextView txtAsunto= view.findViewById(R.id.txtAsunto);
        TextView txtCuerpo = view.findViewById(R.id.txtMensaje);
        TextView txtIcono = view.findViewById(R.id.txtIcono);

        txtAsunto.setText(item.getAsunto());
        if(item.getCuerpo().length()>50){
            txtCuerpo.setText(item.getCuerpo().substring(0,50));
        } else{
            txtCuerpo.setText(item.getCuerpo());
        }

        txtIcono.setText(item.getContacto().toString().substring(0,1));
        txtIcono.getBackground().setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC);

        return view;
    }
}
