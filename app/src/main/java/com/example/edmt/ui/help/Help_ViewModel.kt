package com.example.edmt.ui.help

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Help_ViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Help & Customer Service Fragment"
    }
    val text: LiveData<String> = _text
}