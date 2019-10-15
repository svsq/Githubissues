package com.paulsoja.githubissues.data.mapper.project

import com.paulsoja.githubissues.data.mapper.Mapper
import com.paulsoja.githubissues.data.model.project.ProjectApiModel
import com.paulsoja.githubissues.domain.model.project.Project
import com.paulsoja.githubissues.presentation.model.projects.ProjectVisibility
import com.paulsoja.githubissues.presentation.utils.getEnumTypeValue
import javax.inject.Inject

class ProjectMapper @Inject constructor(
    private val ownerMapper: OwnerMapper,
    private val namespaceMapper: NamespaceMapper,
    private val permissionsMapper: PermissionsMapper,
    private val sharedWithGroupsMapper: SharedWithGroupsMapper
) : Mapper<ProjectApiModel, Project>() {

    override fun reverse(to: Project): ProjectApiModel {
        throw NotImplementedError()
    }

    override fun map(from: ProjectApiModel): Project {
        return with(from) {
            val owner = owner?.let { ownerMapper.map(it) }
            val namespace = namespace?.let { namespaceMapper.map(it) }
            val permissions = permissions?.let { permissionsMapper.map(it) }
            val sharedWithGroups = sharedWithGroups?.let { sharedWithGroupsMapper.map(it) }
            Project(
                id,
                description,
                defaultBranch,
                getEnumTypeValue<ProjectVisibility>(visibility) ?: ProjectVisibility.INTERNAL,
                sshUrlToRepo,
                httpUrlToRepo,
                webUrl,
                tagList,
                owner,
                name,
                nameWithNamespace,
                path,
                pathWithNamespace,
                issuesEnabled,
                openIssuesCount,
                mergeRequestsEnabled,
                jobsEnabled,
                wikiEnabled,
                snippetsEnabled,
                containerRegistryEnabled,
                createdAt,
                lastActivityAt,
                creatorId,
                namespace,
                permissions,
                archived,
                avatarUrl,
                sharedRunnersEnabled,
                forksCount,
                starCount,
                runnersToken,
                publicJobs,
                sharedWithGroups,
                onlyAllowMergeIfPipelineSucceeds,
                onlyAllowMergeIfAllDiscussionsAreResolved,
                requestAccessEnabled,
                readmeUrl
            )
        }
    }
}