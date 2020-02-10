package com.slack.search.validation

import com.slack.search.core.Trie
import com.slack.search.core.provider.SharedPrefProvider
import com.slack.search.file.FileAccessProvider
import javax.inject.Inject
import javax.inject.Singleton


/**
 * We want the validator to be a singleton, we read the blacklisted file into memory into a trie datastructure,
 * only for the first instance or if size is 0, for subsequent searches we want to search the trie instead of reading it from the file.
 *
 * If the service returns an empty response then we write the search string into shared pref and also temporarily cache it in memory
 */
@Singleton
class BlackListTextValidatorImpl @Inject constructor(private val fileAccess: FileAccessProvider,
                                                     private val sharedPref: SharedPrefProvider) : BlackListTextValidator {
    @Inject
    lateinit var trie: Trie


    override fun isBlackListed(searchTerm: String): Boolean {
        var isBlackListed = false
        if (trie.size() == 0) {
            fileAccess.readFile()
        }
       if(trie.search(searchTerm) || sharedPref.contains(searchTerm)){
           isBlackListed = true
       }

        return isBlackListed
    }


    /**
     *  We do not want to blacklist the term and keep putting it in shared pref
     */
    override fun blackListTerm(searchTerm: String) {
        if(!sharedPref.contains(searchTerm)){
            sharedPref.set(searchTerm)
            trie.insert(searchTerm)
        }

    }

}