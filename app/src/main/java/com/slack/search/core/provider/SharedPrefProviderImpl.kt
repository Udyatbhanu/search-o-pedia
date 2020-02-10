package com.slack.search.core.provider

import android.app.Application
import android.content.Context
import javax.inject.Inject

class SharedPrefProviderImpl @Inject constructor(private val context: Application) : SharedPrefProvider{

    /**
     *
     */
    override fun contains(key :String):Boolean{
        return context.getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
                .contains(key)
    }

    /**
     *
     */
    override fun get(key :String):String?{
        return context.getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
                .getString(key, "")
    }


    /**
     *
     */
    override fun set(key :String){
        context.getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
                .edit().putString(key, key).apply()
    }

}