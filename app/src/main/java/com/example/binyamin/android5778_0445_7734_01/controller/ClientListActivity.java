package com.example.binyamin.android5778_0445_7734_01.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.datasource.List_DBManager;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Client;

import java.util.ArrayList;

public class ClientListActivity extends AppCompatActivity {

    List_DBManager list_dbManager = List_DBManager.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);


        ArrayList<Client> clientArrayList = new ArrayList<Client>(list_dbManager.getClients());

       // TODO:charger la data dans list de client avec ASYNKTASK.


        ClientAdapter itemAdapter =
                new ClientAdapter(this,clientArrayList );

        ListView listView = (ListView) findViewById(R.id.rootView);

        listView.setAdapter(itemAdapter);
    }
}
