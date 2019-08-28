package com.paulsoja.githubissues.data.model.server_error

import com.google.gson.annotations.SerializedName

data class SampleApiModel(
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("email") val email: String = ""
)