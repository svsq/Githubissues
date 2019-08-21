package com.paulsoja.githubissues.data.model.server_error

import com.google.gson.annotations.SerializedName

data class ServerErrorApiModel(
  @SerializedName("error_code") val code: Int,
  @SerializedName("description") val description: String?,
  @SerializedName("field") val field: String? = null
)