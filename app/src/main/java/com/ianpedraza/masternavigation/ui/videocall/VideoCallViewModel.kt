package com.ianpedraza.masternavigation.ui.videocall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class VideoCallViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> get() = _name

    val isButtonEnabled: LiveData<Boolean> = Transformations.map(name) { name ->
        !name.isNullOrEmpty()
    }

    private val _navigate = MutableLiveData<String?>()
    val navigate: LiveData<String?> get() = _navigate

    fun setName(name: String) {
        _name.value = name.uppercase()
    }

    fun navigate() {
        _navigate.value = _name.value
    }

    fun onNavigated() {
        _navigate.value = null
    }
}
