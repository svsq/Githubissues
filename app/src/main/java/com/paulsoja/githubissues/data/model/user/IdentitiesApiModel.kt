package com.paulsoja.githubissues.data.model.user

import com.google.gson.annotations.SerializedName

data class IdentitiesApiModel(
    @SerializedName("provider") val provider: String,
    @SerializedName("extern_uid") val externUid: String,
    @SerializedName("saml_provider_id") val samlProviderId: String
)