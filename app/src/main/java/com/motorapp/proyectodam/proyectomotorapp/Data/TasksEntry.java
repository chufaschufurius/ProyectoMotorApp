package com.motorapp.proyectodam.proyectomotorapp.Data;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 14/12/2015.
 */
public class TasksEntry implements Serializable {
    public static String TABLE_NAME = "tasks";
    public static String DESCRIPTION = "description";
    public static String OWNER = "owner";
    public static String PLATE = "plate";

    @Override
    public String toString() {
        return "CarsEntry{" +
                "cars='" + TABLE_NAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", OWNER='" + OWNER + '\'' +
                ", PLATE='" + PLATE + '\'' +
                '}';
    }

    public static String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public static void setDESCRIPTION(String description) {
        DESCRIPTION = description;
    }

    public static String getOWNER() {
        return OWNER;
    }

    public static void setOWNER(String OWNER) {
        TasksEntry.OWNER = OWNER;
    }

    public static String getPLATE() {
        return PLATE;
    }

    public static void setPLATE(String PLATE) {
        TasksEntry.PLATE = PLATE;
    }

}