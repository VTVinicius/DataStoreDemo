package com.example.domain.usecase.userPreferences

import com.example.domain.core.UseCase
import com.example.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.flow

class GetAgeUseCase(
    scope: CoroutineScope,
    private val repository: UserPreferencesRepository
) : UseCase<Int, Unit>(scope = scope) {

    override fun run(params: Unit?) = flow { repository.readAge().let { emit(it) } }

}