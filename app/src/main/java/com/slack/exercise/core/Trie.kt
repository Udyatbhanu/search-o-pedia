package com.slack.exercise.core

interface Trie{
    fun insert(word: String)
    fun search(word: String): Boolean
    fun startsWith(word: String): Boolean

    fun size():Int
}