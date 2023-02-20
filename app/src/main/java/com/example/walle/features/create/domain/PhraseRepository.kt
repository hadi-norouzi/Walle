package com.example.walle.features.create.domain

import com.example.walle.features.wallet.data.model.WalletModel

interface PhraseRepository {

    suspend fun generateMnemonics(): List<String>

    suspend fun createWallet(wallet: WalletModel)
}