package com.paulsoja.githubissues.presentation.ui.flow.projects.project_info

import androidx.core.view.isVisible
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.base.BaseFragment
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.utils.toast
import kotlinx.android.synthetic.main.fragment_project_info.*
import javax.inject.Inject

class ProjectInfoFragment : BaseFragment(R.layout.fragment_project_info), ProjectInfoView {

    companion object {
        fun newInstance() = ProjectInfoFragment()
    }

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.addProjectInfoComponent()?.also {
            it.inject(this)
        }
    }

    override fun releaseDaggerDependency() {
        IssueInjector.clearProjectInfoComponent(closedComponent)
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: ProjectInfoPresenter

    @ProvidePresenter
    fun providePresenter(): ProjectInfoPresenter {
        return presenter
    }

    override fun initViews() {
        toast("tadam")
    }

    override fun showLoading() {
        loadingView.isVisible = true
    }

    override fun hideLoading() {
        loadingView.isVisible = false
    }
}