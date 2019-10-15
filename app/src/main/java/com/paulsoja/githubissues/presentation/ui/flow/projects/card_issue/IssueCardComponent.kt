package com.paulsoja.githubissues.presentation.ui.flow.projects.card_issue

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.scope.PerFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent
interface IssueCardComponent : BaseComponent {
    fun inject(issueCardFragment: IssueCardFragment)
}