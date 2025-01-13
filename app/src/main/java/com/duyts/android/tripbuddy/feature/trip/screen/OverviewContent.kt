package com.duyts.android.tripbuddy.feature.trip.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.duyts.android.tripbuddy.model.MockingData
import com.duyts.android.tripbuddy.model.Overview


@Composable
fun OverviewContent(overview: Overview) {
	var noteVisibility by remember { mutableStateOf(true) }

	Column(
		modifier = Modifier
			.fillMaxWidth()
			.windowInsetsPadding(WindowInsets.safeContent.only(WindowInsetsSides.Horizontal)),
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.clickable { noteVisibility = !noteVisibility },
			horizontalArrangement = Arrangement.SpaceBetween
		) {

			Text(
				text = "Note",
				style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
			)
			Icon(
				imageVector = Icons.Default.KeyboardArrowDown,
				contentDescription = null,
				modifier = Modifier
					.scale(1f, if (noteVisibility) -1f else 1f)
			)
		}
		Spacer(Modifier.height(10.dp))
		AnimatedVisibility(noteVisibility) {
			Text(
				text = overview.note,

				)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun OverviewContentPreview() {
	OverviewContent(MockingData.getMockTrip().overview)
}
