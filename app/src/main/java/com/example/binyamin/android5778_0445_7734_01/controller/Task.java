package com.example.binyamin.android5778_0445_7734_01.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.datasource.List_DBManager ;

import com.example.binyamin.android5778_0445_7734_01.model.datasource.MySQL_DBManager;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Branch;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Car;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Client;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by binyamin on 21/11/2017.
 *
 * This class manage ALL the Task used in the controller.
 * We use a task each time we need access to the Data section.
 * So each access to the data is done through a separate thread from the UIThread.
 */
public class Task
{
    // get instance of the list_dbManager who manage the data.


    private boolean isList;
    static List_DBManager list_dbManager  = List_DBManager.getInstance();
    //static MySQL_D list_dbManager mySQL_d list_dbManager = MySQL_D list_dbManager.getInstance();








    //TODO: Change the list_dbManager to be SQL list_dbManager.
    // TODO:Add also php file in the cloud for post and get method.



    public static class ClientListTask extends AsyncTask< Void, Void , List<Client>> {

        private Activity context;

        public ClientListTask(Activity context) {
            this.context = context;
        }

        @Override
        protected List<Client> doInBackground(Void... voids) {
            return list_dbManager.getClients();
        }

        @Override
        protected void onPostExecute(List<Client> clients) {
            ArrayList<Client> clientArrayList = new ArrayList<>();

            if(!clients.isEmpty())
                clientArrayList= new ArrayList<>(clients);

            ClientAdapter itemAdapter =
                    new ClientAdapter(context, clientArrayList);
            ListView listView = (ListView)context.findViewById(R.id.rootView);
            listView.setAdapter(itemAdapter);
        }
    }

    public static    class AddClientTask extends AsyncTask<ContentValues , Void , Long>
    {
        private Context context;
        public AddClientTask(Context context) {
            this.context = context;

        }

        @Override
        protected Long doInBackground(ContentValues... contentValues) {

            if(contentValues[0] != null)
                return list_dbManager.addClient(contentValues[0]);

            else
                return null;
        }

        @Override
        protected void onPostExecute(Long idCarmodel) {
            if(idCarmodel != null)


                Toast.makeText( context, "Client IdNumber: " + idCarmodel.toString() +
                                " created",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "Error adding client",
                        Toast.LENGTH_SHORT).show();
        }


    }


    public static class CarModelListTask extends AsyncTask<Void, Void , List<CarModel>>
    {
        /*
        need activity for onPostExecuteMethod
        */
        private Activity context;

        public CarModelListTask(Activity context) {
            this.context = context;
        }


        @Override
        protected List<CarModel> doInBackground(Void... choice) {

            return list_dbManager.getCarModels();
        }
    }

    public static    class AddCarModelTask extends AsyncTask<ContentValues, Void, Long>
    {
        private Context context;

        public AddCarModelTask(Context context) {
            this.context = context;
        }

        @Override
        protected Long doInBackground(ContentValues... contentValues) {
            if(contentValues[0] != null)
                return list_dbManager.addCarModel(contentValues[0]);

            else
                return null;
        }
        @Override
        protected void onPostExecute(Long idCarmodel) {
            if(idCarmodel != null)


                Toast.makeText( context, "Car Model IdNumber: " + idCarmodel.toString() +
                                " created",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "Error adding Car Model",
                        Toast.LENGTH_SHORT).show();
        }
    }



    public static class BranchListTask extends  AsyncTask<Void, Void, List<Branch>>
    {
        private Activity context;

        public BranchListTask(Activity context){
            this.context = context;
        }
        @Override
        protected List<Branch> doInBackground(Void... voids) {
            return list_dbManager.getBranchs();
        }



    }

    public static class AddBranchTask extends AsyncTask<ContentValues,Void,Long>
    {
        private Context context;


        public AddBranchTask(Context context){
            this.context = context;
        }
        @Override
        protected Long doInBackground(ContentValues... contentValues) {
            if(contentValues[0] != null)
                return list_dbManager.addBranch(contentValues[0]);

            else
                return null;
        }

        @Override
        protected void onPostExecute(Long idCarmodel) {
            if(idCarmodel != null)


                Toast.makeText( context, "Branch IdNumber: " + idCarmodel.toString() +
                                " created",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "Error adding Branch",
                        Toast.LENGTH_SHORT).show();
        }
    }

    public static class IsMatchPasswordTask extends AsyncTask< String, Void, Boolean>
    {

        @Override
        protected Boolean doInBackground(String... strings) {
                return list_dbManager.isMatchedPassword(strings[0] , strings[1]);

        }
    }

    public static class AddCarTask extends AsyncTask<ContentValues,Void,Long>
    {

        @Override
        protected Long doInBackground(ContentValues... contentValues) {
            if(contentValues[0] != null)
                return list_dbManager.addCar(contentValues[0]);

            else
                return null;
        }
    }


}

