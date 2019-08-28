package com.paulsoja.githubissues.domain.repository

interface PreferencesRepository {

    fun saveToken(token: String?)
    fun getToken(): String?

    fun clear()

}