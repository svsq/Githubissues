package com.paulsoja.githubissues.data.mapper

import com.paulsoja.githubissues.data.model.server_error.SampleApiModel
import com.paulsoja.githubissues.domain.model.sample.Sample
import javax.inject.Inject

class SampleMapper @Inject constructor() : Mapper<SampleApiModel, Sample>() {
    override fun reverse(to: Sample): SampleApiModel {
        throw NotImplementedError()
    }

    override fun map(from: SampleApiModel): Sample {
        return with(from) {
            Sample(id, name, email)
        }
    }
}