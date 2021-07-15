package com.example.edmt.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edmt.ui.login.model.Login_schema
import com.example.edmt.ui.login.model.Signup_schema
import com.example.edmt.ui.login.model.Ride_request
import com.example.edmt.ui.login.model.cars
import com.example.edmt.ui.login.repository.Repository
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Query

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myresponse : MutableLiveData<Response<Login_schema>> = MutableLiveData()
    val myresponse2 : MutableLiveData<Response<Signup_schema>> = MutableLiveData()
    val myresponse3 : MutableLiveData<Response<JsonArray>> = MutableLiveData()


    fun pushPost(user: Login_schema){
        viewModelScope.launch {
            val response = repository.pushPost(user)
            myresponse.value = response
        }
    }

    fun Signup(user: Signup_schema){
        viewModelScope.launch {
            val response = repository.Signup(user)
            myresponse2.value = response
        }
    }

    fun get_cars(lat: Number,long: Number,Class: String){
        viewModelScope.launch {
            val response3 = repository.get_cars(lat,long,Class)
            myresponse3.value = response3
        }
    }

}