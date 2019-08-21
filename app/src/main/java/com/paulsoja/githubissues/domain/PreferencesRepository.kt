package com.paulsoja.githubissues.domain

interface PreferencesRepository {

    fun saveToken(token: String?)
    fun getToken(): String?

    fun clear()

}