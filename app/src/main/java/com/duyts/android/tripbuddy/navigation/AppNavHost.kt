package com.duyts.android.tripbuddy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.duyts.android.tripbuddy.feature.auth.AuthRoute
import com.duyts.android.tripbuddy.feature.auth.authRoute
import com.duyts.android.tripbuddy.feature.home.homeRoute
import com.duyts.android.tripbuddy.feature.home.navigateToArticle
import com.duyts.android.tripbuddy.feature.home.navigateToHome
import com.duyts.android.tripbuddy.feature.trip.navigateToTrip
import com.duyts.android.tripbuddy.feature.trip.tripRoute


@Composable
fun AppNavHost() {
	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = AuthRoute) {
		authRoute(
			onSignInSuccess = navController::navigateToHome
		)
		homeRoute(
			onNavigateToTrip = navController::navigateToTrip,
			onNavigateToArticle = navController::navigateToArticle,
			onBack = navController::goBack
		)
		tripRoute()
	}
}

fun NavController.goBack() {
	popBackStack()
}