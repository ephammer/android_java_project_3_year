package com.example.binyamin.android5778_0445_7734_01.model.entities;

import java.util.Date;

public class Command {
    long commandId;
    long clientId;
    COMMAND_STATE commandState;
    long carId;
    Date startRentingDate;
    Date endRentingDate;
    int  startNumberKilometre;
    int endNumberKilometre;
    FUEL_STATE fuel_state;
    int amountOfLiterFilled;
    float price;


}
