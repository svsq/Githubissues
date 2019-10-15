package com.paulsoja.githubissues.data.model.user

import com.google.gson.annotations.SerializedName

data class UserApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("state") val state: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("web_url") val webUrl: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("bio") val bio: String,
    @SerializedName("location") val location: String,
    @SerializedName("public_email") val publicEmail: String,
    @SerializedName("skype") val skype: String,
    @SerializedName("linkedin") val linkedin: String,
    @SerializedName("twitter") val twitter: String,
    @SerializedName("website_url") val websiteUrl: String,
    @SerializedName("organization") val organization: String,
    @SerializedName("last_sign_in_at") val lastSignInAt: String,
    @SerializedName("confirmed_at") val confirmedAt: String,
    @SerializedName("last_activity_on") val lastActivityOn: String,
    @SerializedName("email") val email: String,
    @SerializedName("theme_id") val themeId: String,
    @SerializedName("color_scheme_id") val colorSchemeId: Int,
    @SerializedName("projects_limit") val projectsLimit: Int,
    @SerializedName("current_sign_in_at") val currentSignInAt: String,
    @SerializedName("identities") val identities: List<IdentitiesApiModel> = listOf(),
    @SerializedName("can_create_group") val canCreateGroup: Boolean,
    @SerializedName("can_create_project") val canCreateProject: Boolean,
    @SerializedName("two_factor_enabled") val twoFactorEnabled: Boolean,
    @SerializedName("external") val external: Boolean,
    @SerializedName("private_profile") val privateProfile: Boolean,
    @SerializedName("shared_runners_minutes_limit") val sharedRunnersMinutesLimit: Int,
    @SerializedName("extra_shared_runners_minutes_limit") val extraSharedRunnersMinutesLimit: Int
)