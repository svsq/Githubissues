package com.paulsoja.githubissues.domain.model.project

data class Namespace(
    val id: Long,
    val name: String?,
    val path: String?,
    val kind: String?,
    val fullPath: String?
)