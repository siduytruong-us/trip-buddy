package com.duyts.android.tripbuddy.feature.trip

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.duyts.android.tripbuddy.model.Trip
import kotlinx.serialization.Serializable


@Serializable
object TripRoute

fun NavController.navigateToTrip(trip: Trip) {
	navigate(TripRoute)
}

fun NavGraphBuilder.tripRoute() {
	composable<TripRoute> {
		TripScreen()
	}
}