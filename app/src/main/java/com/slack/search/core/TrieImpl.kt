package com.slack.search.core

import javax.inject.Inject
import javax.inject.Singleton


/**
 * The infamous Trie data structure, we want to be able to search a term fast, the Trie provides a run time of O(k) where k is the size of
 * the search term, there can be obvious improvements to this however this will work just fine for the purpose
 */
@Singleton
class TrieImpl  @Inject constructor(): Trie {

    data class Node(var word: String? = null, val childNodes: MutableMap<Char, Node> = mutableMapOf())

    private val root = Node()
    private var size :Int = 0


    override fun size():Int{
        return size
    }

    /**
     *
     */
    override fun insert(word: String) {
        var currentNode = root
        for (char in word) {
            if (currentNode.childNodes[char] == null) {
                currentNode.childNodes[char] = Node()
            }
            currentNode = currentNode.childNodes[char]!!


        }
        currentNode.word = word
        size++
    }

    /**
     *
     */

    override fun search(word: String): Boolean {
        var currentNode = root
        for (char in word) {
            if (currentNode.childNodes[char] == null) {
                return false
            }
            currentNode = currentNode.childNodes[char]!!
        }
        return currentNode.word != null
    }


    /**
     *
     */
    override fun startsWith(word: String): Boolean {
        var currentNode = root
        for (char in word) {
            if (currentNode.childNodes[char] == null) {
                return false
            }
            currentNode = currentNode.childNodes[char]!!
        }
        return currentNode.word == null
    }

}