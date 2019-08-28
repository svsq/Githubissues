package com.paulsoja.githubissues.presentation.ui.sample_flow.sample

import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.domain.model.sample.SampleScreenState
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.base.BaseFragment
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.model.SampleMarker
import com.paulsoja.githubissues.presentation.ui.sample_flow.sample.list.SampleAdapter
import com.paulsoja.githubissues.presentation.utils.onClick
import kotlinx.android.synthetic.main.fragment_sample.*
import javax.inject.Inject

class SampleFragment : BaseFragment(), SampleView {

    companion object {
        private const val STATE_ARG = "SCREEN_TYPE"

        fun newInstance(screenState: SampleScreenState): SampleFragment {
            return SampleFragment().apply {
                arguments = bundleOf(STATE_ARG to screenState)
            }
        }
    }

    override val layoutRes: Int = R.layout.fragment_sample

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.plusSampleComponent()?.also {
            it.inject(this)
        }
    }

    override fun releaseDaggerDependency() {
        IssueInjector.clearSampleCOmponent(closedComponent)
    }

    @Inject
    lateinit var adapter: SampleAdapter

    @Inject
    @InjectPresenter
    lateinit var presenter: SamplePresenter
    lateinit var screenState: SampleScreenState

    @ProvidePresenter
    fun providePresenter(): SamplePresenter {
        return presenter.apply {
            arguments?.let {
                screenState = it.getParcelable<SampleScreenState>(STATE_ARG)!!
            }
        }
    }

    override fun initViews() {
        sampleBtn.onClick { presenter.loadData("val1", "val2") }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(sampleRv) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@SampleFragment.adapter
            setHasFixedSize(true)
        }
    }

    override fun onSuccessLoadList(list: List<SampleMarker>) {
        adapter.swapData(list)
    }

    override fun showLoadingDialog() {
        //show
    }

    override fun hideLoadingDialog() {
        //hide
    }

}