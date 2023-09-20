package com.example.walle.core

import com.example.walle.core.model.CoinInfo
import com.example.walle.core.model.TxField
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

    abstract val transactionFields: List<TxField?>

    open fun getInfo(): CoinInfo? {
        return CoinInfo(
            name = name,
            iso = iso,
            address = address,
            decimals = decimals,
            privateKey = privateKey,
            publicKey = publicKey,
            transactionFields = transactionFields,
        )
    }
}
