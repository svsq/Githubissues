package com.paulsoja.githubissues.presentation.ui.sample_flow

import androidx.core.os.bundleOf
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.paulsoja.githubissues.domain.model.sample.SampleScreenState
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.navigation.FlowFragment
import com.paulsoja.githubissues.presentation.navigation.Screens
import com.paulsoja.githubissues.presentation.utils.setLaunchScreen
import javax.inject.Inject

class SampleFlowFragment : FlowFragment(), SampleFlowView {

    companion object {
        private const val STATE_ARG = "SCREEN_TYPE"

        fun newInstance(screenType: SampleScreenState): SampleFlowFragment {
            return SampleFlowFragment().apply {
                arguments = bundleOf(STATE_ARG to screenType)
            }
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: SampleFlowPresenter
    lateinit var screenState: SampleScreenState

    @ProvidePresenter
    fun providePresenter(): SampleFlowPresenter {
        return presenter.apply {
            arguments?.let {
                screenState = it.getParcelable<SampleScreenState>(STATE_ARG)!!
            }
        }
    }

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.plusSampleFlowComponent()?.also {
            it.inject(this)
        }
    }

    override fun releaseDaggerDependency() {
        IssueInjector.clearSampleFlowComponent(closedComponent)
    }

    override fun initLaunchScreen() {
        navigator.setLaunchScreen(Screens.SampleScreen(screenState))
    }

    override fun onExit() {
        presenter.finishFlow()
    }

}