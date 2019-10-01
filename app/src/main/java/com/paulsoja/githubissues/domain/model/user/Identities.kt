package com.paulsoja.githubissues.domain.model.user

data class Identities(
    val provider: String,
    val externUid: String,
    val samlProviderId: String
)