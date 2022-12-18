package com.example.dbg103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dbg103.DB.DBFirebase;
import com.example.dbg103.Entidades.Producto;

public class Home extends AppCompatActivity {
    private EditText editName, editDescription, editPrice;
    private Button btnForm;
    private DBFirebase dbFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnForm = (Button) findViewById(R.id.btnForm);
        editName = (EditText) findViewById(R.id.editName);
        editDescription = (EditText) findViewById(R.id.editDescription);
        editPrice = (EditText) findViewById(R.id.editPrice);

        DBFirebase dbFirebase = new DBFirebase();

        /*Intent intentIN = getIntent();
        textName.setText(intentIN.getStringExtra("name"));
        textDescription.setText(intentIN.getStringExtra("description"));
        textPrice.setText(String.valueOf(intentIN.getIntExtra("price", 0)));
        imgInfoProduct.setImageResource(intentIN.getIntExtra("image", 0 ));*/

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto = new Producto(
                        editName.getText().toString(),
                        editDescription.getText().toString(),
                        editPrice.getText().toString(),
                        String.valueOf(R.drawable.pp1)
                );

                dbFirebase.insertData(producto);
                Intent intent = new Intent(getApplicationContext(), Catalogo.class);
                startActivity(intent);

            }
        });

    }
}
