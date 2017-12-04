package com.example.binyamin.android5778_0445_7734_01.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.entities.Branch;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;

import java.util.List;

/**
 * Created by ehammer on 04/12/2017.
 */

public class BranchAdapter extends ArrayAdapter<Branch> {


    public BranchAdapter(@NonNull Context context, @NonNull List<Branch> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.branch_list_item, parent, false);
        }
        // Get the {@link Branch} object located at this position in the list
        Branch currentBranch = getItem(position);

        TextView cityTextView = (TextView)listItemView.findViewById(R.id.textView_branch_city);
        TextView streetTextView = (TextView)listItemView.findViewById(R.id.textView_branch_street);
        TextView numberTextView = (TextView)listItemView.findViewById(R.id.textView_branch_street_number);
        TextView amountParkingPlacesTextView = (TextView)listItemView.findViewById(R.id.textView_amount_parking_place);

        cityTextView.setText(currentBranch.getBranchCity());
        streetTextView.setText(currentBranch.getBranchStreet());
        numberTextView.setText(String.valueOf(currentBranch.getBranchStreetNumber()));
        amountParkingPlacesTextView.setText(String.valueOf(currentBranch.getBranchAmountParkingPlace()));

        return listItemView;
    }
}
