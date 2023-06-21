package dev.fluttycatgeek.todoapplication.ui.navigation.destinations


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.fluttycatgeek.todoapplication.core.utils.Action
import dev.fluttycatgeek.todoapplication.core.utils.Constants.TASK_ARGUMENT_KEY
import dev.fluttycatgeek.todoapplication.core.utils.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigationToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}