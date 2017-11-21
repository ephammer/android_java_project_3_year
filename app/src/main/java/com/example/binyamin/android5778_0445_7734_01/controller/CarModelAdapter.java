package com.example.binyamin.android5778_0445_7734_01.controller;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.binyamin.android5778_0445_7734_01.R;
import com.example.binyamin.android5778_0445_7734_01.model.entities.CarModel;

import java.util.ArrayList;

/**
 * Created by binyamin on 20/11/2017.
 */

public class CarModelAdapter extends ArrayAdapter<CarModel> {

    public CarModelAdapter(Activity context, ArrayList<CarModel> carModelArrayList) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, carModelArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.car_model_list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        CarModel currentCarModel = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView brandTextView = (TextView) listItemView.findViewById(R.id.brandTextView2);
        TextView lugageTextView = (TextView) listItemView.findViewById(R.id.luggageTextView2);
        TextView colorTextView = (TextView) listItemView.findViewById(R.id.colorTextView2);
        TextView passengerTextView = (TextView) listItemView.findViewById(R.id.passengerTextView);
        TextView volumeTextView = (TextView) listItemView.findViewById(R.id.vlmMotorTextView);
        CheckBox checkBoxAutomatic = (CheckBox) listItemView.findViewById(R.id.automaticCheckBox);
        CheckBox checkBoxAirC = (CheckBox) listItemView.findViewById(R.id.airCCheckBox);
        TextView idTextView = (TextView) listItemView.findViewById(R.id.idTextView);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.nameTextView);

        // Get the version name from the current Word object and
        // set this text on the name TextView
        brandTextView.setText(currentCarModel.getModelCompanyName());
        passengerTextView.setText(currentCarModel.getPassengers().toString());
        colorTextView.setText(currentCarModel.getColor().toString());
        lugageTextView.setText(currentCarModel.getLuggageCompartment().toString());
        volumeTextView.setText( String.valueOf(currentCarModel.getModelMotorVolume()));
        checkBoxAirC.setChecked(currentCarModel.isAirC());
        checkBoxAutomatic.setChecked(currentCarModel.isAutomatic());
        idTextView.setText("ID Type Car: " + String.valueOf(currentCarModel.getModelId()));
        nameTextView.setText(currentCarModel.getModelName());




        // Return the whole list item layout (containing 5 TextViews)
        // so that it can be shown in the ListView
        return listItemView;    }
}
