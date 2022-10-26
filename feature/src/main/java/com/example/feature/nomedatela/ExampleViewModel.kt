package com.example.feature.nomedatela

import androidx.lifecycle.ViewModel
import base_feature.utils.extensions.*
import com.example.domain.repository.UserPreferencesRepository
import com.example.domain.usecase.userPreferences.GetAgeUseCase
import com.example.domain.usecase.userPreferences.GetNameUseCase
import com.example.domain.usecase.userPreferences.SaveAgeUseCase
import com.example.domain.usecase.userPreferences.SaveNameUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class ExampleViewModel : ViewModel(), KoinComponent {

    private val userPreferencesRepository: UserPreferencesRepository by inject()

    private val saveNameUseCase: SaveNameUseCase by useCase()
    private val getNameUseCase: GetNameUseCase by useCase()
    private val saveAgeUseCase: SaveAgeUseCase by useCase()
    private val getAgeUseCase: GetAgeUseCase by useCase()

    private val _saveNameViewState by viewState<String>()
    private val _getNameViewState by viewState<String>()
    private val _getAgeViewState by viewState<Int>()
    private val _saveAgeViewState by viewState<Int>()

    val saveNameViewState = _saveNameViewState.asLiveData()
    val getNameViewState = _getNameViewState.asLiveData()
    val getAgeViewState = _getAgeViewState.asLiveData()
    val saveAgeViewState = _saveAgeViewState.asLiveData()

    fun saveName(name: String) {
        saveNameUseCase(
            params = SaveNameUseCase.Params(name),
            onSuccess = {
                getName()
            },
            onError = {
                _saveNameViewState.postError(it)
            }
        )
    }

    fun saveAge(age: Int) {
        saveAgeUseCase(
            params = SaveAgeUseCase.Params(age),
            onSuccess = {
                getAge()
            },
            onError = {
                _saveAgeViewState.postError(it)
            }
        )
    }

    fun getName() {
        getNameUseCase(
            onSuccess = {
                _getNameViewState.postSuccess(it)
            },
            onError = {
                _getNameViewState.postError(it)
            }
        )
    }

    fun getAge() {
        getAgeUseCase(
            onSuccess = {
                _getAgeViewState.postSuccess(it)
            },
            onError = {
                _getAgeViewState.postError(it)
            }
        )
    }


//    private val getUsersLocalUseCase: GetUsersLocalUseCase by useCase()
//
//    private val _getUsersLocalViewState by viewState<List<GitUserModel>>()
//
//    val getUsersLocalViewState = _getUsersLocalViewState.asLiveData()
//
//    fun getUsersLocal() {
//        getUsersLocalUseCase(
//            onSuccess = {
//                _getUsersLocalViewState.postSuccess(it)
//            },
//            onError = {
//                _getUsersLocalViewState.postError(it)
//            }
//        )
//    }
}