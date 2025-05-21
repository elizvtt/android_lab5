package com.example.lab5_palazova

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lab5_palazova.task1.GridFragment
import com.example.lab5_palazova.task2.Fragment2

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GridFragment()
            1 -> Fragment2()
            else -> GridFragment()
        }
    }

    override fun getItemCount(): Int = 2


}