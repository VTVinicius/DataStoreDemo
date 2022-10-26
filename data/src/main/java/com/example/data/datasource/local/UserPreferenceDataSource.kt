package com.example.data.datasource.local

interface UserPreferenceDataSource {

   suspend fun saveName(value: String)

    suspend fun readName(): String

    suspend fun saveAge(value: Int)

    suspend fun readAge(): Int

}