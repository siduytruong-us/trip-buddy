plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.kotlin.compose)

	alias(libs.plugins.hilt.gradle)
	id ("kotlin-kapt")
	alias(libs.plugins.kotlin.serialize)
}

android {
	namespace = "com.duyts.android.tripbuddy"
	compileSdk = 35

	defaultConfig {
		applicationId = "com.duyts.android.tripbuddy"
		minSdk = 24
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		compose = true
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)


	implementation("androidx.navigation:navigation-compose:2.8.5")
	implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
	implementation("com.squareup.retrofit2:retrofit:2.11.0")
	implementation("com.squareup.retrofit2:converter-gson:2.11.0")
	implementation("io.coil-kt:coil-compose:2.7.0")
	implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
	implementation("com.google.dagger:hilt-android:2.53.1")
	implementation("androidx.room:room-runtime:2.6.1")
	implementation("androidx.room:room-ktx:2.6.1")
	implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
	implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")

	kapt("androidx.room:room-compiler:2.6.1")
	kapt("com.google.dagger:hilt-compiler:2.51")

	testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0")
}