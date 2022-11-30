package com.example.walle.features.phrase.domain

import com.example.walle.features.phrase.data.PhraseLocalDataSource

class PhraseRepositoryImpl constructor(

    val dataSource: PhraseLocalDataSource
) : PhraseRepository {


    override fun generateMnemonics(): List<String> {
        return dataSource.generateMnemonics().split(" ")
    }
}