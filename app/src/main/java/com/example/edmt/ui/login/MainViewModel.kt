package com.example.edmt.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edmt.ui.login.API.retrofitInstance_ride
import com.example.edmt.ui.login.model.Login_schema
import com.example.edmt.ui.login.model.Signup_schema
import com.example.edmt.ui.login.model.trips
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
    val myresponse4 : MutableLiveData<Response<JsonObject>> = MutableLiveData()
    val myresponse5 : MutableLiveData<Response<ResponseBody>> = MutableLiveData()

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


    fun get_class(Class: String){
        viewModelScope.launch {
            val response4 = repository.get_class(Class)
            myresponse4.value = response4
        }
    }


    fun start_trip(trip: trips){
        viewModelScope.launch {
            val response5 = repository.start_trip(trip)
            myresponse5.value = response5
        }
    }

}