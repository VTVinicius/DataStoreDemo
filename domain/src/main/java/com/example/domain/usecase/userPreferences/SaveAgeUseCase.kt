package com.example.domain.usecase.userPreferences

import com.example.domain.core.UseCase
import com.example.domain.exception.MissingParamsException
import com.example.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.flow

class SaveAgeUseCase(
    scope: CoroutineScope,
    private val repository: UserPreferencesRepository
) : UseCase<String, SaveAgeUseCase.Params>(scope = scope) {

    override fun run(params: Params?) = flow {
        emit(
            when {
                params == null -> throw NullPointerException()
                params.age == null-> throw NullPointerException()
                else -> repository.saveAge(params.age).toString()
            }
        )
    }

    data class Params(
        val age: Int?
    )
}