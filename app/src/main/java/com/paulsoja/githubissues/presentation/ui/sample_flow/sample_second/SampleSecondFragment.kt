package com.paulsoja.githubissues.presentation.ui.sample_flow.sample_second

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.base.BaseFragment
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.utils.onClick
import kotlinx.android.synthetic.main.fragment_sample_second.*
import javax.inject.Inject

class SampleSecondFragment : BaseFragment(), SampleSecondView {

    companion object {
        fun newInstance() = SampleSecondFragment()
    }

    override val layoutRes: Int = R.layout.fragment_sample_second

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.plusSampleSecondComponent()?.also {
            it.inject(this)
        }
    }

    override fun releaseDaggerDependency() {
        IssueInjector.clearSampleSecondComponent(closedComponent)
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: SampleSecondPresenter

    @ProvidePresenter
    fun providePresenter(): SampleSecondPresenter {
        return presenter
    }

    override fun initViews() {
        btnLogin.onClick {
            presenter.goToLoginScreen()
        }
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

}