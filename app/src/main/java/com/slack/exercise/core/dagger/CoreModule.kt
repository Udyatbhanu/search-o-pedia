package com.slack.exercise.core.dagger

import com.slack.exercise.core.Trie
import com.slack.exercise.core.TrieImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CoreModule{
    @Binds
    abstract fun provideCoreModule(trie: TrieImpl): Trie
}