package com.example.di

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.di.model.Advice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel(private val myRepository: MyRepository) : ViewModel() {
    private  val _advice: MutableLiveData<String> = MutableLiveData()

    val advice: LiveData<String> = _advice

    init {
        fetchAdvice()
    }

     fun fetchAdvice() {
        myRepository.getAdvice().enqueue(object: Callback<Advice> {
            override fun onResponse(call: Call<Advice>, response: Response<Advice>) {
                if (response.isSuccessful){
                    _advice.value = response.body()!!.slip.advice
                }
            }
            override fun onFailure(call: Call<Advice>, t: Throwable) {
                t.printStackTrace();
            }
        })
    }

}