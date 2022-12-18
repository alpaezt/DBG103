package com.example.dbg103.DB;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.dbg103.Adaptadores.productoAdapter;
import com.example.dbg103.Entidades.Producto;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFirebase {
    private FirebaseFirestore db;

    public DBFirebase(){
        this.db = FirebaseFirestore.getInstance();
    }

    public void insertData(Producto producto){
        // Create a new user with a first and last name
        Map<String, Object> prod = new HashMap<>();
        prod.put("id", producto.getId());
        prod.put("name", producto.getName());
        prod.put("description", producto.getDescription());
        prod.put("price", producto.getPrice());
        prod.put("image", producto.getImage());
        db.collection("products").add(prod);
    }

    public void getData(productoAdapter adapter){
        db.collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Producto> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Producto producto = new Producto(
                                        document.getData().get("id").toString(),
                                        document.getData().get("name").toString(),
                                        document.getData().get("description").toString(),
                                        document.getData().get("price").toString(),
                                        document.getData().get("image").toString()
                                );
                                list.add(producto);
                                //Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                            adapter.setArrayProductos(list);
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

}
