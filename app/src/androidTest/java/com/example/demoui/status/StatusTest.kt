package com.example.demoui.status

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.demoui.Available
import com.example.demoui.NotTakingCalls
import com.example.demoui.StatusView
import org.junit.Rule
import org.junit.Test


class StatusTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun testStatusUI() {
        composeTestRule.setContent {
            StatusView(true, "Taking Calls", "I can take calls")
        }
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