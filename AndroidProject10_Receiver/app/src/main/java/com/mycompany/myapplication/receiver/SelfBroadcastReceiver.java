package com.mycompany.myapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SelfBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "SelfBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "수신");
        String title = intent.getStringExtra("title");
        Log.i(TAG, title);
    }
}
