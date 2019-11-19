package com.dragon.data_binding_binding_adapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var name : String = ""
    val url = "https://www.gstatic.com/images/branding/product/2x/photos_96dp.png"
    val string : MutableLiveData<String> = MutableLiveData<String>()

}