package com.example.walle.features.phrase.domain

interface PhraseRepository {

    fun generateMnemonics(): List<String>
}