package com.example.infosysexample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infosysexample.Utils.VolleyClient
import com.example.infosysexample.dataclasses.CardG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//the view model is simple a list of cards and a way to make them
class MainViewModel : ViewModel() {
    init{
        getCardsList()
    }

    val cards= MutableLiveData<List<CardG>>()


    private fun getCardsList(){
        viewModelScope.launch(Dispatchers.IO) {
            cards.postValue(VolleyClient.getCardsG())
        }
    }
}