package com.example.binyamin.android5778_0445_7734_01.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.graphics.Color;
import android.support.v7.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.backend.Academy_Const;
import com.example.binyamin.android5778_0445_7734_01.model.datasource.List_DBManager;
import com.example.binyamin.android5778_0445_7734_01.model.entities.BRAND;
import com.example.binyamin.android5778_0445_7734_01.model.entities.COLOR;
import com.example.binyamin.android5778_0445_7734_01.model.entities.DOOR;
import com.example.binyamin.android5778_0445_7734_01.model.entities.LUGGAGE;
import com.example.binyamin.android5778_0445_7734_01.model.entities.PASSENGERS;

public class AddCarModelActivity extends AppCompatActivity {

    private Switch airCSwitch;
    private Switch automaticSwitch;
    private EditText nameCarModelEditText;
    private Spinner brandSpinner;
    private Spinner lugageSpinner;
    private Spinner passengerSpinner;
    private Spinner colorSpinner;
    private Spinner doorSpinner;
    private EditText volumeEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_model);

        airCSwitch = (Switch) findViewById(R.id.AirCSwitch);
        automaticSwitch = (Switch) findViewById(R.id.automaticSwitch);
        nameCarModelEditText = (EditText) findViewById(R.id.edit_text_name_model_car);
        brandSpinner = (Spinner) findViewById(R.id.brandSpinner);
        lugageSpinner = (Spinner) findViewById(R.id.spinner_lugage);
        passengerSpinner = (Spinner) findViewById(R.id.spinner_passenger);
        colorSpinner = (Spinner) findViewById(R.id.spinner_color);
        volumeEditText = (EditText) findViewById(R.id.editText_volume_motor);
        doorSpinner = (Spinner)findViewById(R.id.spinner_door);
        addButton = (Button) findViewById(R.id.addButton);

        // Populate the different spinners
        ArrayAdapter<BRAND> brandArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, BRAND.values());
        brandArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(brandArrayAdapter);
        brandSpinner.setPrompt("Brand");

        ArrayAdapter<LUGGAGE> luggageArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, LUGGAGE.values());
        brandArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lugageSpinner.setAdapter(luggageArrayAdapter);
        lugageSpinner.setPrompt("Lugage");

        ArrayAdapter<PASSENGERS> passengersArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, PASSENGERS.values());
        brandArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        passengerSpinner.setAdapter(passengersArrayAdapter);
        passengerSpinner.setPrompt("Passengers");

        ArrayAdapter<COLOR> colorArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, COLOR.values());
        brandArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(colorArrayAdapter);
        colorSpinner.setPrompt("Color");

        ArrayAdapter<DOOR> doorArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, DOOR.values());
        doorArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        doorSpinner.setAdapter(doorArrayAdapter);
        doorSpinner.setPrompt("Door");



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag = true;

                if(nameCarModelEditText.getText().toString().trim().length()==0) {
                    nameCarModelEditText.setHint("Please enter the name of the car model");
                    nameCarModelEditText.setHintTextColor(Color.RED);
                    flag = false;
                }
                else if(volumeEditText.getText().toString().trim().length()==0){
                    volumeEditText.setHint("Please enter the motor volume");
                    volumeEditText.setHintTextColor(Color.RED);
                    flag = false;
                }

                if(flag) {
                    ContentValues contentValues = new ContentValues();

                    contentValues.put(Academy_Const.CarModelConst.COMPANY_NAME, brandSpinner.getSelectedItem().toString());
                    contentValues.put(Academy_Const.CarModelConst.LUGAGE_COMPARTMENT, lugageSpinner.getSelectedItem().toString());
                    contentValues.put(Academy_Const.CarModelConst.AIR_C, airCSwitch.isChecked());
                    contentValues.put(Academy_Const.CarModelConst.GEARBOX_TYPE, automaticSwitch.isChecked());
                    contentValues.put(Academy_Const.CarModelConst.MODEL_NAME, nameCarModelEditText.getText().toString());
                    contentValues.put(Academy_Const.CarModelConst.COLOR, colorSpinner.getSelectedItem().toString());
                    contentValues.put(Academy_Const.CarModelConst.DOOR, doorSpinner.getSelectedItem().toString());
                    contentValues.put(Academy_Const.CarModelConst.MOTOR_VOLUME, volumeEditText.getText().toString());
                    contentValues.put(Academy_Const.CarModelConst.PASSENGERS, passengerSpinner.getSelectedItem().toString());


                    new Task.AddCarModelTask(getApplicationContext()).execute(contentValues);

                    airCSwitch.setChecked(false);
                    automaticSwitch.setChecked(false);
                    nameCarModelEditText.setText(null);
                    brandSpinner.setSelection(0);
                    lugageSpinner.setSelection(0);
                    passengerSpinner.setSelection(0);
                    colorSpinner.setSelection(0);
                    doorSpinner.setSelection(0);
                    volumeEditText.setText(null);

                }
            }
        });

    }
}
