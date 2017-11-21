package com.example.binyamin.android5778_0445_7734_01.model.entities;

public class CarModel {

    static long uniqueId = 2001 ;

    long modelId;
    String modelCompanyName;
    String modelName;
    int modelMotorVolume;
    boolean automatic;
    PASSENGERS passengers;
    COLOR color;
    LUGGAGE luggageCompartment;
    boolean airC ;

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {

        if(modelId > 0)
            this.modelId = modelId;
        else
        {
            this.modelId = uniqueId;
            uniqueId++;
        }
    }

    public String getModelCompanyName() {
        return modelCompanyName;
    }

    public void setModelCompanyName(String modelCompanyName) {
        this.modelCompanyName = modelCompanyName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelMotorVolume() {
        return modelMotorVolume;
    }

    public void setModelMotorVolume(int modelMotorVolume) {
        this.modelMotorVolume = modelMotorVolume;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public PASSENGERS getPassengers() {
        return passengers;
    }

    public void setPassengers(PASSENGERS passengers) {
        this.passengers = passengers;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public LUGGAGE getLuggageCompartment() {
        return luggageCompartment;
    }

    public void setLuggageCompartment(LUGGAGE luggageCompartment) {
        this.luggageCompartment = luggageCompartment;
    }

    public boolean isAirC() {
        return airC;
    }

    public void setAirC(boolean airC) {
        this.airC = airC;
    }


}
