package dev.fluttycatgeek.todoapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.fluttycatgeek.todoapplication.core.utils.Constants.LIST_SCREEN
import dev.fluttycatgeek.todoapplication.ui.navigation.destinations.listComposable
import dev.fluttycatgeek.todoapplication.ui.navigation.destinations.taskComposable

@Composable
fun SetupNavigation(navHostController: NavHostController) {

    val screen = remember(navHostController) {
        Screens(navHostController = navHostController)
    }

    NavHost(navController = navHostController, startDestination = LIST_SCREEN) {
        listComposable(navigationToTaskScreen = screen.task)
        taskComposable(navigationToListScreen = screen.list)
    }
}