package com.example.edmt.ui.about_us

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.edmt.R
import com.example.edmt.ui.edit_info.Edit_info_ViewModel

class About_us_Fragment : Fragment() {


    private lateinit var aboutUsViewmodel: About_Us_ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aboutUsViewmodel =
            ViewModelProvider(this).get(About_Us_ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_aboutus, container, false)
        val textView: TextView = root.findViewById(R.id.text_about_us)
        aboutUsViewmodel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}