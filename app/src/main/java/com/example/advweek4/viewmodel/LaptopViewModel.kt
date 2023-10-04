package com.example.advweek4.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advweek4.model.Laptop
import com.example.advweek4.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class LaptopViewModel(application: Application): AndroidViewModel(application) {
    val laptopLD = MutableLiveData<ArrayList<Laptop>>()
    val laptopLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        Log.d("CEKMASUK", "masukvolley")
        laptopLoadErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/laptop/laptop.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Laptop>>() { }.type
                val result = Gson().fromJson<List<Laptop>>(it, sType)
                laptopLD.value = result as ArrayList<Laptop>?
                loadingLD.value = false
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                laptopLoadErrorLD.value = true
                loadingLD.value = false
            },

            )


        stringRequest.setTag(TAG)
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

}

