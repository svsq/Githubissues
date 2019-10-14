package com.paulsoja.githubissues.presentation.ui.flow.projects.project_info

import com.paulsoja.githubissues.presentation.base.BaseView

interface ProjectInfoView : BaseView {
    fun initViews()
    fun showLoading()
    fun hideLoading()
}