package com.example.edmt.ui.faq

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Faq_ViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is FAQs Fragment"
    }
    val text: LiveData<String> = _text
}