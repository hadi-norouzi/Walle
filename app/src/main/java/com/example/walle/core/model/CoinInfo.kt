package com.example.walle.core.model

import wallet.core.jni.CoinType

data class CoinInfo(
    val address: String? = null,
    val decimals: Int = 0,
    val name: String? = null,
    val iso: String? = null,
    val privateKey: String? = null,
    val publicKey: String? = null,
    val transactionFields: List<TxField?>? = null,
    val enabled: Boolean = false,
    val coinType: CoinType? = null,
    val nativeCoinIso: String? = null,
    val networkName: String? = null,
    val isToken: Boolean = false,
    val isCustom: Boolean = false,
    val chainId: Int? = null,
    val smartContract: String? = null,
) {
    constructor(
        name: String,
        iso: String,
        address: String,
        decimals: String,
        privateKey: String,
        publicKey: String,
        transactionFields: List<TxField>,
        enabled: Boolean,
        coinType: CoinType,
        nativeCoinIso: String,
        networkName: String,
        isToken: Boolean,
        isCustom: Boolean,
        chainId: Int,
        smartContract: String,
    ) : this()
}
