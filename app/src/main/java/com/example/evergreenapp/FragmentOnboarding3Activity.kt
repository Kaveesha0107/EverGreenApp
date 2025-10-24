// FILE: src/main/java/com/example/evergreenapp/FragmentOnboarding3.kt
package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentOnboarding3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding_3, container, false)
        val viewPager = activity?.findViewById<androidx.viewpager2.widget.ViewPager2>(R.id.view_pager)
        val backButton = view.findViewById<ImageView>(R.id.back_button)
        val getStartedButton = view.findViewById<Button>(R.id.btn_get_started)
        val skipForNowButton = view.findViewById<Button>(R.id.btn_skip)

        backButton.setOnClickListener {
            viewPager?.currentItem = 1
        }

        val navigateToLogin = View.OnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        getStartedButton.setOnClickListener(navigateToLogin)

        // FIXED: Skip for now button also navigates to LoginActivity
        skipForNowButton.setOnClickListener(navigateToLogin)

        return view
    }
}