package com.paulsoja.githubissues.domain.model.project

data class Permissions(
    val projectAccess: ProjectAccess?,
    val groupAccess: GroupAccess?
)