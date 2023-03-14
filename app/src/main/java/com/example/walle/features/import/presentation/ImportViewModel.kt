package com.example.walle.features.import.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ImportViewModel constructor(

) : ViewModel() {

    var phrases by mutableStateOf("")
    var walletName by mutableStateOf("")


//    val state: ImportState

    val state = MutableStateFlow<ImportState>(ImportState.Init)


    init {
        getLastWalletCount()
    }


    fun validatePhrases(): Boolean {
        val length = phrases.split(" ").count()
        println(length)
        return  length == 12 || length == 24
    }

    fun getLastWalletCount() {

    }

    fun pasteMnemonic() {

    }

    fun importWallet() {
        viewModelScope.launch {
            state.value = ImportState.Loading
            delay(200)
            state.value = ImportState.Success

        }
    }
}