package com.example.walle.features.create.domain

import com.example.walle.features.create.data.PhraseLocalDataSource
import com.example.walle.features.wallet.data.model.WalletModel

class PhraseRepositoryImpl constructor(

    private val dataSource: PhraseLocalDataSource
) : PhraseRepository {


    override suspend fun generateMnemonics(): List<String> {
        val mnemonic = dataSource.generateMnemonics().split(" ")
        if (mnemonic.size < 24) {
            throw java.lang.Exception()
        }
        return mnemonic
    }

    override suspend fun createWallet(wallet: WalletModel) {
        dataSource.createWallet(wallet.name, listOf())
    }
}