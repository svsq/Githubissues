package com.paulsoja.githubissues.presentation.ui.flow.projects.project_info

import com.arellomobile.mvp.InjectViewState
import com.paulsoja.githubissues.presentation.base.BasePresenter
import com.paulsoja.githubissues.presentation.navigation.router.FlowRouter
import javax.inject.Inject

@InjectViewState
class ProjectInfoPresenter @Inject constructor(
    private val flowRouter: FlowRouter
) : BasePresenter<ProjectInfoView>() {

    override fun onFirstViewAttach() {
        viewState.showLoading()
    }

}