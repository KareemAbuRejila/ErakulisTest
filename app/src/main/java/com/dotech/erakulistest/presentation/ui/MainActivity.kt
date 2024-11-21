package com.dotech.erakulistest.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dotech.erakulistest.presentation.common.Constrains.PARAM_IMG_ID
import com.dotech.erakulistest.presentation.theme.ErakulisTestTheme
import com.dotech.erakulistest.presentation.ui.auth.login.LoginScreen
import com.dotech.erakulistest.presentation.ui.auth.register.RegistrationScreen
import com.dotech.erakulistest.presentation.ui.home.HomeScreen
import com.dotech.erakulistest.presentation.ui.home.HomeViewModel
import com.dotech.erakulistest.presentation.ui.image_details.ImageDetailsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ErakulisTestTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    val context = LocalContext.current
                    NavHost(
                        navController = navController,
                        startDestination = Screens.LoginScreen.route
                    ){
                        composable(
                            route = Screens.RegistrationScreen.route
                        ){
                            RegistrationScreen(
                                onRegisterSuccess = {
                                    navController.navigate(Screens.HomeScreen.route)
                                },
                                onNavigateToLogin = {
                                    Toast.makeText(context, "Not Implemented",
                                        Toast.LENGTH_SHORT).show()
                                }
                            )
                        }
                        composable(
                            route = Screens.LoginScreen.route
                        ) {
                            LoginScreen(
                                onLoginSuccess = {
                                    navController.navigate(Screens.HomeScreen.route)
                                },
                                onNavigateToRegister = {
                                    navController.navigate(Screens.RegistrationScreen.route)
                                },
                                onNavigateToForgotPassword = {
                                    Toast.makeText(context, "Not Implemented",
                                        Toast.LENGTH_SHORT).show()
                                },
                                onNavigateToHelp = {
                                    Toast.makeText(context, "Not Implemented",
                                        Toast.LENGTH_SHORT).show()
                                }
                            )
                        }
                        composable(
                            route = Screens.HomeScreen.route
                        ){
                            HomeScreen(
                                navController = navController
                            )
                        }
                        composable(
                            route = Screens.ImageDetails.route + "/{$PARAM_IMG_ID}"
                        ){
                            ImageDetailsScreen()
                        }

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ErakulisTestTheme {

    }
}