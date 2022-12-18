package com.example.dbg103;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.dbg103.Adaptadores.productoAdapter;
//import com.example.dbg103.DB.DBHelper;
import com.example.dbg103.DB.DBFirebase;
import com.example.dbg103.Entidades.Producto;
//import com.example.dbg103.Servicios.ProductoService;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {
    //private DBHelper dbHelper;
    //private ProductoService productoService;
    private ListView listViewProducts;
    private productoAdapter productAdapter;
    private ArrayList<Producto> arrayProductos;
    private DBFirebase dbFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        dbFirebase = new DBFirebase();

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        arrayProductos = new ArrayList<>();
        /*/*************
        Producto producto1 = new Producto("Producto1", "Desc1", "1000", String.valueOf(R.drawable.pp1));
        Producto producto2 = new Producto("Producto2", "Desc2", "2000", String.valueOf(R.drawable.pp2));
        Producto producto3 = new Producto("Producto3", "Desc3", "3000", String.valueOf(R.drawable.pp3));
        Producto producto4 = new Producto("Producto4", "Desc4", "4000", String.valueOf(R.drawable.pp4));
        Producto producto5 = new Producto("Producto5", "Desc5", "4000", String.valueOf(R.drawable.pp5));
        Producto producto6 = new Producto("Producto6", "Desc6", "4000", String.valueOf(R.drawable.pp6));

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
        arrayProductos.add(producto5);
        arrayProductos.add(producto6);
        //***************/
        productAdapter = new productoAdapter(this, arrayProductos);
        listViewProducts.setAdapter(productAdapter);

        dbFirebase.getData(productAdapter);

/*
        try {
            dbHelper = new DBHelper(this);
            byte[] img = "".getBytes(StandardCharsets.UTF_8);

            dbHelper.insertProduct("Producto1", "Descripcion1", "1000", img);
            dbHelper.insertProduct("Producto2", "Descripcion2", "2000", img);
            dbHelper.insertProduct("Producto3", "Descripcion3", "3000", img);
            dbHelper.insertProduct("Producto4", "Descripcion4", "4000", img);

            //productoService = new ProductoService();
            //arrayProductos = productoService.cursorToArray(dbHelper.getProducts());
            Toast.makeText(this,"Insert OK", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Log.e("DB", e.toString());*/
    }



}