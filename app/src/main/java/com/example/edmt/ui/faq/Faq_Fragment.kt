package com.example.edmt.ui.faq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.edmt.R


class Faq_Fragment : Fragment() {

    private lateinit var faqviewmodelZ : Faq_ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        faqviewmodelZ =
            ViewModelProvider(this).get(Faq_ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_faq, container, false)
        val textView: TextView = root.findViewById(R.id.text_faq)
        faqviewmodelZ.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}