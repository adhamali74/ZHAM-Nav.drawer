package com.example.edmt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.edmt.databinding.FragmentWelcome0Binding
import com.example.edmt.databinding.FragmentWelcome1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [welcome1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Welcome1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcome1Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome1, container, false)
        binding.welcome1NextButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_welcome1_to_welcome2)
        }
        binding.welcome1SkipButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_welcome1_to_login)
        }
        return binding.root
    }

}