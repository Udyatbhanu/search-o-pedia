package com.slack.search.dataprovider

import com.slack.search.model.UserSearchResult
import io.reactivex.Single

/**
 * Provider of [UserSearchResult].
 * This interface abstracts the logic of searching for users through the API or other data sources.
 */
interface UserSearchResultDataProvider {

    /**
     * Returns a [Single] emitting a set of [UserSearchResult].
     */
    fun fetchUsers(searchTerm: String): Single<Set<UserSearchResult>>
}