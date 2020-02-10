package com.slack.search.dagger

import android.app.Application
import com.slack.search.core.dagger.CoreModule
import com.slack.search.core.dagger.NetworkModule
import com.slack.search.dataprovider.UserSearchResultDataProvider
import com.slack.search.ui.dagger.BindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton


/**
 * Component providing Application scoped instances.
 */
@Singleton
@Component(modules = [AppModule::class, AndroidInjectionModule::class, BindingModule::class, CoreModule::class, NetworkModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun userSearchResultDataProvider(): UserSearchResultDataProvider

    @Component.Builder
     interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}