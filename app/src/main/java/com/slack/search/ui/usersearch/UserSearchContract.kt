package com.slack.search.ui.usersearch

import com.slack.search.core.framework.BaseContract
import com.slack.search.model.UserSearchResult

/**
 * MVP contract for User Search.
 */
interface UserSearchContract {

    /**
     * Callbacks to notify the view of the outcome of search queries initiated.
     */
    interface  View: BaseContract.View {
        /**
         * Call when [UserSearchResult] are returned.
         */
        fun onUserSearchResults(results: Set<UserSearchResult>)

        /**
         * Call when an error occurs during the execution of search queries.
         */
        fun onUserSearchError(error: Throwable)
    }

    interface Presenter : BaseContract.Presenter<View> {


        /**
         * Notifies the presenter that the [searchTerm] has changed.
         */
        fun onQueryTextChange(searchTerm: String)
    }
}