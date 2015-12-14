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
import com.motorapp.proyectodam.proyectomotorapp.Data.ClientsEntry;
import com.motorapp.proyectodam.proyectomotorapp.Data.DataSource;
import com.motorapp.proyectodam.proyectomotorapp.Data.TasksEntry;

import bolts.Task;

public class NuevoVehiculo extends AppCompatActivity {
    private String marca;
    private String matricula;
    private String nombreC;
    private String apellidoC;
    private String emailC;
    private String phone;
    private EditText owner;
    private EditText matriculaEdit, marcaEdit, modeloEdit, numMotorEdit, trabajoEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_vehiculo);
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
        marca = intent.getStringExtra("marca");

        matriculaEdit = (EditText) findViewById(R.id.matriculaEditText);
        marcaEdit = (EditText) findViewById(R.id.marcaEdittText);
        modeloEdit = (EditText) findViewById(R.id.modeloEditText);
        numMotorEdit = (EditText) findViewById(R.id.numMotorEditText);
        trabajoEdit = (EditText) findViewById(R.id.trabajoEditText);
        owner = (EditText) findViewById(R.id.ownerEditText);

        matriculaEdit.setText(matricula);
        marcaEdit.setText(marca);
    }
    public void back(View view){
        Intent intent= new Intent(this, SeleccionarMarca.class);
        startActivity(intent);
        finish();
    }

    public void onClick(View v) {
        String cocheMatriculaStr = String.valueOf(matriculaEdit.getText()) ;
        String cocheMarcaStr = String.valueOf(marcaEdit.getText());
        String cocheModeloStr = String.valueOf(modeloEdit.getText());
        String cocheNumMotorStr = String.valueOf(numMotorEdit.getText());
        String cocheTrabajoStr = String.valueOf(trabajoEdit.getText());
        String cocheOwnerStr = String.valueOf(owner.getText());

        if (cocheMatriculaStr.equals("") || cocheMarcaStr.equals("") || cocheModeloStr.equals("") || cocheNumMotorStr.equals("") || cocheTrabajoStr.equals("")) {
            //VENTANA EMERGENTE RELLENAR CAMPOS VACIOS
            Toast.makeText(getApplicationContext(),
                    "Por favor completa los campos vacios",
                    Toast.LENGTH_LONG).show();
        } else {
            CarsEntry.setBRAND(cocheMarcaStr);
            CarsEntry.setMODEL(cocheModeloStr);
            CarsEntry.setMotorNumber(cocheNumMotorStr);
            CarsEntry.setPLATE(cocheMatriculaStr);
            TasksEntry.setOWNER(cocheOwnerStr);
            TasksEntry.setDESCRIPTION(cocheTrabajoStr);
            ClientsEntry.setFkPlate(matricula);
            ClientsEntry.setEMAIL(emailC);
            ClientsEntry.setNAME(nombreC);
            ClientsEntry.setSURNAME(apellidoC);
            ClientsEntry.setPHONE(phone);

            DataSource dataSource = new DataSource(this);
            dataSource.insertClients();
            dataSource.insertCars();
            dataSource.insertTasks();

            Intent intent= new Intent(this, Lista.class);
            startActivity(intent);
            finish();
        }
    }
}
