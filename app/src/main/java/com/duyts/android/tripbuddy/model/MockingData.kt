package com.duyts.android.tripbuddy.model

import java.util.Date

object MockingData {
	val mockArticle = Article(
		title = "The Evolution of Web Development",
		content = longArticleContent,
		author = Author(
			name = "Jane Smith",
			avatarUrl = "https://randomuser.me/api/portraits/women/2.jpg"
		),
		publishedDate = "2024-01-02",
		tags = listOf("Web", "Development", "JavaScript"),
		imageUrl = "https://images.unsplash.com/photo-1560518883-ce09059eeffa"
	)

	fun getMockTrip() = Trip(
		overview = Overview(
			title = "Beach Adventure",
			destination = "Hawaii",
			backgroundImage = "https://images.unsplash.com/photo-1735327854928-6111ac6105c8?q=80&w=3328&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
			note = "Enjoy the beautiful beaches and water activities in Hawaii."
		),
		itineraries = listOf(
			Itinerary(
				startDate = Date(2024, 5, 1),
				endDate = Date(2024, 5, 2),
				activity = "Snorkeling",
				places = listOf(
					Place(
						title = "Waikiki Beach",
						description = "A beautiful beach with crystal clear waters perfect for snorkeling.",
						images = listOf(
							"https://images.unsplash.com/photo-1507525428034-b723cf961d3e",
							"https://images.unsplash.com/photo-1501594907352-04cda38ebc29"
						),
						location = Pair(21.2767, -157.8294)
					)
				)
			),
			Itinerary(
				startDate = Date(2024, 5, 3),
				endDate = Date(2024, 5, 4),
				activity = "Volcano Tour",
				places = listOf(
					Place(
						title = "Hawaii Volcanoes National Park",
						description = "Explore the famous volcanoes and lava fields.",
						images = listOf(
							"https://images.unsplash.com/photo-1502134249126-9f3755a50d78"
						),
						location = Pair(19.4195, -155.2881)
					)
				)
			)
		)
	)

