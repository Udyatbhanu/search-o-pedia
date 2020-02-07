package com.slack.exercise

import com.slack.exercise.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class App : DaggerApplication() {


    companion object {
        const val TAG = "SearchApp" //TODO
    }
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

//        try {
//            val inputStream: InputStream = resources.openRawResource(R.raw.blacklist)
//
//            val inputStreamReader = InputStreamReader(inputStream)
//            val sb = StringBuilder()
//            var line: String?
//            val br = BufferedReader(inputStreamReader)
//            line = br.readLine()
//            while (br.readLine() != null) {
//                sb.append(line)
//                line = br.readLine()
//            }
//            br.close()
//        } catch (e:Exception){
//            Timber.e(e, e.toString())
//        }

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
//        return DaggerAppComponent.create()

//        DaggerAppComponent.builder().application(this).build()

        return DaggerAppComponent.builder().application(this).build()
    }
}