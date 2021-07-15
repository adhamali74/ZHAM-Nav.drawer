package com.example.edmt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.edmt.databinding.FragmentWelcome0Binding


class Welcome0 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcome0Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome0, container, false)
        binding.getStartedButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_welcome0_to_welcome1)
        }
        return binding.root
    }


}