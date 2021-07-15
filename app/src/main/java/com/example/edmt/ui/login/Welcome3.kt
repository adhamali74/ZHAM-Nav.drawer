package com.example.edmt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.edmt.databinding.FragmentWelcome2Binding
import com.example.edmt.databinding.FragmentWelcome3Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [welcome3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Welcome3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcome3Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome3, container, false)
        binding.welcome3FinishButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_welcome3_to_login)
        }

        return binding.root
    }

}