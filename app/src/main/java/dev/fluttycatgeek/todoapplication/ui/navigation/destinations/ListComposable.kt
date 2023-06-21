package dev.fluttycatgeek.todoapplication.ui.navigation.destinations


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.fluttycatgeek.todoapplication.core.utils.Constants.LIST_ARGUMENT_KEY
import dev.fluttycatgeek.todoapplication.core.utils.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    navigationToTaskScreen: (Int) -> Unit
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {

    }
}