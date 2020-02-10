package com.slack.search.validation


interface BlackListTextValidator {

    /**
     * Returns a Boolean
     */
    fun isBlackListed(searchTerm: String): Boolean


    /**
     *
     */
    fun blackListTerm(searchTerm: String): Any
}