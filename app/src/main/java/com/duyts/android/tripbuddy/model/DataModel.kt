package com.duyts.android.tripbuddy.model

import java.util.Date
import java.util.UUID


data class Place(
	val title: String,
	val description: String,
	val images: List<String>,
	val location: Pair<Double, Double>, // Latitude and Longitude
)

data class Itinerary(
	val startDate: Date,
	val endDate: Date,
	val activity: String,
	val places: List<Place>,
)

data class Overview(
	val title: String,
	val destination: String,
	val backgroundImage: String,
	val note: String,
)

data class Trip(
	val id: String = UUID.randomUUID().toString(),
	val overview: Overview,
	val itineraries: List<Itinerary>,
) {
	val earliestDate = itineraries.minBy { it.startDate }.startDate
	val latestDate = itineraries.maxBy { it.endDate }.endDate
}


data class Article(
	val title: String,
	val content: String,
	val author: Author,
	val publishedDate: String,
	val tags: List<String>,
	val imageUrl: String
)

data class Author(
	val name: String,
	val avatarUrl: String
)