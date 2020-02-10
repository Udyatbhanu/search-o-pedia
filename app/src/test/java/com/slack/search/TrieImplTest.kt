package com.slack.search

import com.slack.search.core.Trie
import com.slack.search.core.TrieImpl
import junit.framework.TestCase.*
import org.junit.After

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class TrieImplTest {
    lateinit var trie : Trie
    val testString :String  = "Test"



    @Before
    fun setUp() {
        trie = TrieImpl()
    }

    @Test
    fun testTrieState() {
        assertNotNull(trie)
        assertEquals(trie.size() , 0)
    }

    @Test
    fun testTrieInsert() {
        assertEquals(trie.size() , 0)
        trie.insert(testString)
        assertNotNull(trie)
        assertEquals(trie.size() , 1)
    }


    /**
     *
     */
    @Test
    fun testTrieSearch() {
        assertEquals(trie.size() , 0)
        trie.insert(testString)
        assertNotNull(trie.search(testString))

        assertTrue(trie.search(testString))
        assertFalse(trie.search(""))

    }

    @Test
    fun testTrieClean() {

        trie.insert(testString)
        trie.clean()
        assertNotNull(trie)
        assertEquals(trie.size() , 0)
        assertFalse(trie.search(testString))


    }

    @After
    fun tearDown() {
        trie.clean()
    }
}