package com.slack.exercise.file

import android.app.Application
import com.slack.exercise.R
import com.slack.exercise.api.SlackApi
import com.slack.exercise.core.Trie
import com.slack.exercise.model.UserSearchResult
import io.reactivex.Single
import timber.log.Timber
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FileAccessProviderImpl @Inject constructor(private val context: Application): FileAccessProvider{
    @Inject lateinit var trie : Trie
    override fun readFile() {
        try {
            val inputStream: InputStream = context.resources.openRawResource(R.raw.blacklist)

            val inputStreamReader = InputStreamReader(inputStream)

            val br = BufferedReader(inputStreamReader)
            val lines:List<String> = br.readLines()

            for(line in lines){
                trie.insert(line)
            }

            br.close()
        } catch (e:Exception){
            Timber.e(e, e.toString())
        }
    }

}