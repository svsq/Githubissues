package com.paulsoja.githubissues.domain.mapper

import com.paulsoja.githubissues.data.mapper.Mapper
import com.paulsoja.githubissues.domain.model.sample.Sample
import com.paulsoja.githubissues.domain.model.sample.SampleViewModel
import javax.inject.Inject

class SampleViewModelMapper @Inject constructor() : Mapper<Sample, SampleViewModel>() {

    override fun reverse(to: SampleViewModel): Sample {
        throw NotImplementedError()
    }

    override fun map(from: Sample): SampleViewModel {
        return SampleViewModel(from.id, from.name, from.email)
    }

}