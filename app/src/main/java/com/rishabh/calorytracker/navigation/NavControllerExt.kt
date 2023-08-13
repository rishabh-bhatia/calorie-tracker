package com.rishabh.calorytracker.navigation

import androidx.navigation.NavController
import com.rishabh.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}