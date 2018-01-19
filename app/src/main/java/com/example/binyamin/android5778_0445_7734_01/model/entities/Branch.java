package com.example.binyamin.android5778_0445_7734_01.model.entities;

/**
 * Created by binyamin on 09/11/2017.
 */

public class Branch {

    static long uniqueId = 4001 ;
    String branchName;

    String branchCity;
    String branchStreet;
    int sector;
    int branchStreetNumber;
    int branchAmountParkingPlace;
    long branchId;

    public Branch() {
    }

    public Branch(String branchCity, String branchStreet, int sector, int branchStreetNumber, int branchAmountParkingPlace) {
        this.branchCity = branchCity;
        this.branchStreet = branchStreet;
        this.sector = sector;
        this.branchStreetNumber = branchStreetNumber;
        this.branchAmountParkingPlace = branchAmountParkingPlace;
        setBranchName("Take&go  - " + branchStreet + " -");
        setBranchId(0);
    }

    public String getBranchName() {
        return branchName;
    }
    public void setBranchName(String name) {
        this.branchName = name;
    }



    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }


    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public String getBranchStreet() {
        return branchStreet;
    }

    public void setBranchStreet(String branchStreet) {
        this.branchStreet = branchStreet;
    }

    public int getBranchStreetNumber() {
        return branchStreetNumber;
    }

    public void setBranchStreetNumber(int branchStreetNumber) {
        this.branchStreetNumber = branchStreetNumber;
    }

    public int getBranchAmountParkingPlace() {
        return branchAmountParkingPlace;
    }

    public void setBranchAmountParkingPlace(int branchAmountParkingPlace) {
        this.branchAmountParkingPlace = branchAmountParkingPlace;
    }

    public  long getBranchId() {
        return branchId;
    }

    public  void setBranchId(long branchId) {

        if(branchId >0)
            this.branchId = branchId;

        else
        {
            this.branchId = uniqueId;
            uniqueId++;
        }

    }
}
