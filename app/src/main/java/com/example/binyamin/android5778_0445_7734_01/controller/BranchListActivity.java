package com.example.binyamin.android5778_0445_7734_01.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.binyamin.android5778_0445_7734_01.R;

public class BranchListActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_list);

        new Task.BranchListTask(this).execute();
    }
}
