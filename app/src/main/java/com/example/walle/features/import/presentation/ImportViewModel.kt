package com.example.walle.features.import.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ImportViewModel constructor(

) : ViewModel() {

    var phrases by mutableStateOf("")
    var walletName by mutableStateOf("")

    init {
        getLastWalletCount()
    }


    fun validatePhrases(): Boolean {
        return (phrases.length != 12)
    }

    fun getLastWalletCount() {

    }

    fun pasteMnemonic() {

    }
}