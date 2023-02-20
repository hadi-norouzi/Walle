package com.example.walle.core

import wallet.core.jni.CoinType

abstract class Coin {

    abstract val address: String

    abstract val publicKey: String

    abstract val privateKey: String

    open val decimals: Int = 8

    abstract val iso: String

    abstract val name: String

    abstract val networkName: String

    abstract val coinType: CoinType
}