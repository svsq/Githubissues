package com.paulsoja.githubissues.presentation.ui.sample_flow.sample

import com.paulsoja.githubissues.presentation.base.BaseView
import com.paulsoja.githubissues.presentation.model.SampleMarker

interface SampleView : BaseView {
    fun initViews()
    fun onSuccessLoadList(list: List<SampleMarker>)
    fun showLoadingDialog()
    fun hideLoadingDialog()
}