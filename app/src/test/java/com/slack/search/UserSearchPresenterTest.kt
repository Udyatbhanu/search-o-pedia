package com.slack.search

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.slack.search.dataprovider.UserSearchResultDataProvider
import com.slack.search.model.UserSearchResult
import com.slack.search.ui.usersearch.UserSearchContract
import com.slack.search.ui.usersearch.UserSearchPresenter
import com.slack.search.validation.BlackListTextValidator
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import junit.framework.TestCase.assertEquals
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.util.concurrent.Executor

@RunWith(JUnit4::class)
class UserSearchPresenterTest{


    private val immediateScheduler = object : Scheduler() {
        override fun createWorker(): Worker {
            return ExecutorScheduler.ExecutorWorker(Executor { it.run() }, false)
        }
    }


    @Mock
    lateinit var userSearchResultDataProvider: UserSearchResultDataProvider

    @Mock
    lateinit var validator: BlackListTextValidator

    @Mock
    lateinit var view: UserSearchContract.View


    lateinit var presenter: UserSearchPresenter






    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.presenter = UserSearchPresenter(userSearchResultDataProvider, validator )
        RxJavaPlugins.setInitIoSchedulerHandler { immediateScheduler }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediateScheduler }
    }




    @Test
    fun testOnAttach() {


        val searchResults = setOf(UserSearchResult(1, "Henry Rollins", "HR", "http://someurl.com")
                                 ,UserSearchResult(2, "Tiger Shark", "Tiger", "http://someurl.com"))

        val single: Single<Set<UserSearchResult>> = Single.create {
            emitter ->
            emitter.onSuccess(searchResults)
        }





        whenever(validator.isBlackListed(anyString())).thenReturn(false)
        whenever(userSearchResultDataProvider.fetchUsers(anyString())).thenReturn(single)


        this.presenter.attach(view)

//        verify(view).onUserSearchResults(searchResults)


    }
    @After
    fun tearDown() {
        RxJavaPlugins.reset()
        RxAndroidPlugins.reset()
    }


}