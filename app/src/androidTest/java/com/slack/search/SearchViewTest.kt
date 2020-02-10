package com.slack.search

import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.slack.search.ui.usersearch.UserSearchActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SearchViewTest{
    @get:Rule
    var activityTestRule = ActivityTestRule(UserSearchActivity::class.java)

    private lateinit var query: String
    @Before
    fun setUp() {
        query = "a"
    }



    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.slack.search", appContext.packageName)
    }


    @Test
    fun testQuerySearch() {

        onView(withId(R.id.search_menu_item)).perform(click())
        onView(isAssignableFrom(EditText::class.java)).perform(typeText(query), pressImeActionButton())


    }
}