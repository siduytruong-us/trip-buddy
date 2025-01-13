package com.duyts.android.tripbuddy.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.duyts.android.tripbuddy.component.TagChip
import com.duyts.android.tripbuddy.ext.toLocalDate
import com.duyts.android.tripbuddy.model.Article
import com.duyts.android.tripbuddy.model.MockingData
import com.duyts.android.tripbuddy.model.Trip

@Composable
fun HomeScreen(
	onNavigateToTrip: (Trip) -> Unit,
	onNavigateToArticle: (Article) -> Unit,
) {
	HomeContent(
		trips = MockingData.getMockTrips(),
		articles = MockingData.mockArticles,
		onNavigateToArticle = onNavigateToArticle,
		onNavigateToTrip = onNavigateToTrip
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeContent(
	trips: List<Trip>,
	articles: List<Article>,
	onAddTrip: () -> Unit = {},
	onNavigateToTrip: (Trip) -> Unit = {},
	onNavigateToArticle: (Article) -> Unit = {},
) {
	Scaffold(modifier = Modifier.fillMaxSize(), floatingActionButton = {
		FloatingActionButton(
			onClick = onAddTrip, shape = CircleShape
		) {
			Icon(
				Icons.Default.Add, contentDescription = null
			)
		}
	}, topBar = {
		TopAppBar(title = {
			IconButton(onClick = { /* Handle search click */ }) {
				Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
			}
		}, actions = {
			// Search Icon Button

			// Avatar Image Button
			IconButton(onClick = { /* Handle profile click */ }) {
				AsyncImage(
					model = "https://randomuser.me/api/portraits/men/1.jpg",
					contentDescription = "Avatar",
					modifier = Modifier
						.size(36.dp)
						.clip(CircleShape)
				)
			}

		})
	}) { innerPadding ->
		LazyColumn(
			modifier = Modifier
				.padding(innerPadding)
				.consumeWindowInsets(innerPadding)
				.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(12.dp)
		) {
			item {
				TripsContent(
					modifier = Modifier.fillMaxWidth(),
					trips = trips,
					onNavigateToTrip = onNavigateToTrip
				)
			}
			item {
				Text(
					modifier = Modifier.fillMaxWidth(),
					text = "Articles",
					style = MaterialTheme.typography.titleMedium
				)
			}
			items(articles) { article ->
				ArticleItem(article, onNavigateToArticle)
			}
		}
	}
}

@Composable
private fun TripsContent(
	modifier: Modifier = Modifier,
	trips: List<Trip>,
	onNavigateToTrip: (Trip) -> Unit = {},
) {
	Column(
		modifier = modifier, verticalArrangement = Arrangement.spacedBy(6.dp)
	) {
		Text(
			modifier = modifier, text = "Trips", style = MaterialTheme.typography.titleMedium
		)
		LazyRow(
			modifier, horizontalArrangement = Arrangement.spacedBy(12.dp)
		) {
			items(trips) { trip ->
				TripItem(
					trip = trip, onNavigateToTrip = onNavigateToTrip
				)
			}
		}
	}
}


@Composable
fun ArticleItem(
	article: Article,
	onNavigateToArticle: (Article) -> Unit = {},
) {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.height(IntrinsicSize.Max)
			.clickable { onNavigateToArticle(article) },
		elevation = CardDefaults.cardElevation(12.dp),
		colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
	) {
		Row(
			modifier = Modifier.padding(12.dp)

		) {
			Column(
				modifier = Modifier
					.weight(1f)
					.fillMaxHeight(),
				verticalArrangement = Arrangement.SpaceAround,
			) {
				Row {
					article.tags.map { text ->
						TagChip(text)
					}
				}
				Spacer(Modifier.height(6.dp))
				Text(
					article.title,
					style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
				)
				Spacer(Modifier.height(12.dp))
				Row(
					horizontalArrangement = Arrangement.spacedBy(12.dp),
					verticalAlignment = Alignment.CenterVertically
				) {
					AsyncImage(
						model = article.author.avatarUrl,
						contentDescription = null,
						modifier = Modifier
							.size(16.dp)
							.clip(CircleShape)
					)
					Text(article.author.name, style = MaterialTheme.typography.bodySmall)
					Text(article.publishedDate, style = MaterialTheme.typography.bodySmall)
				}
			}
			AsyncImage(
				modifier = Modifier
					.size(100.dp)
					.clip(RoundedCornerShape(12.dp)),
				model = article.imageUrl,
				contentScale = ContentScale.Crop,
				contentDescription = null,
			)
		}
	}
}

@Composable
private fun TripItem(
	trip: Trip,
	onNavigateToTrip: (Trip) -> Unit = {},
) {
	val earliestDate by remember { derivedStateOf { trip.earliestDate.toLocalDate() } }
	val latestDate by remember { derivedStateOf { trip.latestDate.toLocalDate() } }
	Card(
		modifier = Modifier
			.width(180.dp)
			.clickable { onNavigateToTrip(trip) },
		shape = RoundedCornerShape(12.dp)
	) {
		Column(modifier = Modifier.padding(12.dp)) {
			Text(
				text = trip.overview.title,
				style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
			)
			Text(
				text = trip.overview.destination, style = MaterialTheme.typography.bodyMedium
			)
			Text(
				text = "$earliestDate - $latestDate",
				style = MaterialTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic)
			)
		}
	}
}

@Preview(showBackground = false)
@Composable
private fun ArticleItemPreview() {
	ArticleItem(MockingData.mockArticle, {})
}

@Preview(showBackground = false)
@Composable
private fun TripItemReview() {
	TripItem(MockingData.getMockTrip())
}

@Preview(showBackground = true)
@Composable
private fun HomeContentPreview() {
	HomeContent(MockingData.getMockTrips(), MockingData.mockArticles)
}

