package com.motorapp.proyectodam.proyectomotorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.motorapp.proyectodam.proyectomotorapp.Data.CarsEntry;

public class DatosTarea extends AppCompatActivity {

    private EditText matriculaEdit, descriptionEdit, ownerEdit;
    private String matricula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_tarea);
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
        matricula = intent.getStringExtra("matricula").toUpperCase();

        matriculaEdit = (EditText) findViewById(R.id.matriculaEditText);
        descriptionEdit = (EditText) findViewById(R.id.descriptionEditText);
        ownerEdit = (EditText) findViewById(R.id.ownerEditText);

//        matriculaEdit.setText(matricula);
    }

    public void onClick(View view) {
        String userMatriculaStr = matriculaEdit.getText().toString().toUpperCase();
        String userDescriptionStr = descriptionEdit.getText().toString().toUpperCase();
        String userOwnerStr = ownerEdit.getText().toString().toUpperCase();

        if (userDescriptionStr.equals("") || userOwnerStr.equals("") || userMatriculaStr.equals("")) {
            //TOAST RELLENAR CAMPOS VACIOS
            Toast.makeText(getApplicationContext(),
                    "Por favor completa los campos vacios",
                    Toast.LENGTH_LONG).show();
        } else {
            insertarNuevaTarea(userMatriculaStr, userDescriptionStr, userOwnerStr);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void insertarNuevaTarea(String Matricula, String Descrip, String Owner) {
    }

    public void back(View view) {
        Intent intent = new Intent(this, IntroMatricula.class);
        startActivity(intent);
        finish();
    }

}
