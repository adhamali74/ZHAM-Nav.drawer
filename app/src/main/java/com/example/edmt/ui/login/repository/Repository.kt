package com.example.edmt.ui.login.repository

import com.example.edmt.ui.login.API.retrofitInstance
import com.example.edmt.ui.login.API.retrofitInstance_ride
import com.example.edmt.ui.login.model.Login_schema
import com.example.edmt.ui.login.model.Signup_schema
import com.example.edmt.ui.login.model.trips
import com.example.edmt.ui.login.model.cars
import com.example.edmt.ui.login.model.Ride_request
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import okhttp3.ResponseBody

import retrofit2.Response

class Repository {

    suspend fun pushPost(user: Login_schema) :Response<Login_schema>{
        return retrofitInstance.api.pushPost(user)
    }

    suspend fun Signup(user: Signup_schema) :Response<Signup_schema>{
        return retrofitInstance.api.Signup(user)
    }
    suspend fun get_cars(lat: Number,long: Number,Class: String) :Response<JsonArray>{
        return retrofitInstance_ride.api.get_cars(lat,long,Class)
    }

    suspend fun get_class(Class: String) :Response<JsonObject>{
        return retrofitInstance_ride.api.get_class(Class)
    }
    suspend fun start_trip(trip: trips):Response<ResponseBody>{
        return retrofitInstance_ride.api.start_trip(trip)
    }
}