package com.example.di

import com.example.data.datasource.repository.UserPreferencesRepositoryImpl
import com.example.domain.repository.UserPreferencesRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserPreferencesRepository> { UserPreferencesRepositoryImpl(get()) }

}