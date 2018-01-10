package com.example.binyamin.android5778_0445_7734_01.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.datasource.List_DBManager;
import com.example.binyamin.android5778_0445_7734_01.model.datasource.MySQL_DBManager;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Branch;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

import static com.example.binyamin.android5778_0445_7734_01.controller.Task.list_dbManager;

/**
 * Created by binyamin on 21/11/2017.
 *
 * This class manage ALL the Task used in the controller.
 * We use a task each time we need access to the Data section.
 * So each access to the data is done through a separate thread from the UIThread.
 */
class Task
{
    // get instance of the manager who manage the data.

    static List_DBManager list_dbManager = List_DBManager.getInstance();
    static MySQL_DBManager sql_dbManager = MySQL_DBManager.getInstance();
    //TODO: Change the manager to be SQL_MANAGER.
    // TODO:Add also php file in the cloud for post and get method.



    static class ClientListTask extends AsyncTask< Void, Void , List<Client>> {

        private Activity context;

        public ClientListTask(Activity context) {
            this.context = context;
        }

        @Override
        protected List<Client> doInBackground(Void... voids) {
            return sql_dbManager.getClients();
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

    static class CarModelListTask extends AsyncTask<Void, Void , List<CarModel>>
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

            return sql_dbManager.getCarModels();
        }

        //
        @Override
        protected void onPostExecute(List<CarModel> carModels) {
            ArrayList<CarModel> carModelArrayList = new ArrayList<CarModel>(carModels);

            CarModelAdapter itemAdapter =
                    new CarModelAdapter(context , carModelArrayList );
            ListView listView = (ListView)context.findViewById(R.id.rootView);
            listView.setAdapter(itemAdapter);
        }
    }

    static    class AddClientTask extends AsyncTask<ContentValues , Void , Long>
    {
        private Context context;
        public AddClientTask(Context context) {
            this.context = context;

        }

        @Override
        protected Long doInBackground(ContentValues... contentValues) {

            if(contentValues[0] != null)
                return sql_dbManager.addClient(contentValues[0]);

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

    static    class AddCarModelTask extends AsyncTask<ContentValues, Void, Long>
    {
        private Context context;

        public AddCarModelTask(Context context) {
            this.context = context;
        }

        @Override
        protected Long doInBackground(ContentValues... contentValues) {
            if(contentValues[0] != null)
                return sql_dbManager.addCarModel(contentValues[0]);

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

    static class AddBranchTask extends AsyncTask<ContentValues,Void,Long>
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
    }

    static class BranchListTask extends  AsyncTask<Void, Void, List<Branch>>
    {
        private Activity context;

        public BranchListTask(Activity context){
            this.context = context;
        }
        @Override
        protected List<Branch> doInBackground(Void... voids) {
            return list_dbManager.getBranchs();
        }

        @Override
        protected void onPostExecute(List<Branch> branches) {
            ArrayList<Branch> branchesArrayList = new ArrayList<>(branches);

            BranchAdapter itemAdapter =
                    new BranchAdapter(context , branchesArrayList );
            ListView listView = (ListView)context.findViewById(R.id.rootView);
            listView.setAdapter(itemAdapter);
        }

    }
}

