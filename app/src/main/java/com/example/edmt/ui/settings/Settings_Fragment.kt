package com.example.edmt.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.edmt.R
import kotlinx.android.synthetic.main.fragment_settings.*

class Settings_Fragment : Fragment() {
    private lateinit var settingviewmodelZ : Settings_ViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        settingviewmodelZ = ViewModelProvider(this).get(Settings_ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        val textView: TextView = root.findViewById(R.id.text_settings)
        settingviewmodelZ.text.observe(viewLifecycleOwner, Observer {
            textView.text = it

        })
        return root
    }

}