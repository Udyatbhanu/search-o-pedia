package com.slack.exercise.dagger

import android.app.Application
import com.slack.exercise.api.SlackApi
import com.slack.exercise.api.SlackApiImpl
import com.slack.exercise.core.Trie
import com.slack.exercise.core.TrieImpl
import com.slack.exercise.dataprovider.UserSearchResultDataProvider
import com.slack.exercise.dataprovider.UserSearchResultDataProviderImpl
import com.slack.exercise.file.FileAccessProvider
import com.slack.exercise.file.FileAccessProviderImpl
import com.slack.exercise.validation.BlackListTextValidator
import com.slack.exercise.validation.BlackListTextValidatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Module to setup Application scoped instances that require providers.
 */
@Module
abstract class AppModule {
    @Binds
    abstract fun provideUserSearchResultDataProvider(dataProvider: UserSearchResultDataProviderImpl): UserSearchResultDataProvider

    @Binds
    abstract fun provideSlackApi(apiImpl: SlackApiImpl): SlackApi


    @Binds
    abstract fun provideValidator(validator: BlackListTextValidatorImpl): BlackListTextValidator


    @Binds
    abstract fun provideFileAccess(fileAccess: FileAccessProviderImpl): FileAccessProvider




}