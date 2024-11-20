package com.dotech.erakulistest.presentation.ui


sealed class Screens(val route: String) {
    data object RegistrationScreen: Screens("RegistrationScreen")
    data object LoginScreen: Screens("LoginScreen")


    data object HomeScreen: Screens("HomeScreen")
    data object ImageDetails: Screens("ImageDetails")
}