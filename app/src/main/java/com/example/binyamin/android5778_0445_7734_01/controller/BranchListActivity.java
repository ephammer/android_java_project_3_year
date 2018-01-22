package com.example.binyamin.android5778_0445_7734_01.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.backend.Academy_Const;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Branch;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivityForResult;
import static java.security.AccessController.getContext;

public class BranchListActivity extends AppCompatActivity  {

    public static final int REQUEST_CODE = 1;
    private long branchId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_list);
        new Task.BranchListTask(this).execute();

    }


}
