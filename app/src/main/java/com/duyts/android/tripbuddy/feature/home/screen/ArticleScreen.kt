package com.duyts.android.tripbuddy.feature.home.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.duyts.android.tripbuddy.R
import com.duyts.android.tripbuddy.component.TagChip
import com.duyts.android.tripbuddy.model.Article
import com.duyts.android.tripbuddy.model.MockingData

@Composable
fun ArticleScreen(onBack: () -> Unit) {
	ArticleContent(MockingData.mockArticle, onBack = onBack)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleContent(
	article: Article,
	onBack: () -> Unit = {},
) {
	Scaffold(
		topBar = {
			TopAppBar(
				navigationIcon = {
					IconButton(onClick = onBack) {
						Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
					}
				},
				title = {
					Text(
						text = article.title,
						maxLines = 1,
						overflow = TextOverflow.Ellipsis
					)
				},
				actions = {
					IconButton(onClick = { /* Handle more options click */ }) {
						Icon(
							imageVector = Icons.Default.MoreVert,
							contentDescription = "More Options"
						)
					}
				}
			)
		}
	) { paddingValues ->
		Column(
			modifier = Modifier
				.padding(paddingValues)
				.verticalScroll(rememberScrollState())
		) {
			// Header Image
			AsyncImage(
				model = article.imageUrl,
				contentDescription = "Article Header Image",
				modifier = Modifier
					.fillMaxWidth()
					.height(250.dp),
				placeholder = painterResource(R.drawable.wallpaper),
				contentScale = ContentScale.Crop
			)


			// Tags Section
			Spacer(Modifier.height(20.dp))
			Row(
				modifier = Modifier
					.padding(16.dp)
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(8.dp)
			) {
				article.tags.forEach { tag ->
					TagChip(tag)
				}
			}

			// Article Title
			Text(
				text = article.title,
				style = MaterialTheme.typography.headlineMedium,
				fontWeight = FontWeight.Bold,
				modifier = Modifier.padding(horizontal = 16.dp)
			)

			// Author Section with Avatar
			Row(
				modifier = Modifier.padding(16.dp),
				verticalAlignment = Alignment.CenterVertically
			) {
				AsyncImage(
					model = article.author.avatarUrl,
					contentDescription = "Author Avatar",
					modifier = Modifier
						.size(48.dp)
						.clip(CircleShape),
					placeholder = painterResource(R.drawable.ic_launcher_background)
				)
				Spacer(modifier = Modifier.width(8.dp))
				Column {
					Text(
						text = article.author.name,
						fontWeight = FontWeight.Bold
					)
				}
			}

			// Content Section
			Text(
				text = article.content,
				modifier = Modifier.padding(16.dp),
				style = MaterialTheme.typography.bodyMedium
			)

		}
	}
}

@Preview
@Composable
private fun ArticlePreview() {
	ArticleContent(MockingData.mockArticle)
}