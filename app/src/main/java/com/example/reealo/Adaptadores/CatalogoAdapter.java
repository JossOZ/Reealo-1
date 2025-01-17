package com.example.reealo.Adaptadores;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.reealo.Clases.Producto;
import com.example.reealo.R;

import java.util.List;

public class CatalogoAdapter extends RecyclerView.Adapter<CatalogoAdapter.MyViewHolder> implements View.OnClickListener {

    // TODO> Instancias que vamos a necesitarr
    private List<Producto> productoList;
    private View.OnClickListener listener;

    // TODO: Constructor
    public CatalogoAdapter(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    // TODO: Obtenemos los valores de la vista
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView nombre, stock, precio, precioOerta;

        public MyViewHolder(View view) {
            super(view);
            imagen = (ImageView) view.findViewById(R.id.imageViewProducto);
            //nombre = (TextView) view.findViewById(R.id.lblNombre);
            stock = (TextView) view.findViewById(R.id.lblStock);
            precio = (TextView) view.findViewById(R.id.lblPrecio);
            precio.setPaintFlags(precio.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG); // va a tachar el texto
            precioOerta = (TextView) view.findViewById(R.id.lblPrecioOferta);
        }
    }

    // TODO: Creamos el RecyclerView para la lista de productos
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.productos_fila, parent, false);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_catalogo, parent, false);
        itemView.setOnClickListener(this);
        return new MyViewHolder(itemView);
    }

    // TODO: Actualiza el contenido de RecyclerView.ViewHolder con el elemento en la posición dada
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Producto producto = productoList.get(position);
        holder.imagen.setImageResource(producto.getIdImagen());
        //holder.nombre.setText(producto.getNombre());
        holder.stock.setText(producto.getStock());
        holder.precio.setText(producto.getPrecio());
        holder.precioOerta.setText(producto.getPrecioOferta());


    }

    // TODO: Devuelve el número total de elementos en el conjunto de datos que posee el adaptador.
    @Override
    public int getItemCount() {
        return productoList.size();
    }

    // TODO: Implementar el método onClick para el RecyclerView
    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }

}