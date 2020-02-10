package com.slack.search.ui.dagger

import com.slack.search.ui.usersearch.UserSearchActivity
import com.slack.search.ui.usersearch.UserSearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module to declare UI components that have injectable members
 */
@Module
abstract class BindingModule {
    @ContributesAndroidInjector
    abstract fun bindUserSearchActivity(): UserSearchActivity

    @ContributesAndroidInjector
    abstract fun bindUserSearchFragment(): UserSearchFragment
}