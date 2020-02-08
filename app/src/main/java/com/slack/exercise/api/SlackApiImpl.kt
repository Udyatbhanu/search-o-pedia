package com.slack.exercise.api

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject
import javax.inject.Singleton

private const val API_URL = "https://slack-users.herokuapp.com/"

/**
 * Implementation of [SlackApi] using [UserSearchService] to perform the API requests.
 */
@Singleton
class SlackApiImpl @Inject constructor() : SlackApi {
    @Inject
    lateinit var service: UserSearchService



    override fun searchUsers(searchTerm: String): Single<List<User>> {
        return service.searchUsers(searchTerm)
                .map {
                    it.users
                }
                .subscribeOn(Schedulers.io())

    }
}