package com.paulsoja.githubissues.presentation.ui.flow.issue.projects.list

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.paulsoja.githubissues.presentation.model.projects.ProjectViewModel
import com.paulsoja.githubissues.presentation.model.projects.ProjectsMarker
import javax.inject.Inject

class ProjectsAdapter @Inject constructor() : ListDelegationAdapter<MutableList<ProjectsMarker>>() {

    val projectDelegate = ProjectDelegate()

    var callback: Callback? = null
    set(value) {
        field = value
        projectDelegate.callback = { project -> callback?.onProject(project) }
    }

    init {
        items = mutableListOf()
        delegatesManager.addDelegate(projectDelegate)
    }

    fun swapData(list: List<ProjectsMarker>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    interface Callback {
        fun onProject(project: ProjectViewModel)
    }

}