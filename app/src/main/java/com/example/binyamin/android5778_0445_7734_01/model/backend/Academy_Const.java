package com.example.binyamin.android5778_0445_7734_01.model.backend;

import android.content.ContentValues;


import com.example.binyamin.android5778_0445_7734_01.model.entities.Branch;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CLASSE;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Car;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Client;
import com.example.binyamin.android5778_0445_7734_01.model.entities.LUGGAGE;
import com.example.binyamin.android5778_0445_7734_01.model.entities.PASSENGERS;

import java.util.Date;


/**
 * Created by binyamin on 10/11/2017.
 */

public class Academy_Const {


    public static final String[] City = new String[]{"Jerusalem", "Tel Aviv" , "Rishon Letzion" , "Ashdod" ,
            "Haifa" , "Beit Shemesh" , "Eilat" , "Bnei Brak" , "Raanana" , "Natanya" , "Ashkelon" , "Beit Shemen"
    };

    public static final String[] Streets = new String[] { "Kanfei Nesharim" , "King George" ,"HaPalmach" , "Herzl"
            ,"Yitzhak Rabin", "Ben Gurion" , "Menachem Begin" , "Dizengof" , "Arlozorov"
    };

    public static class BranchConst
    {
        public static final String ID = "_id";
        public static final String CITY = "branchCity";
        public static final String STREET = "branchStreet";
        public static final String NUMBER_STREET = "branchStreetNumber";
        public static final String AMOUNT_PARKING_PLACE = "branchAmountParkingPlace";
        public static final String NAME = "name";
        public static final String SECTOR = "sector";
    }

    public static class CarConst
    {
        public static final String ID = "_id";
        public static final String TYPE_MODEL_ID = "idModelCar";
        public static final String KILOMETRE = "kilometre";
        public static final String BRANCH_ID_PARKED = "idBranchParked";
        public static final String ISFREE = "isfree";

    }

    public static class ClientConst
    {
        public static final String ID = "_id";
        public static final String FIRSTNAME = "firstName";
        public static final String LASTNAME = "lastName";
        public static final String PHONE_NUMBER = "phoneNumber";
        public static final String MAIL_ADDRESS = "mailAddress";
        public static final String CREDIT_CAR_NUMBER = "creditCardNumber";
        public static final String PASSWORD = "password";
        public static final String SECTOR = "sector";

    }

    public static class CarModelConst
    {
        public static final String ID = "_id";
        public static final String COMPANY_NAME = "companyName";
        public static final String MODEL_NAME = "modelName";
        public static final String MOTOR_VOLUME = "motorVolume";
        public static final String IS_AUTOMATIC = "isAutomatic";
        public static final String PASSENGERS = "passengers";
        public static final String DOOR = "door";
        public static final String LUGAGE_COMPARTMENT = "lugageCompartment";
        public static final String AIR_C = "airC";
        public static final String CLASSE = "classe";
        public static final String PRICE_DAY = "price_day";


    }

