package com.slack.exercise.validation

import io.reactivex.Single

interface BlackListTextValidator {

    /**
     * Returns a [Single] emitting a Boolean
     */
    fun isBlackListed(searchTerm: String): Boolean
}