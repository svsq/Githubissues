package com.paulsoja.githubissues.data.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.paulsoja.githubissues.domain.PreferencesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesDataRepository @Inject constructor(
    private val preferences: SharedPreferences
) : PreferencesRepository {

    companion object {
        const val AUTH_TOKEN = "auth_token"
    }

    override fun saveToken(token: String?) {
        preferences.edit {
            putString(AUTH_TOKEN, token)
        }
    }

    override fun getToken(): String? {
        return preferences.getString(AUTH_TOKEN, null)
    }

    override fun clear() {
        preferences.edit().clear().apply()
    }

}