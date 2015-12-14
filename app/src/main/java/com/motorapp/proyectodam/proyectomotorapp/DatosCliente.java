package com.motorapp.proyectodam.proyectomotorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatosCliente extends AppCompatActivity implements View.OnClickListener{
    private EditText matriculaEdit, nombreEdit, apellidoEdit, emailEdit, telefonoEdit, cocheEdit;
    private String matricula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);
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

        nombreEdit = (EditText) findViewById(R.id.nombreEditText);
        apellidoEdit = (EditText) findViewById(R.id.apellidosEditText);
        emailEdit = (EditText) findViewById(R.id.emailEditText);
        telefonoEdit = (EditText) findViewById(R.id.telefonoEditText);
        cocheEdit = (EditText) findViewById(R.id.cocheEditText);
        cocheEdit.setVisibility(View.INVISIBLE);
        matriculaEdit = (EditText) findViewById(R.id.matriculaEditText);

        matriculaEdit.setText(matricula);

        extraerDatosCliente(matricula.toUpperCase());
        extraerDatosCoche(matricula.toUpperCase());
        //Esconde el editText de "coche" si no existe en la bbdd
        String coche = cocheEdit.getText().toString();
        if(coche.equals("")){
            cocheEdit.setVisibility(View.VISIBLE);
        }else{
            cocheEdit.setVisibility(View.INVISIBLE);}

    }
    @Override
    public void onClick(View view) {
        String userApellidosStr = apellidoEdit.getText().toString().toUpperCase();
        String userCocheStr = cocheEdit.getText().toString().toUpperCase();
        String userNombreStr = nombreEdit.getText().toString().toUpperCase();
        String userEmailStr = emailEdit.getText().toString().toUpperCase();
        String userTelefonoStr = telefonoEdit.getText().toString().toUpperCase();
        String userMatriculaStr = matriculaEdit.getText().toString().toUpperCase();

        if (userCocheStr.equals("")) {
            if (userApellidosStr.equals("") || userNombreStr.equals("") || userEmailStr.equals("") || userTelefonoStr.equals("") || userMatriculaStr.equals("")) {
                //TOAST RELLENAR CAMPOS VACIOS
                Toast.makeText(getApplicationContext(),
                        "Por favor completa los campos vacios",
                        Toast.LENGTH_LONG).show();
            } else{
                lanzarNuevoVehiculo(userNombreStr, userApellidosStr, userEmailStr, userTelefonoStr, userMatriculaStr);
            }
        } else {
            //lanzar tarear a realizar
            lanzarVehiculoExiste(matricula);
        }
    }

    public void extraerDatosCliente(final String matricula) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("clients");
        query.whereEqualTo("plate", matricula.toUpperCase());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List objects, ParseException e) {
                if (e == null) {
                    int len = objects.size();
                    for (int i = 0; i < len; i++) {
                        ParseObject p = (ParseObject) objects.get(i);
                        String nombre = p.getString("name");
                        String apellido = p.getString("surname");
                        String email = p.getString("email");
                        String phone = p.getString("phone");
                        nombreEdit.setText(nombre);
                        apellidoEdit.setText(apellido);
                        emailEdit.setText(email);
                        telefonoEdit.setText(phone);
                        extraerDatosCoche(matricula);
                    }
                } else {
                    Log.d("clients", "Error: " + e.getMessage());
                }
            }
        });
    }


    public void extraerDatosCoche(String matricula) {
        //Conecta a Parse y busca el coche por su matrícula. Si existe rellena el campo "coche" con la marca y el modelo.
        ParseQuery<ParseObject> query = ParseQuery.getQuery("cars");
        query.whereEqualTo("plate", matricula.toUpperCase());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List objects, ParseException e) {
                if (e == null) {
                    int len = objects.size();
                    for (int i = 0; i < len; i++) {
                        ParseObject p = (ParseObject) objects.get(i);
                        String marca = p.getString("brand");
                        String modelo = p.getString("model");
                        cocheEdit.setText(marca + " " + modelo);

                    }

                } else {
                    Log.d("clients", "Error: " + e.getMessage());
                }
            }
        });

    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public void lanzarNuevoVehiculo(String nombre, String apellido, String email, String phone, String matricula) {

        Intent intent = new Intent(this, SeleccionarMarca.class);
        intent.putExtra("nombreC", nombre);
        intent.putExtra("apellidoC", apellido);
        intent.putExtra("emailC", email);
        intent.putExtra("phone", phone);
        intent.putExtra("matricula", matricula);
        startActivity(intent);
        finish();
    }

    public void lanzarVehiculoExiste(String matric) {

        Intent intent = new Intent(this, DatosTarea.class);
        intent.putExtra("matricula", matric);
        startActivity(intent);
        finish();
    }

    public void back(View view){
        Intent intent= new Intent(this, IntroMatricula.class);
        startActivity(intent);
        finish();
    }

//    public boolean comprobarCoche(){

//        return false;
//    }
}
