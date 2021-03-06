package com.skelrath.mynirvana.domain.sharedPreferences.usecases

import com.skelrath.mynirvana.domain.sharedPreferences.repository.SharedPreferencesRepository

class ChangeUserNameUseCase(private val sharedPreferencesRepository: SharedPreferencesRepository) {
    fun invoke(userName: String) {
        sharedPreferencesRepository.updateSharedPreferencesValueByKey(
            USER_NAME, userName
        )
    }

    companion object {
        const val USER_NAME = "userName"
    }
}