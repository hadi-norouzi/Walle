package com.example.walle.di

import androidx.room.Room
import com.example.walle.core.database.AppDatabase
import com.example.walle.features.create.PhrasesViewModel
import com.example.walle.features.create.data.PhraseLocalDataSource
import com.example.walle.features.create.data.PhraseLocalDataSourceImpl
import com.example.walle.features.create.domain.PhraseRepository
import com.example.walle.features.create.domain.PhraseRepositoryImpl
import com.example.walle.features.discover.presentation.DiscoverViewModel
import com.example.walle.features.splash.SplashViewModel
import com.example.walle.features.wallet.data.WalletDataSource
import com.example.walle.features.wallet.data.WalletDataSourceImpl
import com.example.walle.features.wallet.data.WalletRepository
import com.example.walle.features.wallet.domain.WalletRepositoryImpl
import com.example.walle.features.wallet.presentation.WalletViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {


    single { Room.databaseBuilder(get(), AppDatabase::class.java, "walle_database").build() }

    single { get<AppDatabase>().walletDao() }
    single { get<AppDatabase>().browserDao() }

    single<WalletDataSource> { WalletDataSourceImpl(get()) }
    single<WalletRepository> { WalletRepositoryImpl(get()) }

    viewModel { WalletViewModel(get()) }
    viewModel { SplashViewModel(get()) }

    single<PhraseLocalDataSource> { PhraseLocalDataSourceImpl(get()) }
    single<PhraseRepository> { PhraseRepositoryImpl(get()) }

    viewModel { PhrasesViewModel(get()) }




    viewModel { DiscoverViewModel(get()) }



}