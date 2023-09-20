package com.example.walle.core.model

data class UtxoDTO(
    val transactionHash: String,
    val transactionIndex: Int,
    val value: Long,
    val rawTx: String,
)
