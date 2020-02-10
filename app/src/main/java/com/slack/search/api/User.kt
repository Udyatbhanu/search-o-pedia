package com.slack.search.api

import com.google.gson.annotations.SerializedName

/**
 * User model returned by the API.
 */
data class User(
        val id: Int,
        @SerializedName("display_name")
        val displayName: String,
        val username: String,
        @SerializedName("avatar_url")
        val avatarUrl: String)