package com.example.binyamin.android5778_0445_7734_01.controller;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.backend.Academy_Const;
import com.example.binyamin.android5778_0445_7734_01.model.entities.BRAND;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CLASSE;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;
import com.example.binyamin.android5778_0445_7734_01.model.entities.LUGGAGE;
import com.example.binyamin.android5778_0445_7734_01.model.entities.PASSENGERS;

public class AddCarModelActivity extends AppCompatActivity implements View.OnClickListener{

    private Switch   airCSwitch;
    private Switch   automaticSwitch;
    private EditText nameCarModelEditText;
    private Spinner  brandSpinner;
    private Spinner  lugageSpinner;
    private Spinner  passengerSpinner;
    private Spinner  classeSpinner;

    private Button   addButton;

    private void getViews()
    {
        airCSwitch = (Switch)findViewById(R.id.AirCSwitch);
        automaticSwitch = (Switch)findViewById(R.id.automaticSwitch) ;
        nameCarModelEditText= (EditText)findViewById(R.id.nameModelCarEdittext);
        brandSpinner = (Spinner)findViewById(R.id.brandSpinner) ;
        lugageSpinner = (Spinner)findViewById(R.id.lugageSpinner);
        passengerSpinner = (Spinner)findViewById(R.id.passengerSpinner);
        classeSpinner = (Spinner)findViewById(R.id.classeSpinner);

        addButton = (Button)findViewById(R.id.addButton);
    }

    private void setOnClickListeners() {
        if (addButton != null) {
            addButton.setOnClickListener(this);
        }
    }

    private void initActivity()
    {
        getViews();
        setOnClickListeners();
        populateSpinners();
    }

    private void populateSpinners()
    {
        ArrayAdapter<BRAND> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, BRAND.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(adapter);
        brandSpinner.setPrompt("Brand");

        ArrayAdapter<LUGGAGE> adapter1 =  new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, LUGGAGE.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lugageSpinner.setAdapter(adapter1);
        lugageSpinner.setPrompt("Lugage");

        ArrayAdapter<PASSENGERS> adapter2 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, PASSENGERS.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        passengerSpinner.setAdapter(adapter2);
        passengerSpinner.setPrompt("Passengers");

        ArrayAdapter<CLASSE> adapter3 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, CLASSE.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classeSpinner.setAdapter(adapter3);



    }

    private void  addCarModel()
    {
        CarModel carModel = new CarModel();
        carModel.setAutomatic(automaticSwitch.isChecked());
        carModel.setClasse((CLASSE) classeSpinner.getSelectedItem());
        carModel.setDoor();
        carModel.setPriceDay();
        carModel.setModelMotorVolume();
        carModel.setModelCompanyName(brandSpinner.getSelectedItem().toString());
        carModel.setPassengers((PASSENGERS) passengerSpinner.getSelectedItem());
        carModel.setModelName(nameCarModelEditText.getText().toString());
        carModel.setModelCompanyName(brandSpinner.getSelectedItem().toString());
        carModel.setAirC(airCSwitch.isChecked());
        carModel.setLuggageCompartment((LUGGAGE)lugageSpinner.getSelectedItem());

        ContentValues contentValues = Academy_Const.CarModelToContentValues(carModel);

        new Task.AddCarModelTask(this).execute(contentValues);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_model);
        initActivity();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.addButton:
                addCarModel();
                refreshInputsText();
                break;



        }
    }

    private void refreshInputsText() {
        airCSwitch.setChecked(false);
        automaticSwitch.setChecked(false);
        nameCarModelEditText.setText(null);
        brandSpinner.setSelection(0);
        lugageSpinner.setSelection(0);
        passengerSpinner.setSelection(0);
        classeSpinner.setSelection(0);


    }
}
