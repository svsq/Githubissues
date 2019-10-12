package com.paulsoja.githubissues.presentation.ui.flow.issue.projects

import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.base.BaseFragment
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.model.projects.ProjectViewModel
import com.paulsoja.githubissues.presentation.model.projects.ProjectsMarker
import com.paulsoja.githubissues.presentation.ui.flow.issue.projects.list.ProjectsAdapter
import com.paulsoja.githubissues.presentation.utils.toast
import kotlinx.android.synthetic.main.fragment_projects.*
import javax.inject.Inject

class ProjectsFragment : BaseFragment(R.layout.fragment_projects), ProjectsView, ProjectsAdapter.Callback {

    companion object {
        fun newInstance() = ProjectsFragment()
    }

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.addProjectsComponent()?.also {
            it.inject(this)
        }
    }

    override fun releaseDaggerDependency() {
        IssueInjector.clearProjectsComponent(closedComponent)
    }

    @Inject
    lateinit var adapter: ProjectsAdapter

    override fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter.callback = this
        with(rvProjects) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ProjectsFragment.adapter
            setHasFixedSize(true)
        }
    }

    override fun onSuccessProjects(list: List<ProjectsMarker>) {
        adapter.swapData(list)
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: ProjectsPresenter

    @ProvidePresenter
    fun providePresenter(): ProjectsPresenter {
        return presenter
    }

    override fun showLoadingDialog() {
    }

    override fun hideLoadingDialog() {
    }

    override fun onProject(project: ProjectViewModel) {
        toast("test")
    }

}