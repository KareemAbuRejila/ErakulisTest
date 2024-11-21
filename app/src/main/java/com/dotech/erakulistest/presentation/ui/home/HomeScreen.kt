package com.dotech.erakulistest.presentation.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dotech.erakulistest.presentation.ui.Screens
import com.dotech.erakulistest.presentation.ui.home.components.ImageListItem

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val state = viewModel.state.value
    val context = navController.context

    Scaffold(
        floatingActionButton = { LogoutButton(viewModel,navController) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                state.isLoading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                state.error.isNotBlank() -> Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )

                else ->
                    LazyColumn {
                        items(state.images) { image ->
                            ImageListItem(image = image) {
                                navController.navigate(Screens.ImageDetails.route + "/${image.id}")
                                Toast.makeText(
                                    context, "${Screens.ImageDetails.route} ${image.id}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                        items(state.images) {
                        }
                    }
            }
        }
    }
}

@Composable
fun LogoutButton(viewModel: HomeViewModel, navController: NavController) {
    FloatingActionButton(
        onClick = {
            viewModel.logout()
            navController.navigate(Screens.LoginScreen.route) {
                popUpTo(Screens.HomeScreen.route) { inclusive = true } // Clears backstack
            }
        },
        content = {
            Icon(Icons.Default.ExitToApp, contentDescription = "Logout")
        }
    )
}

