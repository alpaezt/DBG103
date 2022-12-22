package com.example.nivelacion1234;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.nivelacion1234.Adaptadores.ProductoAdapter;
import com.example.nivelacion1234.DB.DBFirebase;
import com.example.nivelacion1234.Entidades.Producto;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {
    private DBFirebase dbFirebase;
    private ListView listViewProducts;
    private ArrayList<Producto> arrayProductos;
    private ProductoAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        arrayProductos = new ArrayList<>();
        dbFirebase = new DBFirebase();

        /*
        //*********PRODUCTOS QUEMADOS ****
        Producto producto1 = new Producto("Producto1", "Desc1", 1000, "", "", "");
        Producto producto2 = new Producto("Producto2", "Desc2", 2000, "", "", "");
        Producto producto3 = new Producto("Producto3", "Desc3", 3000, "", "", "");
        Producto producto4 = new Producto("Producto4", "Desc4", 4000, "", "", "");
        Producto producto5 = new Producto("Producto5", "Desc5", 5000, "", "", "");
        Producto producto6 = new Producto("Producto6", "Desc6", 6000, "", "", "");

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
        arrayProductos.add(producto5);
        arrayProductos.add(producto6);
        //*************
         */

        productAdapter = new ProductoAdapter(this, arrayProductos);
        listViewProducts.setAdapter(productAdapter);
        dbFirebase.getData(productAdapter);
       }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemAdd:
                intent = new Intent(getApplicationContext(), Form.class);
                startActivity(intent);
                return true;
            case R.id.itemMap:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

/*

        try {
            dbHelper = new DBHelper(this);
            dbFirebase = new DBFirebase();
            productoService = new ProductoService();
            arrayProductos = productoService.cursorToArray(dbHelper.getProducts());

            dbHelper.insertProduct("Producto1", "Descripcion1", "1000", img);
            dbHelper.insertProduct("Producto2", "Descripcion2", "2000", img);
            dbHelper.insertProduct("Producto3", "Descripcion3", "3000", img);
            dbHelper.insertProduct("Producto4", "Descripcion4", "4000", img);
            Toast.makeText(this,"Insert OK", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Log.e("DB", e.toString());


                dbFirebase.getData(ProductoAdapter, arrayProductos);
                }


@Override
public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
        }

@Override
public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_add:
        Intent intent = new Intent(getApplicationContext(), FormProduct.class);
        startActivity(intent);
        return true;
default:
        return super.onOptionsItemSelected(item);
        }
        }
        }
 */