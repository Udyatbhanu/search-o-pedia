package com.slack.search.file

import android.app.Application
import com.slack.search.R
import com.slack.search.core.Trie
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