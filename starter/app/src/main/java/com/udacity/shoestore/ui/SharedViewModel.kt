package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    private val _shoeList : MutableLiveData<List<Shoe>> = MutableLiveData()
    val shoeList : LiveData<List<Shoe>> = _shoeList


    fun addNewShoe(shoe : Shoe) {
        val newList = shoeList.value.orEmpty().toMutableList()
        newList.add(shoe)
        _shoeList.value = newList
    }
}