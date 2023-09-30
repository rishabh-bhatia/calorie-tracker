package com.rishabh.tracker_presentation.search

import com.rishabh.tracker_domain.model.TrackableFood

data class   TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)
