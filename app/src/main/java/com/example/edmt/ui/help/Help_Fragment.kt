package com.example.edmt.ui.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.edmt.R


class Help_Fragment : Fragment() {

    private lateinit var helpviewmodelZ : Help_ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        helpviewmodelZ =
            ViewModelProvider(this).get(Help_ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_help, container, false)
        val textView: TextView = root.findViewById(R.id.text_help)
        helpviewmodelZ.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

}