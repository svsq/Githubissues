package com.paulsoja.githubissues.presentation.ui.flow.issue.projects

import com.arellomobile.mvp.InjectViewState
import com.paulsoja.githubissues.domain.interactor.project.GetProjectsUseCase
import com.paulsoja.githubissues.domain.mapper.ProjectViewModelMapper
import com.paulsoja.githubissues.presentation.base.BasePresenter
import com.paulsoja.githubissues.presentation.navigation.router.FlowRouter
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

@InjectViewState
class ProjectsPresenter @Inject constructor(
    private val flowRouter: FlowRouter,
    private val getProjectsUseCase: GetProjectsUseCase,
    private val projectViewModelMapper: ProjectViewModelMapper
) : BasePresenter<ProjectsView>() {

    override fun onFirstViewAttach() {
        viewState.initViews()
        loadProjects()
    }

    private fun loadProjects(visibility: String = "internal") {
        val params = GetProjectsUseCase.Params(visibility)
        disposables += getProjectsUseCase.execute(params)
            .doOnSubscribe { viewState.showLoadingDialog() }
            .doFinally { viewState.hideLoadingDialog() }
            .subscribe({
                viewState.onSuccessProjects(projectViewModelMapper.map(it))
            }, {
                handleRetrofitError(it)
            })
    }

}