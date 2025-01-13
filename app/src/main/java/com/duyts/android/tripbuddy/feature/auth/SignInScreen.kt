package com.duyts.android.tripbuddy.feature.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.duyts.android.tripbuddy.R

@Composable
fun SignInScreen(
	onSignInSuccess: () -> Unit = {},
) {
	SignInContent(
		onSignInSuccess = onSignInSuccess
	)
}

@Composable
private fun SignInContent(
	onSignInSuccess: () -> Unit = {},
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.imePadding()
			.paint(
				painter = painterResource(R.drawable.wallpaper),
				contentScale = ContentScale.FillBounds
			)
	) {
		Spacer(modifier = Modifier.weight(4f))
		Card(
			modifier = Modifier
				.weight(6f),
			colors = CardDefaults.cardColors(
				containerColor = MaterialTheme.colorScheme.background.copy(
					alpha = 0.9f
				)
			),
			shape = RoundedCornerShape(topEnd = 32.dp, topStart = 32.dp)
		) {
			Column(
				modifier = Modifier
					.weight(6f)
					.safeContentPadding()
					.fillMaxSize(),
				verticalArrangement = Arrangement.SpaceEvenly,
				horizontalAlignment = Alignment.CenterHorizontally
			) {

				Text(
					text = "Nice to meet you again",
					style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
					textAlign = TextAlign.Center
				)
				Spacer(Modifier.height(24.dp))
				EditTextField(
					label = "Email",
					value = "username",
					modifier = Modifier.fillMaxWidth()
				)
				Spacer(Modifier.height(12.dp))
				EditTextField(
					label = "Password",
					value = "password",
					isPassword = true,
					modifier = Modifier.fillMaxWidth()
				)
				Spacer(Modifier.height(12.dp))
				LoginButton(
					label = "Sign In",
					onClick = onSignInSuccess
				)
				LoginButton("Or Login with Google")

				FooterContent()
			}

		}
	}

}


@Composable
private fun EditTextField(
	label: String,
	value: String,
	isPassword: Boolean = false,
	modifier: Modifier = Modifier,
) {
	var editText by remember { mutableStateOf(value) }
	var passwordVisible by remember { mutableStateOf(false) }
	Column(modifier = modifier) {
		Text(
			text = label,
			style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
			color = MaterialTheme.colorScheme.onSurfaceVariant
		)
		Spacer(modifier = Modifier.height(6.dp))
		TextField(
			value = editText,
			onValueChange = { editText = it },
			modifier = Modifier.fillMaxWidth(),
			shape = RoundedCornerShape(12.dp),
			colors = TextFieldDefaults.colors(
				unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.5f),
				focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
				focusedIndicatorColor = Color.Transparent,
				unfocusedIndicatorColor = Color.Transparent
			),
			visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,

			trailingIcon = {
				if (isPassword) {
					IconButton(onClick = { passwordVisible = !passwordVisible }) {
						Icon(
							imageVector = if (passwordVisible) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
							contentDescription = if (passwordVisible) "Hide password" else "Show password",
							tint = MaterialTheme.colorScheme.onSurfaceVariant
						)
					}
				}
			}
		)
	}
}

@Composable
private fun LoginButton(label: String, onClick: () -> Unit = {}) {
	Button(
		onClick = onClick,
		modifier = Modifier
			.fillMaxWidth(),
		colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSurface)
	) {
		Text(text = label)
	}
}

@Composable
private fun HeaderContent() {
	Row(modifier = Modifier.fillMaxSize()) {

	}
}

@Composable
private fun FooterContent(onForgetPassword: () -> Unit = {}) {
	Row(
		modifier = Modifier
			.fillMaxWidth(),
		horizontalArrangement = Arrangement.Center
	) {
		Text("Don't have an account?")
		Spacer(Modifier.width(12.dp))
		Text(
			text = "Sign up now",
			color = Color.Blue,
			modifier = Modifier.clickable { onForgetPassword() }
		)
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignInContentPreview() {
	SignInContent({ })
}