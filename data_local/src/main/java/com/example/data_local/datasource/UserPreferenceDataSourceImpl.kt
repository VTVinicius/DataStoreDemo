package com.example.data_local.datasource

import com.example.data.datasource.local.UserPreferenceDataSource
import com.example.data_local.utils.DataStoreHelper
import com.example.domain.utils.UserPreferencesKeys

class UserPreferenceDataSourceImpl(
    private val dataStoreHelper: DataStoreHelper
) : UserPreferenceDataSource {
    override suspend fun saveName(value: String) {
        dataStoreHelper.saveString(UserPreferencesKeys.NAME.name, value)
    }

    override suspend fun readName(): String {
        return dataStoreHelper.readString(UserPreferencesKeys.NAME.name) ?: ""
    }

    override suspend fun saveAge(value: Int) {
        dataStoreHelper.saveInt(UserPreferencesKeys.AGE.name, value)
    }

    override suspend fun readAge(): Int {
        return dataStoreHelper.readInt(UserPreferencesKeys.AGE.name) ?: 0
    }
}