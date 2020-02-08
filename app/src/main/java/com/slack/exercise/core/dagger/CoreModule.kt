package com.slack.exercise.core.dagger

import com.slack.exercise.core.Trie
import com.slack.exercise.core.TrieImpl
import com.slack.exercise.core.provider.SharedPrefProvider
import com.slack.exercise.core.provider.SharedPrefProviderImpl
import com.slack.exercise.file.FileAccessProvider
import com.slack.exercise.file.FileAccessProviderImpl
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