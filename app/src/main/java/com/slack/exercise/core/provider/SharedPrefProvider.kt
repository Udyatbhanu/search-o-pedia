package com.slack.exercise.core.provider


interface SharedPrefProvider  {

    /**
     *
     */
    fun contains(key :String):Boolean

    /**
     *
     */
    fun get(key :String):String?


    /**
     *
     */
    fun set(key :String)


}