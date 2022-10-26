package com.example.domain.usecase.userPreferences

import com.example.domain.core.UseCase
import com.example.domain.exception.MissingParamsException
import com.example.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveNameUseCase(
    scope: CoroutineScope,
    private val repository: UserPreferencesRepository
) : UseCase<String, SaveNameUseCase.Params>(scope = scope) {

    override fun run(params: Params?) = flow {
        emit(
            when {
                params == null -> throw NullPointerException()
                params.name.isEmpty() -> throw MissingParamsException()
                else -> repository.saveName(params.name).toString()
            }
        )
    }

    data class Params(
        val name: String
    )
}