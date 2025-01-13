package com.duyts.android.tripbuddy.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TagChip(tag: String, modifier: Modifier = Modifier) {
	Box(
		modifier = Modifier
			.padding(end = 8.dp)
			.background(Color.DarkGray.copy(alpha = 0.6f), shape = RoundedCornerShape(16.dp))
			.then(modifier)
			.padding(horizontal = 12.dp, vertical = 6.dp),
	) {
		Text(
			text = tag,
			style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
			maxLines = 1,
			overflow = TextOverflow.Ellipsis
		)
	}
}

@Preview
@Composable
private fun TagChipPreview() {
	TagChip("Tag Chip Preview")
}