package com.paulsoja.githubissues.presentation.ui.sample_flow.sample_first.list

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.model.SampleMainViewModel
import com.paulsoja.githubissues.presentation.model.SampleMarker
import com.paulsoja.githubissues.presentation.utils.inflate
import kotlinx.android.synthetic.main.list_item_sample.view.*

class SampleMainDelegate() : AdapterDelegate<MutableList<SampleMarker>>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_sample))
    }

    override fun isForViewType(items: MutableList<SampleMarker>, position: Int): Boolean {
        return items[position] is SampleMainViewModel
    }

    override fun onBindViewHolder(
        list: MutableList<SampleMarker>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payload: MutableList<Any>
    ) {
        val item = list[position] as SampleMainViewModel
        (holder as? ViewHolder)?.bind(item)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: SampleMainViewModel) {
            itemView.sampleId.text = model.id
            itemView.sampleName.text = model.name
            itemView.sampleEmail.text = model.email
        }
    }

}