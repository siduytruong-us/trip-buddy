package com.duyts.android.tripbuddy.feature.trip.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.duyts.android.tripbuddy.component.TagChip
import com.duyts.android.tripbuddy.ext.toLocalDate
import com.duyts.android.tripbuddy.model.Itinerary
import com.duyts.android.tripbuddy.model.MockingData
import com.duyts.android.tripbuddy.model.Place


@Composable
fun ItineraryContent(itineraries: List<Itinerary>) {
	var selectedItinerary by remember { mutableStateOf(itineraries.firstOrNull()) }
	Column(
		modifier = Modifier
			.fillMaxSize()
			.windowInsetsPadding(WindowInsets.safeContent.only(WindowInsetsSides.Horizontal))
	) {
		ItineraryItems(
			itineraries,
			onItinerarySelected = { selectedItinerary = it }
		)
		Spacer(Modifier.height(6.dp))
		selectedItinerary?.apply {
			PlaceItems(places)
		}
	}
}

@Composable
private fun ItineraryItems(
	list: List<Itinerary>,
	onItinerarySelected: (Itinerary) -> Unit = {},
) {
	LazyRow {
		items(list) { item ->
			TagChip(
				item.startDate.toLocalDate(),
				modifier = Modifier
					.background(Color.DarkGray.copy(alpha = 0.9f))
					.clickable { onItinerarySelected(item) }
			)
		}
	}
}


@Composable
private fun PlaceItems(list: List<Place>) {
	LazyColumn(modifier = Modifier.fillMaxWidth()) {
		items(list) { item ->
			PlaceItem(item)
		}
	}
}

@Composable
private fun PlaceItem(place: Place) {
	var isExpanded by remember { mutableStateOf(false) }
	ConstraintLayout(modifier = Modifier
		.fillMaxWidth()
		.clickable { isExpanded = !isExpanded }) {
		val (textRef, imagesRef, iconRef) = createRefs()
		Column(
			modifier = Modifier.constrainAs(textRef) {
				top.linkTo(parent.top)
				start.linkTo(parent.start)
				end.linkTo(iconRef.start)
			}
		) {
			Text(
				text = place.title,
				style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
			)
			Text(
				place.description,
				style = MaterialTheme.typography.bodySmall,
			)
		}
		Icon(
			Icons.Default.KeyboardArrowDown,
			contentDescription = null,
			modifier = Modifier
				.size(32.dp)
				.constrainAs(iconRef) {
					end.linkTo(parent.end)
					top.linkTo(textRef.top)
					bottom.linkTo(textRef.bottom)
				}
		)
		AnimatedVisibility(isExpanded, modifier = Modifier.constrainAs(imagesRef) {
			top.linkTo(textRef.bottom)
		}) {
			place.images.map { image ->
				AsyncImage(model = image, contentDescription = null)
			}
		}

	}
}

@Preview(showBackground = true)
@Composable
private fun PlaceItemPreview() {
	PlaceItems(MockingData.getMockTrip().itineraries.first().places)
}

@Preview(showBackground = true)
@Composable
fun ItineraryContentPreview() {
	ItineraryContent(MockingData.getMockTrip().itineraries)
}
