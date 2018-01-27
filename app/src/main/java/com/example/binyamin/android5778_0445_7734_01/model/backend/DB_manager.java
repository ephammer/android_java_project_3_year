package com.example.binyamin.android5778_0445_7734_01.model.backend;

import android.content.ContentValues;
import android.content.Context;

import com.example.binyamin.android5778_0445_7734_01.model.entities.Branch;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Car;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Client;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by binyamin on 10/11/2017.
 */



public interface DB_manager {

   /*
    long addBranch(ContentValues branch);
    boolean removeBranch(long id);
    boolean updateBranch(long id);

    boolean removeCarModel(long id);
    boolean updateCarModel(long id);
    boolean removeClient(long id);
    boolean updateClient(long id);
    boolean removeCar(long id);
    boolean updateCar(long id);
    */



    long addClient(ContentValues client);
    boolean isClientExist(long id);
    boolean isMatchedPassword(Context context, String password , String id);
    List<Client> getClients();


    long addCarModel(ContentValues carModel);
    List<CarModel> getCarModels();

    long addCar(ContentValues car);
    List<Car> getCars();

    long addBranch(ContentValues contentValues);
    List<Branch> getBranchs();

}


