package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Dragon

/**
 * MainViewModel is the bridge to communicate between data layer and ui layer.
 *
 * @author Lin Guo
 * @since 2021/2/26
 */

class MainViewmodel : ViewModel() {

    /**
     * The LiveData variable to observe Contact object list.
     */
    val dogsLiveData: LiveData<List<Dragon>>
        get() = _dogsLiveData

    private val _dogsLiveData = MutableLiveData<List<Dragon>>()

    private val dogs =
        mutableListOf<Dragon>(
            Dragon(dragonName = "A", dragonDescribe = "A", catch = false),
            Dragon(dragonName = "A", dragonDescribe = "A", catch = false),
            Dragon(dragonName = "A", dragonDescribe = "A", catch = false),
            Dragon(dragonName = "A", dragonDescribe = "A", catch = false),
            Dragon(dragonName = "A", dragonDescribe = "A", catch = false),
        )

    fun pullData() {
        _dogsLiveData.value = dogs
    }
}