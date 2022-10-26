package com.example.di

import com.example.data.datasource.local.UserPreferenceDataSource
import com.example.data_local.datasource.UserPreferenceDataSourceImpl
import com.example.data_local.utils.DataStoreHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataLocalModule = module {

    single { DataStoreHelper(androidApplication()) }

    single<UserPreferenceDataSource> { UserPreferenceDataSourceImpl(get()) }

}