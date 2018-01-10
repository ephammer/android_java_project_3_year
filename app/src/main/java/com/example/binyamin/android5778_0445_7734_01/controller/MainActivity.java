package com.example.binyamin.android5778_0445_7734_01.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.binyamin.android5778_0445_7734_01.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // declare All the view in the activity
    private Button addClientButton;
    private Button displayClientListButton;
    private Button addCarModelButton;
    private Button displayCarModelButton;
    private Button addBranch;
    private Button displayAllBranches;

    //instance of each view by id of the activity
    private void findViews()
    {
        addClientButton = findViewById(R.id.addClientbutton);
        displayClientListButton = findViewById(R.id.displayListClientbutton);
        addCarModelButton = findViewById(R.id.addModelCar);
        displayCarModelButton = findViewById(R.id.displayListCarmodel);
        addBranch = findViewById(R.id.addBranch);
        displayAllBranches = findViewById(R.id.displayListBranch);
    }

    private void addClientIntent()
    {
        Intent intent = new Intent(this, AddClientActivity.class);
        startActivity(intent);
    }

    private void addCarModelIntent()
    {
        Intent intent = new Intent(this, AddCarModelActivity.class);
        startActivity(intent);
    }

    private void addBranchIntent()
    {
        Intent intent = new Intent(this,AddBranchActivity.class);
        startActivity(intent);
    }

    private void displayClientListIntent()
    {
        Intent intent = new Intent(this, ClientListActivity.class);
        startActivity(intent);
    }

    private void displayCarModelListIntent()
    {
        Intent intent = new Intent(this, CarModelListActivity.class);
        startActivity(intent);
    }

    private void displayBranchListIntent()
    {
        Intent intent = new Intent(this,BranchListActivity.class);
        startActivity(intent);
    }
    private void setOnClickListeners() {

        addClientButton.setOnClickListener(this);

        displayClientListButton.setOnClickListener(this);

        addCarModelButton.setOnClickListener(this);

        displayCarModelButton.setOnClickListener(this);

        addBranch.setOnClickListener(this);

        displayAllBranches.setOnClickListener(this);
    }

    private void initActivity()
    {
        // Call function that instance all the views.
        findViews();
        setOnClickListeners();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActivity();


    }

    @Override
    public void onClick(View v)
    {
        Log.i("IDView", String.valueOf((v.getId())));

        switch (v.getId()){

            case R.id.addClientbutton:
                    addClientIntent();
                break;

            case R.id.displayListClientbutton:
                    displayClientListIntent();
                break;
            case R.id.addModelCar:
                    addCarModelIntent();
                    break;

            case R.id.displayListCarmodel:
                displayCarModelListIntent();
                break;

            case R.id.displayListBranch:
                displayBranchListIntent();
                break;
            case R.id.addBranch:
                addBranchIntent();
                break;
        }
    }
}
