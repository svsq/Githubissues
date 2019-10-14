package com.paulsoja.githubissues.domain.model.project

data class SharedWithGroup(
    val groupId: Long,
    val groupName: String?,
    val groupAccessLevel: Long
)