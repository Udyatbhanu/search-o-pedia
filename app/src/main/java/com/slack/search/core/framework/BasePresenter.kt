package com.slack.search.core.framework

import java.lang.ref.WeakReference

open class BasePresenter<in V> : BaseContract.Presenter<V>{
    private var weakReference: WeakReference<V>? = null


    override fun attach(view: V) {
        if (!isViewAttached) {
            weakReference = WeakReference(view)
        }
    }

    override fun detach() {
        weakReference?.clear()
        weakReference = null
    }

//    val view: V?
//        get() = weakReference?.get()

    private val isViewAttached: Boolean
        get() = weakReference != null && weakReference!!.get() != null




}