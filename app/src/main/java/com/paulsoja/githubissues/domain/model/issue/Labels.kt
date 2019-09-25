package com.paulsoja.githubissues.domain.model.issue

data class Labels(
    val id: Long,
    val nodeId: String,
    val url: String,
    val name: String,
    val color: String,
    val default: Boolean
)