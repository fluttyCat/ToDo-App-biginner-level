package dev.fluttycatgeek.todoapplication.ui.navigation

import androidx.navigation.NavHostController
import dev.fluttycatgeek.todoapplication.core.utils.Action
import dev.fluttycatgeek.todoapplication.core.utils.Constants.LIST_SCREEN

class Screens(navHostController: NavHostController) {

    val list: (Action) -> Unit = { action ->
        navHostController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) {
                inclusive = true
            }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navHostController.navigate("task/$taskId")
    }
}