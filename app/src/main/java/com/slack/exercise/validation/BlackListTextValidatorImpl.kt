package com.slack.exercise.validation

import com.slack.exercise.core.Trie
import com.slack.exercise.file.FileAccessProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BlackListTextValidatorImpl  @Inject constructor(private val fileAccess: FileAccessProvider): BlackListTextValidator{
    @Inject lateinit var trie : Trie


    override fun isBlackListed(searchTerm: String): Boolean {
        if(trie.size() == 0){
            fileAccess.readFile()
        }

        return trie.search(searchTerm)
    }

}