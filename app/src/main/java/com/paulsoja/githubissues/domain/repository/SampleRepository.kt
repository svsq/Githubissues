package com.paulsoja.githubissues.domain.repository

import com.paulsoja.githubissues.domain.model.sample.Sample
import io.reactivex.Single

interface SampleRepository {

    fun getSampleData(value: String): Single<List<Sample>>

}