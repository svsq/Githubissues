package com.paulsoja.githubissues.domain.model.project

data class Project(
    val id: Long,
    val title: String?,
    val description: String?,
    val avatar: String?,
    val forksCount: Int,
    val starCount: Int
)