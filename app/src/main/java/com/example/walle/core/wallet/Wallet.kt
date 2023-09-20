package com.example.walle.core.wallet

import com.example.walle.core.model.CoinInfo

abstract class Wallet<T> {
    abstract fun generateCoins()
    abstract fun generateTokens()
    abstract fun getAllCoinsInfo(): List<CoinInfo>?
    abstract fun getVersion(): Int

}
