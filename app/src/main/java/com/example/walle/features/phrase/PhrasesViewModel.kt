package com.example.walle.features.phrase

import androidx.lifecycle.ViewModel
import com.example.walle.features.phrase.data.PhraseLocalDataSourceImpl
import com.example.walle.features.phrase.domain.PhraseRepositoryImpl

class PhrasesViewModel constructor(

): ViewModel() {


    private val repo = PhraseRepositoryImpl(dataSource = PhraseLocalDataSourceImpl())

    var mnemonic: List<String> = listOf()

    init {

        mnemonic = repo.generateMnemonics()
    }



}