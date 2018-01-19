package com.example.binyamin.android5778_0445_7734_01.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;

import java.util.ArrayList;
import java.util.List;

public class CarModelListActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_model_list);





        List<CarModel> carModelList = new Task.CarModelListTask(this).doInBackground();

        ArrayList<CarModel> carModelArrayList = new ArrayList<CarModel>(carModelList);

        CarModelAdapter itemAdapter =
                new CarModelAdapter(this , carModelArrayList );
        ListView listView = (ListView)this.findViewById(R.id.rootView);


        listView.setAdapter(itemAdapter);






    }

}
