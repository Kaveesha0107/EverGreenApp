// FILE: src/main/java/com/example/evergreenapp/FragmentOnboarding2.kt
package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentOnboarding2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding_2, container, false)
        val viewPager = activity?.findViewById<androidx.viewpager2.widget.ViewPager2>(R.id.view_pager)
        val backButton = view.findViewById<ImageView>(R.id.back_button)
        val nextButton = view.findViewById<Button>(R.id.btn_next)
        val skipButton = view.findViewById<TextView>(R.id.skip_button)

        backButton.setOnClickListener {
            viewPager?.currentItem = 0
        }

        nextButton.setOnClickListener {
            viewPager?.currentItem = 2
        }

        // FIXED: Skip button now navigates to LoginActivity
        skipButton.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return view
    }
}