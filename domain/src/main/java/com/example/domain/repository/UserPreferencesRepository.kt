package com.example.domain.repository

interface UserPreferencesRepository {

    suspend fun saveName(value: String)

    suspend fun readName(): String

    suspend fun saveAge(value: Int)

    suspend fun readAge(): Int
}