    public static class CommandConst
    {
        public static final String ID = "_id";
        public static final String CLIENT_ID = "clientId";
        public static final String STATE = "state";
        public static final String CAR_ID = "carId";
        public static final String START_RENTING_DATE = "startRentingDate";
        public static final String END_RENTING_DATE = "endRentingDate";
        public static final String START_NUMBER_KILOMETRE = "startNumberKilometre";
        public static final String END_NUMBER_KILOMETRE = "endNumberKilometre";
        public static final String FUEL_STATE = "fuelState";
        public static final String AMOUNTOfLITERFILLED = "amountOfLiterFilled";
        public static final String BILL = "bill";

    }
    public static ContentValues BranchToContentValues(Branch branch)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BranchConst.ID, branch.getBranchId());
        contentValues.put(BranchConst.AMOUNT_PARKING_PLACE, branch.getBranchAmountParkingPlace());
        contentValues.put(BranchConst.CITY, branch.getBranchCity());
        contentValues.put(BranchConst.STREET, branch.getBranchStreet());
        contentValues.put(BranchConst.NUMBER_STREET, branch.getBranchStreetNumber());
        contentValues.put(BranchConst.NAME, branch.getBranchName());
        contentValues.put(BranchConst.SECTOR, branch.getSector());

        return contentValues ;
    }


    public static CarModel ContentValuesToCarModel(ContentValues contentValues)
    {
        CarModel carModel = new CarModel();


        //Sometimes(e.g : List_DBManager.addCarModel() )
        // we translate the contentValue before we assign it an ID.
        //So we need to check wether ID is Null or not
        if(contentValues.getAsLong(CarModelConst.ID)!=null)
            carModel.setModelId(contentValues.getAsLong(CarModelConst.ID));

        carModel.setAirC(contentValues.getAsBoolean(CarModelConst.AIR_C));
        carModel.setAutomatic( contentValues.getAsBoolean(CarModelConst.IS_AUTOMATIC));
        carModel.setLuggageCompartment((LUGGAGE.valueOf(contentValues.getAsString(CarModelConst.LUGAGE_COMPARTMENT).toUpperCase())));
        carModel.setModelCompanyName(contentValues.getAsString(CarModelConst.COMPANY_NAME));
        carModel.setModelName(contentValues.getAsString(CarModelConst.MODEL_NAME));
        carModel.setPassengers((PASSENGERS.valueOf(contentValues.getAsString(CarModelConst.PASSENGERS).toUpperCase())));
        carModel.setClasse(CLASSE.valueOf(contentValues.getAsString(CarModelConst.CLASSE)));
        carModel.setPriceDay();
        carModel.setDoor();
        carModel.setModelMotorVolume();

        return carModel;
    }


    public static ContentValues CarModelToContentValues(CarModel carModel)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(CarModelConst.ID , carModel.getModelId());
        contentValues.put(CarModelConst.PASSENGERS, carModel.getPassengers().toString());
        contentValues.put(CarModelConst.MOTOR_VOLUME, carModel.getModelMotorVolume());
        contentValues.put(CarModelConst.MODEL_NAME, carModel.getModelName());
        contentValues.put(CarModelConst.COMPANY_NAME, carModel.getModelCompanyName());
        contentValues.put(CarModelConst.LUGAGE_COMPARTMENT, carModel.getLuggageCompartment().toString());
        contentValues.put(CarModelConst.IS_AUTOMATIC, carModel.isAutomatic());
        contentValues.put(CarModelConst.DOOR, carModel.getDoor().toString());
        contentValues.put(CarModelConst.AIR_C, carModel.isAirC());
        contentValues.put(CarModelConst.CLASSE, String.valueOf(carModel.getClasse()));
        contentValues.put(CarModelConst.PRICE_DAY, carModel.getPriceDay());

        return contentValues;
    }
    public static ContentValues ClientToContentValues(Client client) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ClientConst.ID, client.getClientId());
        contentValues.put(ClientConst.CREDIT_CAR_NUMBER, client.getCreditCardNumber());
        contentValues.put(ClientConst.FIRSTNAME, client.getFirstName());
        contentValues.put(ClientConst.LASTNAME, client.getLastName());
        contentValues.put(ClientConst.MAIL_ADDRESS, client.getMailAdress());
        contentValues.put(ClientConst.PHONE_NUMBER,client.getPhoneNumber());
        contentValues.put(ClientConst.PASSWORD, client.getPassword());
        contentValues.put(ClientConst.SECTOR, client.getSector());

        return contentValues;

    }



    public static ContentValues CarToContentValues(Car car)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CarConst.ID , car.getCarId());
        contentValues.put(CarConst.TYPE_MODEL_ID, car.getTypeModelID());
        contentValues.put(CarConst.KILOMETRE, car.getKilometre());
        contentValues.put(CarConst.BRANCH_ID_PARKED, car.getBranchIdCarParked());
        contentValues.put(CarConst.ISFREE, car.isFree());

        return contentValues;
    }

    public static Car ContentValuesToCar(ContentValues contentValues)
    {
        Car car = new Car();

        //Sometimes(e.g : List_DBManager.addCar() )
        // we translate the contentValue before we assign it an ID.
        //So we need to check wether ID is Null or not
        if(contentValues.getAsLong(CarConst.ID) !=null)
            car.setCarId(contentValues.getAsLong(CarConst.ID));

        car.setBranchIdCarParked(contentValues.getAsLong(CarConst.BRANCH_ID_PARKED));
        car.setKilometre(contentValues.getAsInteger(CarConst.KILOMETRE));
        car.setTypeModelID(contentValues.getAsLong(CarConst.TYPE_MODEL_ID));
        car.setFree(contentValues.getAsBoolean(CarConst.ISFREE));

        return car;
    }
    public static Branch ContentValuesToBranch(ContentValues contentValues)
    {
        Branch branch = new Branch();

        //Sometimes(e.g : List_DBManager.addBranch() )
        // we translate the contentValue before we assign it an ID.
        //So we need to check wether ID is Null or not
        if(contentValues.getAsLong(BranchConst.ID) !=null)
            branch.setBranchId(contentValues.getAsLong(BranchConst.ID));

        branch.setBranchAmountParkingPlace(contentValues.getAsInteger(BranchConst.AMOUNT_PARKING_PLACE));
        branch.setBranchCity(contentValues.getAsString(BranchConst.CITY));
        branch.setBranchStreet(contentValues.getAsString(BranchConst.STREET));
        branch.setBranchStreetNumber(contentValues.getAsInteger(BranchConst.NUMBER_STREET));
        branch.setBranchName(contentValues.getAsString(BranchConst.NAME));
        branch.setSector(contentValues.getAsInteger(BranchConst.SECTOR));


        return  branch;

    }



    public static Client ContentValuesToClient(ContentValues contentValues)
    {
        Client client = new Client();

        //Sometimes(e.g : List_DBManager.addClient() )
        // we translate the contentValue before we assign it an ID.
        //So we need to check wether ID is Null or not
        if (contentValues.getAsLong(ClientConst.ID) != null)
            client.setClientId(contentValues.getAsLong(ClientConst.ID));

        client.setCreditCardNumber(contentValues.getAsString(ClientConst.CREDIT_CAR_NUMBER));
        client.setFirstName(contentValues.getAsString(ClientConst.FIRSTNAME));
        client.setLastName((contentValues.getAsString(ClientConst.LASTNAME)));
        client.setMailAdress(contentValues.getAsString(ClientConst.MAIL_ADDRESS));
        client.setPhoneNumber(contentValues.getAsString(ClientConst.PHONE_NUMBER));
        client.setPassword(contentValues.getAsString(ClientConst.PASSWORD));
        client.setSector(contentValues.getAsInteger(ClientConst.SECTOR));

        return client;
    }

}
