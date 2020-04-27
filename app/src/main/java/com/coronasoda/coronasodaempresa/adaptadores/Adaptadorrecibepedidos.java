package com.coronasoda.coronasodaempresa.adaptadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.coronasoda.coronasodaempresa.MainActivity;
import com.coronasoda.coronasodaempresa.R;
import com.coronasoda.coronasodaempresa.modelos.PedidoRealmFirebase;

import java.util.ArrayList;
import java.util.List;

public class Adaptadorrecibepedidos extends RecyclerView.Adapter<Adaptadorrecibepedidos.AdaptadorViewHolder>  {
private Context mainContext;
        String foto;
        SharedPreferences prefs;
        String FileName ="myfile";

public ArrayList<PedidoRealmFirebase> items;
public Adaptadorrecibepedidos(ArrayList<PedidoRealmFirebase> items, MainActivity contexto){
        this.mainContext=contexto;
        this.items=items;


        }
static class AdaptadorViewHolder extends RecyclerView.ViewHolder{
    protected TextView direccion;
    protected TextView nombrecliente;
    protected TextView referencia;
    protected TextView totalapagar;
    protected TextView cuantodaelcliente;
    protected TextView vuelto;
    protected TextView telefono;
    protected Button aceptar;
    protected Button rechazar;
    public AdaptadorViewHolder(View v){
        super(v);
        this.direccion=(TextView) v.findViewById(R.id.direccion);
        this.nombrecliente=(TextView) v.findViewById(R.id.nombrecliente);
        this.referencia=(TextView) v.findViewById(R.id.referencias);
        this.totalapagar=(TextView) v.findViewById(R.id.totalapagar);
        this.cuantodaelcliente=(TextView) v.findViewById(R.id.cuantopaga);
        this.vuelto=(TextView) v.findViewById(R.id.vuelto);
        this.telefono=(TextView) v.findViewById(R.id.telefono);

    }
}


    @Override
    public Adaptadorrecibepedidos.AdaptadorViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tarjetapedidos,viewGroup,false);
        return new Adaptadorrecibepedidos.AdaptadorViewHolder(v);
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final Adaptadorrecibepedidos.AdaptadorViewHolder viewHolder, final int position) {
        final PedidoRealmFirebase item = items.get(position);
        viewHolder.itemView.setTag(item);
        viewHolder.direccion.setText(String.valueOf(item.getDireccionallevar()));
        viewHolder.nombrecliente.setText(item.getNombreusuario());
        viewHolder.referencia.setText(String.valueOf(item.getReferencias()));
        viewHolder.totalapagar.setText(String.valueOf(item.getTotalpedido()));
        viewHolder.cuantodaelcliente.setText(String.valueOf(item.getCuantopagaecliente()));
        viewHolder.vuelto.setText(String.valueOf(item.getVuelto()));
        viewHolder.telefono.setText(String.valueOf(item.getTelefono()));



      /*  viewHolder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String producto=items.get(position).getProducto();
                String subtotal =String.valueOf(items.get(position).getTotal());

                      int numerito= G.capturariddedetalledeprodysubtotal(producto,subtotal);
///Toast.makeText(mainContext,"el id de detalle"+String.valueOf(numerito),Toast.LENGTH_LONG).show();


                //int tr= Crudetallepedido.calculateIndex();
                //int iddedetalles=Crudetallepedido.calculateIndex();



                G.eliminaraunTotalcrema(numerito);
                G.eliminarunTotaladicional(numerito);
                G.eliminarunTOTALdetallepedido(numerito);
                items.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());
                mainContext.recargartotalesisisomos();
mainContext.calculatotal();




            }
        });
    */
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

}

