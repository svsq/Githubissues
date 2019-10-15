package com.paulsoja.githubissues.presentation.model.projects

import com.paulsoja.githubissues.domain.model.TypeEnum

enum class ProjectVisibility(override val type: String): TypeEnum {
    INTERNAL ("internal"),
    PUBLIC ("public"),
    PRIVATE ("private")
}