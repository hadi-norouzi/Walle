package com.example.walle.features.create

import com.example.walle.features.create.domain.PhraseRepository
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CreatePresenterTest {


    @Mock
    private lateinit var mockActivity: CreateContract.CreateViewInterface


    @Mock
    private lateinit var mockRepository: PhraseRepository


    lateinit var createPresenter: CreatePresenter


    @Before
    fun setup() {
        createPresenter = CreatePresenter(mockActivity, mockRepository)
    }


    @Test
    fun `test get random mnemonics`() {
    }

}