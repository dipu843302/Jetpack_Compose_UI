package com.example.demoui.uitest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.demoui.Available
import com.example.demoui.NotTakingCalls
import com.example.demoui.StatusView
import org.junit.Rule
import org.junit.Test


class StatusViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun testStatusUI() {
        val checkStatus=true
        val statusHeading="Taking Calls"
        val statusSubHeading="I can take calls"
        composeTestRule.setContent {
            StatusView(checkStatus,statusHeading ,statusSubHeading )
        }
        composeTestRule.onNodeWithText(statusHeading).assertExists()
        composeTestRule.onNodeWithText(statusHeading).assertIsDisplayed()
    }

    @Test
    fun testAvailableUI() {
        composeTestRule.setContent {
            Available()
        }
    }

    @Test
    fun testNotTakingCall() {
        composeTestRule.setContent {
            NotTakingCalls()
        }
    }

}