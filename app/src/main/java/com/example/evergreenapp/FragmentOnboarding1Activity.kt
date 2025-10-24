// FILE: src/main/java/com/example/evergreenapp/FragmentOnboarding1.kt
package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment

class FragmentOnboarding1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding_1, container, false)

        val viewPager = activity?.findViewById<androidx.viewpager2.widget.ViewPager2>(R.id.view_pager)
        val nextButton = view.findViewById<Button>(R.id.btn_next)
        val skipButton = view.findViewById<TextView>(R.id.skip_button)


        activity?.window?.apply {
            statusBarColor = ContextCompat.getColor(requireContext(), android.R.color.black)
            WindowInsetsControllerCompat(this, decorView).isAppearanceLightStatusBars = true
        }

        nextButton.setOnClickListener {
            viewPager?.currentItem = 1
        }

        // Skip button goes to LoginActivity
        skipButton.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return view
    }
}
