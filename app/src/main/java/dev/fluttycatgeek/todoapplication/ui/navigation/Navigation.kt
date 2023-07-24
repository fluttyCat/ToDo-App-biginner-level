package dev.fluttycatgeek.todoapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.fluttycatgeek.todoapplication.core.utils.Constants.LIST_SCREEN
import dev.fluttycatgeek.todoapplication.ui.navigation.destinations.listComposable
import dev.fluttycatgeek.todoapplication.ui.navigation.destinations.taskComposable
import dev.fluttycatgeek.todoapplication.ui.sharedViewModel.SharedViewModel

@Composable
fun SetupNavigation(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    val screen = remember(navHostController) {
        Screens(navHostController = navHostController)
    }

    NavHost(navController = navHostController, startDestination = LIST_SCREEN) {
        listComposable(
            navigateToTaskScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
        taskComposable(navigationToListScreen = screen.list)
    }
}