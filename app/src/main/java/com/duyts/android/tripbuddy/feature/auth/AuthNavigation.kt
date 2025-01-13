package com.duyts.android.tripbuddy.feature.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kotlinx.serialization.Serializable

@Serializable
object AuthRoute {
	@Serializable
	object SignIn

	@Serializable
	object SignUp
}

fun NavGraphBuilder.authRoute(
	onSignInSuccess: () -> Unit,
) {
	navigation<AuthRoute>(startDestination = AuthRoute.SignIn) {
		composable<AuthRoute.SignIn> {
			SignInScreen(onSignInSuccess= onSignInSuccess)
		}
	}

}