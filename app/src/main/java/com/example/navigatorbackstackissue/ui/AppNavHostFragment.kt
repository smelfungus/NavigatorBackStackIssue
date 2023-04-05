package com.example.navigatorbackstackissue.ui

import androidx.navigation.NavHostController
import androidx.navigation.NoOpNavigator
import androidx.navigation.fragment.NavHostFragment

class AppNavHostFragment : NavHostFragment() {

    override fun onCreateNavHostController(navHostController: NavHostController) {
        super.onCreateNavHostController(navHostController)
        navHostController.navigatorProvider.addNavigator(NoOpNavigator())
    }
}
