package com.example.binyamin.android5778_0445_7734_01.controller;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TableRow;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.backend.Academy_Const;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Branch;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivityForResult;
import static java.security.AccessController.getContext;

public class BranchListActivity extends AppCompatActivity  implements IsAbleToCommunicateFragment {

    private long branchId;
    private long carModelId;
    private FrameLayout carModelListFrame ;
    private FrameLayout BranchListFrame  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_list);

        carModelListFrame = (FrameLayout) findViewById(R.id.addCarFrame);
        BranchListFrame= (FrameLayout) findViewById(R.id.branchListFrame);

        new Task.BranchListTask(this).execute();

    }

    private void addCarToBranch()
    {
        ContentValues car = new ContentValues();
        car.put(Academy_Const.CarConst.KILOMETRE , 0);
        car.put(Academy_Const.CarConst.TYPE_MODEL_ID , carModelId);
        car.put(Academy_Const.CarConst.BRANCH_ID_PARKED , branchId);
        car.put(Academy_Const.CarConst.ISFREE , "true");

        new Task.AddCarTask(this).execute(car);

    }
    private void displayAddCarFrame() {

        //design the GUI
        TableRow.LayoutParams paramsBranchList = new TableRow.LayoutParams();
        paramsBranchList.weight = 1f;
        paramsBranchList.height = 0;

        TableRow.LayoutParams paramsAddCarList = new TableRow.LayoutParams();
        paramsAddCarList.weight = 1f;
        paramsAddCarList.height = 0;

        carModelListFrame.setVisibility(View.VISIBLE);
        carModelListFrame.setLayoutParams(paramsAddCarList);

        BranchListFrame.setVisibility(View.GONE);
        new Task.CarModelListForAddTask(this).execute();

    }

    private void removeCarFrame()
    {

        carModelListFrame.setVisibility(View.GONE);

        // reset the size of the listView.
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.weight = 1f;
        params.height = 0;

        BranchListFrame.setVisibility(View.VISIBLE);
        BranchListFrame.setLayoutParams(params);

    }


    @Override
    public void sendData(COMUNICATE_BTWN_FRAG com, Object... data) {
        switch (com)
        {
            case BRANCH_LIST_TO_ADDCARMODEL:
                branchId = (Long) data[0];
                displayAddCarFrame();
                break;
            case ADDCARMODEL_TO_BRANCH_LIST:
                carModelId = (Long) data[0];
                removeCarFrame();
                //add The car
                addCarToBranch();
                break;

        }
    }
}
