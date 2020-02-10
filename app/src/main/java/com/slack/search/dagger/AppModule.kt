package com.slack.search.dagger

import com.slack.search.api.SlackApi
import com.slack.search.api.SlackApiImpl
import com.slack.search.dataprovider.UserSearchResultDataProvider
import com.slack.search.dataprovider.UserSearchResultDataProviderImpl
import com.slack.search.validation.BlackListTextValidator
import com.slack.search.validation.BlackListTextValidatorImpl
import dagger.Binds
import dagger.Module

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


}