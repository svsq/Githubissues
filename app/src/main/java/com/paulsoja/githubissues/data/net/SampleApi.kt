package com.paulsoja.githubissues.data.net

import com.paulsoja.githubissues.data.model.server_error.SampleApiModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SampleApi {

    @GET("sample/")
    fun getSamples(@Path("value") value: String): Single<List<SampleApiModel>>

}