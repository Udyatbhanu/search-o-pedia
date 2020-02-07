package com.slack.exercise.file

/**
 * File accesor, only purpose of this is to read our blacklisted file and store the result in a Trie data structure
 */
interface FileAccessProvider{
    fun readFile()
}