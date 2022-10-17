package com.example.demoui

sealed class Screen(val route:String){
    object StatusView :Screen("status_screen")
    object StatusMeeting:Screen("status_meeting")
    object StatusLunch:Screen("status_lunch")
    object StatusVacation:Screen("status_vacation")
    object StatusCustom:Screen("status_custom")
}
