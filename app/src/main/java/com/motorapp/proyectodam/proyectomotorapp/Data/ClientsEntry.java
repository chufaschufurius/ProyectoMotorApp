package com.motorapp.proyectodam.proyectomotorapp.Data;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 04/03/2015.
 */
public class ClientsEntry implements Serializable {

    //    private int id;
    //        public static final String COLUMN_ID = BaseColumns._ID;
    public static String TABLE_NAME = "clients";
    public static String FK_PLATE = "plate"; //cogemos la matricula de coches
    public static String EMAIL = "email";
    public static String NAME = "name";
    public static String PHONE = "phone";
    public static String SURNAME = "surname";

    @Override
    public String toString() {
        return "ClientsEntry{" +
                "clients='" + TABLE_NAME + '\'' +
                ", FK_PLATE='" + FK_PLATE + '\'' +
                ", NAME='" + NAME + '\'' +
                ", PHONE='" + PHONE + '\'' +
                ", SURNAME='" + SURNAME + '\'' +
                '}';
    }


    public static String getFkPlate() {
        return FK_PLATE;
    }

    public static void setFkPlate(String fkPlate) {
        FK_PLATE = fkPlate;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

    public static void setEMAIL(String EMAIL) {
        ClientsEntry.EMAIL = EMAIL;
    }

    public static String getNAME() {
        return NAME;
    }

    public static void setNAME(String NAME) {
        ClientsEntry.NAME = NAME;
    }

    public static String getPHONE() {
        return PHONE;
    }

    public static void setPHONE(String PHONE) {
        ClientsEntry.PHONE = PHONE;
    }

    public static String getSURNAME() {
        return SURNAME;
    }

    public static void setSURNAME(String SURNAME) {
        ClientsEntry.SURNAME = SURNAME;
    }
}


