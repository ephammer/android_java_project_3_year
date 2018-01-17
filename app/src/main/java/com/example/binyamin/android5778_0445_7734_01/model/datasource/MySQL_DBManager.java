package com.example.binyamin.android5778_0445_7734_01.model.datasource;

import android.content.ContentValues;
import android.util.Log;

import com.example.binyamin.android5778_0445_7734_01.model.backend.Academy_Const;
import com.example.binyamin.android5778_0445_7734_01.model.backend.DB_manager;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Branch;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Car;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by binyamin on 01/12/2017.
 */

public class MySQL_DBManager implements DB_manager {

    private static final MySQL_DBManager ourInstance = new MySQL_DBManager();

    public static MySQL_DBManager getInstance() {
        return ourInstance;
    }

    private MySQL_DBManager() {
    }

    private String WEB_URL = "http://obinyami.vlab.jct.ac.il/Academy";
    private String SLASH = "/";



    @Override
    public long addClient(ContentValues client) {

        try
        {
            String result = PHPtools.POST(WEB_URL + SLASH +"add_client.php", client);
            long id = Long.parseLong(result);

            //Log.i("addClient: " , result);
            return id;



        }
        catch (Exception e )
        {
            Log.e("addClientException: \n" , e.toString());
            return  -1;
        }
    }

    @Override
    public boolean isMatchedPassword(String password, String id) {

        List<Client> result = new ArrayList<>();
        try
        {
            String str = PHPtools.GET(WEB_URL +  SLASH +"getClientByPasswordAndMail.php");
            JSONArray array = new  JSONObject(str).getJSONArray("client");

            JSONObject jsonObject;
            ContentValues contentValues;
            Client client;

            for (int i = 0 ; i < array.length(); i++)
            {
                jsonObject = array.getJSONObject(i);
                contentValues = PHPtools.JsonToContentValues(jsonObject);
                client = Academy_Const.ContentValuesToClient(contentValues);

                result.add(client);

            }
            return !(result.isEmpty());


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean isClientExist( long  id) {
        List <Client> clientList = getClients();

        for (Client c : clientList) {
            if(c.getClientId() == id)
                return true;
        }
        return false;
    }

    @Override
    public List<Client> getClients() {
        List<Client> result = new ArrayList<>();
        try
        {
            String str = PHPtools.GET(WEB_URL +  SLASH +"getClientList.php");
            JSONArray array = new  JSONObject(str).getJSONArray("cilents");

            JSONObject jsonObject;
            ContentValues contentValues;
            Client client;

            for (int i = 0 ; i < array.length(); i++)
            {
                jsonObject = array.getJSONObject(i);
                contentValues = PHPtools.JsonToContentValues(jsonObject);
                client = Academy_Const.ContentValuesToClient(contentValues);

                result.add(client);



            }
            return result;


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public long addCarModel(ContentValues carModel) {
        try
        {

            String result = PHPtools.POST(WEB_URL + SLASH +"add_car_model.php", carModel);
            long id = Long.parseLong(result);

            Log.i("addCarModel: " , result);
            return id;



        }
        catch (Exception e )
        {
            Log.e("addCarModelException: \n" , e.toString());
            return  -1;
        }
    }

    @Override
    public List<CarModel> getCarModels() {
        List<CarModel> result = new ArrayList<>();
        try
        {
            String str = PHPtools.GET(WEB_URL + SLASH +"getCarModelList.php");
            JSONArray array = new  JSONObject(str).getJSONArray("CarModel");

            JSONObject jsonObject;
            ContentValues contentValues;
            CarModel carModel;

            for (int i = 0 ; i < array.length(); i++)
            {
                jsonObject = array.getJSONObject(i);
                contentValues = PHPtools.JsonToContentValues(jsonObject);
                carModel = Academy_Const.ContentValuesToCarModel(contentValues);

                result.add(carModel);



            }
            return result;


        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("CarModel",e.toString());
        }
        return result;
    }

    @Override
    public long addCar(ContentValues car) {
        try
        {
            String result = PHPtools.POST(WEB_URL + SLASH +"add_car.php", car);
            long id = Long.parseLong(result);

            //Log.i("addCar: " , result);
            return id;



        }
        catch (Exception e )
        {
            Log.e("addCarException: \n" , e.toString());
            return  -1;
        }
    }


    @Override
    public List<Car> getCars() {
        List<Car> result = new ArrayList<>();
        try
        {
            String str = PHPtools.GET(WEB_URL + SLASH +"getCarList.php");
            JSONArray array = new  JSONObject(str).getJSONArray("carList");

            JSONObject jsonObject;
            ContentValues contentValues;
            Car car;

            for (int i = 0 ; i < array.length(); i++)
            {
                jsonObject = array.getJSONObject(i);
                contentValues = PHPtools.JsonToContentValues(jsonObject);
                car = Academy_Const.ContentValuesToCar(contentValues);

                result.add(car);



            }
            return result;


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public long addBranch(ContentValues branch) {
        try
        {
            String result = PHPtools.POST(WEB_URL + SLASH +"add_client.php", branch);
            long id = Long.parseLong(result);

            //Log.i("addBranch: " , result);
            return id;



        }
        catch (Exception e )
        {
            Log.e("addBranchException: \n" , e.toString());
            return  -1;
        }
    }


    @Override
    public List<Branch> getBranchs() {

        List<Branch> result = new ArrayList<>();
        try
        {
            String str = PHPtools.GET(WEB_URL + SLASH +"getBranchList.php");
            JSONArray array = new  JSONObject(str).getJSONArray("branch");

            JSONObject jsonObject;
            ContentValues contentValues;
            Branch branch;

            for (int i = 0 ; i < array.length(); i++)
            {
                jsonObject = array.getJSONObject(i);
                contentValues = PHPtools.JsonToContentValues(jsonObject);
                branch = Academy_Const.ContentValuesToBranch(contentValues);

                result.add(branch);



            }
            return result;


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
