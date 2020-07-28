package com.leandroid.formula1


import com.leandroid.formula1.champion.ChampionViewModel
import com.leandroid.formula1.home.HomeViewModel
import com.leandroid.formula1.info.InfoViewModel
import com.leandroid.formula1.race.RaceViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(androidApplication(),get()) }
    viewModel { RaceViewModel(androidApplication(),get()) }
    viewModel { ChampionViewModel(androidApplication(),get()) }
    viewModel { InfoViewModel(androidApplication(),get()) }
}

