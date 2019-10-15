package com.paulsoja.githubissues.data.mapper.project

import com.paulsoja.githubissues.data.mapper.Mapper
import com.paulsoja.githubissues.data.model.project.NamespaceApiModel
import com.paulsoja.githubissues.domain.model.project.Namespace
import javax.inject.Inject

class NamespaceMapper @Inject constructor() : Mapper<NamespaceApiModel, Namespace>() {

    override fun reverse(to: Namespace): NamespaceApiModel {
        throw NotImplementedError()
    }

    override fun map(from: NamespaceApiModel): Namespace {
        return with(from) {
            Namespace(id, name, path, kind, fullPath)
        }
    }

}