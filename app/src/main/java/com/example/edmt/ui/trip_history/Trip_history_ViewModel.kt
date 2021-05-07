package com.example.edmt.ui.trip_history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Trip_history_ViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Trip History Fragment"
    }
    val text: LiveData<String> = _text
}