package com.example.binyamin.android5778_0445_7734_01.model.datasource;

import android.content.ContentValues;

import com.example.binyamin.android5778_0445_7734_01.model.backend.Academy_Const;
import  com.example.binyamin.android5778_0445_7734_01.model.backend.DB_manager;
import com.example.binyamin.android5778_0445_7734_01.model.entities.BRAND;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Branch;
import com.example.binyamin.android5778_0445_7734_01.model.entities.COLOR;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Car;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Client;
import com.example.binyamin.android5778_0445_7734_01.model.entities.DOOR;
import com.example.binyamin.android5778_0445_7734_01.model.entities.LUGGAGE;
import com.example.binyamin.android5778_0445_7734_01.model.entities.PASSENGERS;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by binyamin on 15/11/2017.
 */

public class List_DBManager implements DB_manager {

    private static final List_DBManager ourInstance = new List_DBManager();

    public static List_DBManager getInstance() {
        return ourInstance;
    }

    private static void initList() {


        Client client = new Client("Bin", "Oliel","065676876","binoliel@",
                "345678765433333","1234",2);

        clientList.add(client);

        Client client1 = new Client("Ephra", "Hammer","065676876","kidon@",
                "345678765433333","1234",2);
        clientList.add(client1);

        Branch branch = new Branch("Paris", "Maubert", 5 , 21, 12);
        branchList.add(branch);

        Branch branch1 = new Branch("Marseille", "Maubert", 5 , 21, 12);
        branchList.add(branch1);



    }

    private List_DBManager() {

    }

    private static List<Branch> branchList;
    private static List<Car> carList;
    private static List<Client> clientList;
    private static List<CarModel> carModelList;


    static {
        branchList = new ArrayList<>();
        carList= new ArrayList<>();
        clientList= new ArrayList<>();
        carModelList= new ArrayList<>();
        initList();


    }

    public interface Predicate<T> { boolean apply(T type); }

    public static <T> List<T> filter(List<T> col, Predicate<T> predicate) {
        List<T> result = new ArrayList<T>();
        for (T element: col) {
            if (predicate.apply(element)) {
                result.add(element);
            }
        }
        return result;
    }

    @Override
    public long addClient(ContentValues values) {

        Client client = Academy_Const.ContentValuesToClient(values);
        // Here we are setting up the id of the client ,
        // Thats why we need to update the values.
        client.setClientId(-1);
        values = Academy_Const.ClientToContentValues(client);

        clientList.add(client);
        return client.getClientId();
    }


    @Override
    public boolean isMatchedPassword(String password, String id)
    {
        for (Client c : clientList) {
            if(c.getMailAdress() == id && c.getPassword() == password)
                return true;
        }
        return false;
    }


    @Override
    public boolean isClientExist( final long  id) {

        Predicate<Client> predicate = new Predicate<Client>() {
            public boolean apply(Client client) {
                return client.getClientId() == id;
            }


        };
         return  filter( clientList, predicate).isEmpty();


    }

    @Override
    public List<Client> getClients() {
        return clientList;
    }

    @Override
    public long addCarModel(ContentValues contentValues) {
        CarModel carModel = Academy_Const.ContentValuesToCarModel(contentValues);


        carModelList.add(carModel);
        return carModel.getModelId();
    }

    @Override
    public List<CarModel> getCarModels() {
        return carModelList;
    }

    @Override
    public long addCar(ContentValues contentValues) {
        Car car = Academy_Const.ContentValuesToCar(contentValues);

        carList.add(car);
        return car.getCarId();
    }

    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public List<Branch> getBranchs() {
        return branchList;
    }

    @Override
    public long addBranch(ContentValues contentValues)
    {
        Branch branch = Academy_Const.ContentValuesToBranch(contentValues);
        branchList.add(branch);

        return branch.getBranchId();
    }
}
