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
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //    public void extraerMatricula(final String matricula) {
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("clients");
//        query.whereEqualTo("plate", matricula.toUpperCase());
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List objects, ParseException e) {
//                if (e == null) {
//                    int len = objects.size();
//                    for (int i = 0; i < len; i++) {
//                        ParseObject p = (ParseObject) objects.get(i);
//                        String matricula = p.getString("plate");
//                        matriculaEdit.setText(matricula);
//                    }
//                } else {
//                    Log.d("clients", "Error: " + e.getMessage());
//                }
//            }
//        });
//    }
    public void back(View view) {
        Intent intent = new Intent(this, IntroMatricula.class);
        startActivity(intent);
        finish();
    }

}
