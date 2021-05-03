package com.example.edmt.ui.edit_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Edit_info_ViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is an Edit information Fragment"
    }
    val text: LiveData<String> = _text
}