package com.example.walle.core.model

data class TxField(
    val id: Int = 0,
    val alias: String? = null,
    val name: String? = null,
    val type: Type? = null,
    val defaultValue: Number? = null,
    val minValue: Number? = null,
    val maxValue: Number? = null,
    val optional: Boolean = false,
    val customizable: Boolean = false,
)
enum class Type{
     INTEGER,
    DECIMAL,

    STRING
}
