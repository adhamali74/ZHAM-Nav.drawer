package com.example.edmt.ui.about_us

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class About_Us_ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is an About Us Fragment"
    }
    val text: LiveData<String> = _text
}