	fun getMockTrips(): List<Trip> {
		return listOf(
			Trip(
				overview = Overview(
					title = "Beach Adventure",
					destination = "Hawaii",
					backgroundImage = "https://images.unsplash.com/photo-1573143622688-5a42c73e3e83",
					note = "Enjoy the beautiful beaches and water activities in Hawaii."
				),
				itineraries = listOf(
					Itinerary(
						startDate = Date(2024, 5, 1),
						endDate = Date(2024, 5, 2),
						activity = "Snorkeling",
						places = listOf(
							Place(
								title = "Waikiki Beach",
								description = "A beautiful beach with crystal clear waters perfect for snorkeling.",
								images = listOf(
									"https://images.unsplash.com/photo-1507525428034-b723cf961d3e",
									"https://images.unsplash.com/photo-1501594907352-04cda38ebc29"
								),
								location = Pair(21.2767, -157.8294)
							)
						)
					),
					Itinerary(
						startDate = Date(2024, 5, 3),
						endDate = Date(2024, 5, 4),
						activity = "Volcano Tour",
						places = listOf(
							Place(
								title = "Hawaii Volcanoes National Park",
								description = "Explore the famous volcanoes and lava fields.",
								images = listOf(
									"https://images.unsplash.com/photo-1502134249126-9f3755a50d78"
								),
								location = Pair(19.4195, -155.2881)
							)
						)
					)
				)
			), Trip(
				overview = Overview(
					title = "Beach Adventure",
					destination = "Hawaii",
					backgroundImage = "https://images.unsplash.com/photo-1573143622688-5a42c73e3e83",
					note = "Enjoy the beautiful beaches and water activities in Hawaii."
				),
				itineraries = listOf(
					Itinerary(
						startDate = Date(2024, 5, 1),
						endDate = Date(2024, 5, 2),
						activity = "Snorkeling",
						places = listOf(
							Place(
								title = "Waikiki Beach",
								description = "A beautiful beach with crystal clear waters perfect for snorkeling.",
								images = listOf(
									"https://images.unsplash.com/photo-1507525428034-b723cf961d3e",
									"https://images.unsplash.com/photo-1501594907352-04cda38ebc29"
								),
								location = Pair(21.2767, -157.8294)
							)
						)
					),
					Itinerary(
						startDate = Date(2024, 5, 3),
						endDate = Date(2024, 5, 4),
						activity = "Volcano Tour",
						places = listOf(
							Place(
								title = "Hawaii Volcanoes National Park",
								description = "Explore the famous volcanoes and lava fields.",
								images = listOf(
									"https://images.unsplash.com/photo-1502134249126-9f3755a50d78"
								),
								location = Pair(19.4195, -155.2881)
							)
						)
					)
				)
			),
			Trip(
				overview = Overview(
					title = "Beach Adventure",
					destination = "Hawaii",
					backgroundImage = "https://images.unsplash.com/photo-1573143622688-5a42c73e3e83",
					note = "Enjoy the beautiful beaches and water activities in Hawaii."
				),
				itineraries = listOf(
					Itinerary(
						startDate = Date(2024, 5, 1),
						endDate = Date(2024, 5, 2),
						activity = "Snorkeling",
						places = listOf(
							Place(
								title = "Waikiki Beach",
								description = "A beautiful beach with crystal clear waters perfect for snorkeling.",
								images = listOf(
									"https://images.unsplash.com/photo-1507525428034-b723cf961d3e",
									"https://images.unsplash.com/photo-1501594907352-04cda38ebc29"
								),
								location = Pair(21.2767, -157.8294)
							)
						)
					),
					Itinerary(
						startDate = Date(2024, 5, 3),
						endDate = Date(2024, 5, 4),
						activity = "Volcano Tour",
						places = listOf(
							Place(
								title = "Hawaii Volcanoes National Park",
								description = "Explore the famous volcanoes and lava fields.",
								images = listOf(
									"https://images.unsplash.com/photo-1502134249126-9f3755a50d78"
								),
								location = Pair(19.4195, -155.2881)
							)
						)
					)
				)
			),
			Trip(
				overview = Overview(
					title = "European Tour",
					destination = "Italy & France",
					backgroundImage = "https://images.unsplash.com/photo-1583122622175-eaf2a4f02b12",
					note = "Experience the rich history and culture of Europe."
				),
				itineraries = listOf(
					Itinerary(
						startDate = Date(2024, 6, 1),
						endDate = Date(2024, 6, 2),
						activity = "Visit Colosseum",
						places = listOf(
							Place(
								title = "Colosseum",
								description = "An ancient amphitheater in the heart of Rome.",
								images = listOf(
									"https://images.unsplash.com/photo-1568572933382-74d440642117"
								),
								location = Pair(41.8902, 12.4922)
							)
						)
					),
					Itinerary(
						startDate = Date(2024, 6, 3),
						endDate = Date(2024, 6, 4),
						activity = "Eiffel Tower Visit",
						places = listOf(
							Place(
								title = "Eiffel Tower",
								description = "A famous landmark in Paris offering a stunning view.",
								images = listOf(
									"https://images.unsplash.com/photo-1522932467653-e48f79727fbe"
								),
								location = Pair(48.8584, 2.2945)
							)
						)
					)
				)
			)
		)
	}

