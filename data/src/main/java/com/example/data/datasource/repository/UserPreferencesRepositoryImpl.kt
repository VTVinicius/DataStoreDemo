package com.example.data.datasource.repository

import com.example.data.datasource.local.UserPreferenceDataSource
import com.example.domain.repository.UserPreferencesRepository

class UserPreferencesRepositoryImpl(
    private val dataSource: UserPreferenceDataSource
) : UserPreferencesRepository {
    override suspend fun saveName(value: String) {
        dataSource.saveName(value)
    }

    override suspend fun readName(): String {
        return dataSource.readName()

    }

    override suspend fun saveAge(value: Int) {
        dataSource.saveAge(value)
    }

    override suspend fun readAge(): Int {
        return dataSource.readAge()
    }
}