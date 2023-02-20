package com.example.walle.features.wallet.data

import com.example.walle.features.wallet.domain.entity.Wallet

interface WalletRepository {

    suspend fun getDefaultWallet(): Wallet
}