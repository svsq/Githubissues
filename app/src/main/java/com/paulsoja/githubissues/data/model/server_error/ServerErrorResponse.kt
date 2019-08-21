package com.paulsoja.githubissues.data.model.server_error

import com.google.gson.annotations.SerializedName

data class ServerErrorResponse(@SerializedName("errors") val errors: List<ServerErrorApiModel>)