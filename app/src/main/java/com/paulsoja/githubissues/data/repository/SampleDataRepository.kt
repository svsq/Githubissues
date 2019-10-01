package com.paulsoja.githubissues.data.repository

import com.paulsoja.githubissues.data.mapper.SampleMapper
import com.paulsoja.githubissues.data.net.SampleApi
import com.paulsoja.githubissues.domain.model.sample.Sample
import com.paulsoja.githubissues.domain.repository.SampleRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SampleDataRepository @Inject constructor(
    private val api: SampleApi,
    private val sampleMapper: SampleMapper
) : SampleRepository {

    override fun getSampleData(value: String): Single<List<Sample>> {
        return api.getSamples(value).map {
            sampleMapper.map(it)
        }
    }

}