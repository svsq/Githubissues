package com.paulsoja.githubissues.presentation.model.projects

data class ProjectViewModel(
    val id: Long,
    val title: String?,
    val description: String?,
    val avatar: String?,
    val forksCount: Int,
    val starCount: Int
) : ProjectsMarker