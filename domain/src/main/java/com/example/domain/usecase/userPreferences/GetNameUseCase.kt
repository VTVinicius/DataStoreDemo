package com.example.domain.usecase.userPreferences

import com.example.domain.core.UseCase
import com.example.domain.exception.MissingParamsException
import com.example.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNameUseCase(
    scope: CoroutineScope,
    private val repository: UserPreferencesRepository
): UseCase<String, Unit>(scope = scope) {

    override fun run(params: Unit?) = flow { repository.readName().let { emit(it) } }

}