package com.paulsoja.githubissues.presentation.ui.flow.sample.sample_first.list

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.paulsoja.githubissues.presentation.model.SampleMarker
import javax.inject.Inject

class SampleAdapter @Inject constructor() : ListDelegationAdapter<MutableList<SampleMarker>>() {

    init {
        items = mutableListOf()
        delegatesManager
            .addDelegate(SampleMainDelegate())
    }

    fun swapData(sample: List<SampleMarker>) {
        items.clear()
        items.addAll(sample)
        notifyDataSetChanged()
    }

}