package com.slack.exercise.core.framework

class BaseContract{

    interface Presenter<in T>{

        /**
         * Call to attach a [Presenter] and provide its [View].
         */
        fun attach(view: T)

        /**
         * Call to detach a [Presenter] and clean up resources.
         */
        fun detach()

    }

    /**
     * Want to keep this open for adding common view features
     */
    interface View
}