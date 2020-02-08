package com.slack.exercise.api

import com.slack.exercise.core.api.Endpoints
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserSearchService {
    /**
     * Search query. Returns a [Single] emitting the API response.
     */
    @GET(Endpoints.SEARCH_USERS)
    fun searchUsers(@Query("query") query: String): Single<UserSearchResponse>
}

/**
 * Models the search query response.
 */
data class UserSearchResponse(val ok: Boolean, val users: List<User>)