package com.slack.search.core.dagger

import com.slack.search.core.Trie
import com.slack.search.core.TrieImpl
import com.slack.search.core.provider.SharedPrefProvider
import com.slack.search.core.provider.SharedPrefProviderImpl
import com.slack.search.file.FileAccessProvider
import com.slack.search.file.FileAccessProviderImpl
import dagger.Binds
import dagger.Module


/**
 * Responsible for providing core libraries or resuable components
 */
@Module
abstract class CoreModule{
    @Binds
    abstract fun provideCoreModule(trie: TrieImpl): Trie

    @Binds
    abstract fun sharedPrefModule(sharedPref: SharedPrefProviderImpl): SharedPrefProvider

    @Binds
    abstract fun provideFileAccess(fileAccess: FileAccessProviderImpl): FileAccessProvider
}