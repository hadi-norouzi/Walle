package com.example.walle.features.create

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walle.core.bitcoin.Bitcoin
import com.example.walle.features.create.data.PhraseLocalDataSourceImpl
import com.example.walle.features.create.domain.PhraseRepository
import com.example.walle.features.create.domain.PhraseRepositoryImpl
import com.example.walle.features.wallet.data.model.WalletModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getKoin

class PhrasesViewModel constructor(private val repository: PhraseRepository) : ViewModel() {


    var mnemonic: List<String> by mutableStateOf(listOf())

    init {

        getMnemonics()
    }

    fun getMnemonics() {
        viewModelScope.launch {
            mnemonic = repository.generateMnemonics()

        }
    }


    fun createWallet() {
        viewModelScope.launch {
            repository.createWallet(WalletModel(name = "wallet1", isDefault = true, privateKey = ""))
        }
    }


}