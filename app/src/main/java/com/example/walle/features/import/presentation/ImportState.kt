package com.example.walle.features.import.presentation

sealed class ImportState {
    object Init: ImportState()
    object Loading: ImportState()
    object Success : ImportState()
    data class Failure(val message: String): ImportState()
}
