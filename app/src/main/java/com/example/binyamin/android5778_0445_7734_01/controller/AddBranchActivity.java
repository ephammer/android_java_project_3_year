package com.example.binyamin.android5778_0445_7734_01.controller;

import android.content.ContentValues;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.backend.Academy_Const;

public class AddBranchActivity extends AppCompatActivity {

    EditText mBranchCityEditText;
    EditText mBranchStreetEditText;
    EditText mBranchStreetNumberEditText;
    EditText mBranchAmountParkingPlaceEditText;

    Button mAddBranchButton;

    String branchName;
    int sectr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);

        // Initialize all the UI elements
        mBranchCityEditText = (EditText)findViewById(R.id.editText_branch_city);
        mBranchStreetEditText = (EditText)findViewById(R.id.editText_branch_street);
        mBranchStreetNumberEditText = (EditText)findViewById(R.id.editText_branch_street_number);
        mBranchAmountParkingPlaceEditText = (EditText)findViewById(R.id.editText_amount_parking_place);

        mAddBranchButton = (Button)findViewById(R.id.button_add_branch);

        mAddBranchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean flag = true;
                if(mBranchCityEditText.getText().toString().trim().length()==0) {
                    mBranchCityEditText.setHint("Please enter City");
                    mBranchCityEditText.setHintTextColor(Color.RED);
                    flag = false;
                }
                else if(mBranchStreetEditText.getText().toString().trim().length()==0) {
                     mBranchStreetEditText.setHint("Please enter Street");
                     mBranchStreetEditText.setHintTextColor(Color.RED);
                    flag = false;
                 }
                 else if(mBranchStreetNumberEditText.getText().toString().trim().length()==0) {
                     mBranchStreetNumberEditText.setHint("Please enter Street Number");
                     mBranchStreetNumberEditText.setHintTextColor(Color.RED);
                     flag = false;
                 }
                 else if(mBranchAmountParkingPlaceEditText.getText().toString().trim().length()==0) {
                     mBranchAmountParkingPlaceEditText.setHint("Please enter amount of parking places");
                     mBranchAmountParkingPlaceEditText.setHintTextColor(Color.RED);
                     flag = false;
                 }

                 if(flag)
                 {
                     sectr = (int)(Math.random() * 21 );
                     branchName = "Take&go " + mBranchStreetEditText.getText().toString().trim();

                     ContentValues contentValues = new ContentValues();

                     contentValues.put(Academy_Const.BranchConst.CITY,mBranchCityEditText.getText().toString().trim());
                     contentValues.put(Academy_Const.BranchConst.STREET, mBranchStreetEditText.getText().toString().trim());
                     contentValues.put(Academy_Const.BranchConst.NUMBER_STREET, Integer.parseInt(mBranchStreetNumberEditText.getText().toString().trim()));
                     contentValues.put(Academy_Const.BranchConst.AMOUNT_PARKING_PLACE, Integer.parseInt(mBranchAmountParkingPlaceEditText.getText().toString().trim()));
                     contentValues.put(Academy_Const.BranchConst.SECTOR , sectr);
                     contentValues.put(Academy_Const.BranchConst.NAME, branchName);

                     new Task.AddBranchTask(getApplicationContext()).execute(contentValues);

                     // Clean all the EditText Fields
                     mBranchCityEditText.setText("");
                     mBranchStreetEditText.setText("");
                     mBranchStreetNumberEditText.setText("");
                     mBranchAmountParkingPlaceEditText.setText("");
                     Toast.makeText(getApplicationContext(),"Branch succesfully added!",Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }
}
