package com.slack.search.core

interface Trie{

    /**
     * Insert a string
     */
    fun insert(word: String)

    /**
     * Search for a string
     */
    fun search(word: String): Boolean

    /**
     * Search string starting with
     */
    fun startsWith(word: String): Boolean


    /**
     * Size of the trie
     */
    fun size():Int


    /**
     * Clean the trie
     */
    fun clean():Any
}