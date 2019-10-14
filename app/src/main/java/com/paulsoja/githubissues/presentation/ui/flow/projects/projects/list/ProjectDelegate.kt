package com.paulsoja.githubissues.presentation.ui.flow.projects.projects.list

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.model.projects.ProjectViewModel
import com.paulsoja.githubissues.presentation.model.projects.ProjectsMarker
import com.paulsoja.githubissues.presentation.utils.inflate
import com.paulsoja.githubissues.presentation.utils.onClick
import kotlinx.android.synthetic.main.list_item_project.view.*

class ProjectDelegate : AdapterDelegate<MutableList<ProjectsMarker>>() {

    var callback: ((project: ProjectViewModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_project))
    }

    override fun isForViewType(items: MutableList<ProjectsMarker>, position: Int): Boolean {
        return items[position] is ProjectViewModel
    }

    override fun onBindViewHolder(
        list: MutableList<ProjectsMarker>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payload: MutableList<Any>
    ) {
        val item = list[position] as ProjectViewModel
        (holder as? ViewHolder)?.bind(item)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: ProjectViewModel) {
            itemView.onClick { callback?.invoke(model) }
            itemView.tvName.text = model.title
            itemView.tvDescription.text = model.description
            itemView.tvForkNumber.text = model.forksCount.toString()
            itemView.tvStarNumber.text = model.starCount.toString()
        }
    }

}