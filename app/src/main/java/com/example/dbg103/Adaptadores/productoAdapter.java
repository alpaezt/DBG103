package com.example.dbg103.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dbg103.Entidades.Producto;
import com.example.dbg103.Info;
import com.example.dbg103.R;

import java.util.ArrayList;

public class productoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> arrayProductos;

    public productoAdapter(Context context, ArrayList<Producto> arrayProductos) {
        this.context = context;
        this.arrayProductos = arrayProductos;
    }

    public ArrayList<Producto> getArrayProductos() {
        return arrayProductos;
    }

    public void setArrayProductos(ArrayList<Producto> arrayProductos) {
        this.arrayProductos = arrayProductos;
    }

    @Override
    public int getCount() {
        return arrayProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProductos.get(i);

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.product_template, null);

        Producto producto = arrayProductos.get(i);

        ImageView imgProduct = (ImageView) view.findViewById(R.id.imgProduct);
        TextView tvNameProduct = (TextView) view.findViewById(R.id.tvNameProduct);
        TextView tvDescriptionProduct = (TextView) view.findViewById(R.id.tvDescriptionProduct);
        TextView tvPriceProduct = (TextView) view.findViewById(R.id.tvPriceProduct);
        //Button btnProduct = (Button) view.findViewById(R.id.btnProduct);


        imgProduct.setImageResource(Integer.parseInt(producto.getImage()));
        tvNameProduct.setText(producto.getName());
        tvDescriptionProduct.setText(producto.getDescription());
        tvPriceProduct.setText(producto.getPrice());

        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), Info.class);
                intent.putExtra("id", producto.getId());
                intent.putExtra("name", producto.getName());
                intent.putExtra("description", producto.getDescription());
                intent.putExtra("price", producto.getPrice());
                intent.putExtra("image", producto.getImage());
                context.startActivity(intent);
            }
        });

        return view;
    }
}


