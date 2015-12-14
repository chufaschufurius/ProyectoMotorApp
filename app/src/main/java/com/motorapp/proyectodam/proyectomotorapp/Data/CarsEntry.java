package com.motorapp.proyectodam.proyectomotorapp.Data;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 04/03/2015.
 */
public class CarsEntry implements Serializable {
    public static String TABLE_NAME = "cars";
    public static String MOTOR_NUMBER = "motorNumber";
    public static String BRAND = "brand";
    public static String MODEL = "model";
    public static String PLATE = "plate";

    @Override
    public String toString() {
        return "CarsEntry{" +
                "cars='" + TABLE_NAME + '\'' +
                ", MOTOR_NUMBER='" + MOTOR_NUMBER + '\'' +
                ", BRAND='" + BRAND + '\'' +
                ", MODEL='" + MODEL + '\'' +
                ", PLATE='" + PLATE + '\'' +
                '}';
    }

    public static String getMotorNumber() {
        return MOTOR_NUMBER;
    }

    public static void setMotorNumber(String motorNumber) {
        MOTOR_NUMBER = motorNumber;
    }

    public static String getBRAND() {
        return BRAND;
    }

    public static void setBRAND(String BRAND) {
        CarsEntry.BRAND = BRAND;
    }

    public static String getMODEL() {
        return MODEL;
    }

    public static void setMODEL(String MODEL) {
        CarsEntry.MODEL = MODEL;
    }

    public static String getPLATE() {
        return PLATE;
    }

    public static void setPLATE(String PLATE) {
        CarsEntry.PLATE = PLATE;
    }


}