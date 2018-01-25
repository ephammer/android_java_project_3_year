package com.example.binyamin.android5778_0445_7734_01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class FreeCarReceiver extends BroadcastReceiver {

    static int i =0;
    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        i++;
        Toast.makeText(context,"Received " + String.valueOf(i),Toast.LENGTH_SHORT).show();
    }
}
