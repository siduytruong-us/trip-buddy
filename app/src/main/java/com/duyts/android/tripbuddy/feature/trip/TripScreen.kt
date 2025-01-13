package com.duyts.android.tripbuddy.feature.trip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.duyts.android.tripbuddy.R
import com.duyts.android.tripbuddy.ext.toLocalDate
import com.duyts.android.tripbuddy.feature.trip.screen.ItineraryContent
import com.duyts.android.tripbuddy.feature.trip.screen.OverviewContent
import com.duyts.android.tripbuddy.model.MockingData
import com.duyts.android.tripbuddy.model.Trip
import kotlinx.coroutines.launch

@Composable
fun TripScreen() {
	TripContent(MockingData.getMockTrip())
}

private enum class ContentTab(val index: Int, val title: String) {
	OVERVIEW(0, "Overview"),
	ITINERARY(1, "Itinerary"),
	MAP(2, "Map")
}

@Composable
fun TripContent(trip: Trip) {
	val pagerState = rememberPagerState(pageCount = {
		ContentTab.entries.size
	})
	val coroutineScope = rememberCoroutineScope()

	Scaffold(
		modifier = Modifier.fillMaxSize(),
		topBar = {
			CustomTopAppBar(
				title = "Iceland Trip",
				onHomeClick = { /* Handle home click */ },
				onMoreClick = { /* Handle more click */ }
			)
		}
	) { innerPaddings ->
		Column(
			modifier = Modifier
				.consumeWindowInsets(innerPaddings)
		) {
			Header(trip = trip)
			TabRow(
				modifier = Modifier
					.width(270.dp),
				selectedTabIndex = pagerState.currentPage,
				containerColor = Color.Transparent,
				divider = {}
			) {
				ContentTab.entries.forEachIndexed { index, tab ->
					Tab(
						modifier = Modifier.wrapContentWidth(),
						text = { Text(tab.title) },
						selected = pagerState.currentPage == index,
						onClick = {
							coroutineScope.launch {
								pagerState.animateScrollToPage(index)
							}
						}
					)
				}
			}
			Spacer(Modifier.height(12.dp))
			HorizontalPager(
				state = pagerState
			) { page ->
				when (page) {
					ContentTab.OVERVIEW.index -> OverviewContent(trip.overview)
					ContentTab.ITINERARY.index -> ItineraryContent(trip.itineraries)
				}
			}
		}
	}
}

@Composable
private fun Header(trip: Trip, modifier: Modifier = Modifier) {
	val overview = trip.overview
	val earliestDate by remember { derivedStateOf { trip.earliestDate.toLocalDate() } }
	val latestDate by remember { derivedStateOf { trip.latestDate.toLocalDate() } }
	ConstraintLayout(
		modifier = modifier
			.wrapContentHeight(),

		) {
		val (backgroundImageRef, cardRef) = createRefs()
		AsyncImage(
			model = overview.backgroundImage,
			contentDescription = null,
			modifier = Modifier
				.fillMaxWidth()
				.height(150.dp)
				.constrainAs(backgroundImageRef) {

				},
			contentScale = ContentScale.Crop,
			placeholder = painterResource(R.drawable.wallpaper)
		)
		Card(
			modifier = Modifier.constrainAs(cardRef) {
				top.linkTo(backgroundImageRef.bottom)
				bottom.linkTo(backgroundImageRef.bottom)
				start.linkTo(parent.start)
				end.linkTo(parent.end)
			},
			colors = CardDefaults.cardColors(
				containerColor = MaterialTheme.colorScheme.background
			),
			elevation = CardDefaults.cardElevation(6.dp)
		) {
			Column(
				modifier = Modifier
					.fillMaxWidth(.9f)
					.height(100.dp)
					.padding(12.dp),
				verticalArrangement = Arrangement.SpaceBetween
			) {
				Text(
					text = overview.title,
					style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
				)

				Text(
					text = "${overview.destination} (${earliestDate} - ${latestDate})",
					style = MaterialTheme.typography.bodyLarge
				)
			}
		}
	}
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(title: String, onHomeClick: () -> Unit, onMoreClick: () -> Unit) {
	TopAppBar(
		colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
		title = {
			Text(
				text = title,
				style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
				modifier = Modifier.fillMaxWidth(),
				textAlign = TextAlign.Center
			)
		},
		navigationIcon = {
			IconButton(onClick = onHomeClick) {
				Icon(
					imageVector = Icons.Default.Home,
					contentDescription = "Home"
				)
			}
		},
		actions = {
			IconButton(onClick = onMoreClick) {
				Icon(
					imageVector = Icons.Default.MoreVert,
					contentDescription = "More"
				)
			}
		}
	)
}


@Preview(showBackground = true)
@Composable
fun TripContentPreview() {
	TripContent(MockingData.getMockTrip())
}