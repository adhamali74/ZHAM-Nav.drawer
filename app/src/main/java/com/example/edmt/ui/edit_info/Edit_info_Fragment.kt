package com.example.edmt.ui.edit_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.edmt.R

class Edit_info_Fragment : Fragment() {

    private lateinit var editEdit_info_ViewModel : Edit_info_ViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        editEdit_info_ViewModel =
                ViewModelProvider(this).get(Edit_info_ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_editinfo, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        editEdit_info_ViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}