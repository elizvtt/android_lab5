package com.example.lab5_palazova.task2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.lab5_palazova.R
import com.example.lab5_palazova.databinding.SecondFragmentBinding

class Fragment2 : Fragment() {

    private lateinit var powerReceiver: BroadcastReceiver
    private lateinit var airplaneReceiver: BroadcastReceiver
    private lateinit var textViewPower: TextView
    private lateinit var textViewAirplane: TextView
    private lateinit var powerImage: ImageView
    private lateinit var airplaneImage: ImageView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = SecondFragmentBinding.inflate(inflater, container, false)
        textViewPower = binding.textView1
        textViewAirplane = binding.textView2
        powerImage = binding.imageView3
        airplaneImage = binding.imageView4
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        powerReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent?.action == Intent.ACTION_POWER_CONNECTED) {
                    textViewPower.text = "Зарядка підключена!"
                    powerImage.setImageResource(R.drawable.icon_battery)
                }
            }
        }
        val powerIntentFilter = IntentFilter(Intent.ACTION_POWER_CONNECTED)
        requireActivity().registerReceiver(powerReceiver, powerIntentFilter)

        airplaneReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
                    val isAirplaneMode = intent.getBooleanExtra("state", false)
                    textViewAirplane.text = if (isAirplaneMode) "Режим польоту увімкнено" else "Режим польоту вимкнено"
                    airplaneImage.setImageResource(
                        if (isAirplaneMode) R.drawable.icon_plane else R.drawable.icon_plane_slash
                    )
                }
            }
        }
        val airplaneIntentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        requireActivity().registerReceiver(airplaneReceiver, airplaneIntentFilter)
    }

    override fun onStop() {
        super.onStop()

        requireActivity().unregisterReceiver(powerReceiver)
        requireActivity().unregisterReceiver(airplaneReceiver)
    }
}