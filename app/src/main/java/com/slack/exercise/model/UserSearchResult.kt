package com.slack.exercise.model

/**
 * Models users returned by the API.
 */
data class UserSearchResult(val id: Int, val displayName: String, val username: String, val avatarUrl: String)