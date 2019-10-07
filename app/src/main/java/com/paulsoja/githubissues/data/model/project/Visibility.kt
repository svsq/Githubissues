package com.paulsoja.githubissues.data.model.project

import com.google.gson.annotations.SerializedName

enum class Visibility(private val jsonName: String) {
    @SerializedName("public")
    PUBLIC("public"),
    @SerializedName("internal")
    INTERNAL("internal"),
    @SerializedName("private")
    PRIVATE("private");

    override fun toString() = jsonName
}