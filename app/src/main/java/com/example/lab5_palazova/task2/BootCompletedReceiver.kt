package com.example.lab5_palazova.task2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.d("BootReceiver", "Пристрій завантажився")
            Toast.makeText(context, "Пристрій завантажився", Toast.LENGTH_LONG).show()
        }
    }
}
//  /c/Android/Sdk/platform-tools/adb logcat -d | grep "Пристрій завантажився"