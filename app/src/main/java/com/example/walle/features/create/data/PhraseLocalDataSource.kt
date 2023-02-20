package com.example.walle.features.create.data

import com.example.walle.features.wallet.data.model.WalletModel

interface PhraseLocalDataSource {

    fun generateMnemonics(): String

    suspend fun createWallet(name: String?, mnemonic: List<String>): WalletModel


}