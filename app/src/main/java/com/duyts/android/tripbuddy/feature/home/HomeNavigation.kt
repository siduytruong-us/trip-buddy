package com.duyts.android.tripbuddy.feature.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.duyts.android.tripbuddy.feature.home.screen.ArticleScreen
import com.duyts.android.tripbuddy.model.Article
import com.duyts.android.tripbuddy.model.Trip
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute {
	@Serializable
	object HomeScreen

	@Serializable
	object ArticleScreen


}

fun NavGraphBuilder.homeRoute(
	onNavigateToTrip: (Trip) -> Unit,
	onNavigateToArticle: (Article) -> Unit,
	onBack: () -> Unit,
) {
	navigation<HomeRoute>(HomeRoute.HomeScreen) {
		composable<HomeRoute.HomeScreen> {
			HomeScreen(
				onNavigateToTrip = onNavigateToTrip,
				onNavigateToArticle = onNavigateToArticle
			)
		}
		composable<HomeRoute.ArticleScreen> {
			ArticleScreen(
				onBack = onBack
			)
		}

	}

}


fun NavController.navigateToHome() {
	navigate(HomeRoute.HomeScreen)
}

fun NavController.navigateToArticle(article: Article) {
	navigate(HomeRoute.ArticleScreen)
}