package com.example.evergreenapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2


class OnboardingActivity : AppCompatActivity() {


    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)


        viewPager = findViewById(R.id.view_pager)


        val adapter = OnboardingPagerAdapter(this)


        viewPager.adapter = adapter
    }
}
