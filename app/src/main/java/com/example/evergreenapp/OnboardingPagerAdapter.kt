package com.example.evergreenapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class OnboardingPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // The total number of onboarding screens.
    private val NUM_PAGES = 3

    // Returns the number of fragments to display.
    override fun getItemCount(): Int = NUM_PAGES

    // Creates and returns the correct Fragment for the given position.
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentOnboarding1()
            1 -> FragmentOnboarding2()
            else -> FragmentOnboarding3()
        }
    }
}
