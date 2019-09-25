package com.paulsoja.githubissues.data.mapper

import com.paulsoja.githubissues.data.model.issue.LabelsApiModel
import com.paulsoja.githubissues.domain.model.issue.Labels
import javax.inject.Inject

class LabelsMapper @Inject constructor() : Mapper<LabelsApiModel, Labels>() {

    override fun reverse(to: Labels): LabelsApiModel {
        throw NotImplementedError()
    }

    override fun map(from: LabelsApiModel): Labels {
        return with(from) {
            Labels(id, nodeId, url, name, color, default)
        }
    }

}