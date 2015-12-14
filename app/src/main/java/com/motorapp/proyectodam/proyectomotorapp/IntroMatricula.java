package com.motorapp.proyectodam.proyectomotorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntroMatricula extends AppCompatActivity implements View.OnClickListener{
    private EditText matriculaEdit;
    private Button siguiente, find;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_matricula);
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

        siguiente = (Button) findViewById(R.id.Siguientebtn);
        siguiente.setOnClickListener(this);
        find = (Button) findViewById(R.id.searchBtn);
        find.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        buscarMatricula();
    }

    public void buscarMatricula() {
        String userMatriculaStr;
        matriculaEdit = (EditText) findViewById(R.id.findMatricula);

        // Retrieve the text entered from the EditText
        userMatriculaStr = matriculaEdit.getText().toString().toUpperCase();

        // Force user to fill up the form
        if (userMatriculaStr.equals("")) {
            //VENTANA EMERGENTE RELLENAR CAMPOS VACIOS
            Toast.makeText(getApplicationContext(),
                    "Por favor introduzca una Matrícula",
                    Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this,DatosCliente.class);
            intent.putExtra("matricula", userMatriculaStr);
            startActivity(intent);
        }
    }

    public void lanzarDatosCliente(View v){
        Intent intent= new Intent(this,DatosCliente.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
