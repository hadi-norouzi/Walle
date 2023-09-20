package com.example.walle.core

object Util {

    fun fromHexString(encoded: String): ByteArray {
        require(encoded.length % 2 == 0) { "Input string must contain an even number of characters" }
        val result = ByteArray(encoded.length / 2)
        val enc = encoded.toCharArray()
        var i = 0
        while (i < enc.size) {
            val curr = StringBuilder(2)
            curr.append(enc[i]).append(enc[i + 1])
            result[i / 2] = curr.toString().toInt(16).toByte()
            i += 2
        }
        return result
    }
}
