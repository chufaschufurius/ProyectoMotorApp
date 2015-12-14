package com.motorapp.proyectodam.proyectomotorapp.Data;

import android.content.Context;

import com.parse.ParseObject;

/**
 * Created by CHUFASCHIN on 29/01/2015.
 */
public class DataSource {
    private Context mContext;


    public DataSource(Context context) {
        mContext = context;
    }

    public static void insertCars() {
        ParseObject cars = new ParseObject("cars");
        cars.put("motorNumber", CarsEntry.getMotorNumber());
        cars.put("brand", CarsEntry.getBRAND());
        cars.put("model", CarsEntry.getMODEL());
        cars.put("plate", CarsEntry.getPLATE());
        cars.saveInBackground();
    }

    public static void insertClients() {
        ParseObject clients = new ParseObject("clients");
        clients.put("plate", ClientsEntry.getFkPlate());
        clients.put("email", ClientsEntry.getEMAIL());
        clients.put("name", ClientsEntry.getNAME());
        clients.put("surname", ClientsEntry.getSURNAME());
        clients.put("phone", ClientsEntry.getPHONE());
        clients.saveInBackground();
    }

    public static void insertTasks() {
        ParseObject tasks = new ParseObject("tasks");
        tasks.put("description", ClientsEntry.getFkPlate());
        tasks.put("owner", ClientsEntry.getEMAIL());
        tasks.saveInBackground();
    }
}
