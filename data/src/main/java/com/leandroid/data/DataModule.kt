package com.leandroid.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.leandroid.data.local.dao.AppDatabase
import com.leandroid.data.local.implementation.ChampionRepositoryImpl
import com.leandroid.data.local.implementation.PilotRepositoryImpl
import com.leandroid.data.local.implementation.RaceRepositoryImpl
import com.leandroid.data.local.repository.ChampionRepository
import com.leandroid.data.local.repository.PilotRepository
import com.leandroid.data.local.repository.RaceRepository
import com.leandroid.data.local.store.LocalChampionStore
import com.leandroid.data.local.store.LocalPilotStore
import com.leandroid.data.local.store.LocalRaceStore
import com.leandroid.data.network.InterceptorFactory
import com.leandroid.data.network.OkHttpFactory
import com.leandroid.data.network.RetrofitFactory
import com.leandroid.data.network.authentication.interceptor.AuthenticationInterceptor
import com.leandroid.data.network.champion.ChampionServiceImpl
import com.leandroid.data.network.pilot.PilotServiceImpl
import com.leandroid.data.network.race.RaceServiceImpl
import com.leandroid.data.network.service.ChampionService
import com.leandroid.data.network.service.PilotService
import com.leandroid.data.network.service.RaceService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import org.koin.android.ext.koin.androidContext
import retrofit2.Converter
import retrofit2.converter.jackson.JacksonConverterFactory
import java.text.SimpleDateFormat
import java.util.*


val dataModule = module {

    //region Network
    single<Retrofit> {
        RetrofitFactory().getRetrofitInstance(androidContext(), get(), get(), get())
    }

    single {
        OkHttpFactory().getOkHttpInstance(get())
    }

    single {
        InterceptorFactory(get())
    }

    single {
        AuthenticationInterceptor()
    }

    single {
        RxJava2CallAdapterFactory.create()
    }

    single<Converter.Factory> {
        val objectMapper = jacksonObjectMapper()
        objectMapper.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)


        val defaultDateFormat = androidContext().getString(R.string.DEFAULT_DATE_FORMAT)
        objectMapper.dateFormat = SimpleDateFormat(defaultDateFormat, Locale.US)

        objectMapper.registerModule(ThreeTenModule())

        JacksonConverterFactory.create(objectMapper)
    }

    //region DAO
    single {
        get<AppDatabase>().raceDao()
    }

    single {
        get<AppDatabase>().pilotDao()
    }

    single {
        get<AppDatabase>().championDao()
    }

    //region Race
    single {
        LocalRaceStore(get())
    }

    single<RaceService> {
        RaceServiceImpl(get())
    }

    single<RaceRepository> {
        RaceRepositoryImpl(get())
    }

    //region Pilot
    single {
        LocalPilotStore(get())
    }

    single<PilotRepository> {
        PilotRepositoryImpl(get())
    }

    single<PilotService> {
        PilotServiceImpl(get())
    }

    //region champion
    single {
        LocalChampionStore(get())
    }

    single<ChampionService> {
        ChampionServiceImpl(get())
    }

    single<ChampionRepository> {
        ChampionRepositoryImpl(get())
    }

    single { ChampionServiceImpl(get()) }

}