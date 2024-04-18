package com.example.simplelivedataexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ExampleViewModel : ViewModel() {
    private var number = 0

    // MutableLiveData example
    private val _currentNumber = MutableLiveData<Int>()
    val currentNumber: LiveData<Int> = _currentNumber

    private val _currentBoolean = MutableLiveData<Boolean>()
    val currentBoolean: LiveData<Boolean> = _currentBoolean

    init {
        _currentNumber.value = number
        _currentBoolean.value = false
    }

    fun incrementNumber() {
        number++
        _currentNumber.value = number
        _currentBoolean.value = number % 2 == 0
    }

    // MediatorLiveData example
    val numberInfo: LiveData<String> = MediatorLiveData<String>().apply {
        addSource(currentNumber) { number ->
            value = "Current Number: $number, Even: ${number % 2 == 0}"
        }
        addSource(currentBoolean) { isEven ->
            value = "Current Number: ${currentNumber.value}, Even: $isEven"
        }
    }

    // Transformations.map example
    val isNumberEven: LiveData<Boolean> = Transformations.map(currentNumber) {
        it % 2 == 0
    }
}