	val mockArticles = listOf(
		Article(
			title = "Exploring the Future of AI",
			content = longArticleContent,
			author = Author(
				name = "John Doe",
				avatarUrl = "https://randomuser.me/api/portraits/men/1.jpg"
			),
			publishedDate = "2024-01-01",
			tags = listOf("AI", "Technology", "Future"),
			imageUrl = "https://images.unsplash.com/photo-1581092335254-829756c5b3ae"
		),
		Article(
			title = "The Evolution of Web Development",
			content = longArticleContent,
			author = Author(
				name = "Jane Smith",
				avatarUrl = "https://randomuser.me/api/portraits/women/2.jpg"
			),
			publishedDate = "2024-01-02",
			tags = listOf("Web", "Development", "JavaScript"),
			imageUrl = "https://images.unsplash.com/photo-1560518883-ce09059eeffa"
		),
		Article(
			title = "Introduction to Kotlin Coroutines",
			content = longArticleContent,
			author = Author(
				name = "Alice Brown",
				avatarUrl = "https://randomuser.me/api/portraits/women/3.jpg"
			),
			publishedDate = "2024-01-03",
			tags = listOf("Kotlin", "Programming", "Coroutines"),
			imageUrl = "https://images.unsplash.com/photo-1517423440428-a5a00ad493e8"
		),
		Article(
			title = "Understanding RESTful APIs",
			content = longArticleContent,
			author = Author(
				name = "Robert Johnson",
				avatarUrl = "https://randomuser.me/api/portraits/men/4.jpg"
			),
			publishedDate = "2024-01-04",
			tags = listOf("API", "REST", "Backend"),
			imageUrl = "https://images.unsplash.com/photo-1498050108023-c5249f4df085"
		),
		Article(
			title = "Mastering Android Jetpack Compose",
			content = longArticleContent,
			author = Author(
				name = "Emily White",
				avatarUrl = "https://randomuser.me/api/portraits/women/5.jpg"
			),
			publishedDate = "2024-01-05",
			tags = listOf("Android", "Jetpack", "UI"),
			imageUrl = "https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0"
		),
		Article(
			title = "The Power of Functional Programming",
			content = longArticleContent,
			author = Author(
				name = "Michael Green",
				avatarUrl = "https://randomuser.me/api/portraits/men/6.jpg"
			),
			publishedDate = "2024-01-06",
			tags = listOf("Functional Programming", "FP", "Coding"),
			imageUrl = "https://images.unsplash.com/photo-1556761175-129418cb2dfe"
		),
		Article(
			title = "Introduction to Microservices Architecture",
			content = longArticleContent,
			author = Author(
				name = "Sophia Martinez",
				avatarUrl = "https://randomuser.me/api/portraits/women/7.jpg"
			),
			publishedDate = "2024-01-07",
			tags = listOf("Microservices", "Architecture", "Cloud"),
			imageUrl = "https://images.unsplash.com/photo-1521747116042-5a810fda9664"
		),
		Article(
			title = "Mastering TypeScript for Modern Web Development",
			content = longArticleContent,
			author = Author(
				name = "William Taylor",
				avatarUrl = "https://randomuser.me/api/portraits/men/8.jpg"
			),
			publishedDate = "2024-01-08",
			tags = listOf("TypeScript", "JavaScript", "Web"),
			imageUrl = "https://images.unsplash.com/photo-1551033406-611cf9a28f67"
		),
		Article(
			title = "Exploring Cloud Computing with AWS",
			content = longArticleContent,
			author = Author(
				name = "Olivia Davis",
				avatarUrl = "https://randomuser.me/api/portraits/women/9.jpg"
			),
			publishedDate = "2024-01-09",
			tags = listOf("AWS", "Cloud", "Infrastructure"),
			imageUrl = "https://images.unsplash.com/photo-1542744094-3a31f272c490"
		),
		Article(
			title = "Getting Started with GraphQL",
			content = longArticleContent,
			author = Author(
				name = "Daniel Wilson",
				avatarUrl = "https://randomuser.me/api/portraits/men/10.jpg"
			),
			publishedDate = "2024-01-10",
			tags = listOf("GraphQL", "API", "Web"),
			imageUrl = "https://images.unsplash.com/photo-1498050108023-c5249f4df085"
		)
	)
}

private val longArticleContent = """
    Minimalism is a lifestyle and design philosophy that focuses on simplicity and the removal of excess. 
    It encourages individuals to prioritize what truly matters by eliminating unnecessary clutter from their lives, 
    whether it's physical possessions, mental distractions, or digital noise.

    The roots of minimalism can be traced back to various historical movements, including Japanese Zen philosophy 
    and the Bauhaus art movement. Both emphasize simplicity, balance, and the beauty of functional design. 
    Modern minimalism gained popularity in the early 21st century as a response to consumer culture.

    The benefits of minimalism extend beyond just a tidy home. By embracing minimalism, you can experience:
    - Reduced Stress: Clutter can create mental noise. A simplified space promotes calmness.
    - Financial Freedom: Spending less on non-essentials frees up resources for meaningful experiences.
    - Increased Focus: Fewer distractions mean more clarity and focus on personal goals.
    - Environmental Impact: Consuming less contributes to sustainability and reduces waste.

    Practicing minimalism involves several strategies:
    1. **Declutter Your Space:** Begin by removing items that no longer serve a purpose or bring joy.
    2. **Simplify Your Digital Life:** Unsubscribe from unused services, reduce notifications, and organize files.
    3. **Adopt a Capsule Wardrobe:** Limit your clothing collection to versatile, high-quality pieces.
    4. **Practice Mindful Consumption:** Avoid impulse purchases and focus on quality over quantity.
    5. **Set Priorities:** Identify your core values and align your lifestyle with them.

    Minimalism is not about deprivation but about creating space for what truly matters. 
    It's a continuous journey of intentional living that can bring greater joy, peace, and purpose to your life.

    Consider taking the first step today by decluttering one small area of your life. 
    Whether it's a drawer, your phone's home screen, or your weekly schedule, small changes can lead to profound impacts.

    Remember, the goal of minimalism is not perfection but progress. 
    Embrace the freedom that comes with letting go of the non-essentials and focusing on what makes you truly happy.
""".trimIndent()
