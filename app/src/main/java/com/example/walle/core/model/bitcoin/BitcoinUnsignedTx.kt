package com.example.walle.core.model.bitcoin

import com.example.walle.core.model.UtxoDTO

data class BitcoinUnsignedTx(
    val utxoList: List<UtxoDTO?>,
    val script: String,
    val destinationAddress: String,
    val amount: Long,
    val feePerByte: Long,
    val isMaxAmount: Boolean,
)
