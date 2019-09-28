package com.paulsoja.githubissues.domain.interactor.sample

import com.paulsoja.githubissues.domain.interactor.base.SingleUseCase
import com.paulsoja.githubissues.domain.mapper.SampleViewModelMapper
import com.paulsoja.githubissues.domain.repository.SampleRepository
import com.paulsoja.githubissues.presentation.model.SampleMainViewModel
import com.paulsoja.githubissues.presentation.model.SampleMarker
import io.reactivex.Single
import javax.inject.Inject

class GetSampleUseCase @Inject constructor(
    private val sampleRepository: SampleRepository,
    private val sampleViewModelMapper: SampleViewModelMapper
) : SingleUseCase<List<SampleMarker>, GetSampleUseCase.Params>() {

    override fun buildSingleUseCase(params: Params): Single<List<SampleMarker>> {
        return Single.just(stubData())
        /*return sampleRepository.getSampleData(params.sample).map {
            sampleViewModelMapper.map(it)
        }*/
    }

    private fun stubData(): List<SampleMarker> {
        val list = mutableListOf<SampleMainViewModel>()
        list.add(SampleMainViewModel("id", "name", "email"))
        list.add(SampleMainViewModel("id2", "name2", "email4"))
        list.add(SampleMainViewModel("id3", "name3", "email2"))
        list.add(SampleMainViewModel("id4", "name4", "email3"))
        val result = mutableListOf<SampleMarker>()
        result.addAll(list)
        return list
    }

    data class Params(val sample: String, val sample2: String)

}