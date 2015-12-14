package com.motorapp.proyectodam.proyectomotorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SeleccionarMarca extends AppCompatActivity {
    private String marca, matricula, nombreC, apellidoC, emailC, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_marca);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(
                true
        );
        toolbar.setNavigationIcon(R.drawable.arrowleft);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(v);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.hide();

        Intent intent = getIntent();
        matricula = intent.getStringExtra("matricula");
        nombreC = intent.getStringExtra("nombreC");
        apellidoC = intent.getStringExtra("apellidoC");
        emailC = intent.getStringExtra("emailC");
        phone = intent.getStringExtra("phone");
    }

    public void onClick(View view) {
        Button button = (Button) view;
        //Usamos el texto del botón para asignar el nombre de la marca del coche
        marca = button.getText().toString();
        Intent intent = new Intent(this, NuevoVehiculo.class);
        intent.putExtra("nombreC", nombreC);
        intent.putExtra("apellidoC", apellidoC);
        intent.putExtra("emailC", emailC);
        intent.putExtra("phone", phone);
        intent.putExtra("matricula", matricula);
        intent.putExtra("marca", marca);
        startActivity(intent);
    }
    public void back(View view){
        Intent intent= new Intent(this, DatosCliente.class);
        startActivity(intent);
        finish();
    }

}
