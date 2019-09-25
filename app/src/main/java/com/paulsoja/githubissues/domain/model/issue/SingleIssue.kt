package com.paulsoja.githubissues.domain.model.issue

import com.paulsoja.githubissues.domain.model.user.User

data class SingleIssue(
    val url: String,
    val repoUrl: String,
    val labelsUrl: String,
    val commentsUrl: String,
    val eventsUrl: String,
    val htmlUrl: String,
    val id: Int,
    val node_id: String,
    val issueNumber: Int,
    val issueTitle: String,
    val user: User,
    val labels: List<Labels> = listOf(),
    val state: String,
    val isLocked: Boolean,
    val assignee: User?,
    val assignees: List<User> = listOf(),
    val milestone: String?,
    val comments: String?,
    val createdAt: String,
    val updatedAt: String?,
    val closedAt: String?,
    val authorAssociation: String,
    val issueBody: String?,
    val closedBy: String?
)