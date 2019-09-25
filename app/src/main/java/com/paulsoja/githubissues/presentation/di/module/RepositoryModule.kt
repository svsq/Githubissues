package com.paulsoja.githubissues.presentation.di.module

import com.paulsoja.githubissues.data.repository.IssueDataRepository
import com.paulsoja.githubissues.data.repository.PreferencesDataRepository
import com.paulsoja.githubissues.data.repository.SampleDataRepository
import com.paulsoja.githubissues.domain.repository.IssueRepository
import com.paulsoja.githubissues.domain.repository.PreferencesRepository
import com.paulsoja.githubissues.domain.repository.SampleRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun preferencesRepository(preferencesRepositoryImpl: PreferencesDataRepository): PreferencesRepository

    @Binds
    @Singleton
    abstract fun sampleRepository(sampleDataRepository: SampleDataRepository): SampleRepository

    @Binds
    @Singleton
    abstract fun issueRepository(issueDataRepository: IssueDataRepository): IssueRepository

}