package com.paulsoja.githubissues.presentation.ui.flow.issue.projects.list

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.paulsoja.githubissues.presentation.model.projects.ProjectsMarker
import javax.inject.Inject

class ProjectsAdapter @Inject constructor() : ListDelegationAdapter<MutableList<ProjectsMarker>>() {

    init {
        items = mutableListOf()
        delegatesManager.addDelegate(ProjectDelegate())
    }

    fun swapData(list: List<ProjectsMarker>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

}