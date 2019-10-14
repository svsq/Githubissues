package com.paulsoja.githubissues.presentation.ui.flow.projects.projects

import com.paulsoja.githubissues.presentation.base.BaseView
import com.paulsoja.githubissues.presentation.model.projects.ProjectsMarker

interface ProjectsView : BaseView {
    fun initViews()
    fun onSuccessProjects(list: List<ProjectsMarker>)
    fun showLoading()
    fun hideLoading()
}