package com.example.demoui.uitest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.demoui.StatusBreak
import org.junit.Rule
import org.junit.Test

class MeetingBreakTest {

    @get:Rule
    var composeRule= createComposeRule()

    @Test
    fun MeetingBreakTest(){
        val status="In a Meeting"
        composeRule.setContent {
            StatusBreak(status = status)
        }
        composeRule.onNodeWithText(status).assertExists()
        composeRule.onNodeWithText(status).assertIsDisplayed()
    }
}