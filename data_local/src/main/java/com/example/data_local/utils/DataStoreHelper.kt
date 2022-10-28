package com.example.data_local.utils

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.first
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream

class DataStoreHelper(
    val context: Context
) {

    private var dataStore: DataStore<Preferences> = context.createDataStore(name = "settings")

    private val cryptoManager = CryptoManager()
    private var stringToDecrypt = ""
    private var stringToEncrypt = ""


    suspend fun saveString(key: String, value: String) {

        val stream = ByteArrayOutputStream()

        stringToEncrypt = value

        val bytes = stringToEncrypt.encodeToByteArray()

        stringToDecrypt = cryptoManager.encrypt(
            bytes = bytes,
            outputStream = stream
        ).decodeToString()

        val dataStoreKey = preferencesKey<String>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = stringToDecrypt
        }
    }

    suspend fun readString(key: String): String? {

        val dataStoreKey = preferencesKey<String>(key)
        val preferences = dataStore.data.first()

        //initialize an InputStream
        val inputStream: InputStream = ByteArrayInputStream(preferences[dataStoreKey]?.toByteArray())

        val decryptedBytes = cryptoManager.decrypt(inputStream)

        val decoded = decryptedBytes.decodeToString()

        decoded

        return decoded
    }

    suspend fun saveInt(key: String, value: Int) {
        val dataStoreKey = preferencesKey<Int>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    suspend fun readInt(key: String): Int? {
        val dataStoreKey = preferencesKey<Int>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }
}