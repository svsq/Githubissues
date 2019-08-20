package com.paulsoja.githubissues.data

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HttpAuthInterceptor @Inject constructor(
    //private val preferencesRepository: PreferencesRepository
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        //Build new request
        val builder = request.newBuilder()

        builder.header("Accept-Language", "uk")
        builder.header("x-version", "14")
        /*preferencesRepository.getToken()?.let { token ->
            builder.header("Authorization", "Bearer $token")
            Timber.d("Auth token = $token")
        }
        if (!isExceptions(chain.request().url().toString())) {
            preferencesRepository.getChain()?.let {
                builder.header("x-chain", it)
            }
        }*/

        request = builder.build()
        return chain.proceed(request)
    }

}