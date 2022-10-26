package com.example.di

import com.example.domain.core.ThreadContextProvider
import com.example.domain.usecase.userPreferences.GetAgeUseCase
import com.example.domain.usecase.userPreferences.GetNameUseCase
import com.example.domain.usecase.userPreferences.SaveAgeUseCase
import com.example.domain.usecase.userPreferences.SaveNameUseCase
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module {

    single {
        ThreadContextProvider()
    }

    factory { (scope: CoroutineScope) ->
        SaveNameUseCase(
            scope = scope,
            repository = get()
        )
    }
    factory { (scope: CoroutineScope) ->
        GetNameUseCase(
            scope = scope,
            repository = get()
        )
    }

    factory { (scope: CoroutineScope) ->
        SaveAgeUseCase(
            scope = scope,
            repository = get()
        )
    }
    factory { (scope: CoroutineScope) ->
        GetAgeUseCase(
            scope = scope,
            repository = get()
        )
    }
}
